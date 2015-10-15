/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar Apl;

@parser::header {
import java.util.*;
import com.mlt.japl.workspace.EvalContext;
import com.mlt.japl.ast.AstFunc;
}

options {
	language=Java;
	}


@parser::members {
    EvalContext context;
    Stack<HashSet<String>> localFunctions;

    public AplParser(TokenStream input, EvalContext context) {
        this(input);
        this.context = context;
        localFunctions = new Stack<HashSet<String>>();
        localFunctions.push(new HashSet<String>());
    }

    private void enterLambdaContext() {
        localFunctions.push(new HashSet<String>(localFunctions.peek()));
    }

    private void exitLambdaContext() {
        localFunctions.pop();
    }

    private void registerLocalFunction(String name, AstFunc fn) {
        System.out.println("Registering local function " + name);
        localFunctions.peek().add(name);
    }

    private boolean isFnSymbol() {
        String sym = getCurrentToken().getText();
        boolean isfn = context.isBoundToFunction(sym) || localFunctions.peek().contains(sym);
        System.out.println("Is function? " + sym + " " + isfn);
        return isfn;
    }
}

ID  :	('a'..'z'|'A'..'Z'|'_'|'\u237a'|'\u2375'|'\u2206'|'\u2359') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'\u237a'|'\u2375'|'\u2206'|'\u2359')*
    ;

LABEL : ID ':' ;

SIGN: '\u00af';

INT :	SIGN? '0'..'9'+
    ;

FLOAT
    :   SIGN? ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   SIGN? '.' ('0'..'9')+ EXPONENT?
    |   SIGN? ('0'..'9')+ EXPONENT
    ;

COMPLEX: (INT | FLOAT) 'J' (INT|FLOAT);

COMMENT
    :   '\u235D' ~('\n'|'\r')* '\r'? '\n'
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        ) -> skip
    ;

NL	:	'\n'
	;

STRING
    :  '\'' ( ESC_SEQ | ~('\\'|'\'') )* '\''
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

FUNC 	: ('\u002b' | '\u002d' | '\u00d7' | '\u00f7' |                       // add sub mul div
           '\u003c' | '\u2264' | '\u003d' | '\u2260' | '\u2265' | '\u003e' | // lt lte eq neq gte gt
           '\u2228' | '\u2227' | '\u2371' | '\u2372' |                       // or and nor nand
           '\u220a' | '\u2282' | '\u2283' | '\u2229' | '\u222a' |            // epsilon enclose disclose intersection union
           '?'      | ','      | '!'      |                                  // roll ravel factorial
           '\u223C' | '\u2223' | '\u2373' | '\u2374' | '\u2212' | '\u234B' | '\u2352' |
           '\u234E' | '\u2355' | '\u2349' | '\u2296' | '\u233D' | '\u25CB' | '\u22C6' |
           '\u230A' | '\u2308' | '\u235F' | '\u2339' |
           '\u22A5' | '\u22A4' | '\u2191' | '\u2193' | '\u2261' | '\u22a3' | '\u22a2'
          )
        ;

ASSIGN  : '\u2190' ;
LPAREN  : '(' ;
RPAREN  : ')' ;
LBRACKET : '[' ;
RBRACKET : ']' ;
LBRACE : '{' ;
RBRACE : '}' ;
COLON : ':' ;
DIAMOND : '\u22C4' ;
SEMICOLON : ';' ;

IF      : ':If' ;
ENDIF   : (':EndIf' | ':End' ) ;
ELSE    : ':Else' ;
ELSEIF  : ':ElseIf' ;
WHILE   : ':While' ;
ENDWHILE : (':EndWhile' | ':End' ) ;
REPEAT : ':Repeat' ;
ENDREPEAT : (':EndRepeat' | ':End' ) ;
FOR     : ':For' ;
IN      : ':In' ;
ENDFOR  : (':EndFor' | ':End') ;

OPERATOR : ('/' | '\u233f' | '\\' | '\u2340' | '¨') ;
POWEROPERATOR : '\u2363';

BOUNDWITH : '\u2218' ;
OUTERPRODUCT : BOUNDWITH '.' ;
DEL : '\u2207';

sep	:	DIAMOND | (NL | COMMENT)+ ;

toplevel
	:	sep? expr_list sep? EOF
	;

interactive : toplevelexpr EOF ;

toplevelexpr
	:	toplevelfunc
	|   toplevelassignment
	|   if_expr
	|	while_expr
    |   repeat_expr
    |   for_expr
	|	arrayexpr
	;

expr_list
	:	LABEL? toplevelexpr (sep LABEL? toplevelexpr)*
	;

if_expr	:
	IF condition=arrayexpr sep
	   thenbranch=expr_list sep?
    elseifs*
	(ELSE sep
		    elsebranch=expr_list sep?)?
	ENDIF
	;

elseifs : ELSEIF arrayexpr sep expr_list sep? ;

for_expr :
    FOR ID IN arrayexpr sep
            expr_list
    ENDFOR
    ;

while_expr :
    WHILE arrayexpr sep
		expr_list sep?
	ENDWHILE
	;

repeat_expr :   REPEAT arrayexpr sep
                expr_list sep?
                ENDREPEAT
            ;

arrayexpr
	:	ident ASSIGN arrayexpr                                              # expr_assign
	|	l=array (fn=func_operator r=arrayexpr)?                             # dyadic_call_or_array
	|   func_operator arrayexpr?                                             # monadic_call_or_niladic
	;

toplevelassignment :
       //ID ASSIGN arrayexpr                                              # singleassignment
        ID ASSIGN func_operator { registerLocalFunction($ID.text, null); } # fnassignment
	|   ID+ ASSIGN arrayexpr                                             # strandassignment
	;

array	:	arrayitem+
	;

arrayitem : ident | integer | floating | complexnum | string | subarrayexpr
          ;

subarrayexpr
	:	LPAREN arrayexpr RPAREN index?
	;

integer	:	INT
	;

floating :       FLOAT
        ;

complexnum : COMPLEX ;

string 	:	STRING index?
	;

ident	:	{!isFnSymbol()}? ID index?
	;

index	:	LBRACKET indexelement+ RBRACKET
	;

indexelement : SEMICOLON | arrayexpr ;

func_operator
        :       func (OPERATOR axis?)?          # func_oper_no_parens
        |       OPERATOR axis?                  # operator_as_func
        |       LPAREN func_operator RPAREN     # func_oper_with_parens
        ;

func	:
        outer=func '.' inner=func   # innerprod
    |   FUNC axis?                  # simplefunc
    |   {isFnSymbol()}? ID          # idfunc
    |   OUTERPRODUCT func           # outerproduct
    |   arrayitem BOUNDWITH func    # boundfunc
    |   func POWEROPERATOR arrayitem # powerfunc
	| 	lambdafunc                  # lambda
	|   LPAREN func RPAREN          # func_with_parens
	;

axis : LBRACKET arrayexpr RBRACKET ;

lambdafunc
	:	LBRACE { enterLambdaContext(); }
        sep? (guard_or_assignment sep)* arrayexpr sep?
        RBRACE { exitLambdaContext(); }
	;

toplevelfunc
    : DEL (ret=ID ASSIGN)? a=ID b=ID? c=ID? localslist sep
        { if($c!=null) {
             registerLocalFunction($b.text, null);
          } else {
             registerLocalFunction($a.text, null);
          }
          enterLambdaContext();
        }
        expr_list sep?
      DEL
        { exitLambdaContext(); }
    ;

localslist : (SEMICOLON ID)* ;

guard_or_assignment :
          guard | toplevelassignment
    ;

guard : arrayexpr COLON arrayexpr;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar Apl;

@parser::header {
import java.util.*;
import com.mlt.japl.workspace.EvalContext;
import com.mlt.japl.newast.AstFunc;
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
        localFunctions.peek().add(name);
    }

    private boolean isFnSymbol() {
        String sym = getCurrentToken().getText();
        return context.isBoundToFunction(sym) || localFunctions.peek().contains(sym);
    }
}

ID  :	('a'..'z'|'A'..'Z'|'_'|'\u237a'|'\u2375') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'\u237a'|'\u2375')*
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

FUNC 	: ('\u002b' | '\u002d' | '\u00d7' | '\u00f7' |   // add sub mul div
           '\u003c' | '\u2264' | '\u003d' | '\u2260' | '\u2265' | '\u003e' | // lt lte eq neq gte gt
           '\u2228' | '\u2227' | '\u2371' | '\u2372' |   // or and nor nand
           '\u220a' | '\u2282' | '\u2283' | '\u2229' | '\u222a'  // epsilon enclose disclose intersection union
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

OUTERPRODUCT : '\u2218.' ;
DEL : '\u2207';

sep	:	DIAMOND | (NL | COMMENT)+ ;

toplevel
	:	sep? expr_list sep? EOF
	;

toplevelexpr
	:	toplevelfunc
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
    (ELSEIF elifcondition=arrayexpr sep
            elifthenbranch=expr_list sep?)*
	(ELSE
		    elsebranch=expr_list sep?)?
	ENDIF
	;

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
	:	assignment
	|   monadic_call_or_niladic
	|	dyadic_call_or_array
	;

assignment :
        ID ASSIGN { registerLocalFunction($ID.text, null); } func_operator  # fnassignment
	|   ID+ ASSIGN arrayexpr   # strandassignment
	;

monadic_call_or_niladic
	:	func_operator arrayexpr?
	;

dyadic_call_or_array
	:	l=array (fn=func_operator r=arrayexpr)?
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
        :       func (OPERATOR axis?)?
        ;

func	:
        outer=func '.' inner=func   # innerprod
    |   FUNC axis?                  # simplefunc
    |   {isFnSymbol()}? ID          # idfunc
    |   OUTERPRODUCT func           # outerproduct
	| 	lambdafunc                  # lambda
	;

axis : LBRACKET arrayexpr RBRACKET ;

lambdafunc
	:	LBRACE { enterLambdaContext(); }
        sep? (guard_or_assignment sep)* arrayexpr sep?
        RBRACE { exitLambdaContext(); }
	;

toplevelfunc
    : DEL (ret=ID ASSIGN)? a=ID b=ID c=ID? localslist sep
        { enterLambdaContext(); }
        expr_list sep?
      DEL
        { exitLambdaContext(); }
    ;

localslist : (SEMICOLON ID)* ;

guard_or_assignment :
          guard | assignment
    ;

guard : arrayexpr COLON arrayexpr;

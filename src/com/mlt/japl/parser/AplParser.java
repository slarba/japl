/* Generated By:JavaCC: Do not edit this line. AplParser.java */
package com.mlt.japl.parser;

import java.io.Reader;
import com.mlt.japl.iface.*;
import com.mlt.japl.fns.*;
import com.mlt.japl.ast.*;
import com.mlt.japl.errors.*;
import com.mlt.japl.workspace.*;

import java.util.ArrayList;
import java.util.List;

public class AplParser implements AplParserConstants {
  EvalContext context;

  public AplParser(Reader reader, EvalContext context)
  {
    this(reader);
    this.context = context;
  }

  public EvalContext getContext()
  {
    return context;
  }

  public Func lookupFn(String name)
  {
        switch(name)
        {
                case "+": return new AddFn();
                case "\u2212": return new SubFn();
                case "\u00d7": return new MulFn();
//		case ",": return new RavelFn();
                case "\u230a": return new FloorFn();
                case "\u2308": return new CeilFn();
                case "\u2223": return new AbsFn();
                case "\u00f7": return new DivFn();
                case "\u2374": return new RhoFn();
                case "\u2373": return new IotaFn();
//		case "○": return new TrigFn();
//		case "∈": return new ExistsFn();
//		case "<": return new LtFn();
//		case ">": return new GtFn();
//		case "≤": return new LteFn();
//		case "≥": return new GteFn();
                case "=": return new EqFn();
//		case "∼": return new NotFn();
//		case "≠": return new NeqFn();
//		case "∨": return new OrFn();  // logical or
                case "\u2227": return new AndFn();  // logical and
//		case "⍱": return new NorFn();  // nor
//		case "⍲": return new NandFn();  // nand
//		case "⍉": return new ReverseFn();
//		case "⌽": return new ReverseLastFn();
//		case "⊖": return new ReverseFirstFn();
//		case "↑": return new TakeFn();
//		case "↓": return new DropFn();
                case "\u2261": return new DepthFn();
                case "\u2282": return new EncloseFn();
                case "\u2283": return new DiscloseFn();
//		case "⊥": return new DecodeFn();//		case "∪": return new UnionFn();//		case "/": return new ReplicateFn();
                default:
                System.out.println("trying to find function " + name);
                        return context.tryGetFunction(name);
        }
  }

  public Func buildMonadicOperator(String n, Func arg)
  {
        switch(n)
        {
                case "/":  return new ReduceFn(arg);
                case "\u005c\u005c": return new ScanFn(arg);
                case "\u00a8": return new EachFn(arg);
                case "\u233f": return new FirstAxisReduceFn(arg);
                case "\u2340": return new FirstAxisScanFn(arg);
                default:
                        throw new SyntaxError();
        }
  }

  public AstNode parse()
  {
     try
     {
                return apl_expr();
     } catch(ParseException e)
     {
                throw new SyntaxError();
     }
  }

// top level expression ends with EOF
  final public AstNode apl_expr() throws ParseException {
  AstNode t;
    t = expr();
    jj_consume_token(0);
          {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

// expression is a single expression or a list of expressions
  final public AstNode expr() throws ParseException {
  AstNode t;
  AstNode c;
  List<AstNode> statements = new ArrayList<AstNode>();
    t = singleexpr();
    label_1:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_1;
      }
      jj_consume_token(17);
      c = singleexpr();
                  statements.add(c);
    }
          if(statements.size()==0) {if (true) return t;}
          statements.add(0, t);
          {if (true) return new StatementListNode(statements);}
    throw new Error("Missing return statement in function");
  }

// single expression is either monadic/niladic call or dyadic call/array
  final public AstNode singleexpr() throws ParseException {
  AstNode t;
    if (jj_2_2(2)) {
      t = monadic_call_or_niladic();
          {if (true) return t;}
    } else if (jj_2_3(2)) {
      t = dyadic_call_or_array();
          {if (true) return t;}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

// monadic call starts with a function expression, followed by optional axis expression and
// argument expr
  final public AstNode monadic_call_or_niladic() throws ParseException {
  Func s;
  AstNode t = null;
  AstNode arg = null;
  AstNode axis = null;
    s = fn_expr();
    if (jj_2_4(2)) {
      jj_consume_token(18);
      axis = expr();
      jj_consume_token(19);
    } else {
      ;
    }
    if (jj_2_5(2)) {
      t = singleexpr();
    } else {
      ;
    }
    if(t!=null)
    {
      {if (true) return new MonadicCallNode(s, t, axis);}
    } else
    {
      {if (true) return new NiladicCallNode(s);}
    }
    throw new Error("Missing return statement in function");
  }

// dyadic call starts with an array, followed by function expression, possible axis expr and right
// single expression
  final public AstNode dyadic_call_or_array() throws ParseException {
  AstNode left;
  Func op = null;
  AstNode right = null;
  AstNode axis = null;
    left = array();
    if (jj_2_7(2)) {
      op = fn_expr();
      if (jj_2_6(2)) {
        jj_consume_token(18);
        axis = expr();
        jj_consume_token(19);
      } else {
        ;
      }
      right = singleexpr();
    } else {
      ;
    }
    if(op!=null)
    {
                {if (true) return new DyadicCallNode(op, left, right, axis);}
    } else
    {
                {if (true) return left;}
    }
    throw new Error("Missing return statement in function");
  }

// array is a sequence of 1 or more elements (identifiers, paren-enclosed expressions, constants)
  final public AstNode array() throws ParseException {
  AstNode idexpr = null;
  Token s;
  boolean mustEvaluate = false;
  List<AstNode > nodeList = new ArrayList<AstNode>();
    label_2:
    while (true) {
      if (jj_2_8(2)) {
        idexpr = identifierexpr();
            nodeList.add(idexpr);
            mustEvaluate = true;
      } else if (jj_2_9(2)) {
        s = jj_consume_token(CONSTANT);
            nodeList.add(new ConstantAstNode(s.toString()));
      } else if (jj_2_10(2)) {
        s = jj_consume_token(STRING);
            nodeList.add(new ConstantAstNode(s.toString()));
      } else if (jj_2_11(2)) {
        s = jj_consume_token(CPLXCONSTANT);
            nodeList.add(new ConstantAstNode(s.toString(), ConstantAstNode.COMPLEX));
      } else if (jj_2_12(2)) {
        jj_consume_token(20);
        idexpr = singleexpr();
            nodeList.add(idexpr);
            mustEvaluate = true;
        jj_consume_token(21);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
      if (jj_2_13(2)) {
        ;
      } else {
        break label_2;
      }
    }
          if(mustEvaluate)
          {
            if(nodeList.size()==1) {if (true) return nodeList.get(0);}
            {if (true) return new EvalArrayNode(nodeList);}
          }
          else
          {
            if(nodeList.size()==1) {if (true) return nodeList.get(0);}
                {if (true) return new ConstArrayNode(nodeList);}
          }
    throw new Error("Missing return statement in function");
  }

  final public AstNode identifierexpr() throws ParseException {
  AstNode e = null;
  AstNode e2 = null;
  Token ident = null;
    ident = jj_consume_token(ID);
    if (jj_2_14(2)) {
      jj_consume_token(18);
      e = indexexpr();
      jj_consume_token(19);
    } else {
      ;
    }
    if (jj_2_15(2)) {
      jj_consume_token(22);
      e2 = singleexpr();
    } else {
      ;
    }
    if(e2!=null)
        {if (true) return new AssignmentNode(ident.toString(), e2);}
    else
            {if (true) return new IdentifierNode(ident.toString(), e);}
    throw new Error("Missing return statement in function");
  }

  final public IndexExprNode indexexpr() throws ParseException {
  AstNode e1 = null;
  IndexExprNode e2 = null;
    if (jj_2_16(2)) {
      e1 = singleexpr();
    } else {
      ;
    }
    if (jj_2_17(2)) {
      jj_consume_token(23);
      e2 = indexexpr();
    } else {
      ;
    }
    {if (true) return new IndexExprNode(e1, e2);}
    throw new Error("Missing return statement in function");
  }

  final public Func fn_expr() throws ParseException {
  Func s = null;
  AstNode userfn = null;
  Token m = null;
    if (jj_2_19(2)) {
      userfn = userfndef();
                           {if (true) return new UserFnNode(userfn, context);}
    } else if (jj_2_20(2)) {
      s = operatorexpr();
      if (jj_2_18(2)) {
        m = jj_consume_token(MONADICOPERATOR);
      } else {
        ;
      }
       if(m!=null)
         {if (true) return buildMonadicOperator(m.toString(), s);}
       else
         {if (true) return s;}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public AstNode userfndef() throws ParseException {
  AstNode fnBody = null;
    jj_consume_token(24);
    fnBody = expr();
    jj_consume_token(25);
    {if (true) return fnBody;}
    throw new Error("Missing return statement in function");
  }

  final public Func operatorexpr() throws ParseException {
  Func right = null;
    if (jj_2_21(2)) {
      right = function_or_inner_product();
    {if (true) return right;}
    } else if (jj_2_22(2)) {
      right = monadic_operator_as_fn();
    {if (true) return right;}
    } else if (jj_2_23(2)) {
      right = outer_product();
        {if (true) return right;}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Func outer_product() throws ParseException {
  Func right = null;
    jj_consume_token(OUTERPROD);
    right = operatorexpr();
          {if (true) return new OuterProdFn(right);}
    throw new Error("Missing return statement in function");
  }

  final public Func monadic_operator_as_fn() throws ParseException {
  Token s = null;
    s = jj_consume_token(MONADICOPERATOR);
          {if (true) return lookupFn(s.toString());}
    throw new Error("Missing return statement in function");
  }

  final public Func operatorexpr_noinnerprod() throws ParseException {
        Func s = null;
        Token t = null;
    if (jj_2_24(2)) {
      s = outer_product();
          {if (true) return s;}
    } else if (jj_2_25(2)) {
      s = monadic_operator_as_fn();
      {if (true) return s;}
    } else if (jj_2_26(2)) {
      t = jj_consume_token(FUNC);
      {if (true) return lookupFn(t.toString());}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Func function_or_inner_product() throws ParseException {
  Token s = null;
  Token t = null;
  Func right = null;
  List<Func> chain = new ArrayList<Func>();
    s = jj_consume_token(FUNC);
    label_3:
    while (true) {
      if (jj_2_27(2)) {
        ;
      } else {
        break label_3;
      }
      jj_consume_token(26);
      right = operatorexpr_noinnerprod();
          chain.add(right);
    }
          if(chain.size() > 1)
          {
            chain.add(0,lookupFn(s.toString()));
            Func x = chain.get(0);
            for(int i=1; i<chain.size(); i++)
            {
              x = new InnerProdFn(x, chain.get(i));
            }
                {if (true) return x;}
          }
          else if(chain.size()==1)
          {
            {if (true) return new InnerProdFn(lookupFn(s.toString()), chain.get(0));}
          }
          else
          {
             {if (true) return lookupFn(s.toString());}
          }
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  private boolean jj_2_11(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_11(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  private boolean jj_2_12(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_12(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(11, xla); }
  }

  private boolean jj_2_13(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_13(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(12, xla); }
  }

  private boolean jj_2_14(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_14(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(13, xla); }
  }

  private boolean jj_2_15(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_15(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(14, xla); }
  }

  private boolean jj_2_16(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_16(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(15, xla); }
  }

  private boolean jj_2_17(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_17(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(16, xla); }
  }

  private boolean jj_2_18(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_18(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(17, xla); }
  }

  private boolean jj_2_19(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_19(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(18, xla); }
  }

  private boolean jj_2_20(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_20(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(19, xla); }
  }

  private boolean jj_2_21(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_21(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(20, xla); }
  }

  private boolean jj_2_22(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_22(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(21, xla); }
  }

  private boolean jj_2_23(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_23(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(22, xla); }
  }

  private boolean jj_2_24(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_24(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(23, xla); }
  }

  private boolean jj_2_25(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_25(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(24, xla); }
  }

  private boolean jj_2_26(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_26(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(25, xla); }
  }

  private boolean jj_2_27(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_27(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(26, xla); }
  }

  private boolean jj_3_4() {
    if (jj_scan_token(18)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3_16() {
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3_14() {
    if (jj_scan_token(18)) return true;
    if (jj_3R_10()) return true;
    if (jj_scan_token(19)) return true;
    return false;
  }

  private boolean jj_3R_10() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_16()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3_17()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_26() {
    if (jj_scan_token(FUNC)) return true;
    return false;
  }

  private boolean jj_3R_5() {
    if (jj_3R_8()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_4()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3_5()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_16() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_24()) {
    jj_scanpos = xsp;
    if (jj_3_25()) {
    jj_scanpos = xsp;
    if (jj_3_26()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_24() {
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3_25() {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_9() {
    if (jj_scan_token(ID)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_14()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3_15()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_scan_token(MONADICOPERATOR)) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_3R_5()) return true;
    return false;
  }

  private boolean jj_3R_4() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3_3()) return true;
    }
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_scan_token(OUTERPROD)) return true;
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3_12() {
    if (jj_scan_token(20)) return true;
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(17)) return true;
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3R_7() {
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3_11() {
    if (jj_scan_token(CPLXCONSTANT)) return true;
    return false;
  }

  private boolean jj_3_10() {
    if (jj_scan_token(STRING)) return true;
    return false;
  }

  private boolean jj_3_9() {
    if (jj_scan_token(CONSTANT)) return true;
    return false;
  }

  private boolean jj_3_23() {
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3_13() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_8()) {
    jj_scanpos = xsp;
    if (jj_3_9()) {
    jj_scanpos = xsp;
    if (jj_3_10()) {
    jj_scanpos = xsp;
    if (jj_3_11()) {
    jj_scanpos = xsp;
    if (jj_3_12()) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3_6() {
    if (jj_scan_token(18)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3_8() {
    if (jj_3R_9()) return true;
    return false;
  }

  private boolean jj_3R_17() {
    Token xsp;
    if (jj_3_13()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_13()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3_22() {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_21()) {
    jj_scanpos = xsp;
    if (jj_3_22()) {
    jj_scanpos = xsp;
    if (jj_3_23()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_21() {
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3_18() {
    if (jj_scan_token(MONADICOPERATOR)) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3_7() {
    if (jj_3R_8()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_6()) jj_scanpos = xsp;
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3_15() {
    if (jj_scan_token(22)) return true;
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3R_11() {
    if (jj_scan_token(24)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3_27() {
    if (jj_scan_token(26)) return true;
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3_17() {
    if (jj_scan_token(23)) return true;
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3_20() {
    if (jj_3R_12()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_18()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_6() {
    if (jj_3R_17()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_7()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_19() {
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_8() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_19()) {
    jj_scanpos = xsp;
    if (jj_3_20()) return true;
    }
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_scan_token(FUNC)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_27()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  /** Generated Token Manager. */
  public AplParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[0];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[27];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public AplParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AplParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AplParserTokenManager(this, jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public AplParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AplParserTokenManager(this, jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public AplParser(AplParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(AplParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[27];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 0; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 27; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 27; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
            case 10: jj_3_11(); break;
            case 11: jj_3_12(); break;
            case 12: jj_3_13(); break;
            case 13: jj_3_14(); break;
            case 14: jj_3_15(); break;
            case 15: jj_3_16(); break;
            case 16: jj_3_17(); break;
            case 17: jj_3_18(); break;
            case 18: jj_3_19(); break;
            case 19: jj_3_20(); break;
            case 20: jj_3_21(); break;
            case 21: jj_3_22(); break;
            case 22: jj_3_23(); break;
            case 23: jj_3_24(); break;
            case 24: jj_3_25(); break;
            case 25: jj_3_26(); break;
            case 26: jj_3_27(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}

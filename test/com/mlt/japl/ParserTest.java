package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mlt.japl.ast.AstNode;
import com.mlt.japl.ast.ConstArrayNode;
import com.mlt.japl.ast.ConstantAstNode;
import com.mlt.japl.ast.DyadicCallNode;
import com.mlt.japl.ast.IdentifierNode;
import com.mlt.japl.ast.IndexExprNode;
import com.mlt.japl.ast.MonadicCallNode;
import com.mlt.japl.errors.SyntaxError;
import com.mlt.japl.fns.AddFn;
import com.mlt.japl.parser.AplParser;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.workspace.EvalContext;

public class ParserTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private EvalContext ctx;
	
	public ParserTest() {
		ctx = new EvalContext();
		ctx.set("fn", new AddFn());
		ctx.set("x", new IntScalar(42));
	}
	
	private String doParseAndPrint(String s) {
		return doParse(s).print();
	}

	private AstNode doParse(String s) {
		AplParser parser = new AplParser(new StringReader(s), ctx);
		return parser.parse();
	}

	@Test
	public void testScalarParse() {
		AstNode node = doParse("2");
		assertTrue(node instanceof ConstantAstNode);
		assertEquals("2", node.print());
	}
	
	@Test
	public void testArrayParse() {
		AstNode node = doParse("2 3 4");
		assertTrue(node instanceof ConstArrayNode);
		assertEquals("2 3 4", node.print());
	}
	
	@Test
	public void testMonadicParse() {
		AstNode node = doParse("+2 3 4");
		assertTrue(node instanceof MonadicCallNode);
		assertEquals("+(2 3 4)", node.print());
	}
	
	@Test
	public void testDyadicParse() {
		AstNode node = doParse("2+4 5 6");
		assertTrue(node instanceof DyadicCallNode);
		DyadicCallNode dn = (DyadicCallNode)node;
		assertTrue(dn.getLeft() instanceof ConstantAstNode);
		assertTrue(dn.getRight() instanceof ConstArrayNode);
		assertEquals("+(2,4 5 6)", node.print());
	}
	
	@Test
	public void testDoubleMonadicParse() {
		AstNode node = doParse("++2 3 4");
		assertEquals("+(+(2 3 4))", node.print());
	}
	
	@Test
	public void testMonadicDyadic() {
		assertEquals("+(+(4 5 6,7 8))", doParseAndPrint("+4 5 6+7 8"));
	}
	
	@Test
	public void testParens() {
		assertEquals("+(+(2,3),+(4,5))", doParseAndPrint("(2+3)+(4+5)"));
	}

	@Test
	public void testToplevelParens() {
		AstNode n = doParse("((2+3)+(4+5))");
		assertTrue(n instanceof DyadicCallNode);
		assertEquals("+(+(2,3),+(4,5))", n.print());
	}

	@Test
	public void testSingleElementParens() {
		assertEquals("+(+(2,3),+(4,5))", doParseAndPrint("(2+(3))+(4+5)"));
	}
	
	@Test
	public void testUnbalancedParens() {
		thrown.expect(SyntaxError.class);
		doParseAndPrint("(2+(3)))+4+5)");
	}
	
	@Test
	public void testIndexExpr1() {
		AstNode node = doParse("x[4 2]");
		assertTrue(node instanceof IdentifierNode);
		IdentifierNode n = (IdentifierNode)node;
		assertNotNull(n.getIndexExpr());
		assertTrue(n.getIndexExpr() instanceof IndexExprNode);
		assertEquals("x[4 2]", node.print());
	}

	@Test
	public void testIndexExpr2() {
		assertEquals("evalarray[x[3;+(4,2)],5]", doParseAndPrint("x[3; 4+2] 5"));
		assertEquals("evalarray[x[;;],5]", doParseAndPrint("x[;;] 5"));
	}
	
	@Test
	public void testIdentifier() {
		assertEquals("x", doParseAndPrint("x"));
	}

	@Test
	public void testFunctionIdentifierMonadic() {
		assertEquals("+(2 3)", doParseAndPrint("fn 2 3"));
	}

	@Test
	public void testFunctionIdentifierDyadic() {
		assertEquals("+(2 3,3)", doParseAndPrint("2 3 fn 3"));
	}

	@Test
	public void testFunctionIdentifierChained() {
		assertEquals("+(+(2 3,3))", doParseAndPrint("fn 2 3 fn 3"));
	}
	
	@Test
	public void testScanExpr() {
		assertEquals("scan<+>(2 3 4)", doParseAndPrint("+\\2 3 4"));
	}

	@Test
	public void testScanExprWithIdentifier() {
		assertEquals("scan<+>(2 3 4)", doParseAndPrint("fn\\2 3 4"));
	}
	
	@Test
	public void testReduceExpr() {
		assertEquals("reduce<+>(2 3 4)", doParseAndPrint("+/2 3 4"));
	}

	@Test
	public void testReduceExprWithIdenfier() {
		assertEquals("reduce<+>(2 3 4)", doParseAndPrint("fn/2 3 4"));
	}
	
	@Test
	public void testOuterProdExpr() {
		assertEquals("outerprod<+>(1 2 3,2 3 4)", doParseAndPrint("1 2 3\u2218.+2 3 4"));
	}

	@Test
	public void testOuterProdExprWithIdentifier() {
		assertEquals("outerprod<+>(1 2 3,2 3 4)", doParseAndPrint("1 2 3\u2218.fn2 3 4"));
	}

	@Test
	public void testOuterProdExprWithComplicatedFunction() {
		assertEquals("reduce<outerprod<+>>(1 2 3,2 3 4)", doParseAndPrint("1 2 3\u2218.+/2 3 4"));
	}

	@Test
	public void testOuterProdExprWithComplicatedFunction2() {
		assertEquals("reduce<outerprod<outerprod<+>>>(1 2 3,2 3 4)", doParseAndPrint("1 2 3\u2218.\u2218.+/2 3 4"));
	}

	@Test
	public void testInnerProdExprWithComplicatedFunction() {
		assertEquals("innerprod<innerprod<+,*>,->(1 2 3,2 3 4)", doParseAndPrint("1 2 3+.×.−2 3 4"));
	}

	@Test
	public void testMixedInnerOuterProduct() {
		assertEquals("scan<innerprod<+,outerprod<->>>(2 3 4)", doParseAndPrint("+.\u2218.−\\2 3 4"));
	}

	@Test
	public void testMixedInnerOuterProduct2() {
		assertEquals("scan<innerprod<+,outerprod<innerprod<-,outerprod<+>>>>>(2 3 4)", doParseAndPrint("+.\u2218.−.\u2218.+\\2 3 4"));
	}
	
	@Test
	public void testInnerProdExpr() {
		assertEquals("innerprod<+,+>(1 2 3,2 3 4)", doParseAndPrint("1 2 3+.+2 3 4"));
	}

	@Test
	public void testInnerProdWithIdentifier() {
		assertEquals("innerprod<+,+>(1 2 3,2 3 4)", doParseAndPrint("1 2 3fn.+2 3 4"));
		assertEquals("innerprod<+,+>(1 2 3,2 3 4)", doParseAndPrint("1 2 3+.fn2 3 4"));
	}
	
	@Test
	public void testAxisExpression() {
		assertEquals("reduce<+>[+(1,2)](2 3 4 5)", doParseAndPrint("+/[1+2]2 3 4 5"));
	}
	
	@Test
	public void testStringLiteral() {
		assertEquals("2 'foo' 3", doParseAndPrint("2 'foo' 3"));
	}

	@Test
	public void testStringLiteralTopLevel() {
		assertEquals("'foo' 'bar'", doParseAndPrint("'foo' 'bar'"));
	}

	@Test
	public void testNegative() {
		assertEquals("¯2", doParseAndPrint("¯2"));
	}

	@Test
	public void testEmptyCharScalar() {
		assertEquals("''", doParseAndPrint("''"));
	}
	
	@Test
	public void testNegativeFloat() {
		assertEquals("¯2.14", doParseAndPrint("¯2.14"));
	}
	
	@Test
	public void testAssign() {
		assertEquals("x <- 2 3", doParseAndPrint("x←2 3"));
	}
	
	@Test
	public void testUserFn() {
		assertEquals("{ +(2,3) }(2 3)", doParseAndPrint("{2 fn 3} 2 3"));
	}

	@Test
	public void testUserFnDyadic() {
		assertEquals("{ +(2,3) }(2 3,5 6)", doParseAndPrint("2 3 {2 fn 3} 5 6"));
	}

	@Test
	public void testUserFnDyadicCombined() {
		assertEquals("{ +(2,3) }(2 3,+(5 6,2))", doParseAndPrint("2 3 {2 fn 3} 5 6 + 2"));
	}
	
}

package com.mlt.japl.ast;

import java.util.List;

import com.mlt.japl.arrays.CharArray;
import com.mlt.japl.arrays.DoubleArray;
import com.mlt.japl.arrays.IntArray;
import com.mlt.japl.arrays.NestedArray;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.CharScalar;
import com.mlt.japl.scalars.DoubleScalar;
import com.mlt.japl.scalars.IntScalar;
import com.mlt.japl.workspace.EvalContext;

public class ConstArrayNode implements AstNode {	
	private List<AstNode> nodes;
	private Array value;

	public ConstArrayNode(List<AstNode> nodes) {
		this.nodes = nodes;

		// determine array type
		int doubleNodes = 0;
		int intNodes = 0;
		int charNodes = 0;
		int stringNodes = 0;
		int complexNodes = 0;
		
		int totalLen = nodes.size();
		
		for(AstNode n : nodes) {
			ConstantAstNode c = (ConstantAstNode)n;
			if(c.isStringConstant()) {
				stringNodes++;
			} else if(c.isDouble()) {
				doubleNodes++;
			} else if(c.isInteger()) {
				intNodes++;
			} else if(c.isCharConstant()) { 
				charNodes++;
			} else if(c.isComplex()) {
				complexNodes++;
			} else
				throw new RuntimeException("unknown constant type");
		}

		if(totalLen == intNodes) {  // contains only int tokens -> intarray
			long[] data = new long[totalLen];
			int i=0;
			for(AstNode n : nodes) {
				data[i++] = ((ConstantAstNode)n).getInt();
			}
			value = new IntArray(data);
		} else if(totalLen == (doubleNodes + intNodes)) {   // contains only int and double tokens -> doublearray
			double[] data = new double[totalLen];
			int i=0;
			for(AstNode n : nodes) {
				data[i++] = ((ConstantAstNode)n).getDouble();
			}
			value = new DoubleArray(data);
		} else if(totalLen == charNodes) {   // only charnodes -> char array
			char[] data = new char[totalLen];
			int i=0;
			for(AstNode n : nodes) {
				data[i++] = ((ConstantAstNode)n).getChar();
			}
			value = new CharArray(data);
		} else {   // mixed array
			Array[] data = new Array[totalLen];
			int i=0;
			for(AstNode n : nodes) {
				ConstantAstNode x = (ConstantAstNode)n;
				Array cell = null;
				if(x.isDouble()) cell = new DoubleScalar(x.getDouble());
				else
				if(x.isInteger()) cell = new IntScalar(x.getInt());
				else
				if(x.isCharConstant()) cell = new CharScalar(x.getChar());
				else
				if(x.isComplex()) cell = x.getAsCell();
				else
				if(x.isStringConstant()) cell = new CharArray(x.getString());
				data[i++] = cell;
			}
			value = new NestedArray(data);			
		}
	}
	
	@Override
	public Array eval(EvalContext context) {
		return value;
	}

	@Override
	public String print() {
		StringBuilder builder = new StringBuilder();
		int i=0;
		int length = nodes.size();
		for(AstNode a : nodes) {
			builder.append(a.print());
			i++;
			if(i!=length)
				builder.append(' ');
		}
		return builder.toString();
	}

}

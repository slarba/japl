package com.mlt.japl.ast;

import java.util.List;

import com.mlt.japl.iface.Array;
import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.concrete.BitArray;
import com.mlt.japl.newarrays.concrete.CharArray;
import com.mlt.japl.newarrays.concrete.CharScalar;
import com.mlt.japl.newarrays.concrete.DoubleArray;
import com.mlt.japl.newarrays.concrete.DoubleScalar;
import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.IntScalar;
import com.mlt.japl.newarrays.concrete.MixedArray;
import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.workspace.EvalContext;

public class ConstArrayNode implements AstNode {	
	private List<AstNode> nodes;
	private IValue value;

	public ConstArrayNode(List<AstNode> nodes) {
		this.nodes = nodes;

		// determine array type
		int doubleNodes = 0;
		int intNodes = 0;
		int charNodes = 0;
		int stringNodes = 0;
		int complexNodes = 0;
		int totalIntZerosOnes = 0;
		
		int totalLen = nodes.size();
		
		for(AstNode n : nodes) {
			ConstantAstNode c = (ConstantAstNode)n;
			if(c.isStringConstant()) {
				stringNodes++;
			} else if(c.isDouble()) {
				doubleNodes++;
			} else if(c.isInteger()) {
				intNodes++;
				long v = c.getInt();
				if(v==1 || v==0)
					totalIntZerosOnes++;
			} else if(c.isCharConstant()) { 
				charNodes++;
			} else if(c.isComplex()) {
				complexNodes++;
			} else
				throw new RuntimeException("unknown constant type");
		}

		if(totalLen == totalIntZerosOnes) {
			BitArray b = new BitArray(new Dimensions(totalIntZerosOnes));
			int i=0;
			for(AstNode n : nodes) {
				b.setBit(i++, ((ConstantAstNode)n).getInt());
			}
			value = b;
		} else if(totalLen == intNodes) {  // contains only int tokens -> intarray
			long[] data = new long[totalLen];
			int i=0;
			for(AstNode n : nodes) {
				data[i++] = ((ConstantAstNode)n).getInt();
			}
			value = new IntArray(new Dimensions(data.length), data);
		} else if(totalLen == (doubleNodes + intNodes)) {   // contains only int and double tokens -> doublearray
			double[] data = new double[totalLen];
			int i=0;
			for(AstNode n : nodes) {
				data[i++] = ((ConstantAstNode)n).getDouble();
			}
			value = new DoubleArray(new Dimensions(data.length), data);
		} else if(totalLen == charNodes) {   // only charnodes -> char array
			char[] data = new char[totalLen];
			int i=0;
			for(AstNode n : nodes) {
				data[i++] = ((ConstantAstNode)n).getChar();
			}
			value = new CharArray(new Dimensions(data.length), data);
		} else {   // mixed array
			IValue[] data = new IValue[totalLen];
			int i=0;
			for(AstNode n : nodes) {
				ConstantAstNode x = (ConstantAstNode)n;
				IValue cell = null;
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
			value = new MixedArray(new Dimensions(data.length), data);			
		}
	}
	
	@Override
	public IValue eval(EvalContext context) {
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

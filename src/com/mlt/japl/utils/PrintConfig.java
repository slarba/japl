package com.mlt.japl.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.mlt.japl.iface.Array;
import com.mlt.japl.tools.Iterator;

public class PrintConfig {

	public String padToMaxLength(int maxLen, int len) {
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<maxLen-len; i++) {
			builder.append(' ');
		}
		return builder.toString();
	}

	public String getDoubleFormatString() {
		return "%.2f";
	}

	public String print(long data) {
		return Long.toString(data);
	}
	
	public String print(double data) {
		if(data==(long)data) return Long.toString((long)data);
		return String.format(Locale.US, getDoubleFormatString(), data);
	}

	public String print(char data) {
		return Character.toString(data);
	}

	public String print(double re, double im) {
		return "0J0";
	}

	private int stringWidth(String s) {
		String[] split = s.split("\n");
		int len = 0;
		for(String x : split) {
			len = Math.max(len, x.length());
		}
		return len;
	}
	
	public String print(Array a) {
//		if(a.rank()==0) {
//			return get(0).asString(config);
//		}
		String space = " ";
		if(a.type()==Array.CHARACTER) space="";
		
		int lastDim = a.dims().lastDim();
		int[] maxLens = computLastDimMaxWidths(a, lastDim);

		int totalRowLen = 0;
		for(int i=0; i<maxLens.length; i++) totalRowLen += maxLens[i];
		
		StringBuilder builder = new StringBuilder();
		Iterator indexer = a.dims().iteratorAlongLastAxis();
		
		for(int i=0; i<a.length(); i+=lastDim) {
			int maxSubRowHeight = 0;
			List<String[]> row = new ArrayList<String[]>();
			
			for(int j=0; j<lastDim; j++) {
				String s = a.atA(i+j).asString(this).trim();
				String[] subrows = s.split("\n");
				maxSubRowHeight = Math.max(maxSubRowHeight, subrows.length);
				row.add(subrows);
			}
			for(int n=0; n<maxSubRowHeight; n++) {
				for(int j=0; j<lastDim; j++) {
					String[] rowPart = row.get(j);
					String spacer = rowPart.length>1 ? "|" : space;
					boolean last = j==lastDim-1;
					boolean outputNewLine = rowPart.length>1;
					if(n>=rowPart.length) {
						builder.append(padToMaxLength(maxLens[j], 0));
						if(!last) builder.append(spacer); else if(outputNewLine) builder.append('\n');
						continue;
					} else {
						String s = rowPart[n];
						builder.append(padToMaxLength(maxLens[j], s.length()));   // pad to maxLength
						builder.append(s);										
						if(!last) builder.append(spacer); else if(outputNewLine) builder.append('\n');
					}
				}
			}
			int newLines = 1;
			for(int j=0; j<lastDim; j++) {
				indexer.step();
			}			
			for(int k=0; k<newLines; k++) {
				if(maxSubRowHeight>1) {
					for(int x=0; x<totalRowLen+(lastDim-1); x++) builder.append('-');
				}
				builder.append('\n');		
			}
		}
		return builder.toString();
	}

	private int[] computLastDimMaxWidths(Array a, int lastDim) {
		int[] maxLens = new int[lastDim];
		for(int i=0; i<a.length(); i++) {
			int s = i%lastDim;
			maxLens[s] = Math.max(stringWidth(a.atA(i).asString(this)), maxLens[s]);
		}
		return maxLens;
	}
	
}

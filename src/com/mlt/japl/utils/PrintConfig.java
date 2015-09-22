package com.mlt.japl.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.mlt.japl.newarrays.IValue;
import com.mlt.japl.newarrays.interf.IBitArray;
import com.mlt.japl.newarrays.interf.ICharArray;
import com.mlt.japl.newarrays.interf.ICharScalar;
import com.mlt.japl.newarrays.interf.IDoubleArray;
import com.mlt.japl.newarrays.interf.IDoubleScalar;
import com.mlt.japl.newarrays.interf.IIntArray;
import com.mlt.japl.newarrays.interf.IIntScalar;
import com.mlt.japl.newarrays.interf.IMixedArray;
import com.mlt.japl.newarrays.interf.IMixedScalar;
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

	private int[] computeLastDimMaxWidths(String[] a, int lastDim) {
		int[] maxLens = new int[lastDim];
		for(int i=0; i<a.length; i++) {
			int s = i%lastDim;
			maxLens[s] = Math.max(stringWidth(a[i]), maxLens[s]);
		}
		return maxLens;
	}

	public String print(IBitArray a) {
		// compute column widths
		int lastDim = a.dims().lastDim();
		
		StringBuilder builder = new StringBuilder();
		Iterator indexer = a.dims().iteratorAlongLastAxis();
		
		for(int i=0; i<a.length(); i+=lastDim) {			
			int newLines = 0;
			for(int j=0; j<lastDim; j++) {
				String s = print(a.get(i+j));
				builder.append(s);
				if(j!=lastDim-1)
					builder.append(' ');
				newLines = indexer.step();
			}
			for(int k=0; k<newLines-1; k++) {
				builder.append('\n');		
			}
		}
		return builder.toString();		
	}
	
	public String print(IMixedArray a) {
		StringBuilder buffer = new StringBuilder();
		String[] arr = new String[a.dims().length()];
		boolean space = false;
		for(int i=0; i<arr.length; i++) {
			boolean firstCol = i % a.dims().axis(a.rank()-1) == 0;
			IValue v = a.get(i);
			if(v instanceof ICharScalar) {
				arr[i] = (space ? " " : "") + v.asString(this);
				space = false;
			} else {
				arr[i] = (firstCol ? "": " ") + (space ? " " : "") + v.asString(this);
				space = true;
			}
		}
		int lastDim = a.dims().lastDim();
		int[] maxLens = computeLastDimMaxWidths(arr, lastDim);
		Iterator indexer = a.dims().iteratorAlongLastAxis();

		for(int i=0; i<arr.length; i+=lastDim) {
			// splitataan tulostettavan rivin elementit riveiksi
			List<String[]> rivi = new ArrayList<String[]>();
			for(int j=0; j<lastDim; j++) rivi.add(arr[i+j].split("\n"));
			int maxSubRows=0;
			int newLines = 1;
			for(int j=0; j<lastDim; j++) {
				maxSubRows = Math.max(maxSubRows, rivi.get(j).length);
				newLines = indexer.step();
			}
			for(int subRow=0; subRow<maxSubRows; subRow++) {
				buffer.append(' ');
				for(int j=0; j<lastDim; j++) {
					String[] sr = rivi.get(j);
					if(subRow<sr.length) {
						String r = sr[subRow];
						buffer.append(padToMaxLength(maxLens[j], r.length()));
						buffer.append(r);
					} else {
						buffer.append(padToMaxLength(maxLens[j], 0));
					}
				}
				buffer.append('\n');
			}
			for(int k=0; k<newLines-2; k++)
				buffer.append('\n');
		}
		return buffer.toString();
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
	
	public String print(IIntScalar a) {
		long val = a.get();
		if(val<0) return "¯" + (-val);
		return Long.toString(val);
	}

	public String print(IDoubleScalar a) {
		double val = a.get();
		if(val==(long)val) return print((long)val);
		if(val<0) return "¯" + String.format(Locale.US, getDoubleFormatString(), -val);
		return String.format(Locale.US, getDoubleFormatString(), val);
	}

	public String print(ICharScalar a) {
		char val = a.get();
		return Character.toString(val);
	}

	public String print(IMixedScalar a) {
		String s = a.get().asString(this);
		String[] ss = s.split("\n");
		StringBuilder b = new StringBuilder();
		for(String x : ss) {
			b.append(' ');
			b.append(x);
			b.append('\n');
		}
		return " " + b.toString().trim();
	}

	public String print(long val) {
		if(val<0) return "¯" + (-val);
		return Long.toString(val);
	}

	public String print(double val) {
		if(val==(long)val) return print((long)val);
		if(val<0) return "¯" + String.format(Locale.US, getDoubleFormatString(), -val);
		return String.format(Locale.US, getDoubleFormatString(), val);
	}

	public String print(IIntArray a) {
		// compute column widths
		int lastDim = a.dims().lastDim();
		int[] maxLens = computLastDimMaxWidths(a, lastDim);
		
		StringBuilder builder = new StringBuilder();
		Iterator indexer = a.dims().iteratorAlongLastAxis();
		
		for(int i=0; i<a.length(); i+=lastDim) {			
			int newLines = 0;
			for(int j=0; j<lastDim; j++) {
				String s = print(a.get(i+j));
				builder.append(padToMaxLength(maxLens[j], s.length()));
				builder.append(s);
				if(j!=lastDim-1)
					builder.append(' ');
				newLines = indexer.step();
			}
			for(int k=0; k<newLines-1; k++) {
				builder.append('\n');		
			}
		}
		return builder.toString();		
	}

	private int[] computLastDimMaxWidths(IIntArray a, int lastDim) {
		int[] maxLens = new int[lastDim];
		for(int i=0; i<a.length(); i++) {
			int s = i%lastDim;
			maxLens[s] = Math.max(print(a.get(i)).length(), maxLens[s]);
		}
		return maxLens;
	}
	
	public String print(IDoubleArray a) {
		// compute column widths
		int lastDim = a.dims().lastDim();
		int[] maxLens = computLastDimMaxWidths(a, lastDim);
		
		StringBuilder builder = new StringBuilder();
		Iterator indexer = a.dims().iteratorAlongLastAxis();
		
		for(int i=0; i<a.length(); i+=lastDim) {			
			int newLines = 1;
			for(int j=0; j<lastDim; j++) {
				String s = print(a.get(i+j));
				builder.append(padToMaxLength(maxLens[j], s.length()));
				builder.append(s);
				if(j!=lastDim-1)
					builder.append(' ');
				newLines = indexer.step();
			}
			for(int k=0; k<newLines-1; k++) {
				builder.append('\n');		
			}
		}
		return builder.toString();		
	}

	private int[] computLastDimMaxWidths(IDoubleArray a, int lastDim) {
		int[] maxLens = new int[lastDim];
		for(int i=0; i<a.length(); i++) {
			int s = i%lastDim;
			maxLens[s] = Math.max(print(a.get(i)).length(), maxLens[s]);
		}
		return maxLens;
	}

	public String print(ICharArray a) {
		int lastDim = a.dims().lastDim();

		StringBuilder builder = new StringBuilder();
		Iterator indexer = a.dims().iteratorAlongLastAxis();
		
		for(int i=0; i<a.length(); i+=lastDim) {			
			int newLines = 1;
			for(int j=0; j<lastDim; j++) {
				builder.append(a.get(i+j));
				newLines = indexer.step();
			}
			for(int k=0; k<newLines-1; k++) {
				builder.append('\n');		
			}
		}
		return builder.toString();		
	}
	
}

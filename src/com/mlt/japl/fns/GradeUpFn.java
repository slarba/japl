package com.mlt.japl.fns;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import com.mlt.japl.errors.DomainError;
import com.mlt.japl.iface.Array;
import com.mlt.japl.scalars.BaseScalar;
import com.mlt.japl.tools.Dimensions;

public class GradeUpFn extends SpecialBaseFn {

	private boolean up;

	public GradeUpFn(boolean up) {
		this.up = up;
	}
	
	class CmpOrder {
		public CmpOrder(BaseScalar a, int i) {
			array = a;
			ordinal = i;
		}
		public BaseScalar array;
		public int ordinal;
	}

	class AscendingOrderComparator implements Comparator<CmpOrder> {
		@Override
		public int compare(CmpOrder o1, CmpOrder o2) {
			return o1.array.compareTo(o2.array);
		}
	}

	class DescendignOrderComparator implements Comparator<CmpOrder> {
		@Override
		public int compare(CmpOrder o1, CmpOrder o2) {
			return o2.array.compareTo(o1.array);
		}
	}

	@Override
	public Array monadic(Array a, int axis) {
		if(a.type()==Array.MIXED) throw new DomainError();
		List<CmpOrder> cmp = new ArrayList<CmpOrder>();
		for(int i=0; i<a.length(); i++) {
			cmp.add(new CmpOrder((BaseScalar)a.atA(i), i+1));
		}
		cmp.sort(up ? new AscendingOrderComparator() : new DescendignOrderComparator());
		Array result = ArrayFactory.makeArrayOfType(Array.INTEGER, new Dimensions(cmp.size()));
		for(int i=0; i<cmp.size(); i++) {
			result.setI(i, cmp.get(i).ordinal);
		}
		return result;
	}
	
	@Override
	public String getName() {
		return "grade";
	}

	@Override
	public int resultTypeFor(Array a) {
		return Array.INTEGER;
	}

	@Override
	public int resultTypeFor(Array a, Array b) {
		return Array.INTEGER;
	}

	@Override
	public Dimensions resultDimsFor(Array a, int axis) {
		return new Dimensions(a.length());
	}

	@Override
	public Dimensions resultDimsFor(Array a, Array b, int axis) {
		return new Dimensions(b.length());
	}

}

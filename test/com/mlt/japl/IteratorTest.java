package com.mlt.japl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mlt.japl.tools.Dimensions;
import com.mlt.japl.tools.Iterator;

public class IteratorTest {

	@Test
	public void testAxisIteratorWithEmptyDimensions() {
		Dimensions n = new Dimensions(3);
		Dimensions r = n.elideAxis(0);
		Iterator i = r.linearIterator();
		assertTrue(i.isFinished());
	}
	
	@Test
	public void testAxisIteration() {
		Dimensions n = new Dimensions(2,3);
		Iterator i = n.iteratorAlongAxis(1);
		
		assertEquals(0, i.axis(0));
		assertEquals(0, i.axis(1));
		assertEquals(0, i.index());
		assertFalse(i.isFinished());
		i.step();
		assertEquals(0, i.axis(0));
		assertEquals(1, i.axis(1));
		assertEquals(1, i.index());
		assertFalse(i.isFinished());
		i.step();
		assertEquals(0, i.axis(0));
		assertEquals(2, i.axis(1));
		assertEquals(2, i.index());
		assertFalse(i.isFinished());
		i.step();
		assertEquals(1, i.axis(0));
		assertEquals(0, i.axis(1));
		assertEquals(3, i.index());
		assertFalse(i.isFinished());
		i.step();
		assertEquals(1, i.axis(0));
		assertEquals(1, i.axis(1));
		assertEquals(4, i.index());
		assertFalse(i.isFinished());
		i.step();
		assertEquals(1, i.axis(0));
		assertEquals(2, i.axis(1));
		assertEquals(5, i.index());
		assertFalse(i.isFinished());
		i.step();

		
		assertTrue(i.isFinished());
	}

	@Test
	public void testAxisIteration2() {
		Dimensions n = new Dimensions(2,3);
		Iterator i = n.iteratorAlongAxis(0);
		
		assertEquals(0, i.axis(0));
		assertEquals(0, i.axis(1));
		assertEquals(0, i.index());
		assertFalse(i.isFinished());
		i.step();
		assertEquals(1, i.axis(0));
		assertEquals(0, i.axis(1));
		assertEquals(3, i.index());
		assertFalse(i.isFinished());
		i.step();
		assertEquals(0, i.axis(0));
		assertEquals(1, i.axis(1));
		assertEquals(1, i.index());
		assertFalse(i.isFinished());
		i.step();
		assertEquals(1, i.axis(0));
		assertEquals(1, i.axis(1));
		assertEquals(4, i.index());
		assertFalse(i.isFinished());
		i.step();
		assertEquals(0, i.axis(0));
		assertEquals(2, i.axis(1));
		assertEquals(2, i.index());
		assertFalse(i.isFinished());
		i.step();
		assertEquals(1, i.axis(0));
		assertEquals(2, i.axis(1));
		assertEquals(5, i.index());
		assertFalse(i.isFinished());
		i.step();
		
		assertTrue(i.isFinished());
	}
}

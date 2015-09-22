package com.mlt.japl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mlt.japl.newarrays.concrete.IntArray;
import com.mlt.japl.newarrays.concrete.MixedArray;
import com.mlt.japl.newfns.Indexer;
import com.mlt.japl.newfns.RangeIndexer;
import com.mlt.japl.tools.Dimensions;

public class IndexerTest {

	@Test
	public void test() {
		RangeIndexer indexer = new RangeIndexer(2);
		assertEquals(0, indexer.get());
		assertFalse(indexer.step());
		assertEquals(1, indexer.get());
		assertTrue(indexer.step());
		assertEquals(0, indexer.get());
		assertFalse(indexer.step());
	}

}

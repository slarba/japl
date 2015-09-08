package com.mlt.japl.newtests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.mlt.japl.workspace.Interpreter;

@RunWith(Parameterized.class)
public class OpTest {

	private File file;
	private Interpreter itp;
	private OutputStream out;
	private OutputStream err;
	
	@Parameters
	public static Collection<Object[]> getFiles() {
		Collection<Object[]> params = new ArrayList<Object[]>();
		for(File f : new File("tests").listFiles()) {
			Object[] arr = new Object[] { f };
			params.add(arr);
		}
		return params;
	}
	
	public OpTest(File f) {
		file = f;
		out = new ByteArrayOutputStream();
		err = new ByteArrayOutputStream();
		itp = new Interpreter(out, err);
	}
	
	@Test
	public void test() throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		while((line=r.readLine())!=null) {
			itp.eval(line);
		}
	}

}

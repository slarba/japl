package com.mlt.japl.newtests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringBufferInputStream;
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
	}
	
	@Test
	public void test() throws IOException, FileNotFoundException {
		BufferedReader testInput = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line;
		int linenum = 1;
		while((line=testInput.readLine())!=null) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Interpreter itp = new Interpreter(out, out);
			line = line.trim() + "\n";
			itp.eval(new ByteArrayInputStream(line.getBytes("UTF-8")));
			out.flush();
			String[] result = out.toString("UTF-8").split("\n");
			for(String s : result) {
				assertEquals("on line " + linenum + ", file " + file.getName(), testInput.readLine(), s);
				linenum++;
			}
			linenum++;
		}
	}
}

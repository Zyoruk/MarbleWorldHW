package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Test;

import analysis.AnalizadorLexico;

public class Tests {

	@Test
	public void test() {
		try {
			Reader r = new FileReader("./src/analysis/input.txt");
			new AnalizadorLexico(new BufferedReader(r));
//			r.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

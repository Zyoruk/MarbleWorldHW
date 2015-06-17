package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Test;

import analysis.AnalizadorLexico;
import analysis.parser;

public class Tests {

	//@Test
	public void test() {
		try {
			Reader r = new FileReader("./src/analysis/input.txt");
			new AnalizadorLexico(new BufferedReader(r));
//			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testCUP() throws Exception{
		parser p = new parser(new AnalizadorLexico(new FileInputStream("./src/analysis/input.txt")));
		p.parse();
	}
}

package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Test;

import errorHandler.ModuloDeErrores;
import analysis.AnalizadorLexico;
import analysis.parser;

public class Tests {

	//@Test
	public void test() {
		try {
			Reader r = new FileReader("./src/analysis/input.txt");
			ModuloDeErrores masterErrors =new ModuloDeErrores();
			new AnalizadorLexico(new BufferedReader(r),masterErrors);
			//			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testCUP() throws Exception{
		ModuloDeErrores masterErrors =new ModuloDeErrores();
		parser p = new parser(new AnalizadorLexico(new FileInputStream("./src/analysis/input.txt"), masterErrors),masterErrors);
		p.parse();
		masterErrors.buildHTML();
	}
}

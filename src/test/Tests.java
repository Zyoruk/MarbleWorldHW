package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

import analysis.AnalizadorLexico;

public class Tests {

	@Test
	public void test() {
		try {
			Reader r = new InputStreamReader(new FileInputStream("./src/analysis/input.txt"), "Cp1252");
			new AnalizadorLexico(new BufferedReader(r));
			r.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

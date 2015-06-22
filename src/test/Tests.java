package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import mightyMain.main;

import org.junit.Test;

import errorHandler.ModuloDeErrores;
import analysis.AnalisisSemantico;
import analysis.AnalizadorLexico;
import analysis.parser;

public class Tests {
	@SuppressWarnings("deprecation")
	//@Test
	public void casoCorrecto() throws Exception{
		ModuloDeErrores masterErrors =new ModuloDeErrores();
		AnalizadorLexico al = new AnalizadorLexico(new FileInputStream("./src/analysis/input.txt"), masterErrors);
		parser p = new parser(al,masterErrors);
		p.parse();
		AnalisisSemantico as = new AnalisisSemantico(al.getSymbolTable());
		as.semanticAnalysis();
		masterErrors.buildHTML();
	}
	@SuppressWarnings("deprecation")
	//@Test
	public void casoConst() throws Exception{
		ModuloDeErrores masterErrors =new ModuloDeErrores();
		AnalizadorLexico al = new AnalizadorLexico(new FileInputStream("./src/analysis/input2.txt"), masterErrors);
		parser p = new parser(al,masterErrors);
		p.parse();
		AnalisisSemantico as = new AnalisisSemantico(al.getSymbolTable());
		as.semanticAnalysis();
		masterErrors.buildHTML();
	}
	@SuppressWarnings("deprecation")
	@Test
	public void casoError() throws Exception{
		ModuloDeErrores masterErrors =new ModuloDeErrores();
		AnalizadorLexico al = new AnalizadorLexico(new FileInputStream("./src/analysis/input3.txt"), masterErrors);
		parser p = new parser(al,masterErrors);
		p.parse();
		AnalisisSemantico as = new AnalisisSemantico(al.getSymbolTable());
		as.semanticAnalysis();
		masterErrors.buildHTML();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void casoCompSameNums() throws Exception{
		ModuloDeErrores masterErrors =new ModuloDeErrores();
		AnalizadorLexico al = new AnalizadorLexico(new FileInputStream("./src/analysis/input4.txt"), masterErrors);
		parser p = new parser(al,masterErrors);
		p.parse();
		AnalisisSemantico as = new AnalisisSemantico(al.getSymbolTable());
		as.semanticAnalysis();
		masterErrors.buildHTML();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void casoCompDiffNums() throws Exception{
		ModuloDeErrores masterErrors =new ModuloDeErrores();
		AnalizadorLexico al = new AnalizadorLexico(new FileInputStream("./src/analysis/input5.txt"), masterErrors);
		parser p = new parser(al,masterErrors);
		p.parse();
		AnalisisSemantico as = new AnalisisSemantico(al.getSymbolTable());
		as.semanticAnalysis();
		masterErrors.buildHTML();
	}
	@SuppressWarnings("deprecation")
	@Test
	public void casoTRUE() throws Exception{
		ModuloDeErrores masterErrors =new ModuloDeErrores();
		AnalizadorLexico al = new AnalizadorLexico(new FileInputStream("./src/analysis/input6.txt"), masterErrors);
		parser p = new parser(al,masterErrors);
		p.parse();
		AnalisisSemantico as = new AnalisisSemantico(al.getSymbolTable());
		as.semanticAnalysis();
		masterErrors.buildHTML();
	}
//	@Test
	public void testMain() throws Exception{
		main m = new main("");
		m.compile();
	}
}

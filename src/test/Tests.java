package test;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import mightyMain.main;

import org.junit.Test;
<<<<<<< HEAD

=======
>>>>>>> origin/master
import generate.GetInput;
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
<<<<<<< HEAD

=======
	@SuppressWarnings("deprecation")
>>>>>>> origin/master
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
	
<<<<<<< HEAD
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
=======
	    @Test
		public void testGenerate() throws IOException {
			
		        GetInput cargar = new GetInput("/home/daniel/Documents/TEC2015/lenguajes_compi/compi/codeLines.txt");
		        ArrayList<String> codeLines = cargar.getCodesLinesFinal();
//		        int i;
//		        int j;
//		        //System.out.print(codeLines.get(3).get(0));
//		        for(i = 0; i < codeLines.size(); i++){
//		        	for(j = 0; j < codeLines.get(i).size(); j++){
//		        		
//      			        	System.out.print(codeLines.get(i).get(j));
//      			        	System.out.print(" ");
//			       }
//		        	System.out.println("paso");
//		        	
//		        }
		}
>>>>>>> f3660511f29c8640bbe6d643ed41421cb7da48a9
}

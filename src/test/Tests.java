package test;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.junit.Test;

<<<<<<< HEAD
import generate.GetInput;
=======
import errorHandler.ModuloDeErrores;
import analysis.AnalisisSemantico;
>>>>>>> 9c4b83a7b706567416922ae3c4ea2e0e5158aac1
import analysis.AnalizadorLexico;
import analysis.parser;

public class Tests {


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
<<<<<<< HEAD
	//@Test
=======

	@SuppressWarnings("deprecation")
	@Test
>>>>>>> 9c4b83a7b706567416922ae3c4ea2e0e5158aac1
	public void testCUP() throws Exception{
		ModuloDeErrores masterErrors =new ModuloDeErrores();
		AnalizadorLexico al = new AnalizadorLexico(new FileInputStream("./src/analysis/input.txt"), masterErrors);
		parser p = new parser(al,masterErrors);
		p.parse();
		AnalisisSemantico as = new AnalisisSemantico(al.getSymbolTable());
		as.semanticAnalysis();
		masterErrors.buildHTML();
	}
	
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
}

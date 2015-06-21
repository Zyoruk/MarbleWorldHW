package mightyMain;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import analysis.AnalisisSemantico;
import analysis.AnalizadorLexico;
import analysis.parser;
import errorHandler.ModuloDeErrores;

/**
 * 
 */

/**
 * @author zyoruk
 *
 */
public class main {
	public main() throws Exception{
		setup();
		ModuloDeErrores masterErrors =new ModuloDeErrores();
		AnalizadorLexico al = new AnalizadorLexico(new FileInputStream("./src/analysis/input.txt"), masterErrors);
		@SuppressWarnings("deprecation")
		parser p = new parser(al,masterErrors);
		p.parse();
		AnalisisSemantico as = new AnalisisSemantico(al.getSymbolTable());
		as.semanticAnalysis();
		masterErrors.buildHTML();
	}
	private void setup() throws IOException{
		File f = new File("./output/OutputAnalisisLexico.txt");
		OutputStream fo = new FileOutputStream(f);
		fo.close();
	}
}

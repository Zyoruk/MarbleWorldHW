package mightyMain;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;

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
	private ModuloDeErrores masterErrors;
	Reader r;
	AnalizadorLexico al;
	AnalisisSemantico as;
	parser p;
	String toCompile;
	public main(String ptoCompile) throws Exception{
		setup();
		toCompile = ptoCompile;
	}
	@SuppressWarnings("deprecation")
	public void compile() throws Exception{
		r = new StringReader(toCompile);
		al = new AnalizadorLexico(r, masterErrors);
		p = new parser(al,masterErrors);
		p.parse();
		as = new AnalisisSemantico(al.getSymbolTable());
		as.semanticAnalysis();
		masterErrors.buildHTML();
	}
	private void setup() throws IOException{
		File f = new File("./output/OutputAnalisisLexico.txt");
		OutputStream fo = new FileOutputStream(f);
		fo.close();
		masterErrors =new ModuloDeErrores();
	}
}

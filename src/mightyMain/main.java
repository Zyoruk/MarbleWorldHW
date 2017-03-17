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

import constants.Constants;
/**
 * @author zyoruk
 *
 */
public class main {
	private ModuloDeErrores masterErrors;
	Reader reader;
	AnalizadorLexico al;
	AnalisisSemantico as;
	Parser p;
	String toCompile;
	public main(String pToCompile) throws Exception{
		setup();
		this.toCompile = pToCompile;
	}
	@SuppressWarnings("deprecation")
	public void compile() throws Exception{
		this.reader = new StringReader(toCompile);
		this.al = new AnalizadorLexico(reader, masterErrors);
		this.p = new parser(this.al,this.masterErrors);
		this.p.parse();
		this.as = new AnalisisSemantico(al.getSymbolTable());
		this.as.semanticAnalysis();
		this.masterErrors.buildHTML();
	}
	private void setup() throws IOException{
		File file = new File(_LEX_OUTPUT);
		OutputStream fo = new FileOutputStream(file);
		fo.close();
		this.masterErrors = new ModuloDeErrores();
	}
}

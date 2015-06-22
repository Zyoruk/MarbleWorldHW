/**
 * 
 */
package errorHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Datastructs.SimpleList.SimpleList;
import constants.Constants;

/**
 * @author zyoruk
 *
 */
public class ModuloDeErrores {
	private Constants K;
	private SimpleList<String> lexerrors;
	private SimpleList<String> syntErrors;
	private SimpleList<String> semErrors;
public ModuloDeErrores() throws IOException{
	K=new Constants();
	this.lexerrors = new SimpleList<String>();
	this.syntErrors = new SimpleList<String>();
	this.semErrors = new SimpleList<String>();
}

public void lexError(String toWrite) throws IOException{
	if(toWrite.equals("")==false){
		final BufferedWriter out = new BufferedWriter( new FileWriter( K._LEX_ERROR_OUTFILE ) );
		out.write(toWrite);
		out.close();
		this.lexerrors.append(toWrite);
	}
}

public void syntError(String toWrite) throws IOException{
	
	final BufferedWriter out = new BufferedWriter( new FileWriter( K._CUP_ERROR_OUTFILE ) );
	out.write(toWrite);
	out.close();
	this.syntErrors.append(toWrite);
}

public void semError(String toWrite) throws IOException{
	final BufferedWriter out = new BufferedWriter( new FileWriter( K._SEM_ERROR_OUTFILE) );
	out.write("Semantic Error found in line # "+toWrite);
	out.close();
	this.semErrors.append(toWrite);
}

public void buildHTML() throws IOException{
	StringBuilder sb = new StringBuilder();
	sb.append("<!DOCTYPE html><html lang ="+"\"en\""+"><head><title>ErrorsModule.html</title><meta charset ="+ "\"UTF-8\""+"/></head><body><h1>Errors Module Report</h1>");
	sb.append("<h2>Lexical Errors</h2>");
	if(this.lexerrors.length() == 0){
		sb.append("<p>There are no lexical errors!</p>");
	}else{
		for (int i=0; i < this.lexerrors.length();i++){
			sb.append("<p>"+this.lexerrors.getElementAt(i)+"</p>");
		}
	}
	sb.append("<h2>Syntax Errors</h2>");
	if(this.syntErrors.length() == 0){
		sb.append("<p>There are no syntax errors!</p>");
	}else{
		for (int i=0; i < this.syntErrors.length();i++){
			sb.append("<p>"+this.syntErrors.getElementAt(i)+"</p>");
		}
	}
//	sb.append("<h2>Semantic Errors</h2>");
//	if(this.semErrors.length() == 0){
//		sb.append("<p>There are no semantic errors!</p>");
//	}else{
//		for (int i=0; i < this.semErrors.length();i++){
//			sb.append("<p>"+this.semErrors.getElementAt(i)+"</p>");
//		}
//	}
	sb.append("</body></html>");
	File newTable = new File(K._ERROR_HTML);
	BufferedWriter out = new BufferedWriter( new FileWriter( newTable ) );
	out.write(sb.toString());
	out.close();
	
}
}

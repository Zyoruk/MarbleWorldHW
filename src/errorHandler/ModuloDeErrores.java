/**
 * 
 */
package errorHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import constants.Constants;

/**
 * @author zyoruk
 *
 */
public class ModuloDeErrores {
	private Constants K;
	private String lexicalErrorOutput;
	private String syntErrorOutput;
public ModuloDeErrores() throws IOException{
	K=new Constants();
	lexicalErrorOutput =  K._LEX_ERROR_OUTFILE;
	syntErrorOutput = K._CUP_ERROR_OUTFILE;
//	this.lexicalErrorOutput.createNewFile();
}

public void lexError(String toWrite) throws IOException{
	final BufferedWriter out = new BufferedWriter( new FileWriter( this.lexicalErrorOutput ) );
	out.write(toWrite);
	out.close();
}
}

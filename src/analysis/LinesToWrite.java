package analysis;
import java.util.ArrayList;



/**
 *  Solely used to store two variables, a line to write and the line where it will  be written.
 */

public class LinesToWrite {

	
	private final  ArrayList<String> lineToWrite;
	private final int codeLine;
	
	public LinesToWrite (  ArrayList<String> lineToWrite,  int codeLine){
		
		this.lineToWrite = lineToWrite;
		this.codeLine = codeLine;
	}


	/**
	 * Retrurns the line to write in a string presentation.
	 * @return
	 */
	public String getWriteOutput () {
		
		return arrayToString( lineToWrite);
	}

	public int getCodeLine() {
		return codeLine;
	}
	
	/**
	 * Converts ArrayList<String> to string , adding a white space between them.
	 * @param array
	 * @return
	 */
	 public static String arrayToString (  ArrayList<String>  array ) {

			String listString = "";

			for (String s : array)
			{
			    listString += s + "\t";
			}

			return listString;
		 }
	
	
	
}

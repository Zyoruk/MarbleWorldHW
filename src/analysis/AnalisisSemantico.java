package analysis;

import java.io.*;
import java.util.ArrayList;
import java.util.SplittableRandom;

import symbolTable.SymbolTable;
/**
 * @author Nicolas									Please Note:	
 *                      								1.		Part when brackets or curls are attached to the condition  is not yet supported.
 *                      								2. 	Only checks when curls are part of the conditional declarations. Otherwise doesn't work.		
 */
public class AnalisisSemantico {
	
	private final ArrayList<String> listaErrores;
	private String[][] symbolTable;
	private final ArrayList<Boolean> usedVariables; 
	private final ArrayList<Integer> linesToDelete;
	private  final int EOF;

	
	/**
	 * Receives the project symbol Table. Contructor too.
	 * @param symbolTable
	 * @throws IOException 
	 */
	public AnalisisSemantico (SymbolTable  symbolTable ) throws IOException{
		
		this.symbolTable = symbolTable.getSymbolTable();
		this.listaErrores = new ArrayList<>();         // Checking if it is important.
		this.usedVariables = new ArrayList<>();
		this.linesToDelete = new ArrayList<>();
		this.EOF = getFileLength();
		fillUsed();
	}
	
	/**
	 * Must be completely changed.
	 * @return
	 */
	public boolean manager () {
		
		boolean multipleDeclaration = multipleDeclarations();
		
		return multipleDeclaration;
	}
	
//  *******************************************************  //
	//        Unused Variables Part           //
//  *******************************************************  //		
	
	/**
	 *  This method is the first one to analyze if we need to keep some variables. 
	 *  Sends each line to analyzeLine to check which variables are being use, by setting them true.
	 * @throws IOException
	 */
	private void notUsedChecker ( ) throws IOException{

		String currentLine;
		String[] splitedLine;
		
		for (  int i = 0; i < EOF ; i++){
			
			currentLine = lineReader( i );
			splitedLine = currentLine.split(" " );
			
			if ( splitedLine[ 0 ].equals(  "DECLARE" ) )
				
				continue;
			
			analyzeLine(  splitedLine  );	
		}
		
	}
	
	/**
	 * Analyze one line of code to determine if variables are actually being used.
	 * Sets true the ID of the symbol table provided that are being used.
	 * @param line
	 */
	private void analyzeLine( String[] line){
		
		for ( String token :  line   ){
			
			if (  token.equals("EQUALS") || token.equals("DIFFERENT") || token.equals("MORETHAN") || token.equals("LESSEQUALS") ||     
					token.equals("PLUS") || token.equals("MINUS") || token.equals("TIMES") || token.equals("DIVISION") || token.equals("LBRACK") ||
					token.equals("RBRACK") || token.equals("RCURL") || token.equals("LCURL") || token.equals("THEN") || token.equals("ELSE") ||
					token.equals("IF") || token.equals("WHILE") || token.equals("DO") || token.equals("TYPE") || token.equals("D1") || token.equals("D3") ||
					token.equals("D2") || token.equals("D4") || token.equals("D5") ||  isNumeric(token) || token.equals("MOVE") || token.equals( "ASSIGN")
					||  token.equals( "TRUE" ) || token.equals( "FALSE" )  ||  token.equals("MOREEQUAL"))    
					  
					continue;
			int position;
			if (  (position = varPosSym( token ) )  != -1 ){
				
				usedVariables.set( position, true    );
			}
		}
	}	
	
	/**
	 *  Finds which declarations of variables have to be removed because they are useless.
	 *  Uses lineTo Delete to find the specific lines must be deleted.
	 * @throws IOException 
	 */
	private void variableDeletion() throws IOException{
		
		for ( int i = 0; i < usedVariables.size(); i++ ){
			
			if ( usedVariables.get(  i  ) == false  ){
																										
				lineToDelete  (  i ) ;   // i  s a position in the symbol table, so lineToDelete search
												//  in the code the apparition ( in a declaration) of the said variable.
			}
		}
	}
	
	/**
	 *    --------------Works Only For The Unused Variables Optimization--------------
	 * 
	 * This function reads line by line the code to find the pointless declaration of one not used variable.
	 * @param symbolIndex    
	 * @throws IOException   
	 */
	private void lineToDelete(  int symbolIndex  ) throws IOException{
		
		String line;
		String[] splitedLine;
		String id = symbolTable [ symbolIndex ][ 1 ];
		for (   int i = 0; i < EOF;  i++ ){
			
			line = lineReader( i );
			splitedLine = line.split( " " );
			
			if ( !splitedLine[ 0 ].equals(  "DECLARE" ))
				
				continue;
			
			if (  id.equals(  splitedLine[ 2 ] ) ){
				
				linesToDelete.add( i  );    // List of lines to delete, compound by the unused and conditional optimization.
				return;
			}		
		}
	}
	
	/**
	 * Finds the position of a  variable in the symbol table, and returns.
	 * @param var
	 * @return
	 */ 
	private int varPosSym ( String var) {
		
		for  ( int i = 0;  i< symbolTable.length ; i++  ){
			
			if (   symbolTable[ i ][ 1 ].equals( var  ) ){
				
				return i;
			}
		} 
		return -1;
	}
	  
	
//  *******************************************************  //
	//        Condition Evaluation Part           //
//  *******************************************************  //	
	
	/**
	 * 
	 */
	private void fileAnalyzer(){
		
		 
	}	
	
	/**
	 * 
	 * @throws IOException
	 */
	private ArrayList<String> ifANDwhileFinder(  int comenzar ) throws IOException{
		
		String line;
		String[] splitedLine;
		String finish = "RBRACKET";
		ArrayList<String> condition = new ArrayList<>();
		
		for ( int i =  comenzar;  i < EOF ; i++  ) {
			
			line = lineReader( i );
			splitedLine = line.split( " ");
			
			if ( splitedLine[ 0 ].equals("IF")  ||  splitedLine[ 0 ].equals("WHILE")   ) {
				 
				for ( int j = 1; j < splitedLine.length; j++ ){
 					 
					if ( splitedLine[ j ].equals(  finish) )
						break;
						
					condition.add(  splitedLine[ j ] );
				}
				return condition;
			}
			boolean whileFound = false;
			for ( int j = 0; j< splitedLine.length; j++ ) {
				
				if ( splitedLine[ j ].equals( "WHILE" )  || whileFound ){

					if  (whileFound)
						condition.add( splitedLine[ j ]  );
										
					else
						whileFound = true;
				}
			}
		}	
		return condition;
	}
	
	/**
	
 * 	 Deals with an if or while condition, evaluates if the condition is always true or always false. If succeeds  
	 *	 the function alwaysTrue or alwaysFalse is called.  It's only true if the condition contains the true statement or if it's a 
	 *	 numerical expression that can be computed. Same logic for the always false condition.
	 * @param condition
	 * @throws IOException  
	 */
	private void conditionTester (  String[] condition  , int lineOfCode ) throws IOException  {
		
		if ( condition[ 0 ].equals("FALSE") ){
			
			alwaysFalse(   lineOfCode );
			return;
		}
		if ( condition[ 0 ].equals("TRUE") ){        // deal with the case when the condition begins with bracket.  
 																		// Not finished yet.		
			alwaysTrue(lineOfCode );
			return;
		}			
		float leftResult = 0;
		float rightResult = 0;
		boolean switchSide = false;
		String currentOp  = "N/A";
		String relationalOp = "";
		
		for ( int i = 1;  i < condition.length ; i++ )  {
			
			if (  ! (condition[ i ].equals( "MORETHAN" )  ||  condition[ i ].equals( "DIFFERENT" )  ||  condition[ i ].equals( "EQUALS" )  ||
					condition[ i ].equals( "LESSTHAN" )  || condition[ i ].equals( "LESSEQUALS" )  || condition[ i ].equals( "PLUS" )  ||
					condition[ i ].equals( "MINUS" )  || condition[ i ].equals( "TIMES" )  || condition[ i ].equals( "DIVISION" )  ||
					isNumeric( condition[ i ] ) || condition[ i ].equals( "MOREEQUAL" )  ||  condition[i].equals("RBRACK")    )  ){
				 
				return;
			}
			if ( condition[ i ].equals( "MORETHAN" )  ){
				
				switchSide =true;
				relationalOp = "MORETHAN";
				currentOp  = "N/A";
				continue;	
			}
			if ( condition[ i ].equals( "DIFFERENT" )  ){
				
				switchSide =true;
				relationalOp = "DIFFERENT";
				currentOp  = "N/A";
				continue;	
			}
			if ( condition[ i ].equals( "LESSTHAN" )  ){
				
				switchSide =true;
				relationalOp = "LESSTHAN";
				currentOp  = "N/A";
				continue;	
			}			
			if ( condition[ i ].equals( "EQUALS" )  ){
				
				switchSide =true;
				relationalOp = "EQUALS";
				currentOp  = "N/A";
				continue;	
			}			
			if ( condition[ i ].equals( "MOREEQUAL" )  ){
				
				switchSide =true;
				relationalOp = "MOREEQUAL";
				currentOp  = "N/A";
				continue;	
			}		
			if ( condition[ i ].equals( "LESSEQUALS" )  ){
				
				switchSide =true;
				relationalOp = "LESSEQUALS";
				currentOp  = "N/A";
				continue;				
			}
			if (   condition[ i ].equals( "PLUS" )    ){
				
				currentOp = "PLUS";
				continue;
			}
			if (   condition[ i ].equals( "MINUS" )    ){
				
				currentOp = "MINUS";
				continue;
			}
			if (   condition[ i ].equals( "DIVISION" )    ){
				
				currentOp = "DIVISION";
				continue;
			}
			if (   condition[ i ].equals( "TIMES" )    ){
				
				currentOp = "TIMES";
				continue;
			}			
			if (currentOp.equals("N/A")){
			
				if (!switchSide)
					
					leftResult += Float.parseFloat( condition [i] );
				else
					rightResult += Float.parseFloat( condition [i] );
				
			}			
			else{
				
				float numero = Float.parseFloat( condition [i] );
				
				if ( !switchSide ){
					
					if (currentOp.equals("PLUS")){
						
						leftResult += numero;
					}
					if (currentOp.equals("TIMES")){
						
						leftResult *= numero;
					}					
					if (currentOp.equals("MINUS")){
						
						leftResult -= numero;
					}					
					if (currentOp.equals("DIVISION")){
						
						leftResult /= numero;
					}
				}
				else{
					
					if (currentOp.equals("PLUS")){
						 
						rightResult += numero;
					}
					if (currentOp.equals("TIMES")){
						
						rightResult *= numero;
					}					
					if (currentOp.equals("MINUS")){
						
						rightResult -= numero;
					}					
					if (currentOp.equals("DIVISION")){
						
						rightResult  /= numero;
					}					
				}
			}
		}	
		if ( relationalOp.equals(  "MOREEQUALS") ){
			
			if (   leftResult >= rightResult   )
				alwaysTrue(  lineOfCode );
			
			else
				alwaysFalse(  lineOfCode );
		}
		if ( relationalOp.equals(  "EQUALS") ) {
			
			if (   leftResult == rightResult   )
				alwaysTrue(  lineOfCode );
	
			else
				alwaysFalse(  lineOfCode );	
		}		
		if ( relationalOp.equals(  "DIFFERENT")  ){
			
			if (  leftResult != rightResult  )
				alwaysTrue(  lineOfCode );
				
			else
				alwaysFalse(  lineOfCode );		
		}	
		if ( relationalOp.equals(  "LESSTHAN") ){
			
			if (  leftResult < rightResult  )
				alwaysTrue(  lineOfCode );
			
			else
				alwaysFalse(  lineOfCode );
		}		
		if ( relationalOp.equals(  "LESSEQUALS") ){
			
			if (   leftResult <= rightResult ) 
				alwaysTrue(  lineOfCode );
			
			else
				alwaysFalse(  lineOfCode );			
		}		
		if ( relationalOp.equals(  "MORETHAN") ){
			
			if (   leftResult > rightResult   )
				alwaysTrue(   lineOfCode );
				
			else
				alwaysFalse( lineOfCode);
		}		
	}		
	
	/**
	 * 
	 * @param lineOfCode
	 */
	private void alwaysTrue (  int lineOfCode ) {
		
		
	}	
	
	/**
	 *  At least this line has to be deleted, however probably some more lines will be deleted as well.
	 *  To know when to stop the  " } " will indicate us.
	 * @param lineOfCode
	 * @throws IOException 
	 */
	private void alwaysFalse (  int lineOfCode ) throws IOException {
		
	//	linesToDelete.add( lineOfCode );
		String finisher = "RCURL";
		String line;
		String [] splitedLine;
		
		for ( int i = lineOfCode ; i < EOF ; i ++   ){
			
			line = lineReader( i );
			splitedLine = line.split( " " );
			
			for ( String token : splitedLine ){
				
				if ( token.equals( finisher)){
					
					
				}
			}
		}
	}
		
	
	
//  *******************************************************  //
	//                   U T I L I T I E S   		//
//  *******************************************************  //	
	
	/**
	 * Checks if a String is an Number in the underneath.  Hope works for floats too :)
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}

	/**
	 * Reads one line from the input code from user and returns the whole line. 
	 *The code is tokenization is provided by the lexical analysis.
	 * @param numberLine
	 * @return
	 * @throws IOException
	 */
	private static String lineReader(    int numberLine) throws IOException {
    				
		// The name of the file to open.
		String fileName =   "./MarbleWorldHW/output/lexicalAnalisis.txt";
		// This will reference one line at a time
		String line = null;
   
		// FileReader reads text files in the default encoding.
		FileReader fileReader =    new FileReader(fileName);

		// Always wrap FileReader in BufferedReader.
		BufferedReader bufferedReader =  new BufferedReader(fileReader);
		int i =0;
		while((line = bufferedReader.readLine()) != null  && i<=numberLine   )    {
            
			if ( i == numberLine ){
        		
				bufferedReader.close();
				return line;
			}
			i++;
		}    
		// Always close files.
		bufferedReader.close();            
		return null;
	}

	/**
	 * Get the number of lines of the lexical analysis output.
	 * Length
	 * @return
	 * @throws IOException 
	 */
	private static int  getFileLength() throws IOException{
		
		String fileName =   "./MarbleWorldHW/output/lexicalAnalisis.txt";
		FileReader fileReader =    new FileReader(fileName);
		BufferedReader bufferedReader =  new BufferedReader(fileReader);
		
		int i =0;
		while (   bufferedReader.readLine()   != null ){
			
			i++;
		}
		bufferedReader.close();            		
		return i;
	}

	/**
	 * Fill the usedVariable List with false. This by the way gives the length of the symbol table what is necessary.
	 */
	private void fillUsed(){
		
		for ( int i = 0; i < symbolTable.length ; i++   ) {
			
			usedVariables.add( false);
		}
		System.out.println( usedVariables.size() );
	} 	

	
	//Extras!
	/**
	* Checks if a variable is being declared more than one time, in whose 
	* case would return an error and continue to the end of the semantic parsing.
	 * @return
	 */
	private boolean multipleDeclarations() {
		
		int i;
		boolean errorFound = false;
		String currentVarName;
		int repeated;  	
		for (  String[]  codeLine :   symbolTable   ) {
			
			repeated = 0;
			currentVarName = codeLine[ 1 ];
			for (  i  = 0 ;   i < symbolTable.length ;  i++    ){
				
				if ( symbolTable[ i ][ 1 ] == currentVarName  ){
					
					repeated++;
				}
				if ( repeated > 1 ){
					
					errorFound = true;
					listaErrores.add(  "Semantic Error found in this line " +  symbolTable [ i ][ 3 ] );
					repeated = 1;
				}
			}
		}
		return errorFound;
	}		
}
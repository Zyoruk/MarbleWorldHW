package analysis;

import java.io.*;
import java.util.ArrayList;
import java.util.Spliterator;
import java.util.SplittableRandom;

import symbolTable.SymbolTable;
/**
 * @author Nicolas									Please Note:	
 *                      								1.		Brackets must not be attached to the conditional statement, otherwise won't work.
 *                      								2. 	Only checks when curls are part of the conditional declarations, otherwise won't work.		
 */
public class AnalisisSemantico {
	
	private final ArrayList<String> listaErrores;
	private String[][] symbolTable;
	private final ArrayList<Boolean> usedVariables; 
	private final ArrayList<Integer> linesToDelete;
	private  final int EOF;
	private int lineaAnalisisActual;
	private int lineaCondicion;
	
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
		this.lineaAnalisisActual = 0;
		this.lineaCondicion = 0;
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
	
	
	private void writeOutput() {
		

        // The name of the file to open.
        String fileName = "./MarbleWorldHW/output/semanticOutputPhase1.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            
            String line;
            for  ( int i = 0; i < EOF ; i++ ){ 
      //      bufferedWriter.write(" here is some text.");
      //      bufferedWriter.newLine();
            	
            	if (   linesToDelete.contains( i ) ){
            		
            		continue;
            	}
            	line = lineReader(  i );
            	bufferedWriter.write(  line);
            	bufferedWriter.newLine();
      	
            }
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
		
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
												
				if (! linesToDelete.contains(i) )
					linesToDelete.add(i);	
				  // i  s a position in the symbol table, so lineToDelete search
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
				
				if (! linesToDelete.contains(i) )
					linesToDelete.add(i);						  // List of lines to delete, compound by the unused and conditional optimization.
				
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
	 * First part of the condition evaluation part. Calls the ifANDwhileFinder to search into the places where the if and while
	 * lies.
	 * @throws IOException  
	 */
	public void fileAnalyzer() throws IOException{
		
		ArrayList<String> conditionStream;
		
		 while ( lineaAnalisisActual < EOF ){
			 
			  conditionStream = ifANDwhileFinder( lineaAnalisisActual );
			  conditionTester(conditionStream,  lineaCondicion  );
		 } 
	}	
	
	/**
	 *  Goes through all the lexical output file looking for if's and while's, in order to send the condition that will be analyzed later. 
	 * @throws IOException
	 */
	private ArrayList<String> ifANDwhileFinder(  int comenzar ) throws IOException {
		
		String line;
		String[] splitedLine;
		String finish = "RBRACKET";
		ArrayList<String> condition = new ArrayList<>();
		int i;
		for (  i =  comenzar;  i < EOF ; i++  ) {  // i   is a variable that iterates through the file.
			
			line = lineReader( i );
			splitedLine = line.split( " ");
			
			if ( splitedLine[ 0 ].equals("IF")  ||  splitedLine[ 0 ].equals("WHILE")   ) {
				 
				for ( int j = 1; j < splitedLine.length; j++ ){   // j es una variable que itera a traves de una linea.
 					 
					if ( splitedLine[ j ].equals(  finish) )
						break;
						
					condition.add(  splitedLine[ j ] );
				}
				lineaAnalisisActual = i+1;
				lineaCondicion = i;  
				return condition;
			}
			boolean whileFound = false;
			int brincarseParentesis = 0;
			for ( int j = 0; j< splitedLine.length; j++ ) {
				
				if ( splitedLine[ j ].equals( "WHILE" )  || whileFound ){

					if  (whileFound){
						
						if ( brincarseParentesis >1 )
							condition.add( splitedLine[ j ]  );
						else
							brincarseParentesis++;
					}					
					else
						whileFound = true;
						brincarseParentesis++;
				}
			}
			if ( whileFound)   // Si encontro el while significa que ya tiene la condicion tambien y esta listo.
				break;
		}	
		lineaCondicion = i;
		lineaAnalisisActual = i + 1;
		return condition;
	}
	
	/**
	
 * 	 Deals with an if or while condition, evaluates if the condition is always true or always false. If succeeds  
	 *	 the function alwaysTrue or alwaysFalse is called.  It's only true if the condition contains the true statement or if it's a 
	 *	 numerical expression that can be computed. Same logic for the always false condition.
	 * @param condition
	 * @throws IOException  
	 */
	private void conditionTester (  ArrayList<String> condition  , int lineOfCode ) throws IOException  {
		 
		if ( condition.get(0).equals("FALSE") ){
			
			alwaysFalse(   lineOfCode );
			return;
		}
		if ( condition.get(0).equals("TRUE") ){        // deal with the case when the condition begins with bracket.  
 																		// Not finished yet.		
			alwaysTrue(lineOfCode );
			return;
		}			
		float leftResult = 0;
		float rightResult = 0;
		boolean switchSide = false;
		String currentOp  = "N/A";
		String relationalOp = "";
		
		for ( int i = 1;  i < condition.size() ; i++ )  {
			
			if (  ! (condition.get( i ).equals( "MORETHAN" )  ||  condition.get( i ).equals( "DIFFERENT" )  ||  condition.get( i ).equals( "EQUALS" )  ||
					condition.get( i ).equals( "LESSTHAN" )  || condition.get( i ).equals( "LESSEQUALS" )  || condition.get( i ).equals( "PLUS" )  ||
					condition.get( i ).equals( "MINUS" )  || condition.get( i ).equals( "TIMES" )  || condition.get( i ).equals( "DIVISION" )  ||
					isNumeric( condition.get( i ) ) || condition.get( i ).equals( "MOREEQUAL" )  ||  condition.get( i ).equals("RBRACK")    )  ){
				 
				return;
			}
			if ( condition.get( i ).equals( "MORETHAN" )  ){
				
				switchSide =true;
				relationalOp = "MORETHAN";
				currentOp  = "N/A";
				continue;	
			}
			if ( condition.get( i ).equals( "DIFFERENT" )  ){
				
				switchSide =true;
				relationalOp = "DIFFERENT";
				currentOp  = "N/A";
				continue;	
			}
			if ( condition.get( i ).equals( "LESSTHAN" )  ){
				
				switchSide =true;
				relationalOp = "LESSTHAN";
				currentOp  = "N/A";
				continue;	
			}			
			if ( condition.get( i ).equals( "EQUALS" )  ){
				
				switchSide =true;
				relationalOp = "EQUALS";
				currentOp  = "N/A";
				continue;	
			}			
			if ( condition.get( i ).equals( "MOREEQUAL" )  ){
				
				switchSide =true;
				relationalOp = "MOREEQUAL";
				currentOp  = "N/A";
				continue;	
			}		
			if ( condition.get( i ).equals( "LESSEQUALS" )  ){
				
				switchSide =true;
				relationalOp = "LESSEQUALS";
				currentOp  = "N/A";
				continue;				
			}
			if (   condition.get( i ).equals( "PLUS" )    ){
				
				currentOp = "PLUS";
				continue;
			}
			if (   condition.get( i ).equals( "MINUS" )    ){
				
				currentOp = "MINUS";
				continue;
			}
			if (   condition.get( i ).equals( "DIVISION" )    ){
				
				currentOp = "DIVISION";
				continue;
			}
			if (   condition.get( i ).equals( "TIMES" )    ){
				
				currentOp = "TIMES";
				continue;
			}			
			if (currentOp.equals("N/A")){
			
				if (!switchSide)
					
					leftResult += Float.parseFloat( condition.get( i ));
				else
					rightResult += Float.parseFloat( condition.get( i ) );
				
			}			
			else{
				
				float numero = Float.parseFloat( condition.get( i ) );
				
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
	       																																							//   
	/**
	 * 
	 * @param lineOfCode
	 * @throws IOException 
	 */
	private ArrayList<String> alwaysTrue ( final  int lineOfCode  ) throws IOException {
 
		
		String finisher = "RCURL";
		String line = "";
		String []  splitedLine;
		ArrayList<String> furtherThen = new ArrayList<>();  //FurtherThen is the variable used to get the code that is always executed 
		boolean reachedThen = false;									   //the code next to then is always executed till reach the else that is removed.  
		
		for ( int i = lineOfCode;  i < EOF ; i++) {
		
			line = lineReader(  i  );
			splitedLine = line.split( " " );

			for ( String token : splitedLine ) {
				
				if ( token.equals(  "THEN" ) ) {
			
					reachedThen = true;        
					continue;
				}
				if (reachedThen ){
				
					if (token.equals(finisher) ){
 				
						deleteTrueStatement(lineOfCode);
						return   furtherThen;
					}
					if ( token.equals("LCURL" )){
					
						continue;
					}
					furtherThen.add( token  );
				}
			}
		}	
		return furtherThen;
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	private void deleteTrueStatement ( final int lineOfCode ) throws IOException {
		
		String finisher = "RCURL";
		String line = "";
		String []  splitedLine;
		int times = 0;
		boolean justHappenned = false;
		
		for (  int i = lineOfCode;   i<EOF ; i++){
			
			line = lineReader(  i  );
			splitedLine = line.split( " " );			
			
			if (! linesToDelete.contains(i) )
				linesToDelete.add(i);
			
			for ( int j = 0;  j < splitedLine.length; j++ ){
				
				if ( ! splitedLine[ j ].equals( "ELSE" )  && justHappenned ){
					
						linesToDelete.remove( i );
						return;					
				}

				if ( splitedLine[ j ].equals( finisher  )  ) {
					
					if (  times == 0   ) {
						
						times++;	
						justHappenned = true;
						continue;
					}
					else	
						return; 
				}
				else {
				
					justHappenned = false;
				}
			}
		}
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
			
			
			if (! linesToDelete.contains(i) )
				linesToDelete.add(i);
			
			for ( String token : splitedLine ){
				
				if ( token.equals( finisher))
					
					return;	
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
		if ( isDouble(str))
			return true;
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
	
	/**
	 * 
	 * @param str
	 * @return
	 */
    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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

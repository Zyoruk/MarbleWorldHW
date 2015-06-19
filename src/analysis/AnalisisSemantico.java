package analysis;

import java.io.*;
import java.util.ArrayList;

import symbolTable.SymbolTable;
/**
 * @author Nicolas
 *
 */
public class AnalisisSemantico {
	
	private final ArrayList<String> listaErrores;
	private String[][] symbolTable;
	private final ArrayList<Boolean> usedVariables; 
	private final ArrayList<Integer> linesToDelete;


	public AnalisisSemantico (SymbolTable  symbolTable ){
		
		this.symbolTable = symbolTable.getSymbolTable();
		this.listaErrores = new ArrayList<>();         // Checking if it is important.
		this.usedVariables = new ArrayList<>();
		this.linesToDelete = new ArrayList<>();
		fillUsed();
	}
	
	
	private void fillUsed(){
		
		for ( int i = 0; i < symbolTable.length ; i++   ) {
			
			usedVariables.add( false);
		}
		System.out.println( usedVariables.size() );
	} 
	
	/**
	 *  This method is the first one to analyze if we need to keep some variables. 
	 *  Sends each line to analyzeLine to check which variables are being use, by setting them true.
	 * @throws IOException
	 */
	private void notUsedChecker ( ) throws IOException{
		
		int EOF = 0;
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
			if (  (position = varPos( token ) )  != -1 ){
				
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
				
				lineToDelete  (  i ) ;
			
			}
		}
	}
	
	/**
	 * This function reads line by line the code to find the pointless declaration of one not used variable.
	 * @param symbolIndex
	 * @throws IOException
	 */
	private void lineToDelete(  int symbolIndex  ) throws IOException{
		
		String line;
		String[] splitedLine;
		int EOF = 0;
		String id = symbolTable [ symbolIndex ][ 1 ];
		for (   int i = 0; i < EOF;  i++ ){
			
			line = lineReader( i );
			splitedLine = line.split( " " );
			
			if ( !splitedLine[ 0 ].equals(  "DECLARE" ))
				
				continue;
			
			if (  id.equals(  splitedLine[ 2 ] ) ){
				
				linesToDelete.add( i  );
				return;
			}		
		}
	}
	
	
	
	/**
	 * Finds the position of a  variable in the symbol table, and returns.
	 * @param var
	 * @return
	 */ 
	private int varPos ( String var) {
		
		for  ( int i = 0;  i< symbolTable.length ; i++  ){
			
			if (   symbolTable[ i ][ 1 ].equals( var  ) ){
				
				return i;
			}
		} 
		return -1;
	}
	
	/**
	 * Reads one line from the input code from user and returns the whole line. 
	 *The code is tokenization is provided by the lexical analysis.
	 * @param numberLine
	 * @return
	 * @throws IOException
	 */
	private String lineReader(    int numberLine) throws IOException {
        				
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
	  
	private void conditionTester (  String[] condition   ){
		
		if ( condition[1].equals("FALSE") ){
			
			return;
		}
		if ( condition[1].equals("TRUE") ){
			
			return;
		}			
		float leftResult = 0;
		float rightResult = 0;
		boolean switchSide= false;
		String currentOp  = "N/A";
		String relationalOp;
		
		for ( int i = 1;  i < condition.length ; i++ )  {
			
			if (  ! (condition[ i ].equals( "MORETHAN" )  ||  condition[ i ].equals( "DIFFERENT" )  ||  condition[ i ].equals( "EQUALS" )  ||
					condition[ i ].equals( "LESSTHAN" )  || condition[ i ].equals( "LESSEQUALS" )  || condition[ i ].equals( "PLUS" )  ||
					condition[ i ].equals( "MINUS" )  || condition[ i ].equals( "TIMES" )  || condition[ i ].equals( "DIVISION" )  ||
					isNumeric( condition[ i ] ) || condition[ i ].equals( "MOREEQUAL" )  ||  condition[i].equals("RBRACK")    )  ){
				 
				break;
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
				
				currentOp = "PLUS";
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
				else{
					rightResult += Float.parseFloat( condition [i] );
				}
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
		
	}		
	
	
	/**
	 * Checks if a String is an Integer in the underneath.
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
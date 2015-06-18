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


	public AnalisisSemantico (SymbolTable  symbolTable ){
		
		this.symbolTable = symbolTable.getSymbolTable();
		this.listaErrores = new ArrayList<>();
		
	}
	
	//Checks if a variable is being declared more than one time, in whose 
	//case would return an error and continue to the end of the semantic parsing.
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
					listaErrores.add(  "Semantic Error found in this line" +  symbolTable [ i ][ 3 ] );
					repeated--;
				}
			}
		}
		return errorFound;
	}	
	
	private boolean notDeclaredVar () {
		
		
	}
		

	//Reads one line from the input code from user and returns the whole line. 
	//The code is tokenization is provided by the lexical analysis.
	private String   lineReader(    int numberLine) throws IOException {
        				
		// The name of the file to open.
		String fileName =   "./MarbleWorldHW/output/lexicalAnalisis.txt";
        // This will reference one line at a time
        String line = null;
       
        ‹
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
	  

	
	
	
	
	
}

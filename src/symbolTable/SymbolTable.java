package symbolTable;

import Datastructs.SimpleList.SimpleList;

public class SymbolTable {
	String[][] symboltable;
public SymbolTable(SimpleList<String> plexemes , SimpleList<String> pvalues, SimpleList<String> ptypes){
	  symboltable = new String[plexemes.length()][3];
	  for (int i = 0; i< plexemes.length();i++){
		  symboltable[i][0] = plexemes.getElementAt(i);
		  symboltable[i][1] = pvalues.getElementAt(i);
		  symboltable[i][2] = ptypes.getElementAt(i);
	  }
	  outputTable();
}
private void outputTable(){
	
}
}

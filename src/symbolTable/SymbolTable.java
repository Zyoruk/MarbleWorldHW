package symbolTable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import Datastructs.SimpleList.SimpleList;

public class SymbolTable {
	String[][] symboltable;
	public SymbolTable(SimpleList<String> plexemes , SimpleList<String> pvalues, SimpleList<String> ptypes, SimpleList<String> plines){
		symboltable = new String[plexemes.length()][4];
		for (int i = 0; i< plexemes.length();i++){
			symboltable[i][0] = plexemes.getElementAt(i);
			symboltable[i][1] = pvalues.getElementAt(i);
			symboltable[i][2] = ptypes.getElementAt(i);
			symboltable[i][3] = plines.getElementAt(i);
		}
	}
	public void outputTable() throws IOException{
		File newTable = new File("./output/Symboltable.txt");
		OutputStream os = new FileOutputStream(newTable);
		os.close();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i< symboltable.length;i++){
			sb.append(symboltable[i][0]+" "+symboltable[i][1]+" "+symboltable[i][2] +" "+symboltable[i][3]+"\n");
		}
		final BufferedWriter out = new BufferedWriter( new FileWriter( newTable ) );
		out.write(sb.toString());
		out.close();
	}

	public String[][] getSymbolTable(){
		return this.symboltable;
	}
}

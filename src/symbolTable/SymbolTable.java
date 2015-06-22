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
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i< symboltable.length;i++){
			sb2.append(symboltable[i][0]+" "+symboltable[i][1]+" "+symboltable[i][2] +" "+symboltable[i][3]+"\n");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html><html lang ="+"\"en\""+"><head><title>SymbolTable.html</title><meta charset ="+ "\"UTF-8\""+"/><style type ="+ "\"text/css\""+">table, td, th {border: 1px solid black;}</style></head><body><h1>Symbol Table</h1>");
		sb.append("<table><tr><th>Lexeme</th><th>Name</th><th>Type</th><th>Line</th></tr>");
		for (int i = 0; i< symboltable.length;i++){
			sb.append("<tr>"+"<td>"+symboltable[i][0]+"</td>"+
							 "<td>"+symboltable[i][1]+"</td>"+
							 "<td>"+symboltable[i][2]+"</td>"+
							 "<td>"+symboltable[i][3]+"</td>"+"</tr>");
		}
		sb.append("</table></body></html>");
		BufferedWriter out = new BufferedWriter( new FileWriter( newTable ) );
		out.write(sb2.toString());
		out.close();
		
		newTable = new File("./output/Symboltable.html");
		out = new BufferedWriter( new FileWriter( newTable ) );
		out.write(sb.toString());
		out.close();
		
	}

	public String[][] getSymbolTable(){
		return this.symboltable;
	}
}

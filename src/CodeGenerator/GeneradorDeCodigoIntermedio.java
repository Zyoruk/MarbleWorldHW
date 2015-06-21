/**
 * 
 */
package CodeGenerator;

import java.util.ArrayList;

/**
 * @author zyoruk
 *
 */
public class GeneradorDeCodigoIntermedio {
	
	private ArrayList<String> variablesID;
	private ArrayList<String> variablesType;
	private ArrayList<ArrayList<String>> variablesData;
	ArrayList<String> code;
	
	private int listIndex;
	private int maxIndex;
	
	
	
	public GeneradorDeCodigoIntermedio(ArrayList<String> lineasCode){
		maxIndex = lineasCode.size();
		listIndex = 0;
		variablesID = new ArrayList<String>();
		variablesType = new ArrayList<String>();
		variablesData = new ArrayList<ArrayList<String>>();
		code = lineasCode;
	}
	private void generateCode(ArrayList<String> lineasCode){
		while(listIndex < maxIndex){
			analizarLinea(listIndex);
		}
		
	}
	
	private void analizarLinea(int _index){
		int condicion = setCase(_index);
        switch (condicion) {
            case 1: System.out.println("case1");
                     break;
            case 2: System.out.println("case2");
                     break;
            case 3: caseDeclare();
            			break;
            case 4: System.out.println("case4");
            		break;
            case 5: System.out.println("case5");
             		break;
            case 6: System.out.println("case6");
            		break;
            default: System.out.println("case0000000");
                     break;
        }	
	}
	
	private int setCase(int _index){
		int Case = 0;
		String WORD = code.get(_index);		
		
		if(WORD.equals("IF")){
				Case = 1;
		}
		else if(WORD.equals("ELSE")){
			Case = 2;
		}
		else if(WORD.equals("DECLARE")){
			Case = 3;
		}
		else if(WORD.equals("MOVE")){
			Case = 4;
		}
		else if(WORD.equals("DO")){
			Case = 5;
		}
	    else if(WORD.equals("WHILE")){
			Case = 6;
		}
		else{
			//caso para asignaciones
				Case = 7;
		}
		return Case;
    	
    }
	
	private void caseDeclare(){
		declareVariable(code.get(listIndex+1), code.get(listIndex+2));
		listIndex = listIndex + 3;	
	}
	
	private void declareVariable(String _tipo, String _id){
		variablesID.add(_id);
		variablesType.add(_tipo);
	}
	private void caseIf(){
		if(hasCurl(7)){
			caseIfLong();
		}
		else{
			caseIfSimple();
		}
	}
	private void caseIfSimple(){
		
	}
	private void caseIfLong(){}
	
	private boolean hasCurl(int _index){
		if(code.get(listIndex+_index).equals("LCURL")){
			return true;
		}
		else{
			return false;
		}
	}
	private boolean seCumple(String _operandoA, String _operador, String _operandoB){
		boolean cumplido = false;
		if(_operador.equals("==")){
			if(getValueOfString(_operandoA) == getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		else if(_operador.equals("<=")){
			if(getValueOfString(_operandoA) <= getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		else if(_operador.equals(">=")){
			if(getValueOfString(_operandoA) >= getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		else if(_operador.equals("<")){
			if(getValueOfString(_operandoA) < getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		else if(_operador.equals(">")){
			if(getValueOfString(_operandoA) > getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		else if(_operador.equals("!=")){
			if(getValueOfString(_operandoA) != getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		return cumplido;
	}
	private int getValueOfString(String _input){
		if(isVariable(_input)){
			return getVariable(_input);
		}
		else{
			int val =  Integer.parseInt(_input);
			return val;
		}
	}
	
	private boolean isVariable(String _val){
		boolean isVar = false;
		for(int i = 0; i < variablesData.size(); i++){
			if(_val.equals(variablesData.get(i).get(0))){
				isVar = true;
				break;
			}
		}
		return isVar;
	}
	
	private int getVariable(String _val){
		int val = 0;
		for(int i = 0; i < variablesData.size(); i++){
			if(_val.equals(variablesData.get(i).get(0))){
				val = Integer.parseInt(variablesData.get(i).get(1));
				break;
			}
		}
		return val;
	}

	private void asignVariable(String _id, String _value){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(_id);
		temp.add(_value);
		variablesData.add(temp);
	}
	

}

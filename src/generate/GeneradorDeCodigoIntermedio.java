package generate;

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
		generateCode(lineasCode);
	}
	private void generateCode(ArrayList<String> lineasCode){
		while(listIndex < maxIndex){
			analizarLinea(listIndex);
		}
		
	}
	
	private void analizarLinea(int _index){
		int condicion = setCase(_index);
        switch (condicion) {
            case 1: System.out.println("IF");
            		caseIf();	
                    break;
            case 2: System.out.println("case2");
                    break;
            case 3: caseDeclare();
            		System.out.println("Declarando");
            		break;
            case 4: System.out.println("Move");
            		listIndex += 3;
            		break;
            case 5: System.out.println("case5");
             		break;
            case 6: System.out.println("While");
            		//caseWhile();
            		listIndex += 8;
            		break;
            case 7: System.out.println("asignación");
            		asignVariable(code.get(listIndex),code.get(listIndex+2));
            		listIndex += 3;
    				break;
            case 8: System.out.println("RCURL");
    				listIndex += 1;
    				break;
    				//listIndex +=1;
            default: System.out.println("SI IDENTIDICAR");
            		listIndex += 1;
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
		else if(WORD.equals("RCURL")){
				Case = 8;
		}
		else if(code.get(_index+1).equals("=")){
			Case = 7;	
		}
		return Case;
    	
    }
	private void caseWhile(){
		int temp = listIndex;
		int alcance = getNextIndex(listIndex);
		
		while(seCumple(code.get(listIndex+2),code.get(listIndex+3),code.get(listIndex+4))){
			listIndex += 8;
			System.out.println("SE CUMPLE WHILE");
			while(listIndex < alcance){
				analizarLinea(listIndex);
			}
			listIndex = temp;
		}
		listIndex = getNextIndex(temp);
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
			System.out.println("IF long");
			caseIfLong();
			
		}
		else{
			System.out.println("IF simple");
			caseIfSimple();

		}
	}
	private void caseIfSimple(){
		if(seCumple(code.get(listIndex+2),code.get(listIndex+3),code.get(listIndex+4))){
			System.out.println("se cumplio");
			listIndex += 7;
		}
		else{
			listIndex += 10;
		}
	}
	private void caseIfLong(){
		
		if(seCumple(code.get(listIndex+2),code.get(listIndex+3),code.get(listIndex+4))){
			listIndex += 8;
		}
		else{
			listIndex = getNextIndex(listIndex);
		}
		
	}
	
	private int getNextIndex(int _index){
		int finalIndex = _index+8;
		while(!code.get(finalIndex).equals("RCURL")){
			if(code.get(finalIndex).equals("IF")){
				if(hasCurl(finalIndex)){
					finalIndex = getNextIndex(finalIndex);
					continue;
				}
				else{
					finalIndex += 10;
					continue;
				}
			}
			finalIndex += 1;
		}
		finalIndex += 1;
		return finalIndex;
	}
	
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
		if(_operador.equals("EQUALS")){
			if(getValueOfString(_operandoA) == getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		else if(_operador.equals("LESSEREQUALS")){
			if(getValueOfString(_operandoA) <= getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		else if(_operador.equals("MOREEQUAL")){
			if(getValueOfString(_operandoA) >= getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		else if(_operador.equals("LESSTHAN")){
			if(getValueOfString(_operandoA) < getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		else if(_operador.equals("MORETHAN")){
			if(getValueOfString(_operandoA) > getValueOfString(_operandoB)){
				cumplido = true;
			}
		}
		else if(_operador.equals("DIFFERENT")){
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
		/*if(seRepite(_id)){
			eraseFirstDeclaration(_id);
		}*/
		
	}
	
	private void eraseFirstDeclaration(String _id){
		for(int i = 0; i < variablesData.size(); i++){
			if(_id.equals(variablesData.get(i).get(0))){
				variablesData.remove(i);
				break;
			}
		}
	}
	
	private boolean seRepite(String _id){
		boolean cond = false;
		for(int i = 0; i < variablesData.size(); i++){
			if(_id.equals(variablesData.get(i).get(0))){
				cond = true;
				break;
			}
		}
		return cond;
	}
	

}

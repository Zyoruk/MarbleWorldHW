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
	private ArrayList<String> code;

	private int listIndex;
	private int maxIndex;



	public GeneradorDeCodigoIntermedio(ArrayList<String> pCodeInLines){
		this.maxIndex = pCodeInLines.size();
		this.listIndex = 0;
		this.variablesID = new ArrayList<String>();
		this.variablesType = new ArrayList<String>();
		this.variablesData = new ArrayList<ArrayList<String>>();
		this.code = pCodeInLines;
	}
	private void generateCode(ArrayList<String> pCodeInLines){
		while(this.listIndex < this.maxIndex){
			lineAnalyzer(this.listIndex);
		}

	}

	private void lineAnalyzer(int pIndex){
		int cond = setCase(pIndex);
        switch (cond) {
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

	private int setCase(int pIndex){
		int Case = 0;
		String lexem = code.get(pIndex);

		if(lexem.equals("IF")){
				Case = 1;
		}
		else if(lexem.equals("ELSE")){
			Case = 2;
		}
		else if(lexem.equals("DECLARE")){
			Case = 3;
		}
		else if(lexem.equals("MOVE")){
			Case = 4;
		}
		else if(lexem.equals("DO")){
			Case = 5;
		}
	    else if(lexem.equals("WHILE")){
			Case = 6;
		}
		else{
			//Assignment case
				Case = 7;
		}
		return Case;

    }

	private void caseDeclare(){
		declareVariable(this.code.get(listIndex+1), this.code.get(listIndex+2));
		this.listIndex = this.listIndex + 3;
	}

	private void declareVariable(String pType, String pId){
		variablesID.add(pId);
		variablesType.add(pType);
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

	private boolean hasCurl(int pIndex){
		if(code.get(listIndex+pIndex).equals("LCURL")){
			return true;
		}
		else{
			return false;
		}
	}
	private boolean ifTrue(String pAOperator, String pOperator, String pBOperator){
		boolean isTrue = false;
		if(pOperator.equals("==")){
			if(getValueOfString(pAOperator) == getValueOfString(pBOperator)){
				isTrue = true;
			}
		}
		else if(pOperator.equals("<=")){
			if(getValueOfString(pAOperator) <= getValueOfString(pBOperator)){
				isTrue = true;
			}
		}
		else if(pOperator.equals(">=")){
			if(getValueOfString(pAOperator) >= getValueOfString(pBOperator)){
				isTrue = true;
			}
		}
		else if(pOperator.equals("<")){
			if(getValueOfString(pAOperator) < getValueOfString(pBOperator)){
				isTrue = true;
			}
		}
		else if(pOperator.equals(">")){
			if(getValueOfString(pAOperator) > getValueOfString(pBOperator)){
				isTrue = true;
			}
		}
		else if(pOperator.equals("!=")){
			if(getValueOfString(pAOperator) != getValueOfString(pBOperator)){
				isTrue = true;
			}
		}
		return isTrue;
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

	private void asignVariable(String pId, String _value){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(pId);
		temp.add(_value);
		variablesData.add(temp);
	}


}

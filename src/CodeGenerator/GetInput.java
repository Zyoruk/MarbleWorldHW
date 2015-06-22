package CodeGenerator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GetInput {
    
    private ArrayList<String> codeLines;
    private ArrayList<String> codeLinesFinal;
    
    public GetInput(String _archivo) throws IOException {
        codeLines = new ArrayList();
        codeLinesFinal = new ArrayList();
        muestraContenido(_archivo);
        prepareData();
        
    }
    
    private void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            this.codeLines.add(cadena);
     
        }
        b.close();
    }

    private void prepareData(){
        StringTokenizer tokens;
        
        for(int i = 0;i<codeLines.size();i++){
            tokens = new StringTokenizer(codeLines.get(i), " ");
            while(tokens.hasMoreTokens()){
            String str = tokens.nextToken();
            codeLinesFinal.add(str);      
            }
        }
    
    }
    public ArrayList<String> getCodesLinesFinal() {
        return codeLinesFinal;
    }
}

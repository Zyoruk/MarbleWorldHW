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

    public GetInput(String pFile) throws IOException {
        codeLines = new ArrayList();
        codeLinesFinal = new ArrayList();
        showContent(pFile);
        prepareData();

    }

    private void showContent(String pFile) throws FileNotFoundException, IOException {
        String _string;
        FileReader f = new FileReader(pFile);
        BufferedReader b = new BufferedReader(f);
        while((_string = b.readLine())!=null) {
            this.codeLines.add(_string);

        }
        b.close();
    }

    private void prepareData(){
        StringTokenizer tokens;

        for(int i = 0;i<codeLines.size();i++){
            _tokens = new StringTokenizer(codeLines.get(i), " ");
            while(_tokens.hasMoreTokens()){
            String _str = _tokens.nextToken();
            codeLinesFinal.add(_str);
            }
        }

    }
    public ArrayList<String> getCodesLinesFinal() {
        return codeLinesFinal;
    }
}

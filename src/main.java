import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 */

/**
 * @author zyoruk
 *
 */
public class main {
	int main() throws IOException{
		setup();
		return 0;
	}
	private void setup() throws IOException{
		File f = new File("./output/OutputAnalisisLexico.txt");
		OutputStream fo = new FileOutputStream(f);
		fo.close();
	}
}

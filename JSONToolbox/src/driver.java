import java.io.BufferedReader;
import java.io.FileReader;

public class driver {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("./resources/jsonTest.txt");
			BufferedReader br = new BufferedReader(fr);
			String inputLine = br.readLine();
			String output = "";
			while(inputLine!=null) {
				output+=inputLine+'\n';
				inputLine = br.readLine();
			}
			JSONTree jt = new JSONTree(output, "root");
			System.out.println(jt.getContent());
			System.out.println(jt.getName());
			System.out.println(jt.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

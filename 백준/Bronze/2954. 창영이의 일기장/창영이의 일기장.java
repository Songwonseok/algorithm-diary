import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] regex = {"apa","epe","ipi","opo","upu"};
		String[] origin = {"a","e","i","o","u"};
		
		String diary = br.readLine();
		
		for(int i=0;i<regex.length;i++) {
			diary = diary.replaceAll(regex[i], origin[i]);
		}
		
		System.out.println(diary);
	}
}
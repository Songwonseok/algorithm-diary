import java.io.*;
import java.util.regex.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String regex = "c=|c-|dz=|d-|lj|nj|s=|z={1}";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		int length = str.length();
		while(matcher.find()) {
			length -= matcher.group().length()-1;
		}
		System.out.println(length);
	}

}
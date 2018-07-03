package JVM;

import java.util.ArrayList;

public class ByteCodeReader {
	private ArrayList<String[]> result;
	
	public ArrayList<String[]> transfer(String byteCode){
		result = new ArrayList<String[]>();
		String[] lines = byteCode.split("\n");
		
		int line = lines.length;
		for(int i = 0; i < line ;i++) {
			result.add(lines[i].split(": |_|#|Method "));
		}
		return result;
	}
}

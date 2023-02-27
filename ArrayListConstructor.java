// Works Tue April 6 10:14 PM
package speedReadingToolPKG;
import java.util.ArrayList;

public class ArrayListConstructor {
	static ArrayList<String> stringList;
	static String string;
	static String punctuation = ".!,/?:;\"@#$%^&*()-_=+[]{}|<>~`'";
	static StringBuilder stringBuilder;
	
	public static void start(String rawString) {
		string = rawString;
		stringBuilder = new StringBuilder();
		stringList = new ArrayList<String>();
		parseString();
	}
	
	public static void parseString() {
		for(int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if(Character.isSpaceChar(c) || Character.isWhitespace(c)) {
				if(!stringBuilder.isEmpty()) {
					stringList.add(stringBuilder.toString());
					stringBuilder = new StringBuilder();
				}
			}
			
			else if(punctuation.contains(Character.toString(c))) {
				if(stringBuilder.isEmpty()) {
					stringList.add(Character.toString(c));
				}
				
				else {
					stringList.add(stringBuilder.toString());
					stringBuilder = new StringBuilder();
					stringList.add(Character.toString(c));
				}
			}
			
			else if(Character.isLetterOrDigit(c)) {
				stringBuilder.append(Character.toString(c));
				if(i == string.length() - 1) {
					stringList.add(stringBuilder.toString());
				}
			}
		}
		// Finished product comes out here
		// Main.stringList = stringList;
		if(Main.stringList != stringList) {
			Main.isNewText = true;
			Main.stringList = stringList;
		}
		
		else {
			Main.isNewText = false;
		}
	}
}
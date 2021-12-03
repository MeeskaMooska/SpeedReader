package speedReadingToolPKG;
import java.util.ArrayList;

public class ArrayListReader extends Thread{
	ArrayList<String> strings = new ArrayList<String>();
	static Boolean playing;
	public void start(ArrayList<String> listOfStrings) {
		this.strings = listOfStrings;
		playing = true;
		
	}
	
	public void play() {
		while(playing) {
			
		}
	}
	
	public static void readString(String string) {
		System.out.println(string);
	}
}

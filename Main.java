package speedReadingToolPKG;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
	// 0 = off; 1 = on;
	// 0: NewTextFrame; 1: SettingsFrame;
	// Keeps track of running threads so there aren't more than 1 running at a time
	static boolean isNewText;
	static ArrayList<String> stringList;
	static TextPlayer textPlayer = new TextPlayer();
	static int delay;
	static boolean playing = false;
	static int[] runningThreads = {0, 0};
	static int wpm = 100;
	public static void main(String[] args) {
		// Starts Constructor
		// ArrayListConstructor.start(textBox.getValue());
		new DisplayFrame();
	}
	
	static void prompt(int dialogMessage) {
		String[] dialogMessages = {"That frame is already open.",
				"You must enter text before you press play.",
				"WPM has been changed to " + wpm + "."};
		JOptionPane.showMessageDialog(null, dialogMessages[dialogMessage]);
	}
	
	static int calculateDelay() {
		delay = 60000 / wpm;
		return(delay);
	}
}

package speedReadingToolPKG;
import javax.swing.JOptionPane;

public class WpmContext {
	static int wpm;
	
	public static void getWpm() {
		wpm = Integer.parseInt(JOptionPane.showInputDialog("Please enter your preferred words per minute, must be a number.", Main.wpm));
		Main.wpm = wpm;
		Main.prompt(2);
	}
}

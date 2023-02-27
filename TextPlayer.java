package speedReadingToolPKG;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TextPlayer {
	private final static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
	int index;
	String string;
	public void start(int i) {
		index = i;
		getNextString();
	}
	
	public void getNextString() {
		if(this.index == Main.stringList.toArray().length) {
			DisplayFrame.playPauseButton.setText("Play");
			Main.playing = false;
		}
		
		else {
			string = Main.stringList.toArray()[index].toString();
			queueStringChange();
		}
	}
	
	public void queueStringChange() {
		final Runnable textPlayer = new Runnable() {
			public void run() {
				if(Main.playing) {
					DisplayFrame.stringLabel.setText(string);
					index++;
					getNextString();
				}
			}
		};
		scheduler.schedule(textPlayer, Integer.toUnsignedLong(Main.calculateDelay()), TimeUnit.MILLISECONDS);
	}
}

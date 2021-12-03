package speedReadingToolPKG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if(object == DisplayFrame.newTextButton) {
			if(Main.runningThreads[0] == 0) {
				Main.runningThreads[0] = 1;
				new NewTextFrame();
			}
			
			else {
				Main.prompt(0);
			}
		}
		
		else if(object == DisplayFrame.playPauseButton) {
			if(Main.stringList == null) {
				Main.prompt(1);
			}
			
			else if(Main.playing) {
				Main.playing = false;
				DisplayFrame.playPauseButton.setText("Play");
			}
			
			else {
				if(Main.textPlayer.index == 0) {
					Main.textPlayer.start(0);
				}
				
				else if(Main.textPlayer.index == (int)Main.stringList.toArray().length) {
					Main.textPlayer.start(0);
				}
				
				else {
					Main.textPlayer.start(Main.textPlayer.index);
				}
				Main.playing = true;
				DisplayFrame.playPauseButton.setText("Pause");
			}
		}
		
		else if(object == DisplayFrame.settingsButton) {
			if(Main.runningThreads[1] == 0) {
				Main.runningThreads[1] = 1;
				new SettingsFrame();
			}
			
			else {
				Main.prompt(0);
			}
		}
	}
}

package speedReadingToolPKG;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SettingsFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	static JButton changeWpmButton;
	// 0: wpm;
	static int[] runningContexts = {0};
	SettingsFrame() {
		// Buttons
		changeWpmButton = new JButton("WPM");
		changeWpmButton.addActionListener(new SettingsFrameButtonListener());
		changeWpmButton.setFont(new Font("Serif", Font.PLAIN, 20));	
		
		this.setSize(200, 100);
		this.setTitle("Settings.");
		this.add(changeWpmButton);
		this.setVisible(true);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = e.getComponent().getWidth();
				int height = e.getComponent().getHeight();		
				setComponentSizes(width, height);
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Main.runningThreads[1] = 0;
			}
		});
	}
	
	public class SettingsFrameButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object object = e.getSource();
			
			if(object == changeWpmButton) {
				WpmContext.getWpm();
			}
		}
	}
	
	public void setComponentSizes(int frameWidth, int frameHeight) {
		changeWpmButton.setBounds(0, 0, frameWidth, frameHeight - 26);	
	}
}

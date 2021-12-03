package speedReadingToolPKG;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

public class DisplayFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	static JLabel stringLabel;
	static JButton newTextButton;
	static JButton playPauseButton;
	static JButton settingsButton;
	DisplayFrame() {
		ButtonListener buttonListener = new ButtonListener();
		
		// Buttons
		playPauseButton = new JButton("Play");
		playPauseButton.setFont(new Font("Serif", Font.PLAIN, 20));
		playPauseButton.addActionListener(buttonListener);	
		
		newTextButton = new JButton("New Text");
		newTextButton.setFont(new Font("Serif", Font.PLAIN, 20));
		newTextButton.addActionListener(buttonListener);		

		settingsButton = new JButton("Settings");
		settingsButton.setFont(new Font("Serif", Font.PLAIN, 20));
		settingsButton.addActionListener(buttonListener);		
		
		// Display Label
		stringLabel = new JLabel("Text Here");
		stringLabel.setBackground(Color.lightGray);
		stringLabel.setOpaque(true);
		stringLabel.setFont(new Font("Serif", Font.PLAIN, 100));
		
		
		this.setTitle("Speed Reader");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(stringLabel);
		this.add(newTextButton);
		this.add(playPauseButton);
		this.add(settingsButton);
		this.setLayout(null);
		this.setVisible(true);
		setComponentSizes(this.getWidth(), this.getHeight());
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = e.getComponent().getWidth();
				int height = e.getComponent().getHeight();		
				setComponentSizes(width, height);
			}
		});
	}
	
	public void setComponentSizes(int frameWidth, int frameHeight) {
		int labelWidth = frameWidth / 2;
		int labelHeight = frameHeight / 2;
		stringLabel.setBounds(labelWidth / 2, labelHeight / 4, labelWidth, labelHeight / 2);
		newTextButton.setBounds(0, frameHeight - 88, frameWidth / 2, 60);
		playPauseButton.setBounds(labelWidth, frameHeight - 88, frameWidth / 2, 60);
		settingsButton.setBounds(0, (frameHeight - newTextButton.getHeight() - 88), frameWidth / 2, 60);
	}
}

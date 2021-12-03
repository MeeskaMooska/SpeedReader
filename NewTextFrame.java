package speedReadingToolPKG;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class NewTextFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public JTextArea stringInputField = new JTextArea();
	public JButton enterButton = new JButton();
	NewTextFrame() {
		// Input Field
		stringInputField.setLineWrap(true);
		
		// Button
		enterButton = new JButton("Enter");
		enterButton.addActionListener(new Frame2ButtonListener());
		enterButton.setFont(new Font("Serif", Font.PLAIN, 20));	
		
		this.setSize(200, 200);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.add(stringInputField);
		this.add(enterButton);
		this.setLayout(null);
		setComponentSizes(this.getWidth(), this.getHeight());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Main.runningThreads[0] = 0;
			}
		});
		
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = e.getComponent().getWidth();
				int height = e.getComponent().getHeight();		
				setComponentSizes(width, height);
			}
		});
	}

	public class Frame2ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayListConstructor.start(stringInputField.getText());
		}
	}
	
	public void setComponentSizes(int frameWidth, int frameHeight) {
		stringInputField.setBounds(4, 4, frameWidth - 8, frameHeight - 100);
		enterButton.setBounds(0, stringInputField.getHeight() + 4, frameWidth, 68);	
	}
}

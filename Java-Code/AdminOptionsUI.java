import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminOptionsUI extends JPanel implements ActionListener {
	private JLabel instruction;
	private JButton makeQuiz, approveQuiz, cancel;
	private JPanel bodyPanel, spacePanel, cancelPanel;
	QuizDataManager dm = new QuizDataManager(); 
	adminMakeQuizControl control = new adminMakeQuizControl(dm);

	// Constructor
	public AdminOptionsUI(adminMakeQuizControl control) {
		this.control = control;
		// Initializing the Container
		this.setLayout(new BorderLayout());

		// Label
		instruction = new JLabel("Select a task:");

		// Initializing the Buttons
		makeQuiz = new JButton("Make Quiz");
		approveQuiz = new JButton("Approve Quiz");
		cancel = new JButton("Cancel");

		// Initializing the Panels
		bodyPanel = new JPanel();
		spacePanel = new JPanel();
		spacePanel.setPreferredSize(new Dimension(450, 50));
		cancelPanel = new JPanel();

		// Initializing the Panel
		spacePanel.add(instruction);
		bodyPanel.add(makeQuiz);
		bodyPanel.add(approveQuiz);
		cancelPanel.add(cancel);
		this.add(spacePanel, "North");
		this.add(bodyPanel, "Center");
		this.add(cancelPanel, "South");

		// Adding the actionlistener
		makeQuiz.addActionListener(this);
		cancel.addActionListener(this);
	}

	// Action Event Method
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == makeQuiz) {
			QuizTopicUI frame = new QuizTopicUI(control);
			frame.setSize(450, 200);
			frame.setVisible(true);
			this.removeAll();
			this.add(frame);
			this.revalidate();
			this.repaint();
		}
		if (source == cancel) {
			MainUI frame = new MainUI();
			frame.setSize(450, 200);
			frame.setVisible(true);
			this.removeAll();
			this.add(frame.getBodyPanel());
			this.revalidate();
			this.repaint();
		}
	}
}
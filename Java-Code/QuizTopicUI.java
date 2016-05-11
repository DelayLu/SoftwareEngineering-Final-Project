import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class QuizTopicUI extends JPanel implements ActionListener {
	private JLabel topic, description, instruction;
	private JTextField top, desc;
	private JButton submit, cancel;
	private JPanel labelPanel, buttonPanel, fieldPanel;
	adminMakeQuizControl control;

	// Contstructor
	public QuizTopicUI(adminMakeQuizControl control) {
		this.control = control;
		// Initializing the Container
		this.setLayout(new BorderLayout());

		// Initializing the Buttons
		submit = new JButton("Submit");
		cancel = new JButton("Cancel");

		// Initializing the Labels
		topic = new JLabel("Quiz Topic: ");
		description = new JLabel("Quiz Description: ");
		instruction = new JLabel("");

		// Initializing the textfield
		top = new JTextField(15);
		desc = new JTextField(30);

		// Initializing the panels
		labelPanel = new JPanel();
		buttonPanel = new JPanel();
		fieldPanel = new JPanel();

		// Initializing the Panel
		labelPanel.add(topic);
		labelPanel.add(top);
		this.add(labelPanel, "North");

		fieldPanel.add(description);
		fieldPanel.add(desc);
		this.add(fieldPanel, "Center");

		buttonPanel.add(instruction);
		buttonPanel.add(submit);
		buttonPanel.add(cancel);
		this.add(buttonPanel, "South");

		// Adding the actionlistener
		submit.addActionListener(this);
		cancel.addActionListener(this);
	}

	// Action Event Method
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		QuizListObj quiz = new QuizListObj();

		boolean result = false;
		if (source == submit) {
			quiz.putData(desc.getText(), top.getText());

			result = control.processQuiz(quiz);

			if (result == true) {
				MakeQuizAdminUI frame = new MakeQuizAdminUI(control);
				frame.setSize(450, 250);
				frame.setVisible(true);
				this.removeAll();
				this.add(frame);
				this.revalidate();
				this.repaint();
				
			} else if (result == false) {
				instruction.setText("Your username or password is incorrect.");
			}

		}
		if (source == cancel) {
			MainUI frame = new MainUI();
			frame.setSize(500, 400);
			frame.setVisible(true);
			this.removeAll();
			this.add(frame.getBodyPanel());
			this.revalidate();
			this.repaint();
		}
	}
}
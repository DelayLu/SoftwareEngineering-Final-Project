/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MakeQuizAdminUI extends JFrame implements ActionListener {
	
	adminMakeQuizControl control;
	private int counter = 0;
	// Labels
	private JLabel instruction;

	private JLabel question1;
	private JLabel ansA1, ansB1, ansC1, ansD1;
	private JLabel correct1;

	// TextFields
	private JTextField quest1;
	private JTextField a1, b1, c1, d1;
	private JTextField cor1;

	// Button
	private JButton submit;

	// Panels
	private JPanel instructionPanel, answerPanel, buttonPanel;

	public MakeQuizAdminUI() {
		// labels
		instruction = new JLabel("Enter a question, and four possible answers.");

		question1 = new JLabel("Question:");

		ansA1 = new JLabel("a:");
		ansB1 = new JLabel("b:");
		ansC1 = new JLabel("c:");
		ansD1 = new JLabel("d:");

		correct1 = new JLabel("Enter correct answer: (ex: a)");

		// textfields
		quest1 = new JTextField(30);
		a1 = new JTextField(5);
		b1 = new JTextField(5);
		c1 = new JTextField(5);
		d1 = new JTextField(5);
		cor1 = new JTextField(5);

		// button
		submit = new JButton("Submit");

		// container
		Container contains = this.getContentPane();

		// Initializing the panels
		instructionPanel = new JPanel();
		instructionPanel.setPreferredSize(new Dimension(400, 50));
		answerPanel = new JPanel();
		buttonPanel = new JPanel();

		// Initializing the Panel
		instructionPanel.add(instruction);
		instructionPanel.add(question1);
		instructionPanel.add(quest1);
		contains.add(instructionPanel, "North");

		answerPanel.add(ansA1);
		answerPanel.add(a1);
		answerPanel.add(ansB1);
		answerPanel.add(b1);
		answerPanel.add(ansC1);
		answerPanel.add(c1);
		answerPanel.add(ansD1);
		answerPanel.add(d1);
		answerPanel.add(correct1);
		answerPanel.add(cor1);
		contains.add(answerPanel, "Center");

		buttonPanel.add(submit);
		contains.add(buttonPanel, "South");

		// Adding the actionlistener
		submit.addActionListener(this);
	}

	// Action Event Method
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (e.getSource() == submit) {
			CheckUI create = new CheckUI();
			create.setSize(400, 150);
			create.setVisible(true);
			create.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	public static void main(String args[]) {
		MakeQuizAdminUI frame = new MakeQuizAdminUI();
		frame.setSize(400, 250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void handleCreateQuestion() {
		
		if (counter < 10) {
			counter++;
			
			QuestionObj question = new QuestionObj();
			question.putData(a1.getText(), b1.getText(), c1.getText(),
					d1.getText(), cor1.getText(), quest1.getText());
			control.processQuestion(question);
			a1.setText("");
			b1.setText("");
			c1.setText("");
			d1.setText("");
			quest1.setText("");
			cor1.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Quiz created.");
			this.dispose();
			MainUI frame = new MainUI();
			frame.setSize(450, 200);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}*/

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MakeQuizAdminUI extends JPanel implements ActionListener {
	adminMakeQuizControl control;
	private int counter = 0;
	private String empty = "";

	// Labels
	private JLabel instruction, next;

	private JLabel question1;
	private JLabel ansA1, ansB1, ansC1, ansD1;
	private JLabel correct1;

	// TextFields
	private JTextField quest1;
	private JTextField a1, b1, c1, d1;
	private JTextField cor1;

	// Button
	private JButton submit, yes, no;

	// Panels
	private JPanel instructionPanel, answerPanel, buttonPanel;

	public MakeQuizAdminUI(adminMakeQuizControl control) {
		this.control = control;
		this.setLayout(new BorderLayout());
		// labels
		instruction = new JLabel("Enter a question, and four possible answers.");
		next = new JLabel("Is this information correct?");
		next.setVisible(false);

		question1 = new JLabel("Question:");

		ansA1 = new JLabel("a:");
		ansB1 = new JLabel("b:");
		ansC1 = new JLabel("c:");
		ansD1 = new JLabel("d:");

		correct1 = new JLabel("Enter correct answer: (ex: a)");

		// textfields
		quest1 = new JTextField(30);
		a1 = new JTextField(5);
		b1 = new JTextField(5);
		c1 = new JTextField(5);
		d1 = new JTextField(5);
		cor1 = new JTextField(5);

		// button
		submit = new JButton("Submit");
		yes = new JButton("Yes");
		yes.setVisible(false);
		no = new JButton("No");
		no.setVisible(false);


		// Initializing the panels
		instructionPanel = new JPanel();
		instructionPanel.setPreferredSize(new Dimension(400, 50));
		answerPanel = new JPanel();
		buttonPanel = new JPanel();

		// Initializing the Panel
		instructionPanel.add(instruction);
		instructionPanel.add(question1);
		instructionPanel.add(quest1);
		this.add(instructionPanel, "North");

		answerPanel.add(ansA1);
		answerPanel.add(a1);
		answerPanel.add(ansB1);
		answerPanel.add(b1);
		answerPanel.add(ansC1);
		answerPanel.add(c1);
		answerPanel.add(ansD1);
		answerPanel.add(d1);
		answerPanel.add(correct1);
		answerPanel.add(cor1);
		this.add(answerPanel, "Center");

		buttonPanel.add(submit);
		buttonPanel.add(next);
		buttonPanel.add(yes);
		buttonPanel.add(no);
		this.add(buttonPanel, "South");

		// Adding the actionlistener
		submit.addActionListener(this);
		yes.addActionListener(this);
		no.addActionListener(this);
	}

	// Action Event Method
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (e.getSource() == submit) {
			next.setVisible(true);
			yes.setVisible(true);
			no.setVisible(true);
		}
		if (e.getSource() == no) {
			next.setVisible(false);
			yes.setVisible(false);
			no.setVisible(false);
		}
		if (e.getSource() == yes) {
			handleCreateQuestion();
			next.setVisible(false);
			yes.setVisible(false);
			no.setVisible(false);
		}
	}

	public void handleCreateQuestion() {
		if (counter <= 9) {
			counter++;
			QuestionObj question = new QuestionObj();
			question.putData(a1.getText(), b1.getText(), c1.getText(),
					d1.getText(), cor1.getText(), quest1.getText());
			control.processQuestion(question);
			a1.setText(empty);
			b1.setText(empty);
			c1.setText(empty);
			d1.setText(empty);
			quest1.setText(empty);
			cor1.setText(empty);
		}
		if (counter == 9) {
			JOptionPane.showMessageDialog(null, "Quiz created.");
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

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginUI extends JPanel implements ActionListener {
	private JLabel username, password, instruction;
	private JTextField user;
	private JTextField pass;
	private JButton login, cancel;
	private JPanel labelPanel, buttonPanel, fieldPanel;
	
	QuizDataManager dm = new QuizDataManager();
	
	adminLoginControl control;
	adminMakeQuizControl control2 = new adminMakeQuizControl(dm);

	// Contstructor
	public LoginUI(adminLoginControl control) {
		this.control = control;
		// Initializing the Container
		this.setLayout(new BorderLayout());
		
		

		// Initializing the Buttons
		login = new JButton("Login");
		cancel = new JButton("Cancel");

		// Initializing the Labels
		username = new JLabel("Username: ");
		password = new JLabel("Password: ");
		instruction = new JLabel("");

		// Initializing the textfield
		user = new JTextField(15);

		// Initializing the passwordfield
		pass = new JTextField(15);

		// Initializing the panels
		labelPanel = new JPanel();
		buttonPanel = new JPanel();
		fieldPanel = new JPanel();

		// Initializing the Panel
		labelPanel.add(username);
		labelPanel.add(user);
		this.add(labelPanel, "North");

		fieldPanel.add(password);
		fieldPanel.add(pass);
		this.add(fieldPanel, "Center");

		buttonPanel.add(instruction);
		buttonPanel.add(login);
		buttonPanel.add(cancel);
		this.add(buttonPanel, "South");
		

		// Adding the actionlistener
		login.addActionListener(this);
		cancel.addActionListener(this);
	}

	// Action Event Method
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		AdminObj admin = new AdminObj();
		boolean result = false;

		if (source == login) {
			
			admin.putData(user.getText(), pass.getText());
			result = control.processLogin(admin);

			if(result == true){
				AdminOptionsUI frame = new AdminOptionsUI(control2);
				frame.setSize(450, 200);
				frame.setVisible(true);
		
				this.removeAll();
				this.add(frame);
				this.revalidate();
				this.repaint();
				
			}
			else if(result == false){
				instruction.setText("Your username or password is incorrect.");
			}
			
		}
		if (source == cancel) {
			MainUI frame = new MainUI();
			frame.init();
			frame.setSize(450, 200);
			frame.setVisible(true);
			
			this.removeAll();
			this.add(frame.getBodyPanel());
			this.revalidate();
			this.repaint();
			
		}
	}

}
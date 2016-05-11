import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MainUI extends JApplet implements ActionListener {
	private JLabel instruction, quizGame;
	private JButton player, admin;
	private JPanel bodyPanel, titlePanel;

	AdminLoginDataManager dm = new AdminLoginDataManager();
	adminLoginControl control = new adminLoginControl(dm);
	LoginUI loginui = new LoginUI(control);

	public void init() {
		// Initializing the Container
		this.setSize(450, 200);
		this.setVisible(true);
		
		this.setLayout(new BorderLayout());

		// Initializing the Buttons
		player = new JButton("Player");
		admin = new JButton("Administrator");

		// Initializing the Label
		instruction = new JLabel("Select a user:");
		quizGame = new JLabel("Quiz Game");
		quizGame.setFont(new Font("Arial", Font.PLAIN, 42));

		// Initializing the Panels
		titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(400, 75));
		bodyPanel = new JPanel();

		// Initializing the Panel
		titlePanel.add(quizGame);
		bodyPanel.add(instruction);
		bodyPanel.add(player);
		bodyPanel.add(admin);
		this.add(titlePanel, "North");
		this.add(bodyPanel, "Center");

		// Adding the actionlistener
		admin.addActionListener(this);
	}

	// Action Event Method
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == admin) {
			LoginUI login = new LoginUI(control);
			login.setSize(400, 150);
			login.setVisible(true);

			this.bodyPanel.removeAll();
			this.bodyPanel.add(login);
			this.bodyPanel.revalidate();
			this.bodyPanel.repaint();
		}
	}
	
	public JPanel getBodyPanel(){
		return this.bodyPanel;
	}


}

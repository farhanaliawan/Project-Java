import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame{
	JLabel usernameLabel, passwordLabel;
	JTextField usernameTf;
	JPasswordField passwordTf;
	JButton backButton, submitButton;
	public LoginFrame(){
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		usernameTf = new JTextField();
		passwordTf = new JPasswordField();
		backButton = new JButton("Back");
		submitButton = new JButton("Log In");
		usernameLabel.setBounds(30,50,70,30);
		passwordLabel.setBounds(30,90,70,30);
		usernameTf.setBounds(120,50,90,30);
		passwordTf.setBounds(120,90,90,30);
		backButton.setBounds(30,140,80,30);
		submitButton.setBounds(130,140,80,30);
		add(usernameLabel);
		add(passwordLabel);
		add(usernameTf);
		add(passwordTf);
		add(backButton);
		add(submitButton);
		setLayout(null);
		setVisible(true);
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if (ae.getSource()==backButton) {
				dispose();
				new StartFrame();
			}
		}
	}
}
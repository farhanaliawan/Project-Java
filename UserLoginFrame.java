import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLoginFrame extends LoginFrame{
	JButton signUpButton;
	JLabel signUpLabel;

	public UserLoginFrame(){
		super();
		setSize(280,300);
		signUpLabel = new JLabel("New User? Sign Up!");
		signUpButton = new JButton("Sign Up");
		signUpButton.setBounds(80,210,90,20);
		signUpLabel.setBounds(70,180,150,30);
		add(signUpLabel);
		signUpButton.addActionListener(new MyActionListener());
		add(signUpButton);
		setTitle("User Login");
		backButton.addActionListener(new MyActionListener());
		submitButton.addActionListener(new MyActionListener());
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if (ae.getSource()==backButton) {
				dispose();
				new StartFrame();
			}
			else if (ae.getSource()== signUpButton) {
				dispose();
				new UserSignupFrame();
			}
			else if (ae.getSource()==submitButton) {
				String username = usernameTf.getText();
				String pass = passwordTf.getText();
				UserOperations opt = new UserOperations();
				if (opt.checkPassword(username,pass)) {
					dispose();
					new UserFrame(username);
				}
				else{
					usernameTf.setText("");
					passwordTf.setText("");
				}
			}
		}
	}
}

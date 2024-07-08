import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;

public class UpdateAdminCredentialsFrame extends JFrame{
	JLabel usernameLabel, passwordLabel, currPasswordLabel;
	JTextField usernameTf, passwordTf, currPasswordTf;
	JButton usernameButton, passwordButton;
	JButton homeButton;
	public UpdateAdminCredentialsFrame(){
		setSize(350,240);
		setLabels();
		setTextFields();
		setButtons();
		addLabels();
		addTextFields();
		addButtons();
		setLayout(null);
		setVisible(true);
	}
	public void setLabels(){
		usernameLabel = new JLabel("New Username:");
		passwordLabel = new JLabel("New Password:");
		currPasswordLabel = new JLabel("Old Password:");
		usernameLabel.setBounds(10,40,120,30);
		currPasswordLabel.setBounds(10,80,120,30);
		passwordLabel.setBounds(10,120,120,30);
	}
	public void addLabels(){
		add(usernameLabel);
		add(passwordLabel);
		add(currPasswordLabel);
	}
	public void setTextFields(){
		usernameTf = new JTextField();
		passwordTf = new JTextField();
		currPasswordTf = new JTextField();
		usernameTf.setBounds(110,40,80,30);
		currPasswordTf.setBounds(110,80,80,30);
		passwordTf.setBounds(110,120,80,30);
	}
	public void addTextFields(){
		add(usernameTf);
		add(passwordTf);
		add(currPasswordTf);
	}
	public void addButtons(){
		add(homeButton);
		add(usernameButton);
		add(passwordButton);
	}
	public void setButtons(){
		homeButton = new JButton("Home");
		usernameButton = new JButton("Enter");
		passwordButton = new JButton("Enter");
		homeButton.setBounds(120,160,70,30);
		usernameButton.setBounds(200,40,80,30);
		passwordButton.setBounds(200,120,80,30);
		homeButton.addActionListener(new MyActionListener());
		usernameButton.addActionListener(new MyActionListener());
		passwordButton.addActionListener(new MyActionListener());
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			try
			{
			AdminOperations opt = new AdminOperations();
			if (ae.getSource()==homeButton) {
				dispose();
				new AdminFrame();
			}
			else if (ae.getSource()==usernameButton) {
				opt.updateUsername(usernameTf.getText());
				JOptionPane.showMessageDialog(null,"Username Updated");
			}
			else if (ae.getSource()== passwordButton){
				if (currPasswordTf.getText().equals(opt.getPassword())) {
					opt.updatePassword(passwordTf.getText());
					JOptionPane.showMessageDialog(null,"Password Updated");
					dispose();
					new AdminFrame();
				}
				else{
					JOptionPane.showMessageDialog(null,"Incorrect Old Password");
					currPasswordTf.setText("");
				}
			}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}

	}
	public static void main(String[] args) {
		new UpdateAdminCredentialsFrame();
	}
}
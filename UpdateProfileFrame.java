import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;

public class UpdateProfileFrame extends JFrame{
	JLabel nameLabel, addressLabel, phoneLabel, usernameLabel, passwordLabel;
	JTextField nameTf, addressTf, phoneTf, usernameTf, passwordTf;
	JButton homeButton;
	JButton nameUpdateButton, addressUpdateButton,usernameUpdateButton, passwordUpdateButton;
	JButton phoneUpdateButton;
	String username;
	public UpdateProfileFrame(String username){
		setSize(350,350);
		setLabels();
		setTextFields();
		setButtons();
		addLabels();
		addTextFields();
		addButtons();
		setUpdateButtons();
		setTitle("Update");
		setLayout(null);
		setVisible(true);
		this.username = username;
	}

	public void setLabels(){
		nameLabel = new JLabel("Name:");
		addressLabel = new JLabel("Address:");
		phoneLabel = new JLabel("Phone:");
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		nameLabel.setBounds(50,40,80,30);
		addressLabel.setBounds(50,80,80,30);
		phoneLabel.setBounds(50,120,80,30);
		usernameLabel.setBounds(50,160,80,30);
		passwordLabel.setBounds(50,200,80,30);
	}
	public void addLabels(){
		add(nameLabel);
		add(addressLabel);
		add(phoneLabel);
		add(usernameLabel);
		add(passwordLabel);
	}
	public void setTextFields(){
		nameTf = new JTextField();
		addressTf = new JTextField();
		phoneTf = new JTextField();
		usernameTf = new JTextField();
		passwordTf = new JTextField();
		nameTf.setBounds(120,40,100,30);
		addressTf.setBounds(120,80,100,30);
		phoneTf.setBounds(120,120,100,30);
		usernameTf.setBounds(120,160,100,30);
		passwordTf.setBounds(120,200,100,30);
	}
	public void addTextFields(){
		add(nameTf);
		add(addressTf);
		add(phoneTf);
		add(usernameTf);
		add(passwordTf);
	}
	public void addButtons(){
		add(homeButton);
	}
	public void setButtons(){
		homeButton = new JButton("Back");
		homeButton.setBounds(120,250,70,30);
		homeButton.addActionListener(new MyActionListener());
	}
	public void setUpdateButtons(){
		nameUpdateButton = new JButton("Submit");
		addressUpdateButton = new JButton("Submit");
		phoneUpdateButton = new JButton("Submit");
		usernameUpdateButton = new JButton("Submit");
		passwordUpdateButton = new JButton("Submit");
		nameUpdateButton.setBounds(230,40,80,30);
		addressUpdateButton.setBounds(230,80,80,30);
		phoneUpdateButton.setBounds(230,120,80,30);
		usernameUpdateButton.setBounds(230,160,80,30);
		passwordUpdateButton.setBounds(230,200,80,30);
		nameUpdateButton.addActionListener(new MyActionListener());
		addressUpdateButton.addActionListener(new MyActionListener());
		phoneUpdateButton.addActionListener(new MyActionListener());
		usernameUpdateButton.addActionListener(new MyActionListener());
		passwordUpdateButton.addActionListener(new MyActionListener());
		add(nameUpdateButton);
		add(addressUpdateButton);
		add(phoneUpdateButton);

		add(usernameUpdateButton);
		add(passwordUpdateButton);

	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			try
			{
				AdminOperations opt = new AdminOperations();

				if (ae.getSource()==nameUpdateButton) {
					opt.updateName(username,nameTf.getText());
					nameTf.setText("");
				}

				else if (ae.getSource()==addressUpdateButton) {
					opt.updateAddress(username,addressTf.getText());
					addressTf.setText("");
				}

				else if (ae.getSource()==phoneUpdateButton) {
					opt.updatePhone(username,phoneTf.getText());
					phoneTf.setText("");
				}


				else if (ae.getSource() == usernameUpdateButton) {
					opt.updateUserUsername(username,usernameTf.getText());
					usernameTf.setText("");
				}

				else if (ae.getSource()==passwordUpdateButton) {
					opt.updateUserPassword(username,passwordTf.getText());
					passwordTf.setText("");
				}

				else if (ae.getSource() == homeButton) {
					dispose();
					new UserFrame(username);
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
	public static void main(String[] args) {
		new UpdateProfileFrame("harry");
	}
}
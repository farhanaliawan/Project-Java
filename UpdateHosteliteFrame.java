import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;

public class UpdateHosteliteFrame extends JFrame{
	JLabel nameLabel, addressLabel, phoneLabel, roomNoLabel, roomTypeLabel, usernameLabel, passwordLabel;
	JTextField nameTf, addressTf, phoneTf, roomNoTf, usernameTf, passwordTf;
	JButton homeButton, submitButton;
	JCheckBox messBox, laundryBox;
	JButton nameUpdateButton, addressUpdateButton, roomNoUpdateButton,roomTypeUpdateButton,usernameUpdateButton, passwordUpdateButton;
	JButton messUpdateButton, laundryUpdateButton, phoneUpdateButton;
	JRadioButton roomType1 , roomType2, roomType3;
	ButtonGroup group = new ButtonGroup();
	String username;
	public UpdateHosteliteFrame(String username){
		setSize(350,500);
		setLabels();
		setTextFields();
		setButtons();
		addLabels();
		addTextFields();
		addButtons();
		boxes();
		setUpdateButtons();
		setTitle("Update");
		setLayout(null);
		setVisible(true);
		this.username = username;
	}
	public void boxes(){
		messBox = new JCheckBox("Mess");
		laundryBox = new JCheckBox("Laundry");
		messBox.setBounds(50,320,100,30);
		laundryBox.setBounds(50,360,100,30);
		add(messBox);
		add(laundryBox);
	}
	public void setLabels(){
		nameLabel = new JLabel("Name:");
		addressLabel = new JLabel("Address:");
		phoneLabel = new JLabel("Phone:");
		roomNoLabel = new JLabel("Room No:");
		roomTypeLabel = new JLabel("Room Type:");
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		nameLabel.setBounds(50,40,80,30);
		addressLabel.setBounds(50,80,80,30);
		phoneLabel.setBounds(50,120,80,30);
		roomNoLabel.setBounds(50,160,80,30);
		roomTypeLabel.setBounds(50,200,80,30);
		usernameLabel.setBounds(50,240,80,30);
		passwordLabel.setBounds(50,280,80,30);
	}
	public void addLabels(){
		add(nameLabel);
		add(addressLabel);
		add(phoneLabel);
		add(usernameLabel);
		add(roomNoLabel);
		add(roomTypeLabel);
		add(passwordLabel);
	}
	public void setTextFields(){
		nameTf = new JTextField();
		addressTf = new JTextField();
		phoneTf = new JTextField();
		roomNoTf = new JTextField();
		usernameTf = new JTextField();
		passwordTf = new JTextField();
		nameTf.setBounds(120,40,100,30);
		addressTf.setBounds(120,80,100,30);
		phoneTf.setBounds(120,120,100,30);
		roomNoTf.setBounds(120,160,100,30);
		usernameTf.setBounds(120,240,100,30);
		passwordTf.setBounds(120,280,100,30);
	}
	public void addTextFields(){
		add(nameTf);
		add(addressTf);
		add(phoneTf);
		add(roomNoTf);
		add(usernameTf);
		add(passwordTf);
	}
	public void addButtons(){
		add(homeButton);
		add(submitButton);
	}
	public void setButtons(){
		homeButton = new JButton("Back");
		submitButton = new JButton("Submit");
		homeButton.setBounds(50,400,70,30);
		submitButton.setBounds(150,400,100,30);
		homeButton.addActionListener(new MyActionListener());
		submitButton.addActionListener(new MyActionListener());
		roomType1 = new JRadioButton("1");
		roomType2 = new JRadioButton("2");
		roomType3 = new JRadioButton("3");
		roomType1.setBounds(120,200,35,30);
		roomType2.setBounds(155,200,35,30);
		roomType3.setBounds(190,200,35,30);
		group.add(roomType1);
		group.add(roomType2);
		group.add(roomType3);
		add(roomType1);
		add(roomType2);
		add(roomType3);
	}
	public void setUpdateButtons(){
		nameUpdateButton = new JButton("Submit");
		addressUpdateButton = new JButton("Submit");
		phoneUpdateButton = new JButton("Submit");
		roomNoUpdateButton = new JButton("Submit");
		roomTypeUpdateButton = new JButton("Submit");
		usernameUpdateButton = new JButton("Submit");
		passwordUpdateButton = new JButton("Submit");
		messUpdateButton = new JButton("Submit");
		laundryUpdateButton = new JButton("Submit");
		nameUpdateButton.setBounds(230,40,80,30);
		addressUpdateButton.setBounds(230,80,80,30);
		phoneUpdateButton.setBounds(230,120,80,30);
		roomNoUpdateButton.setBounds(230,160,80,30);
		roomTypeUpdateButton.setBounds(230,200,80,30);
		usernameUpdateButton.setBounds(230,240,80,30);
		passwordUpdateButton.setBounds(230,280,80,30);
		messUpdateButton.setBounds(230,320,80,30);
		laundryUpdateButton.setBounds(230,360,80,30);
		nameUpdateButton.addActionListener(new MyActionListener());
		addressUpdateButton.addActionListener(new MyActionListener());
		phoneUpdateButton.addActionListener(new MyActionListener());
		roomNoUpdateButton.addActionListener(new MyActionListener());
		roomTypeUpdateButton.addActionListener(new MyActionListener());
		usernameUpdateButton.addActionListener(new MyActionListener());
		passwordUpdateButton.addActionListener(new MyActionListener());
		messUpdateButton.addActionListener(new MyActionListener());
		laundryUpdateButton.addActionListener(new MyActionListener());
		add(nameUpdateButton);
		add(addressUpdateButton);
		add(phoneUpdateButton);
		add(roomNoUpdateButton);
		add(roomTypeUpdateButton);
		add(usernameUpdateButton);
		add(passwordUpdateButton);
		add(messUpdateButton);
		add(laundryUpdateButton);
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			try
			{
				AdminOperations opt = new AdminOperations();

				if (ae.getSource()==nameUpdateButton) {
					opt.updateName(username,nameTf.getText());
				}

				else if (ae.getSource()==addressUpdateButton) {
					opt.updateAddress(username,addressTf.getText());
				}

				else if (ae.getSource()==phoneUpdateButton) {
					opt.updatePhone(username,phoneTf.getText());
				}

				else if (ae.getSource()== roomNoUpdateButton) {
					opt.updateRoomNo(username,roomNoTf.getText());
				}

				else if (ae.getSource() == roomTypeUpdateButton) {
					String roomType;
					if (roomType1.isSelected()) {
						roomType = "1";
					}
					else if (roomType2.isSelected()) {
						roomType = "2";
					}
					else{
						roomType = "3";
					}
					opt.updateRoomType(username,roomType);
				}

				else if (ae.getSource() == usernameUpdateButton) {
					opt.updateUserUsername(username,usernameTf.getText());
				}

				else if (ae.getSource()==passwordUpdateButton) {
					opt.updateUserPassword(username,passwordTf.getText());
				}

				else if (ae.getSource()==messUpdateButton) {
					opt.updateMess(username,messBox.isSelected());
				}

				else if (ae.getSource() == laundryUpdateButton) {
					opt.updateLaundry(username,laundryBox.isSelected());
				}

				else if (ae.getSource() == homeButton) {
					dispose();
					new AdminFrame();
				}
				dispose();
				new AdminFrame();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}
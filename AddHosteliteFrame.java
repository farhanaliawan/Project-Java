import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;

public class AddHosteliteFrame extends JFrame{
	JLabel nameLabel, addressLabel, phoneLabel, roomNoLabel, roomTypeLabel, usernameLabel, passwordLabel;
	JTextField nameTf, addressTf, phoneTf, roomNoTf, usernameTf, passwordTf;
	JButton homeButton, submitButton;
	JCheckBox messBox, laundryBox;
	JRadioButton roomType1 , roomType2, roomType3;
	ButtonGroup group = new ButtonGroup();
	public AddHosteliteFrame(){
		setSize(350,500);
		setLabels();
		setTextFields();
		setButtons();
		addLabels();
		addTextFields();
		addButtons();
		boxes();
		setTitle("Add");
		setLayout(null);
		setVisible(true);
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
		nameLabel.setBounds(50,40,100,30);
		addressLabel.setBounds(50,80,100,30);
		phoneLabel.setBounds(50,120,100,30);
		roomNoLabel.setBounds(50,160,100,30);
		roomTypeLabel.setBounds(50,200,100,30);
		usernameLabel.setBounds(50,240,100,30);
		passwordLabel.setBounds(50,280,100,30);
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
		nameTf.setBounds(150,40,100,30);
		addressTf.setBounds(150,80,100,30);
		phoneTf.setBounds(150,120,100,30);
		roomNoTf.setBounds(150,160,100,30);
		usernameTf.setBounds(150,240,100,30);
		passwordTf.setBounds(150,280,100,30);
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
		roomType1.setBounds(148,200,40,30);
		roomType2.setBounds(187,200,40,30);
		roomType3.setBounds(224,200,40,30);
		group.add(roomType1);
		group.add(roomType2);
		group.add(roomType3);
		add(roomType1);
		add(roomType2);
		add(roomType3);
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			AdminOperations opt = new AdminOperations();
			if (ae.getSource()== submitButton) {
				int roomType;
				if (roomType1.isSelected()) {
					roomType = Integer.parseInt("1");
				}
				else if (roomType2.isSelected()) {
					roomType = Integer.parseInt("2");
				}
				else{
					roomType = Integer.parseInt("3");
				}
				int roomNo = Integer.parseInt(roomNoTf.getText());
				Room room = new Room(roomNo,roomType);
				long phoneNumber = Long.parseLong(phoneTf.getText());
				Boolean mess = false;
				Boolean laundry = false;
				if (messBox.isSelected()) {
					 mess = true;
				}
				if (laundryBox.isSelected()) {
					laundry = true;
				}
				if (opt.usernameCheck(usernameTf.getText())) {
				Hostelite h = new Hostelite(nameTf.getText(),addressTf.getText(),phoneNumber,mess,laundry,room,usernameTf.getText(),passwordTf.getText());	
				opt.addHostelite(h);
				JOptionPane.showMessageDialog(null,"Hostelite has been added!");
				dispose();
				new AdminFrame();
				}
				else{
					JOptionPane.showMessageDialog(null,"Username already exists. Try another one.");
					usernameTf.setText("");
				}
			}

			else if (ae.getSource() == homeButton) {
				dispose();
				new AdminFrame();
			}
		}
	}

	public static void main(String[] args) {
		new AddHosteliteFrame();
	}
}
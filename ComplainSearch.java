import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ComplainSearch extends DeleteFrame{
	public ComplainSearch(){
		nameLabel = new JLabel("Enter username:");
		deleteButton = new JButton("Search");
		homeButton = new JButton("Home");
		nameTf = new JTextField();
		nameLabel.setBounds(30,50,100,30);
		deleteButton.setBounds(130,100,90,30);
		homeButton.setBounds(30,100,90,30);
		nameTf.setBounds(130,50,90,30);
		add(deleteButton);
		add(homeButton);
		add(nameLabel);
		add(nameTf);
		deleteButton.addActionListener(new MyActionListener());
		homeButton.addActionListener(new MyActionListener());
		setTitle("Complain Search");
		setLayout(null);
		setVisible(true);
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if (ae.getSource() == deleteButton) {
				try{
					AdminOperations opt = new AdminOperations();
				if (opt.boolSearch(nameTf.getText()) == 0) {
					JOptionPane.showMessageDialog(null,"Hostelite Record not found");
					nameTf.setText("");
				}
				else{
					dispose();
					for (int i = 0 ;i<opt.hostelites.size() ;i++ ) {
						if (opt.hostelites.get(i).getUsername().equals(nameTf.getText())) {
							ArrayList<String> complains = opt.hostelites.get(i).getComplains();
							if (complains.size()==0) {
								JOptionPane.showMessageDialog(null,"No Complains");
							}
							else{
									opt.viewComplains(nameTf.getText());
									dispose();
									new AdminFrame();
							}
							break;
						}
					}
					new AdminFrame();
				}

				}
				catch(Exception e){

				}
			}
			if (ae.getSource() == homeButton) {
				dispose();
				new AdminFrame();
			}

		}
	}
	public static void main(String[] args) {
		new UpdateSearchFrame();
	}
}
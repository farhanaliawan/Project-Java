import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateSearchFrame extends DeleteFrame{
	public UpdateSearchFrame(){
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
		setTitle("Update Search");
		setLayout(null);
		setVisible(true);
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if (ae.getSource() == deleteButton) {
				try{
					AdminOperations operation = new AdminOperations();
				if (operation.boolSearch(nameTf.getText()) == 0) {
					JOptionPane.showMessageDialog(null,"Hostelite Record not found");
					nameTf.setText("");
				}
				else{
					dispose();
					new UpdateHosteliteFrame(nameTf.getText());
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
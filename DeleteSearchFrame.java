import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteSearchFrame extends DeleteFrame{
	JTextField nameTf;
	JLabel nameLabel;
	JButton deleteButton, homeButton;
	public DeleteSearchFrame(){
		setSize(300,200);
		nameLabel = new JLabel("Enter username:");
		nameTf = new JTextField();
		deleteButton = new JButton("Delete");
		homeButton = new JButton("Home");
		nameLabel.setBounds(30,50,100,30);
		nameTf.setBounds(130,50,90,30);
		deleteButton.setBounds(130,100,90,30);
		homeButton.setBounds(30,100,90,30);
		add(nameTf);
		add(nameLabel);
		add(deleteButton);
		add(homeButton);
		deleteButton.addActionListener(new MyActionListener());
		homeButton.addActionListener(new MyActionListener());
		setTitle("Delete");
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
					operation.deleteHostelite(nameTf.getText());
					System.out.println("here");
					dispose();
					new AdminFrame();
				}

				}
				catch(Exception e){
					System.out.println(e);
				}
			}
			if (ae.getSource() == homeButton) {
				dispose();
				new AdminFrame();
			}

		}
	}
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchFrame extends JFrame{
	JTextField nameTf;
	JLabel nameLabel;
	JButton searchButton, homeButton;
	public SearchFrame(){
		setSize(300,200);
		nameLabel = new JLabel("Enter username:");
		nameTf = new JTextField();
		searchButton = new JButton("Search");
		homeButton = new JButton("Home");
		nameLabel.setBounds(30,50,90,30);
		nameTf.setBounds(130,50,90,30);
		searchButton.setBounds(130,100,90,30);
		homeButton.setBounds(30,100,90,30);
		add(nameTf);
		add(nameLabel);
		add(searchButton);
		add(homeButton);
		searchButton.addActionListener(new MyActionListener());
		homeButton.addActionListener(new MyActionListener());
		setTitle("Search");
		setLayout(null);
		setVisible(true);
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if (ae.getSource() == searchButton) {
				try
				{
					AdminOperations opt = new AdminOperations();
				if (opt.boolSearch(nameTf.getText()) == 0) {
					JOptionPane.showMessageDialog(null,"Student Record not found");
					nameTf.setText("");
				}
				else{
					opt.searchHostelite(nameTf.getText());
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
	public static void main(String[] args) {
			new SearchFrame();
		}	
}
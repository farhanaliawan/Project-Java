import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComplainFrame extends JFrame{
	JButton homeButton, enterComplainButton;
	JTextField complainTf;
	JLabel complainLabel;
	String username;
		public ComplainFrame(String username){
			this.username = username;
			homeButton = new JButton("Home");
			enterComplainButton = new JButton("Enter");
			complainLabel = new JLabel("Enter Complain: ");
			complainTf = new JTextField();
			homeButton.setBounds(50,200,90,30);
			enterComplainButton.setBounds(150,200,90,30); 
			complainLabel.setBounds(20,30,150,30);
			complainTf.setBounds(50,70,190,110);
			add(homeButton);
			add(enterComplainButton);
			add(complainLabel);
			add(complainTf);
			enterComplainButton.addActionListener(new MyActionListener());
			homeButton.addActionListener(new MyActionListener());
			setLayout(null);
			setSize(300,300);
			setVisible(true);
			setTitle("Complain");
		}
		public class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent ae){
				if (ae.getSource()==homeButton) {
					dispose();
					new UserFrame(username);
				}
				else if (ae.getSource()==enterComplainButton) {
					String complain = complainTf.getText();
					UserOperations opt = new UserOperations();
					opt.addComplain(username,complain);
					dispose();
					new UserFrame(username);
				}
			}
		}
		public static void main(String[] args) {
				new ComplainFrame("harry");
			}	
}
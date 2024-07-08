import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartFrame extends JFrame{
	JButton adminButton, userButton;
	JLabel label;
	public StartFrame(){
		adminButton = new JButton("Admin");
		userButton = new JButton("User");
		label = new JLabel("Hostel Management System");
		label.setFont(new Font("Verdana", Font.BOLD, 13));
		label.setBounds(80,30,250,20);
		adminButton.setBounds(120,85,120,60);
		userButton.setBounds(120,175,120,60);
		add(userButton);
		add(adminButton);
		add(label);
		adminButton.addActionListener(new MyActionListener());
		userButton.addActionListener(new MyActionListener());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Hostel Management System"); 
		setLayout(null);
		setSize(400,350);
		setVisible(true);
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if (ae.getSource()==adminButton) {
				dispose();
				new AdminLoginFrame();
			}
			else if (ae.getSource()== userButton) {
				dispose();
				new UserLoginFrame();
			}
		}
	}
	public static void main(String[] args) {
		new StartFrame();
	}
}
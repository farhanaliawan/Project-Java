import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLoginFrame extends LoginFrame{
	public AdminLoginFrame(){
		super();
		setSize(280,250);
		setTitle("Admin Login");
		backButton.addActionListener(new MyActionListener());
		submitButton.addActionListener(new MyActionListener());
	}
	// Overrdiding Action Listener
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if (ae.getSource()==backButton) {
				dispose();
				new StartFrame();
			}
			else if (ae.getSource()==submitButton) {
				try
				{
				AdminOperations admin = new AdminOperations();
				Credentials cred = admin.getAdmin();
				if (usernameTf.getText().equals(cred.getUsername()) && passwordTf.getText().equals(cred.getPassword())) {
					dispose();
					new AdminFrame();
				}
				else{
					if (usernameTf.getText().equals(cred.getUsername())) {
						JOptionPane.showMessageDialog(null,"Wrong password");
						passwordTf.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null,"Wrong username and password");
						usernameTf.setText("");
						passwordTf.setText("");
					}
				}
				}
				catch(Exception e){
					System.out.println(e);
				}
				
			}
		}
	}
	public static void main(String[] args) {
		new AdminLoginFrame();
	}
}

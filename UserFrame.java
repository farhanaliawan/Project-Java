import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserFrame extends JFrame{
	String username;
	JButton viewProfileButton, updateProfileButton, viewBillButton, complainButton, menuButton, exitButton;
	public UserFrame(String username){
		viewProfileButton = new JButton("View Profile");
		updateProfileButton = new JButton("Update Profile");
		viewBillButton = new JButton("View Bill");
		complainButton = new JButton("Complain");
		menuButton = new JButton("View Menu");
		exitButton = new JButton("Exit");
		add(viewProfileButton);
		add(menuButton);
		add(viewBillButton);
		add(complainButton);
		add(updateProfileButton);
		add(exitButton);
		viewProfileButton.addActionListener(new MyActionListener());
		exitButton.addActionListener(new MyActionListener());
		menuButton.addActionListener(new MyActionListener());
		viewBillButton.addActionListener(new MyActionListener());
		complainButton.addActionListener(new MyActionListener());
		updateProfileButton.addActionListener(new MyActionListener());
		this.username = username;
		setSize(400,300);
		setTitle("User");
		setLayout(new GridLayout(2,3));
		setVisible(true);
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if (ae.getSource()== viewProfileButton) {
				UserOperations opt = new UserOperations();
				opt.viewProfile(username);
			}
			else if (ae.getSource()==menuButton) {
				Menu menu = new Menu();
				JOptionPane.showMessageDialog(new Frame(),String.format(menu.printMenu()));
			}

			else if (ae.getSource()==viewBillButton) {
				UserOperations opt = new UserOperations();
				for (int i = 0 ;i<opt.hostelites.size() ;i++ ) {
						if (opt.hostelites.get(i).getUsername().equals(username)) {
							Hostelite h = opt.hostelites.get(i);
							String disp = "Room Type: "+h.getRoom().getRoomType()+"\n";
							if (h.getLaundry()) {
								disp += "Laundry: "+ 5000 +"/-Rs\n";
							}
							else{
								disp += "Laundry: "+ 0 +"/-Rs\n";
							}
							if (h.getMess()) {
								disp += "Mess: "+ 5000 +"/-Rs\n";
							}
							else{
								disp += "Mess: "+ 0 +"/-Rs\n";
							}
							String bill = "Bill: "+opt.calculateBill(username);
							disp+=bill;
							JOptionPane.showMessageDialog(null,disp);
							break;
						}
					}
			}
			else if (ae.getSource()==complainButton) {
				dispose();
				new ComplainFrame(username);
			}
			else if (ae.getSource()==updateProfileButton) {
				dispose();
				new UpdateProfileFrame(username);
			}
			if (ae.getSource()== exitButton) {
				dispose();
				new StartFrame();
			}

		}
	}
	public static void main(String[] args) {
		new UserFrame("harry");
	}
}
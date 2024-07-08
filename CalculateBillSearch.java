import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculateBillSearch extends DeleteFrame{
	public CalculateBillSearch(){
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
		setTitle("Bill Search");
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

							String bill = "Bill: "+opt.calculateBill(nameTf.getText());
							disp+=bill;
							JOptionPane.showMessageDialog(null,disp);
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
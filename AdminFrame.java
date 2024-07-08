import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminFrame extends JFrame{
	JButton addHosteliteButton, viewHostelitesButton, deleteHostelitesButton;
	JButton updateCredentitalsButton, updateHosteliteButton, viewComplainsButton;
	JButton calculateBillButton, searchHosteliteButton, exitButton;
	public AdminFrame(){
		setAndAddButtons();
		setLayout(new GridLayout(3,3));
		setTitle("Admin");
		setSize(450,400);
		setVisible(true);
	}
	public void setAndAddButtons(){
		addHosteliteButton = new JButton("Add Hostelite");
		deleteHostelitesButton = new JButton("Delete Hostelite");
		viewHostelitesButton = new JButton("View Hostelites");
		searchHosteliteButton = new JButton("Search Hostelite");
		updateCredentitalsButton = new JButton("Update Credentials");
		updateHosteliteButton = new JButton("Update Hostelite");
		viewComplainsButton = new JButton("View Complains");
		calculateBillButton = new JButton("Calculate Bill");
		exitButton = new JButton("Exit");
		addHosteliteButton.addActionListener(new MyActionListener());
		viewHostelitesButton.addActionListener(new MyActionListener());
		searchHosteliteButton.addActionListener(new MyActionListener());
		deleteHostelitesButton.addActionListener(new MyActionListener());
		updateCredentitalsButton.addActionListener(new MyActionListener());
		updateHosteliteButton.addActionListener(new MyActionListener());
		calculateBillButton.addActionListener(new MyActionListener());
		viewComplainsButton.addActionListener(new MyActionListener());
		exitButton.addActionListener(new MyActionListener());
		add(addHosteliteButton);
		add(deleteHostelitesButton);
		add(viewHostelitesButton);
		add(searchHosteliteButton);
		add(updateCredentitalsButton);
		add(updateHosteliteButton);
		add(viewComplainsButton);
		add(calculateBillButton);
		add(exitButton);
	}
	public class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if (ae.getSource()== addHosteliteButton) {
				dispose();
				new AddHosteliteFrame();
			}
			else if (ae.getSource()== viewHostelitesButton) {
				try
				{
					AdminOperations opt = new AdminOperations();
					opt.displayHostelites();
				}
				catch(Exception e){

				}
			}
			else if (ae.getSource()== searchHosteliteButton) {
				dispose();
				new SearchFrame();
			}
			else if (ae.getSource()==deleteHostelitesButton) {
				dispose();
				new DeleteSearchFrame();
			}
			else if (ae.getSource() == updateCredentitalsButton) {
				dispose();
				new UpdateAdminCredentialsFrame();
			}
			else if (ae.getSource()== updateHosteliteButton) {
				dispose();
				new UpdateSearchFrame();
			}

			else if (ae.getSource()==calculateBillButton) {
				dispose();
				new CalculateBillSearch();
			}
			else if (ae.getSource()==viewComplainsButton) {
				dispose();
				new ComplainSearch();
			}
			else if (ae.getSource()==exitButton) {
				dispose();
				new StartFrame();
			}
		}
	}
	public static void main(String[] args) {
		new AdminFrame();
	}
}

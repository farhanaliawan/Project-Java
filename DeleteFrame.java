import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteFrame extends JFrame{
	JTextField nameTf;
	JLabel nameLabel;
	JButton deleteButton, homeButton;
	public DeleteFrame(){
		setSize(300,200);
		deleteButton = new JButton("Delete");
		homeButton = new JButton("Home");
		deleteButton.setBounds(130,100,90,30);
		homeButton.setBounds(30,100,90,30);
		setTitle("Delete");
		setLayout(null);
		setVisible(true);
	}
}
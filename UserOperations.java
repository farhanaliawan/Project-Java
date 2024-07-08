import java.io.*;
import java.util.*;
import javax.swing.*;

public class UserOperations implements Bill{
	File f = new File("Hostelites.txt");
	ArrayList<Hostelite> hostelites = new ArrayList<Hostelite>();
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	public UserOperations(){
		try
		{
			if (f.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(f));
			hostelites = (ArrayList<Hostelite>)ois.readObject();
			ois.close();
		}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public Boolean checkPassword(String username, String password){
		if (hostelites.size()== 0) {
			JOptionPane.showMessageDialog(null,"Invalid username or Password");
			return false;
		}
		else
		{
			for (int i = 0 ;i<hostelites.size() ;i++ ) {
				if (hostelites.get(i).getUsername().equals(username) && hostelites.get(i).getPassword().equals(password) ) {
					return true;
				}
			}
			JOptionPane.showMessageDialog(null,"Invalid username or Password");
			return false;
		}
	}	

	public void viewProfile(String username){
		for (int i = 0 ;i<hostelites.size() ;i++ ) {
				if (hostelites.get(i).getUsername().equals(username)) {
					JOptionPane.showMessageDialog(null,hostelites.get(i).toString());
					break;
				}
			}
	}

	public void addComplain(String username,String complain){
		try
		{
			for (int i = 0 ;i<hostelites.size() ;i++ ) {
				if (hostelites.get(i).getUsername().equals(username)) {
					hostelites.get(i).setComplain(complain);
					break;
				}
			}
		JOptionPane.showMessageDialog(null,"Complain Added!");
		oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(hostelites);
		oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public double calculateBill(String username){
		Hostelite h = null;
		for (int i = 0 ;i<hostelites.size() ;i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
				h = hostelites.get(i);
				break;
			}
		}

		double bill = 0;
		Room r = h.getRoom();


		if (r.getRoomType()==1) {
			bill+=18000;
		}
		else if (r.getRoomType()==2) {
			bill+=15000;
		}
		else{
			bill+=12000;
		}

		if (h.getMess()) {
			bill+=5000;
		}

		if (h.getLaundry()) {
			bill+=5000;
		}

		return bill;
	}

}
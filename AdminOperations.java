import java.io.*;
import java.util.*;
import javax.swing.*;

public class AdminOperations implements Bill{
	File f = new File("Hostelites.txt");
	File x = new File("Admin.txt");
	Credentials admin = new Credentials("admin","admin");
	ArrayList<Hostelite> hostelites = new ArrayList<Hostelite>();
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	public AdminOperations(){
		try
		{
			if (f.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(f));
			hostelites = (ArrayList<Hostelite>)ois.readObject();
			ois.close();
			}
			if (x.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(x));
			admin = (Credentials)ois.readObject();
			ois.close();
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void addHostelite(Hostelite h){
		try
		{
		hostelites.add(h);
		oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(hostelites);
		oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void displayHostelites(){
		if (hostelites.size()==0) {
			JOptionPane.showMessageDialog(null,"No records to display");
		}
		else{
			for (int i = 0 ;i<hostelites.size() ;i++ ) {
				JOptionPane.showMessageDialog(null,hostelites.get(i).toString());
			}
		}
	}
	public int boolSearch(String username){
		if (hostelites.size()==0) {
			return 0;
		}
		else{
			int count = 0;
			for (int i = 0 ;i<hostelites.size() ;i++ ) {
				if (hostelites.get(i).getUsername().equals(username)) {
					count++;
					break;
				}
			}
			return count;
		}
	}

	public void searchHostelite(String username){
		if (hostelites.size()==0) {
			JOptionPane.showMessageDialog(null,"Hostelite doesnot exist.");
		}
		else{
			int count = 0;
			for (int i = 0 ;i<hostelites.size() ;i++ ) {
				if (hostelites.get(i).getUsername().equals(username)) {
					JOptionPane.showMessageDialog(null,hostelites.get(i).toString());
					count++;
					break;
				}
			}
			if (count == 0) {
				JOptionPane.showMessageDialog(null,"Hostelite record not found");
			}
		}

	}

	public void deleteHostelite(String username){
		try
		{
			if (hostelites.size() == 0) {
			JOptionPane.showMessageDialog(null,"Hostelite doesnot exist.");
		}
	else{
		int count = 0;
		for (int i = 0;i<hostelites.size() ;i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
				hostelites.remove(i);
				JOptionPane.showMessageDialog(null,"Hostelite has been removed");
				count++;
				oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(hostelites);
				oos.close();
				break;
			}
		}
		if (count == 0) {
			JOptionPane.showMessageDialog(null,"Hostelite doesnot exist");
		}
	}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public Credentials getAdmin(){
		return admin;
	}
	public void updateUsername(String username){
		try
		{
			this.getAdmin().setUsername(username);
			oos = new ObjectOutputStream(new FileOutputStream(x));
			oos.writeObject(admin);
			oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void updatePassword(String password){
		try
		{
			this.getAdmin().setPassword(password);
			oos = new ObjectOutputStream(new FileOutputStream(x));
			oos.writeObject(admin);
			oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public String getPassword(){
		return this.getAdmin().getPassword();
	}
	public void updateName(String username, String newName){
		try
		{
			for (int i = 0 ;i<hostelites.size() ; i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
				hostelites.get(i).setName(newName);
				break;
			}
		}
		JOptionPane.showMessageDialog(null,"Name Updated!");
		oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(hostelites);
		oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updateAddress(String username, String newAddress){
		try
		{
			for (int i = 0 ;i<hostelites.size() ; i++ ) {
				System.out.println(hostelites.get(i).getUsername().equals(username));
			if (hostelites.get(i).getUsername().equals(username)) {
				hostelites.get(i).setAddress(newAddress);
				break;
			}
		}
		JOptionPane.showMessageDialog(null,"Address Updated!");
		oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(hostelites);
		oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updatePhone(String username, String newPhone ){
		try
		{
			long newPhoneNumber = Long.parseLong(newPhone);
		for (int i = 0 ;i<hostelites.size() ; i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
				hostelites.get(i).setPhoneNumber(newPhoneNumber);
				break;
			}
		}
		JOptionPane.showMessageDialog(null,"Phone Updated!");
		oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(hostelites);
		oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updateRoomNo(String username, String newRoomNo ){
		try
		{
			int newRoom = Integer.parseInt(newRoomNo);
		for (int i = 0 ;i<hostelites.size() ; i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
				hostelites.get(i).getRoom().setRoomNo(newRoom);
				break;
			}
		}
		JOptionPane.showMessageDialog(null,"Room No Updated!");
		oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(hostelites);
		oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updateRoomType(String username, String newRoomType ){
		try
		{
			int newRoom = Integer.parseInt(newRoomType);
		for (int i = 0 ;i<hostelites.size() ; i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
				hostelites.get(i).getRoom().setRoomType(newRoom);
				break;
			}
		}
		JOptionPane.showMessageDialog(null,"Room Type Updated!");
		oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(hostelites);
		oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updateUserUsername(String username, String newUserName ){
		try
		{
			for (int i = 0 ;i<hostelites.size() ; i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
				hostelites.get(i).setUsername(newUserName);
				break;
			}
		}
		JOptionPane.showMessageDialog(null,"Username Updated!");
		oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(hostelites);
		oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updateUserPassword(String username, String newPassword ){
		try
		{
			for (int i = 0 ;i<hostelites.size() ; i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
				hostelites.get(i).setPassword(newPassword);
				break;
			}
		}
		JOptionPane.showMessageDialog(null,"Password Updated!");
		oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(hostelites);
		oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updateMess(String username, Boolean newMess){
		try
		{
			Boolean mess;
		if (newMess) {
			mess = true;
		}
		else{
			mess = false;
		}
		for (int i = 0 ;i<hostelites.size() ;i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
				hostelites.get(i).setMess(mess);
				break;
			}
		}
		JOptionPane.showMessageDialog(null,"Mess Updated!");
		oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(hostelites);
		oos.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updateLaundry(String username, Boolean newLaundry){
		try
		{
			Boolean laundry;
		if (newLaundry) {
			newLaundry = true;
		}
		else{
			newLaundry = false;
		}
		for (int i = 0 ;i<hostelites.size() ;i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
				hostelites.get(i).setLaundry(newLaundry);
				break;
			}
		}
		JOptionPane.showMessageDialog(null,"Laundry Updated!");
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

	public void viewComplains(String username){
		String comp ="";
		for (int i = 0 ;i<hostelites.size() ;i++ ) {
			if (hostelites.get(i).getUsername().equals(username)) {
						ArrayList<String> complains = hostelites.get(i).getComplains();
							for (int j = 0;j<complains.size() ;j++ ) {
								comp +=	complains.get(j) +"\n";
							}
							break;
				}			
			}
			JOptionPane.showMessageDialog(null,comp);
	}
	public Boolean usernameCheck(String username){
		if (hostelites.size()==0) {
			return true;
		}
		else{
			for (int i = 0 ;i<hostelites.size() ;i++ ) {
				if (hostelites.get(i).getUsername().equals(username)) {
					return false;
				}
			}
			return true;
		}
	}
}

import java.io.*;
import java.util.*;

public class Hostelite extends Credentials implements Serializable {
	private String name,address;
	private long phoneNumber;
	private Boolean mess,laundry;
	private Room room; // Object of Room class (Composition)
    private ArrayList<String> complains = new ArrayList<String>();
	public Hostelite(){
        super();
	}
	public Hostelite(String name, String address, long phoneNumber, Boolean mess, Boolean laundry, Room room, String username, String password){
		super(username,password);
        this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.mess = mess;
		this.laundry = laundry;
		this.room = room;
	}
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }

    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }

    public void setMess(Boolean mess){
        this.mess = mess;
    }
    public Boolean getMess(){
        return mess;
    }

    public void setLaundry(Boolean laundry){
        this.laundry = laundry;
    }
    public Boolean getLaundry(){
        return laundry;
    }

    public void setRoom(Room room){
        this.room = room;
    }
    public Room getRoom(){
        return room;
    }
    @Override
    public String toString(){
    	return "Name: "+name+"\nPhone Number: "+phoneNumber+"\nAddress: "+address+"\nMess: "+mess+"\nLaundry: "+laundry+room.toString()+ "\nUsername: "+getUsername()+"\nPassword: "+getPassword()+"\n***********";
    }
    public ArrayList<String> getComplains(){
        return complains;
    }
    public void setComplain(String complain){
        complains.add(complain);
    }
}
import java.io.*;

public class Room implements Serializable{
	private int roomNo, roomType;
	public Room(){

	}
	public Room(int roomNo, int roomType){
		this.roomNo = roomNo;
		this.roomType = roomType;
	}
    public void setRoomNo(int roomNo){
        this.roomNo = roomNo;
    }
    public int getRoomNo(){
        return roomNo;
    }

    public void setRoomType(int roomType){
        this.roomType = roomType;
    }
    public int getRoomType(){
        return roomType;
    }
    public String toString(){
        return "\nRoom No: "+ roomNo+"\nRoom Type: "+roomType;
    }
}
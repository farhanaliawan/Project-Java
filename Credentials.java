import java.io.*;

public class Credentials implements Serializable{
	private String username,password;
	public Credentials(){

	}
	public Credentials(String username, String password){
		this.username = username;
		this.password = password;
	}
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public String toString(){
        return "\nUsername: "+ username+"\nPassword: "+password;
    }
}
package po.UserPO;

import java.io.Serializable;


public class UserPO implements Serializable {
    private static final long serialVersionUID=1L;
    private int id;
    private String username;
    private String password;
    private String position;
    private String authority;
    private String userID;
    private String contact;
    public UserPO(String username, String passwords, String position,String authority) {
        this.username = username;
        this.password = passwords;
        this.position = position;
        this.authority=authority;
    }
    public UserPO() {

    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAuthority(){
    	return authority;
    }

    public void setAuthority(String authority){
    	this.authority=authority;
    }

    public String getUserID(){
    	return userID;
    }

    public void setUserID(String userID){
    	this.userID=userID;
    }

    public String getContact(){
    	return contact;
    }

    public void setContact(String contact){
    	this.contact=contact;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}


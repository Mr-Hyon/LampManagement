package vo;

import javafx.beans.property.SimpleStringProperty;

public class UserVO {
	
	private final SimpleStringProperty userName; //用户名称
	private final SimpleStringProperty userPassword; //用户密码
	private final SimpleStringProperty userIdentity; //用户身份
	private final SimpleStringProperty userLevel; //用户权限
	
	public UserVO(String userName,String userPassword,String userIdentity,String userLevel){
		this.userName=new SimpleStringProperty(userName);
		this.userPassword=new SimpleStringProperty(userPassword);
		this.userIdentity=new SimpleStringProperty(userIdentity);
		this.userLevel=new SimpleStringProperty(userLevel);
	}
	
	public String getUserName(){
		return userName.get();
	}
	
	public void setUserName(String name){
		userName.set(name);
	}
	
	public String getUserPassword(){
		return userPassword.get();
	}
	
	public void setUserPassword(String password){
		userPassword.set(password);
	}
	
	public String getUserIdentity(){
		return userIdentity.get();
	}
	
	public void setUserIdentity(String identity){
		userIdentity.set(identity);
	}
	
	public String getUserLevel(){
		return userLevel.get();
	}
	
	public void setUserLevel(String level){
		userLevel.set(level);
	}

}

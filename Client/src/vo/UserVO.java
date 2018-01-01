package vo;

import javafx.beans.property.SimpleStringProperty;

public class UserVO {
	
	private final SimpleStringProperty userName; //�û���
	private final SimpleStringProperty userPassword; //�û�����
	private final SimpleStringProperty userIdentity; //�û����
	private final SimpleStringProperty userLevel; //�û�Ȩ��
	
	public UserVO(String userName,String userPassword,String userIdentity,String userLevel){
		this.userName=new SimpleStringProperty(userName);
		this.userPassword=new SimpleStringProperty(userName);
		this.userIdentity=new SimpleStringProperty(userName);
		this.userLevel=new SimpleStringProperty(userName);
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

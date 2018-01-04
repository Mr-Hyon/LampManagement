package vo;

import javafx.beans.property.SimpleStringProperty;

public class ClientVO {
	
	private SimpleStringProperty clientId;		//�ͻ����
	private SimpleStringProperty clientType;	//�ͻ�����(������supplier��������salesman)
	private SimpleStringProperty clientLevel;	//�ͻ��ȼ�(��1��5)
	private SimpleStringProperty clientName;	//�ͻ�����
	private SimpleStringProperty clientContact;	//�ͻ��绰
	private SimpleStringProperty clientAddress;	//�ͻ���ַ
	private SimpleStringProperty clientZip;		//�ͻ��ʱ�
	private SimpleStringProperty clientEmail;	//�ͻ�����
	private SimpleStringProperty clientPay;		//�ͻ�Ӧ��
	private SimpleStringProperty clientReceive;	//�ͻ�Ӧ��
	
	public ClientVO(String clientId,String clientType,String clientLevel,String clientName,String clientContact,String clientAddress,String clientZip,
			String clientEmail,String clientPay,String clientReceive){
		this.clientId=new SimpleStringProperty(clientId);			
		this.clientType=new SimpleStringProperty(clientType);		
		this.clientLevel=new SimpleStringProperty(clientLevel);		
		this.clientName=new SimpleStringProperty(clientName);		
		this.clientContact=new SimpleStringProperty(clientContact);	
		this.clientAddress=new SimpleStringProperty(clientAddress);	
		this.clientZip=new SimpleStringProperty(clientZip);			
		this.clientEmail=new SimpleStringProperty(clientEmail);		
		this.clientPay=new SimpleStringProperty(clientPay);			
		this.clientReceive=new SimpleStringProperty(clientReceive);	
	}
	
	public String getClientId(){
		return clientId.get();
	}
	
	public void setClientId(String id){
		clientId.set(id);
	}
	
	public String getClientType(){
		return clientType.get();
	}
	
	public void setClientType(String type){
		clientType.set(type);
	}
	
	public String getClientLevel(){
		return clientLevel.get();
	}
	
	public void setClientLevel(String level){
		clientLevel.set(level);
	}
	
	public String getClientName(){
		return clientName.get();
	}
	
	public void setClientName(String name){
		clientName.set(name);
	}
	
	public String getClientContact(){
		return clientContact.get();
	}
	
	public void setClientContact(String contact){
		clientContact.set(contact);
	}
	
	public String getClientAddress(){
		return clientAddress.get();
	}
	
	public void setClientAddress(String address){
		clientAddress.set(address);
	}
	
	public String getClientZip(){
		return clientZip.get();
	}
	
	public void setClientZip(String Zip){
		clientZip.set(Zip);
	}
	
	public String getClientEmail(){
		return clientEmail.get();
	}
	
	public void setClientEmail(String email){
		clientEmail.set(email);
	}
	
	public String getClientPay(){
		return clientPay.get();
	}
	
	public void setClientPay(String pay){
		clientPay.set(pay);
	}
	
	public String getClientReceive(){
		return clientReceive.get();
	}
	
	public void setClientReceive(String receive){
		clientReceive.set(receive);
	}

}
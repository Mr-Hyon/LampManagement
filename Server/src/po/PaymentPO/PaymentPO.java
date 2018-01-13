package po.PaymentPO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import po.AccountPO.AccountPO;
import po.UserPO.UserPO;

@Entity
@Table(name="paymentpo")
public class PaymentPO implements Serializable{
	private static final long serialVersionUID=1L;
	public PaymentPO() {
		
	}

	private int id;
	private String billID;
	private String type;
	private String client;

	private UserPO operator;
	private double totalAmount;
	private List<TransferInfo> transferList;
	private String state;
	private String date;
	
	public PaymentPO(String billID,UserPO operator,AccountPO bank,List<TransferInfo> transferList,double total){
		this.billID=billID;
		//this.bank=bank;
		this.operator=operator;
		this.totalAmount=total;
		this.transferList=transferList;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	@Column(name="billID")
	public String getBillID(){
		return billID;
	}
	
	public void setBillID(String billID){
		this.billID=billID;
	}
	
	@Column(name="type")
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	@Column(name = "client")
	public String getClient(){
		return client;
	}
	
	public void setClient(String po){
		this.client=po;
	}
	
	/*@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bankID")
    public AccountPO getBank(){
    	return bank;
    }
    
    public void setBank(AccountPO bank){
    	this.bank=bank;
    }*/
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="operatorID")
    public UserPO getOperator(){
    	return operator;
    }
    
    public void setOperator(UserPO po){
    	this.operator=po;
    }
	
	@Column(name="totalAmount")
	public double getTotalAmount(){
		return totalAmount;
	}
	
	public void setTotalAmount(double amount){
		this.totalAmount=amount;
	}
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="transferID")
	public List<TransferInfo> getTransferList(){
		return transferList;
	}
	
	public void setTransferList(List<TransferInfo> list){
		this.transferList=list;
	}
	
	@Column(name="state")
	public String getState(){
		return state;
	}
	
	public void setState(String state){
		this.state=state;
	}

	@Column(name = "date")
	public String getDate(){
		return  date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}


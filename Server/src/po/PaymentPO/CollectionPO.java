package Server.src.po.PaymentPO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import Server.src.po.AccountPO.AccountPO;
import Server.src.po.UserPO.UserPO;

@Entity
@Table(name="collectionpo")
public class CollectionPO implements Serializable{
    private static final long serialVersionUID=1L;
	public CollectionPO() {
		
	}

	private int id;
	private String billID;
	private UserPO operator;
	private AccountPO bank;
	private double totalAmount;
	private List<FundInfo> fundsList; 
	private String state;
	private String date;
	
	public CollectionPO(String billID,UserPO operator,AccountPO bank,double amount,List<FundInfo> list){
		this.billID=billID;
		this.bank=bank;
		this.operator=operator;
		this.totalAmount=amount;
		this.fundsList=list;
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
    
    public void setBillID(String id){
    	this.billID=id;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="operatorID")
    public UserPO getOperator(){
    	return operator;
    }
    
    public void setOperator(UserPO po){
    	this.operator=po;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bankID")
    public AccountPO getBank(){
    	return bank;
    }
    
    public void setBank(AccountPO bank){
    	this.bank=bank;
    }
    
    @Column(name="totalAmount")
    public double getTotalAmount(){
    	return totalAmount;
    }
    
    public void setTotalAmount(double amount){
    	this.totalAmount=amount;
    }
    
    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="clauseID")
    public List<FundInfo> getClausesList(){
    	return fundsList;
    }
    
    public void setClausesList(List<FundInfo> list){
    	this.fundsList=list;
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


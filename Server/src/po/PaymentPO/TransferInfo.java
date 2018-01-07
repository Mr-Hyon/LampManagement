package po.PaymentPO;

import javax.persistence.*;

import po.AccountPO.AccountPO;

import java.io.Serializable;

@Entity
@Table(name="transferInfo")
public class TransferInfo implements Serializable{
    private static final long serialVersionUID=1L;
	public TransferInfo() {
		
	}

	private int id;
	private String bank;
	private double amount;
	private String remark;
	
	public TransferInfo(String bank,double amount,String remark){
		this.bank=bank;
		this.amount=amount;
		this.remark=remark;
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
    
    @Column(name = "bank")
    public String getBank(){
    	return bank;
    }
    
    public void setBank(String bank){
    	this.bank=bank;
    }
    
    @Column(name="amount")
    public double getAmount(){
    	return amount;
    }
    
    public void setAmount(double amount){
    	this.amount=amount;
    }
    
    @Column(name="remark")
    public String getRemark(){
    	return remark;
    }
    
    public void setRemark(String remark){
    	this.remark=remark;
    }
}


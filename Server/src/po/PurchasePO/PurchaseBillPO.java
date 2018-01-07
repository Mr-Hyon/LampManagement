package po.PurchasePO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import po.ClientPO.ClientPO;
import po.UserPO.UserPO;
import po.GoodInfo;

@Entity
@Table(name="purchasebillpo")
public class PurchaseBillPO implements Serializable{
	private static final long serialVersionUID=1L;
	public PurchaseBillPO() {
		
	}

	private int id;
	private String billID;
	private String supplier;
	private String inventory;
	private String salesman;
	private String operator;
	private List<GoodInfo> purchaseGoodsList;
	private String remark;
	private double totalAmount;
	private String state;
	private String type;
	private String date;
	
	public PurchaseBillPO(String type,String billID,String supplier,String inventory,String salesman,String operator,List<GoodInfo> goodsList,String remark,double totalAmount){
		this.type=type;
		this.billID=billID;
		this.supplier=supplier;
		this.inventory=inventory;
		this.salesman=salesman;
		this.operator=operator;
		this.purchaseGoodsList=goodsList;
		this.remark=remark;
		this.totalAmount=totalAmount;
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
    
    @Column(name="inventory")
    public String getInventory(){
    	return inventory;
    }
    
    public void setInventory(String inventory){
    	this.inventory=inventory;
    }
    
    @Column(name = "supplier")
    public String getSupplier(){
    	return supplier;
    }
    
    public void setSupplier(String supplier){
    	this.supplier=supplier;
    }

	@Column(name = "salesman")
	public String getSalesman(){
		return salesman;
	}

	public void setSalesman(String salesman){
		this.salesman=salesman;
	}

    @Column(name = "operator")
    public String getOperator(){
    	return operator;
    }
    
    public void setOperator(String operator){
    	this.operator=operator;
    }
    
    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name="purchaseGoodsListID")
    public List<GoodInfo> getGoodsList(){
    	return purchaseGoodsList;
    }
    
    public void setGoodsList(List<GoodInfo> list){
    	this.purchaseGoodsList=list;
    }
    
    @Column(name="remark")
    public String getRemark(){
    	return remark;
    }
    
    public void setRemark(String remark){
    	this.remark=remark;
    }
    
    @Column(name="totalAmount")
    public double getTotalAmount(){
    	return totalAmount;
    }
    
    public void setTotalAmount(double total){
    	this.totalAmount=total;
    }
    
    @Column(name="state")
	public String getState(){
		return state;
	}
	
	public void setState(String state){
		this.state=state;
	}
	
	@Column(name="type")
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}

	@Column(name = "date")
	public String getDate(){
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}


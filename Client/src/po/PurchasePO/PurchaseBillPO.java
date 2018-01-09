package po.PurchasePO;

import java.io.Serializable;
import java.util.List;

import po.GoodInfo;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillID(){
    	return billID;
    }
    
    public void setBillID(String id){
    	this.billID=id;
    }

    public String getInventory(){
    	return inventory;
    }
    
    public void setInventory(String inventory){
    	this.inventory=inventory;
    }

    public String getSupplier(){
    	return supplier;
    }
    
    public void setSupplier(String supplier){
    	this.supplier=supplier;
    }

	public String getSalesman(){
		return salesman;
	}

	public void setSalesman(String salesman){
		this.salesman=salesman;
	}

    public String getOperator(){
    	return operator;
    }
    
    public void setOperator(String operator){
    	this.operator=operator;
    }

    public List<GoodInfo> getGoodsList(){
    	return purchaseGoodsList;
    }
    
    public void setGoodsList(List<GoodInfo> list){
    	this.purchaseGoodsList=list;
    }

    public String getRemark(){
    	return remark;
    }
    
    public void setRemark(String remark){
    	this.remark=remark;
    }

    public double getTotalAmount(){
    	return totalAmount;
    }
    
    public void setTotalAmount(double total){
    	this.totalAmount=total;
    }

	public String getState(){
		return state;
	}
	
	public void setState(String state){
		this.state=state;
	}

	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}

	public String getDate(){
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}


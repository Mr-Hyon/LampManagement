package po.SalesPO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import po.ClientPO.ClientPO;
import po.UserPO.UserPO;
import po.GoodInfo;

@Entity
@Table(name="salebillpo")
public class SalesBillPO implements Serializable{
    private static final long serialVersionUID=1L;
	public SalesBillPO() {
		
	}
	private int id;
	private String billID;
	private String seller;
	private String inventory;
	private String salesman;
	private String operator;
	private List<GoodInfo> saleGoodsList;
	private double originPrice;
	private double rebate;
	private double voucher;
	private double finalPrice;
	private String remark;
	private String state;
	private String type;
	private String date;
	
	public SalesBillPO(String type,String billID,String seller,String inventory,String salesman,String operator,List<GoodInfo> goodsList,double originPrice,double rebate,double voucher,double finalPrice,String remark){
		this.type=type;
		this.billID=billID;
		this.seller=seller;
		this.inventory=inventory;
		this.salesman=salesman;
		this.operator=operator;
		this.saleGoodsList=goodsList;
		this.originPrice=originPrice;
		this.rebate=rebate;
		this.voucher=voucher;
		this.finalPrice=finalPrice;
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
    
    @Column(name = "seller")
    public String getSeller(){
    	return seller;
    }
    
    public void setSeller(String seller){
    	this.seller=seller;
    }
    
    @Column(name = "operator")
    public String getOperator(){
    	return operator;
    }
    
    public void setOperator(String operator){
    	this.operator=operator;
    }
    
    @Column(name = "salesman")
    public String getSalesman(){
    	return salesman;
    }
    
    public void setSalesman(String po){
    	this.salesman=po;
    }
    
    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name="saleGoodsListID")
    public List<GoodInfo> getGoodsList(){
    	return saleGoodsList;
    }
    
    public void setGoodsList(List<GoodInfo> list){
    	this.saleGoodsList=list;
    }
    
    @Column(name="originPrice")
    public double getOriginPrice(){
    	return originPrice;
    }
    
    public void setOriginPrice(double originPrice){
    	this.originPrice=originPrice;
    }
    
    @Column(name="rebate")
    public double getRebate(){
    	return rebate;
    }
    
    public void setRebate(double rebate){
    	this.rebate=rebate;
    }
    
    @Column(name="voucher")
    public double getVoucher(){
    	return voucher;
    }
    
    public void setVoucher(double voucher){
    	this.voucher=voucher;
    }
    
    @Column(name="finalPrice")
    public double getFinalPrice(){
    	return finalPrice;
    }
    
    public void setFinalPrice(double finalPrice){
    	this.finalPrice=finalPrice;
    }
    
    @Column(name="remark")
    public String getRemark(){
    	return remark;
    }
    
    public void setRemark(String remark){
    	this.remark=remark;
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
	    return  date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


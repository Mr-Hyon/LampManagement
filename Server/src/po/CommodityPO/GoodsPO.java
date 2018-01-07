package po.CommodityPO;

import javax.persistence.*;
import po.FatherPO;
import java.io.Serializable;


@Entity
@Table (name="goodspo")
public class GoodsPO implements Serializable{
    private static final long serialVersionUID=1L;
    public GoodsPO() {
    	
	}
	private int id;
	private String name;
	private String classification;
	private String type;
	private int num;
	private double defaultPur;
	private double defaultSale;
	private double purPrice;
	private double salePrice;
	private double alarmNum;
	
	public GoodsPO(String classification, String name, String type, int num,double purPrice, double salePrice) {
		
		this.name=name;
		this.classification=classification;
		this.type=type;
		this.num=num;
		this.purPrice=purPrice;
		this.salePrice=salePrice;
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

    @Column(name="name")
    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name=name;
    }
    
    @Column(name="type")
    public String getType(){
    	return type;
    }
    
    public void setType(String type){
    	this.type=type;
    }
    
    @Column (name="num")
    public int getNum(){
    	return num;
    }
    
    public void setNum(int num){
    	this.num=num;
    }
    
    @Column(name="purPrice")
    public double getPurPrice(){
    	return purPrice;
    }
    
    public void setPurPrice(double purPrice){
    	this.purPrice=purPrice;
    }
    
    @Column(name="salePrice")
    public double getSalePrice(){
    	return salePrice;
    }
    
    public void setSalePrice(double salePrice){
    	this.salePrice=salePrice;
    }
    
    @Column(name = "sort")
    public String getClassification(){
    	return this.classification;
    }
    
    public void setClassification(String sort){
    	this.classification=sort;
    }
    
    @Column(name="defaultpur")
    public double getDefaultPur(){
    	return defaultPur;
    }
    
    public void setDefaultPur(double defaultPur){
    	this.defaultPur=defaultPur;
    }
    
    @Column(name="defaultsale")
    public double getDefaultSale(){
    	return defaultSale;
    }
    
    public void setDefaultSale(double defaultSale){
    	this.defaultSale=defaultSale;
    }

    @Column(name = "alarmNum")
    public double getAlarmNum() {
        return alarmNum;
    }

    public void setAlarmNum(double alarmNum) {
        this.alarmNum = alarmNum;
    }
}

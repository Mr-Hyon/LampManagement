package po.CommodityPO;

import java.io.Serializable;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name=name;
    }

    public String getType(){
    	return type;
    }
    
    public void setType(String type){
    	this.type=type;
    }

    public int getNum(){
    	return num;
    }
    
    public void setNum(int num){
    	this.num=num;
    }

    public double getPurPrice(){
    	return purPrice;
    }
    
    public void setPurPrice(double purPrice){
    	this.purPrice=purPrice;
    }

    public double getSalePrice(){
    	return salePrice;
    }
    
    public void setSalePrice(double salePrice){
    	this.salePrice=salePrice;
    }

    public String getClassification(){
    	return this.classification;
    }
    
    public void setClassification(String sort){
    	this.classification=sort;
    }

    public double getDefaultPur(){
    	return defaultPur;
    }
    
    public void setDefaultPur(double defaultPur){
    	this.defaultPur=defaultPur;
    }

    public double getDefaultSale(){
    	return defaultSale;
    }
    
    public void setDefaultSale(double defaultSale){
    	this.defaultSale=defaultSale;
    }

    public double getAlarmNum() {
        return alarmNum;
    }

    public void setAlarmNum(double alarmNum) {
        this.alarmNum = alarmNum;
    }
}

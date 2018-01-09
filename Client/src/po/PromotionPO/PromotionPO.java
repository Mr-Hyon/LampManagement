package po.PromotionPO;

import po.CommodityPO.GoodsPO;

import java.io.Serializable;
import java.util.List;


public class PromotionPO implements Serializable {
	private static final long serialVersionUID=1L;
	public PromotionPO() {
		
	}

	private int id;
    private String level;//�û��ȼ�
    private double originPrice;//原价
	private double priceAmount;//���û����ȯ�Ľ��ؼ۰����ܼۻ���Ʒ���ܼ�
	private String type;//种类
    private String startDate;
    private String endDate;
    private List<GoodsPO> goodsList;
	
	public PromotionPO(String level,double originPrice,double price,String type,String startDate,String endDate){
		this.level=level;
		this.originPrice=originPrice;
	    this.priceAmount=price;
		this.type=type;
		this.startDate=startDate;
		this.endDate=endDate;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPriceAmount(){
    	return priceAmount;
    }
    
    public void setPriceAmount(double amount){
    	this.priceAmount=amount;
    }

    public String getType(){
    	return type;
    }
    
    public void setType(String type){
    	this.type=type;
    }

    public String getStartDate(){return startDate;}

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }

    public List<GoodsPO> getGoodsList(){
        return goodsList;
    }

    public void setGoodsList(List<GoodsPO> goodsList) {
        this.goodsList = goodsList;
    }

}

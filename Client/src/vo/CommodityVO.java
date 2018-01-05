package vo;

import javafx.beans.property.SimpleStringProperty;

public class CommodityVO {
	
	private final SimpleStringProperty goodId;				//商品编号
	private final SimpleStringProperty goodName;			//商品名称
	private final SimpleStringProperty goodModel;			//商品型号
	private final SimpleStringProperty goodNum;				//商品库存数量
	private final SimpleStringProperty goodBuyPrice;		//商品进价
	private final SimpleStringProperty goodRetailPrice;		//商品零售价
	private final SimpleStringProperty goodRecentBP;		//商品最近进价
	private final SimpleStringProperty goodRecentRP;		//商品最近零售价
	
	CommodityTypeVO type;
	
	public CommodityVO(String id,String name,String model,String num,String bp,String rp){
		goodId=new SimpleStringProperty(id);
		goodName=new SimpleStringProperty(name);
		goodModel=new SimpleStringProperty(model);
		goodNum=new SimpleStringProperty(num);	
		goodBuyPrice=new SimpleStringProperty(bp);	
		goodRetailPrice=new SimpleStringProperty(rp);
		goodRecentBP=new SimpleStringProperty(bp);
		goodRecentRP=new SimpleStringProperty(rp);
	}
	
	public void setType(CommodityTypeVO vo){
		this.type=vo;
	}
	
	public CommodityTypeVO getType(){
		return type;
	}
	
	public String getGoodId(){
		return goodId.get();
	}
	
	public void setGoodId(String id){
		goodId.set(id);
	}
	
	public String getGoodName(){
		return goodName.get();
	}
	
	public void setGoodName(String name){
		goodName.set(name);
	}
	
	public String getGoodModel(){
		return goodModel.get();
	}
	
	public void setGoodModel(String model){
		goodModel.set(model);
	}
	
	public String getGoodNum(){
		return goodNum.get();
	}
	
	public void setGoodNum(String num){
		goodNum.set(num);
	}
	
	public String getGoodBuyPrice(){
		return goodBuyPrice.get();
	}
	
	public void setGoodBuyPrice(String bp){
		goodBuyPrice.set(bp);
	}
	
	public String getGoodRetailPrice(){
		return goodRetailPrice.get();
	}
	
	public void setGoodRetailPrice(String rp){
		goodRetailPrice.set(rp);
	}
	
	public String getGoodRecentBP(){
		return goodRecentBP.get();
	}
	
	public void setGoodRecentBP(String bp){
		goodRecentBP.set(bp);
	}
	
	public String getGoodRecentRP(){
		return goodRecentRP.get();
	}
	
	public void setGoodRecentRP(String rp){
		goodRecentRP.set(rp);
	}

}

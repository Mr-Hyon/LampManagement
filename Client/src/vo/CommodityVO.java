package vo;

import javafx.beans.property.SimpleStringProperty;

public class CommodityVO {
	
	private final SimpleStringProperty goodId;				//��Ʒ���
	private final SimpleStringProperty goodName;			//��Ʒ����
	private final SimpleStringProperty goodModel;			//��Ʒ�ͺ�
	private final SimpleStringProperty goodNum;				//��Ʒ�������
	private final SimpleStringProperty goodBuyPrice;		//��Ʒ����
	private final SimpleStringProperty goodRetailPrice;		//��Ʒ���ۼ�
	private final SimpleStringProperty goodRecentBP;		//��Ʒ�������
	private final SimpleStringProperty goodRecentRP;		//��Ʒ������ۼ�
	
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

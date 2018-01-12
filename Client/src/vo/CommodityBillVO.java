package vo;

import java.util.List;

import po.CommodityPO.GoodsPO;

public class CommodityBillVO {
	
    private String date;	//生成日期
    private String type;	//报损单（Lost）报溢单（Earn）
    private CommodityVO good;
    private String billID;
    
    public CommodityBillVO(String billID,String date,String type,CommodityVO vo){
    	this.billID=billID;
    	this.date=date;
    	this.type=type;
    	this.good=vo;
    }
    
    public String getDate(){
    	return date;
    }
    
    public String getType(){
    	return type;
    }
    
    public String getbillID(){
    	return billID;
    }
    
    public CommodityVO getGood(){
    	return good;
    }
    
    public void setDate(String date){
    	this.date=date;
    }
    
    public void setBillId(String BillId){
    	this.billID=BillId;
    }
    
    public void setType(String type){
    	this.type=type;
    }
    
    public void setGood(CommodityVO vo){
    	this.good=vo;
    }
    
    //获取亏损或盈利额度
    public double getValue(){
    	return Integer.parseInt(this.good.getGoodNum())*Double.parseDouble(this.good.getGoodBuyPrice());
    }

}

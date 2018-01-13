package vo;

import java.util.List;

import po.SalesRecordInfo;

public class SalesConditionTableVO {
	
	private int id;
	private String startDate;
	private String endDate;
	private String commodityName;
	private String client;
	private String salesman;
	private List<SalesRecordInfo> salesRecord;
	
	public SalesConditionTableVO(String startDate,String endDate,String commodityName,String client,String salesman,List<SalesRecordInfo> salesRecord){
		this.salesRecord=salesRecord;
		this.startDate=startDate;
		this.endDate=endDate;
		this.commodityName=commodityName;
		this.client=client;
		this.salesman=salesman;
	}
	
	public List<SalesRecordInfo> getSalesRecord(){
		return this.salesRecord;
	}
	
	public String getstartDate(){
		return this.startDate;
	}
	
	public String getEndDate(){
		return this.endDate;
	}
	
	public String getCommodityName(){
		return this.commodityName;
	}
	
	public String getClient(){
		return this.client;
	}
	
	public String getSalesman(){
		return this.salesman;
	}

}

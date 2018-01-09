package po.TablePO;

import  po.SalesRecordInfo;
import java.io.Serializable;
import java.util.List;

public class SalesConditionTablePO implements Serializable{
    private static final long serialVersionUID=1L;

	public SalesConditionTablePO() {
		
	}

	private int id;
	private String startDate;
	private String endDate;
	private String commodityName;
	private String client;
	private String salesman;
	private List<SalesRecordInfo> salesRecord;
	
	public SalesConditionTablePO(String startDate,String endDate,String commodityName,String client,String salesman,List<SalesRecordInfo> salesRecord){
		this.salesRecord=salesRecord;
		this.startDate=startDate;
		this.endDate=endDate;
		this.commodityName=commodityName;
		this.client=client;
		this.salesman=salesman;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<SalesRecordInfo> getSalesRecord(){
    	return salesRecord;
    }
    
    public void setSalesRecord(List<SalesRecordInfo> list){
    	this.salesRecord=list;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }
}

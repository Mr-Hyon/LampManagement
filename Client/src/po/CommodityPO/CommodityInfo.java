package po.CommodityPO;

import java.io.Serializable;

public class CommodityInfo implements Serializable{
    private static final long serialVersionUID=1L;
    public CommodityInfo(){}

    private int id;
    private String commodityName;
    private String type;
    private double amount;
    private double averagePrice;
    private String batch;//����
    private String batchNumber;//����
    private String dateOfProduction;//��������

    public CommodityInfo(String commodityName,String type,double amount,double averagePrice,String batch,String batchNumber,String dateOfProduction){
        this.commodityName=commodityName;
        this.type=type;
        this.amount=amount;
        this.averagePrice=averagePrice;
        this.batch=batch;
        this.batchNumber=batchNumber;
        this.dateOfProduction=dateOfProduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(String dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }
}


package po.CommodityPO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "commodityInfo")
public class CommodityInfo implements Serializable{
    private static final long serialVersionUID=1L;
    public CommodityInfo(){}

    private int id;
    private String commodityName;
    private String type;
    private double amount;
    private double averagePrice;
    private String batch;//批次
    private String batchNumber;//批号
    private String dateOfProduction;//出厂日期

    public CommodityInfo(String commodityName,String type,double amount,double averagePrice,String batch,String batchNumber,String dateOfProduction){
        this.commodityName=commodityName;
        this.type=type;
        this.amount=amount;
        this.averagePrice=averagePrice;
        this.batch=batch;
        this.batchNumber=batchNumber;
        this.dateOfProduction=dateOfProduction;
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

    @Column(name = "commodityName")
    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "averagePrice")
    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Column(name = "batch")
    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Column(name = "batchNumber")
    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Column(name = "dateOfProduction")
    public String getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(String dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }
}


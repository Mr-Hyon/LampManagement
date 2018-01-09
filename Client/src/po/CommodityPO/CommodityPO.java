package po.CommodityPO;

import java.io.Serializable;

public class CommodityPO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String model;
    private double number;
    private double average;
    private String lot;
    private String lotnumber;
    private String date;

    public CommodityPO(String name, String model, double number, double average, String lot, String lotnumber, String date) {
        this.name = name;
        this.model = model;
        this.number = number;
        this.average = average;
        this.lot = lot;
        this.lotnumber = lotnumber;
        this.date = date;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }


    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getLot() {
        return lot;
    }

    public String getLotnumber() {
        return lotnumber;
    }

    public String getDate(){
        return date;
    }
}


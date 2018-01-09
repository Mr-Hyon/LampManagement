package po.CommodityPO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CommodityPO")
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


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
    	 this.name = name;
    }
   

    @Column(name = "model")
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
   	 this.model = model;
   }

    @Column(name = "number")
    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Column(name = "average")
    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Column(name = "lot")
    public String getLot() {
        return lot;
    }
    public void setLot(String lot) {
        this.lot = lot;
    }

    @Column(name = "lotnumber")
    public String getLotnumber() {
        return lotnumber;
    }
    public void setLotnumber(String lotnumber) {
        this.lotnumber = lotnumber;
    }

    @Column(name = "date")
    public String getDate(){
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}


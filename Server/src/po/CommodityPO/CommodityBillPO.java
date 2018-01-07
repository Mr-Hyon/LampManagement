package po.CommodityPO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "commodityBillPO")
public class CommodityBillPO implements Serializable{
    private static final long serialVersionUID=1L;
    public CommodityBillPO(){}

    private int id;
    private String date;
    private String type;
    private List<GoodsPO> InventoryBillGoodsList;
    private String billID;

    public CommodityBillPO(String date,String type,List<GoodsPO> goodsList){
        this.type=type;
        this.InventoryBillGoodsList=goodsList;
        this.date=date;
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

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "InventoryBillGoodsListID")
    public List<GoodsPO> getGoodsList() {
        return InventoryBillGoodsList;
    }

    public void setGoodsList(List<GoodsPO> goodsList) {
        this.InventoryBillGoodsList = goodsList;
    }

    @Column(name = "billID")
    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

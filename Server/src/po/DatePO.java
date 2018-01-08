package po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "datepo")
public class DatePO implements Serializable{
    private static final long serialVersionUID=1L;

    private String date;
    private int[] pool=new int[11];
    private int id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "Date")
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Column(name = "Pool")
    public int[] getPool() {
        return pool;
    }
    public void setPool(int[] pool) {
        this.pool = pool;
    }
}


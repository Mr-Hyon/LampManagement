package Server.src.po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FatherPO implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String ID;
    protected String date;
    public FatherPO(String ID){
        this.ID= ID;
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        date=sdf.format(new Date());
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getID() {
        return ID;
    }
    public String getDate() {
        return date;
    }
}

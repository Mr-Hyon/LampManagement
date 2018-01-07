package po.CommodityPO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import po.CommodityPO.GoodsPO;

@Entity
@Table(name="classificationpo")
public class ClassificationPO implements Serializable{
    private static final long serialVersionUID=1L;
	public ClassificationPO() {
	
	}

	private String name;
	private int id;
	private String parentSort;
	
	public ClassificationPO(String name,String parentsort) {
		this.name=name;
		this.parentSort=parentsort;
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
    
    @Column(name="name")
    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name=name;
    }
    
    @Column(name = "parentSort")
    public String getParentSort(){
    	return parentSort;
    }
    
    public void setParentSort(String parent){
    	this.parentSort=parent;
    }
    

}


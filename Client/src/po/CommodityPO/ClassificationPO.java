package po.CommodityPO;

import java.io.Serializable;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name=name;
    }

    public String getParentSort(){
    	return parentSort;
    }
    
    public void setParentSort(String parent){
    	this.parentSort=parent;
    }
    

}


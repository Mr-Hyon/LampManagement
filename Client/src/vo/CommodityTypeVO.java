package vo;

import javafx.beans.property.SimpleStringProperty;

public class CommodityTypeVO {
	
	private final SimpleStringProperty typeName;	//商品类型名称
	private final SimpleStringProperty typeId;		//商品类型编号
	CommodityTypeVO upperType;
	boolean isleaf;
	
	public CommodityTypeVO(CommodityTypeVO upperType,String typeId,String typeName){
		this.typeId=new SimpleStringProperty(typeId);
		this.typeName=new SimpleStringProperty(typeName);
		isleaf=true;
		this.upperType=upperType;
		if(upperType!=null){
			this.upperType.setisLeaf(false);
		}
	}
	
	public String getTypeId(){
		return typeId.get();
	}
	
	public void setTypeId(String id){
		typeId.set(id);
	}
	
	public String getTypeName(){
		return typeName.get();
	}
	
	public void setTypeName(String name){
		typeName.set(name);
	}
	
	public boolean isLeaf(){
		return isleaf;
	}
	
	public void setisLeaf(boolean bool){
		isleaf=bool;
	}

}

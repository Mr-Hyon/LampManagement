package vo;

import javafx.beans.property.SimpleStringProperty;

public class CommodityTypeVO {
	
	private final SimpleStringProperty typeName;		//商品类型名称
	private final SimpleStringProperty typeId;			//商品类型编号
	private final SimpleStringProperty upperTypeName;	//商品母类名称
	
	public CommodityTypeVO(String upperType,String typeId,String typeName){
		this.typeId=new SimpleStringProperty(typeId);
		this.typeName=new SimpleStringProperty(typeName);
		this.upperTypeName=new SimpleStringProperty(upperType);
	}
	
	public String getUpperTypeName(){
		return upperTypeName.get();
	}
	
	public void setUpperTypeName(String upperTypeName){
		
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
	
}

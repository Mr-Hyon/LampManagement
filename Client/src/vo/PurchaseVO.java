package vo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PurchaseVO {
	private SimpleStringProperty PurchaseId;   	//单据编号
	private SimpleStringProperty Supplier; 		 //供应商
	private SimpleStringProperty Operator;		//操作员
	private SimpleStringProperty Storage;       //仓库
	private SimpleDoubleProperty Sum;           //总额
	private SimpleStringProperty Note1;         //单据备注
	
	
	private SimpleStringProperty IdofGoods;     //商品编号
	private SimpleStringProperty NameofGoods;   //商品名称
	private SimpleStringProperty Xinghao;       //商品型号
	private SimpleIntegerProperty Number;        //数量
	private SimpleStringProperty Price;         //单价
	private SimpleDoubleProperty Sum2;          //入库商品总额
	private SimpleStringProperty Note2;         //入库商品清单备注
	

	
	public PurchaseVO(String PurchaseId,String Supplier,String operator,String Storage,double Sum1, String Note1,
			String Idofgoods,String NameofGoods,String Xinghao,int number, String price,double Sum2,String Note2){
		this.PurchaseId=new SimpleStringProperty(PurchaseId);			
		this.Supplier=new SimpleStringProperty(Supplier);			
		this.Operator=new SimpleStringProperty(operator);		
		this.Storage=new SimpleStringProperty(Storage);	
		this.Sum=new SimpleDoubleProperty(Sum1);	
		this.Note1=new SimpleStringProperty(Note1);			
		this.IdofGoods=new SimpleStringProperty(Idofgoods);	
		this.NameofGoods=new SimpleStringProperty(NameofGoods);	
		this.Xinghao=new SimpleStringProperty(Xinghao);	
		this.Number=new SimpleIntegerProperty(number);
		this.Price=new SimpleStringProperty(price);
		this.Sum2=new SimpleDoubleProperty(Sum2);
		this.Note2=new SimpleStringProperty(Note2);	
		

	}
	public String getPurchaseId() {
		return PurchaseId.get();
	}
	public void setPurchaseId(String PurchaseId){
		this.PurchaseId.set(PurchaseId);
	}
	public String getSupplier() {
		return Supplier.get();
	}
	public void setSupplier(String Supplier){
		this.Supplier.set(Supplier);
	}
	public String getOperator() {
		return Operator.get();
	}
	public void setOperator(String Operator){
		this.Supplier.set(Operator);
	}
	public String getStorage() {
		return Storage.get();
	}
	public void setStorage(String Storage){
		this.Storage.set(Storage);
	}
	public double getSum1() {
		return Sum.get();
	}
	public void setSum1(double Sum){
		this.Sum.set(Sum);
	}
	public String getNote1() {
		return Note1.get();
	}
	public void setNote1(String Note1){
		this.Note1.set(Note1);
	}
	public String getIdofGoods() {
		return IdofGoods.get();
	}
	public void setIdofGoods(String IdofGoods){
		this.IdofGoods.set(IdofGoods);
	}
	public String getNameofGoods() {
		return NameofGoods.get();
	}
	public void setNameofGoods(String NameofGoods){
		this.NameofGoods.set(NameofGoods);
	}
	public String getModel() {
		return Xinghao.get();
	}
	public void setModel(String xinghao){
		this.Xinghao.set(xinghao);
	}public int getNumber() {
		return Number.get();
	}
	public void setNumber(int Number){
		this.Number.set(Number);
	}
	public String getPrice() {
		return Price.get();
	}
	public void setPrice(String Price){
		this.Price.set(Price);
	}
	public double getSum2() {
		return Sum2.get();
	}
	public void setSum2(double Sum2){
		this.Sum2.set(Sum2);
	}
	public String getNote2() {
		return Note2.get();
	}
	public void setNote2(String Note2){
		this.Note2.set(Note2);
	}
	
	
}
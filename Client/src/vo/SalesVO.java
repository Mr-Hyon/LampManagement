package vo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SalesVO {
	private SimpleStringProperty SalesId;   	//单据编号
	private SimpleStringProperty Buyer; 		 //供应商
	private SimpleStringProperty Businessman; 	//业务员 
	private SimpleStringProperty Operator;		//操作员
	private SimpleStringProperty Storage;       //仓库
	private SimpleDoubleProperty Sum;           //折让前总额
   	private SimpleDoubleProperty Discount;      //折让
	private SimpleDoubleProperty DiscountUsed;  //使用代金券
	private SimpleDoubleProperty SumAfterDiscount;  //折让后总额
	private SimpleStringProperty Note1;         //单据备注
	
	private SimpleStringProperty IdofGoods;     //商品编号
	private SimpleStringProperty NameofGoods;   //商品名称
	private SimpleStringProperty Xinghao;       //商品型号
	private SimpleIntegerProperty Number;        //数量
	private SimpleDoubleProperty Price;         //单价
	private SimpleDoubleProperty Sum2;          //出货商品总额
	private SimpleStringProperty Note2;         //出货商品清单备注
	
	
	public SalesVO(String SalesId,String Buyer,String Businessman,String operator,String Storage,double Sum1,double Discount,double DiscountUsed,double SumAfterDiscount, String Note1,
			String Idofgoods,String NameofGoods,String Xinghao,int number,double price, double Sum2,String Note2){
		this.SalesId=new SimpleStringProperty(SalesId);			
		this.Buyer=new SimpleStringProperty(Buyer);		
		this.Businessman=new SimpleStringProperty(Businessman);		
		this.Operator=new SimpleStringProperty(operator);		
		this.Storage=new SimpleStringProperty(Storage);	
		this.Sum=new SimpleDoubleProperty(Sum1);
		this.Discount=new SimpleDoubleProperty(Discount);
		this.DiscountUsed=new SimpleDoubleProperty(DiscountUsed);		
		this.SumAfterDiscount=new SimpleDoubleProperty(SumAfterDiscount);	
		this.Note1=new SimpleStringProperty(Note1);			
		this.IdofGoods=new SimpleStringProperty(Idofgoods);	
		this.NameofGoods=new SimpleStringProperty(NameofGoods);	
		this.Xinghao=new SimpleStringProperty(Xinghao);	
		this.Number=new SimpleIntegerProperty(number);
		this.Price=new SimpleDoubleProperty(price);
		this.Sum2=new SimpleDoubleProperty(Sum2);
		this.Note2=new SimpleStringProperty(Note2);	
		
	}
	public String getSalesId() {
		return SalesId.get();
	}
	public void setSalesId(String SalesId){
		this.SalesId.set(SalesId);
	}
	public String getBusinessman() {
		return Businessman.get();
	}
	public void setBusinessman(String Businessman){
		this.Businessman.set(Businessman);
	}
	public String getBuyer() {
		return Buyer.get();
	}
	public void setBuyer(String Buyer){
		this.Buyer.set(Buyer);
	}
	public String getOperator(){
		return Operator.get();
	}
	public void setOperator(String Operator){
		this.Operator.set(Operator);
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
	public double getDiscount() {
		return Discount.get();
	}
	public void setDiscount(double Discount){
		this.Discount.set(Discount);
	}
	public double getDiscountUsed() {
		return DiscountUsed.get();
	}
	public void setDiscountUsed(double DiscountUsed){
		this.DiscountUsed.set(DiscountUsed);
	}
	public double getSumAfterDiscount() {
		return SumAfterDiscount.get();
	}
	public void setSumAfterDiscount(double SumAfterDiscount){
		this.SumAfterDiscount.set(SumAfterDiscount);
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
	public Double getPrice() {
		return Price.get();
	}
	public void setPrice(Double Price){
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

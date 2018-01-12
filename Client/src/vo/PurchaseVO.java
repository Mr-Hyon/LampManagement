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
	
	private ClientVO client;                            //客户
	private UserVO operator;							//操作员
	private CommodityVO goods;							//商品
	
	public PurchaseVO(String PurchaseId,ClientVO client,UserVO operator,String Storage,double Sum1, String Note1,
			CommodityVO goods,int number, double Sum2,String Note2){
		this.PurchaseId=new SimpleStringProperty(PurchaseId);			
		this.Supplier=new SimpleStringProperty(client.getClientName());			
		this.Operator=new SimpleStringProperty(operator.getUserName());		
		this.Storage=new SimpleStringProperty(Storage);	
		this.Sum=new SimpleDoubleProperty(Sum1);	
		this.Note1=new SimpleStringProperty(Note1);			
		this.IdofGoods=new SimpleStringProperty(goods.getGoodId());	
		this.NameofGoods=new SimpleStringProperty(goods.getGoodName());	
		this.Xinghao=new SimpleStringProperty(goods.getGoodModel());	
		this.Number=new SimpleIntegerProperty(number);
		this.Price=new SimpleStringProperty(goods.getGoodBuyPrice());
		this.Sum2=new SimpleDoubleProperty(Sum2);
		this.Note2=new SimpleStringProperty(Note2);	
		
		this.client=client;
		this.operator=operator;
		this.goods=goods;
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
	
	
	public ClientVO getClient(){
		return client;
	}		
	public void setClient(ClientVO client){
		this.client=client;
		Supplier.set(client.getClientName());
	}
	public UserVO getOperator(){
		return operator;
	}		
	public void setOperator(UserVO operator){
		this.operator=operator;
		Operator.set(operator.getUserName());
	}
	public CommodityVO getCommodity(){
		return goods;
	}
	public void setIdofGoods(CommodityVO goods){
		this.goods=goods;
		IdofGoods.set(goods.getGoodId());
	}
	public void setNameofGoods(CommodityVO goods){
		this.goods=goods;
		NameofGoods.set(goods.getGoodName());
	}
	public void setXinghao(CommodityVO goods){
		this.goods=goods;
		Xinghao.set(goods.getGoodModel());
	}
	public void setPrice(CommodityVO goods){
		this.goods=goods;
		Price.set(goods.getGoodBuyPrice());
	}
}
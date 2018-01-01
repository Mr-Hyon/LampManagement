
public class MockPurchase extends Purchase{
	String nameOfClient;
	String IDOfGoods;
	String nameOfGoods;
	String xinghao;
	double priceOfGoods;
	public MockPurchase(String nameOfClient){
		this.nameOfClient=nameOfClient;
	}
	public String getnameOfClient(){
		return nameOfClient;
	}
	public void MockPurchase0(String IDOfGoods){
		this.IDOfGoods=IDOfGoods;
	}
	public String getIDOfGoods(){
		return IDOfGoods;
	}
	public void MockPurchase1(String nameOfGoods){
		this.nameOfGoods=nameOfGoods;
	}
	public String getnameOfGoods(){
		return nameOfGoods;
	}
	public void MockPurchase2(String xinghao){
		this.xinghao=xinghao;
	}
	public String getxinghao(){
		return xinghao;
	}
	public void MockPurchase3(double priceOfGoods){
		this.priceOfGoods=priceOfGoods;
	}
	public double getpriceOfGoods(){
		return priceOfGoods;
	}
}

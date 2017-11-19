
public class MockSales extends Sales {
	String nameOfClient;
	String IDOfGoods;
	String nameOfGoods;
	String xinghao;
	double priceOfGoods;
	public MockSales(String nameOfClient){
		this.nameOfClient=nameOfClient;
	}
	public String getnameOfClient(){
		return nameOfClient;
	}
	public void MockSales0(String IDOfGoods){
		this.IDOfGoods=IDOfGoods;
	}
	public String getIDOfGoods(){
		return IDOfGoods;
	}
	public void MockSales1(String nameOfGoods){
		this.nameOfGoods=nameOfGoods;
	}
	public String getnameOfGoods(){
		return nameOfGoods;
	}
	public void MockSales2(String xinghao){
		this.xinghao=xinghao;
	}
	public String getxinghao(){
		return xinghao;
	}
	public void MockSales3(double priceOfGoods){
		this.priceOfGoods=priceOfGoods;
	}
	public double getpriceOfGoods(){
		return priceOfGoods;
	}
}

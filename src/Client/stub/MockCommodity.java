public class MockCommodity extends Commodity {
	String name;
	String ID;
	String classification;
	double price;
	int amount;
	
	public MockCommodity(double price,int amount) {
		this.amount = amount;
		this.price = price;
	}

	public double getprice() {
		return price;
	}

	public int getamount() {
		return amount;
	}
}

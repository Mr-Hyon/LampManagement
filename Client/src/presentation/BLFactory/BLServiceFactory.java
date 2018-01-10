package presentation.BLFactory;

import bl.accountbl.AccountController;
import bl.clientbl.ClientController;
import bl.commoditybl.CommodityController;
import bl.paymentbl.PaymentController;
import bl.promotionbl.PromotionController;
import bl.purchasebl.PurchaseController;
import bl.salesbl.SalesController;
import bl.tablebl.TableController;
import bl.userbl.UserController;
import blservice.accountblservice.AccountBLService;
import blservice.clientblservice.ClientBLService;
import blservice.commodityblservice.CommodityBLService;
import blservice.paymentblservice.PaymentBLService;
import blservice.promotionblservice.PromotionBLService;
import blservice.purchaseblservice.PurchaseBLService;
import blservice.salesblservice.SalesBLService;
import blservice.tableblservice.TableBLService;
import blservice.userblservice.UserBLService;

public class BLServiceFactory {
	private static AccountBLService accountBLService= new AccountController();
	private static ClientBLService clientBLService= new ClientController();
	private static CommodityBLService commodityBLService= new CommodityController();
	private static PaymentBLService paymentBLService= new PaymentController();
	private static PromotionBLService promotionBLService= new PromotionController();
	private static PurchaseBLService purchaseBLService= new PurchaseController();
	private static SalesBLService salesBLService= new SalesController();
	private static TableBLService tableBLService= new TableController();
	private static UserBLService userBLService= new UserController();
	
	public static AccountBLService getAccountBLService(){
		return accountBLService;
	}
	
	public static ClientBLService getClientBLService(){
		return clientBLService;
	}
	
	public static CommodityBLService getCommodityBLService(){
		return commodityBLService;
	}
	
	public static PaymentBLService getPaymentBLService(){
		return paymentBLService;
	}
	
	public static PromotionBLService getPromotionBLService(){
		return promotionBLService;
	}
	
	public static PurchaseBLService getPurchaseBLService(){
		return purchaseBLService;
	}
	
	public static SalesBLService getSalesBLService(){
		return salesBLService;
	}
	
	public static TableBLService getTableBLService(){
		return tableBLService;
	}
	
	public static UserBLService getUserBLService(){
		return userBLService;
	}
	
}

package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.AccountDataService.AccountDataService;
import dataservice.ClientDataService.ClientDataService;
import dataservice.CommodityDataService.ClassificationDataService;
import dataservice.CommodityDataService.CommodityDataService;
import dataservice.CommodityDataService.GoodsDataService;
import dataservice.PaymentDataService.CollectionDataService;
import dataservice.PaymentDataService.PaymentDataService;
import dataservice.PromotionDataService.PromotionDataService;
import dataservice.PurchaseDataService.PurchaseBillDataService;
import dataservice.SalesDataService.SalesBillDataService;
import dataservice.TableDataService.SalesConditionDataService;
import dataservice.UserDataService.UserDataService;

public class RemoteHelper {
	private static RemoteHelper remoteHelper=new RemoteHelper();
	private Remote remote;
	
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper(){
		;
	}
	
	public void setRemote(Remote remote){
		this.remote=remote;
	}
	
	public AccountDataService getAccountDataService(){
		return (AccountDataService)remote;
	}

	public ClientDataService getClientDataService(){
		return (ClientDataService)remote;
	}
	
	public ClassificationDataService getClassificationDataService(){
		return (ClassificationDataService)remote;
	}
	
	public GoodsDataService getGoodsDataService(){
		return (GoodsDataService)remote;
	}
	
	public CommodityDataService getCommodityDataService(){
		return (CommodityDataService)remote;
	}
	
	public CollectionDataService getCollectionDataService(){
		return (CollectionDataService)remote;
	}
	
	public PaymentDataService getPaymentDataService(){
		return (PaymentDataService)remote;
	}
	
	public PromotionDataService getPromotionDataService(){
		return (PromotionDataService)remote;
	}
	
	public PurchaseBillDataService getPurchaseDataService(){
		return (PurchaseBillDataService)remote;
	}
	
	public SalesBillDataService getSalesBillDataService(){
		return (SalesBillDataService)remote;
	}
	
	public SalesConditionDataService getSalesConditionDataService(){
		return (SalesConditionDataService)remote;
	}
	
	public UserDataService getUserDataService(){
		return (UserDataService)remote;
	}
}
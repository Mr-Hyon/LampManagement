package rmi;

import data.AccountData.AccountData;
import dataservice.ClientDataService.ClientDataService;
import dataservice.CommodityDataService.ClassificationDataService;
import dataservice.CommodityDataService.CommodityDataService;
import dataservice.CommodityDataService.GoodsDataService;
import dataservice.PaymentDataService.CollectionDataService;
import dataservice.PaymentDataService.PaymentDataService;
import dataservice.PromotionDataService.PromotionDataService;
import dataservice.AccountDataService.AccountDataService;
import po.*;
import po.AccountPO.AccountPO;
import po.ClientPO.ClientPO;
import po.CommodityPO.ClassificationPO;
import po.CommodityPO.CommodityBillPO;
import po.CommodityPO.GoodsPO;
import po.PaymentPO.CollectionPO;
import po.PaymentPO.PaymentPO;
import po.PromotionPO.PromotionPO;
import common.feedback;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionException;



public class DataRemoteObject extends UnicastRemoteObject  implements AccountDataService,ClientDataService,ClassificationDataService,CommodityDataService,GoodsDataService
																		,CollectionDataService,PaymentDataService,PromotionDataService{
	
	private AccountDataService accountDataService;
	
	protected DataRemoteObject() throws RemoteException{
		accountDataService=new AccountData();
	}

	@Override
	public feedback addAccount(AccountPO po) throws RemoteException {
		try {
            return accountDataService.addAccount(po);
        }catch (Exception e){

            e.printStackTrace();
        }
        return feedback.Fail;
	}


	@Override
	public feedback deleteAccount(String name) throws RemoteException {
		try {
            return accountDataService.deleteAccount(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return feedback.Fail;
	}

	@Override
	public feedback updateAccount(AccountPO po) throws RemoteException {
		try{
            return accountDataService.updateAccount(po);
        }catch (Exception e){
            e.printStackTrace();
        }
        return feedback.Fail;
	}

	@Override
	public AccountPO findAccountByKeyWord(String word) throws RemoteException {
		return accountDataService.findAccountByKeyWord(word);
	}

	@Override
	public List<AccountPO> findAccountByBank(String bank) throws RemoteException {
		return accountDataService.findAccountByBank(bank);
	}

	@Override
	public List<AccountPO> showAccount() throws RemoteException {
		return accountDataService.showAccount();
	}

	@Override
	public AccountPO findAccountByName(String name) throws RemoteException {
		return accountDataService.findAccountByName(name);
	}

	@Override
	public feedback addPromotion(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback deletePromotion(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback modifyPromotion(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromotionPO> getPromotion(String date, String type, double amount, String level)
			throws ParseException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromotionPO> findPromotionByType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentPO> findPaymentBillByType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentPO> findPaymentBillByClient(String po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentPO findPaymentBillByBillID(String billID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentPO> getPaymentPO(String startDate, String endDate, String client)
			throws ParseException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentPO> getDraftPaymentBill() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback addPaymentBill(PaymentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback checkPaymentBill(PaymentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback reversePaymentBill(String billID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback modifyPaymentBill(PaymentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionPO> showCollectionBill() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionPO> getCollectionBill(String startDate, String endDate)
			throws ParseException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionPO> getDraftCollectionBill() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback addCash(CollectionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback checkCollection(CollectionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback reverseCollectionBill(String billID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsPO> showGoods() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback insertGoods(GoodsPO sort) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback deleteGoods(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback modifyGoods(GoodsPO sort) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsPO searchGoodsByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsPO> searchGoodsByType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsPO> searchGoodsByClassification(String sort) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endGoodDate() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public feedback addInventoryBill(CommodityBillPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommodityBillPO> getInventoryBill() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommodityBillPO findInventoryBillByBillID(String billID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommodityBillPO> getInventoryList(String startDate, String endDate)
			throws ParseException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback redDashInventoryBill(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback insertSort(ClassificationPO sort) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback deleteSort(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback modifySort(ClassificationPO sort) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassificationPO searchSort(String name) throws RemoteException, SessionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassificationPO> showSort() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassificationPO> searchSortByParent(String parent) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endClassificationData() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public feedback addClient(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback deleteClient(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public feedback updateClient(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientPO findClientById(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientPO findClientByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientPO findClientByKeyWord(String word) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientPO> findClientByType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientPO> showClient() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

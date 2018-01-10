package rmi;

import data.IDData;
import data.AccountData.AccountData;
import data.ClientData.ClientData;
import data.CommodityData.ClassificationData;
import data.CommodityData.CommodityData;
import data.CommodityData.GoodsData;
import data.PaymentData.CollectionData;
import data.PaymentData.PaymentData;
import data.PromotionData.PromotionData;
import data.PurchaseData.PurchaseBillData;
import data.SalesData.SalesBillData;
import data.TableData.SalesConditionData;
import data.UserData.UserData;
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
import dataservice.IDService;
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
import po.PurchasePO.PurchaseBillPO;
import po.SalesPO.SalesBillPO;
import po.TablePO.SalesConditionTablePO;
import po.UserPO.UserPO;
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
																		,CollectionDataService,PaymentDataService,PromotionDataService,PurchaseBillDataService,SalesBillDataService
																		,SalesConditionDataService,UserDataService,IDService{
	
	private AccountDataService accountDataService;
    private ClientDataService clientDataService;
    private ClassificationDataService classificationDataService;
    private GoodsDataService goodsDataService;
    private UserDataService userDataService;
    private IDService idService;
    private PaymentDataService paymentDataService;
    private CollectionDataService collectionDataService;
    private CommodityDataService commodityDataService;
    private PromotionDataService promotionDataService;
    private SalesBillDataService salesBillDataService;
    private PurchaseBillDataService purchaseBillDataService;
    private SalesConditionDataService salesConditionDataService;


	protected DataRemoteObject() throws RemoteException{
		accountDataService=new AccountData();
		clientDataService=new ClientData();
		classificationDataService=new ClassificationData();
        goodsDataService=new GoodsData();
        userDataService=new UserData();
        idService=new IDData();
        paymentDataService=new PaymentData();
        collectionDataService=new CollectionData();
        commodityDataService=new CommodityData();
        promotionDataService=new PromotionData();
        salesBillDataService=new SalesBillData();
        purchaseBillDataService=new PurchaseBillData();
        salesConditionDataService=new SalesConditionData();


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
		return promotionDataService.addPromotion(po);
	}

	@Override
	public feedback deletePromotion(int id) throws RemoteException {
		return promotionDataService.deletePromotion(id);
	}

	@Override
	public feedback modifyPromotion(PromotionPO po) throws RemoteException {
		return promotionDataService.modifyPromotion(po);
	}

	@Override
	public List<PromotionPO> getPromotion(String date, String type, double amount, String level)
			throws ParseException, RemoteException {
		return promotionDataService.getPromotion(date, type, amount, level);
	}

	@Override
	public List<PromotionPO> findPromotionByType(String type) throws RemoteException {
		return promotionDataService.findPromotionByType(type);
	}

	@Override
	public List<PaymentPO> findPaymentBillByType(String type) throws RemoteException {
		return paymentDataService.findPaymentBillByType(type);
	}

	@Override
	public List<PaymentPO> findPaymentBillByClient(String po) throws RemoteException {
		return paymentDataService.findPaymentBillByClient(po);
	}

	@Override
	public PaymentPO findPaymentBillByBillID(String billID) throws RemoteException {
		return paymentDataService.findPaymentBillByBillID(billID);
	}

	@Override
	public List<PaymentPO> getPaymentPO(String startDate, String endDate, String client)
			throws ParseException, RemoteException {
		return paymentDataService.getPaymentPO(startDate, endDate, client);
	}

	@Override
	public List<PaymentPO> getDraftPaymentBill() throws RemoteException {
		return paymentDataService.getDraftPaymentBill();
	}

	@Override
	public feedback addPaymentBill(PaymentPO po) throws RemoteException {
		return paymentDataService.addPaymentBill(po);
	}

	@Override
	public feedback checkPaymentBill(PaymentPO po) throws RemoteException {
		return paymentDataService.checkPaymentBill(po);
	}

	@Override
	public feedback reversePaymentBill(String billID) throws RemoteException {
		return paymentDataService.reversePaymentBill(billID);
	}

	@Override
	public feedback modifyPaymentBill(PaymentPO po) throws RemoteException {
		return paymentDataService.modifyPaymentBill(po);
	}

	@Override
	public List<CollectionPO> showCollectionBill() throws RemoteException {
		return collectionDataService.showCollectionBill();
	}

	@Override
	public List<CollectionPO> getCollectionBill(String startDate, String endDate)
			throws ParseException, RemoteException {
		return collectionDataService.getCollectionBill(startDate, endDate);
	}

	@Override
	public List<CollectionPO> getDraftCollectionBill() throws RemoteException {
		return collectionDataService.getDraftCollectionBill();
	}

	@Override
	public feedback addCash(CollectionPO po) throws RemoteException {
		return collectionDataService.addCash(po);
	}

	@Override
	public feedback checkCollection(CollectionPO po) throws RemoteException {
		return collectionDataService.checkCollection(po);
	}

	@Override
	public feedback reverseCollectionBill(String billID) throws RemoteException {
		return collectionDataService.reverseCollectionBill(billID);
	}

	@Override
	public List<GoodsPO> showGoods() throws RemoteException {
		return goodsDataService.showGoods();
	}

	@Override
	public feedback insertGoods(GoodsPO sort) throws RemoteException {
		return goodsDataService.insertGoods(sort);
	}

	@Override
	public feedback deleteGoods(String name) throws RemoteException {
		return goodsDataService.deleteGoods(name);
	}

	@Override
	public feedback modifyGoods(GoodsPO sort) throws RemoteException {
		return goodsDataService.modifyGoods(sort);
	}

	@Override
	public GoodsPO searchGoodsByName(String name) throws RemoteException {
		return goodsDataService.searchGoodsByName(name);
	}

	@Override
	public List<GoodsPO> searchGoodsByType(String type) throws RemoteException {
		return goodsDataService.searchGoodsByType(type);
	}

	@Override
	public List<GoodsPO> searchGoodsByClassification(String sort) throws RemoteException {
		return goodsDataService.searchGoodsByClassification(sort);
	}

	@Override
	public void endGoodDate() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public feedback addCommodityBill(CommodityBillPO po) throws RemoteException {
		return commodityDataService.addCommodityBill(po);
	}

	@Override
	public List<CommodityBillPO> getCommodityBill() throws RemoteException {
		return commodityDataService.getCommodityBill();
	}

	@Override
	public CommodityBillPO findCommodityBillByBillID(String billID) throws RemoteException {
		return commodityDataService.findCommodityBillByBillID(billID);
	}

	@Override
	public List<CommodityBillPO> getCommodityList(String startDate, String endDate)
			throws ParseException, RemoteException {
		return commodityDataService.getCommodityList(startDate, endDate);
	}

	@Override
	public feedback reverseCommodityBill(int id) throws RemoteException {
		return commodityDataService.reverseCommodityBill(id);
	}

	@Override
	public feedback insertSort(ClassificationPO sort) throws RemoteException {
		return classificationDataService.insertSort(sort);
	}

	@Override
	public feedback deleteSort(String name) throws RemoteException {
		return classificationDataService.deleteSort(name);
	}

	@Override
	public feedback modifySort(ClassificationPO sort) throws RemoteException {
		return classificationDataService.modifySort(sort);
	}

	@Override
	public ClassificationPO searchSort(String name) throws RemoteException, SessionException {
		return classificationDataService.searchSort(name);
	}

	@Override
	public List<ClassificationPO> showSort() throws RemoteException {
		return classificationDataService.showSort();	
	}

	@Override
	public List<ClassificationPO> searchSortByParent(String parent) throws RemoteException {
		return classificationDataService.searchSortByParent(parent);
	}

	@Override
	public void endClassificationData() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public feedback addClient(ClientPO po) throws RemoteException {
		return clientDataService.addClient(po);
	}

	@Override
	public feedback deleteClient(String name) throws RemoteException {
		return clientDataService.deleteClient(name);
	}

	@Override
	public feedback updateClient(ClientPO po) throws RemoteException {
		return clientDataService.updateClient(po);
	}

	@Override
	public ClientPO findClientById(int id) throws RemoteException {
		return clientDataService.findClientById(id);
	}

	@Override
	public ClientPO findClientByName(String name) throws RemoteException {
		return clientDataService.findClientByName(name);
	}

	@Override
	public ClientPO findClientByKeyWord(String word) throws RemoteException {
		return clientDataService.findClientByKeyWord(word);
	}

	@Override
	public List<ClientPO> findClientByType(String type) throws RemoteException {
		return clientDataService.findClientByType(type);
	}

	@Override
	public List<ClientPO> showClient() throws RemoteException {
		return clientDataService.showClient();
	}

	@Override
	public String getID(String type) throws RemoteException {
		return idService.getID(type);
	}

	@Override
	public UserPO findUser(String username) throws RemoteException {
		return userDataService.findUser(username);
	}

	@Override
	public feedback modifyPassword(UserPO user) throws RemoteException {
		return userDataService.modifyPassword(user);
	}

	@Override
	public feedback addSalesCondition(SalesConditionTablePO po) throws RemoteException {
		return salesConditionDataService.addSalesCondition(po);
	}

	@Override
	public List<SalesRecordInfo> getSalesBill(String startDate, String endDate, String commodityName, String client,
			String salesman, String inventory) throws ParseException, RemoteException {
		return salesConditionDataService.getSalesBill(startDate, endDate, commodityName, client, salesman, inventory);
	}

	@Override
	public SalesConditionTablePO searchSalesConditionBillByID(int id) throws RemoteException {
		return salesConditionDataService.searchSalesConditionBillByID(id);
	}

	@Override
	public List<SalesConditionTablePO> showSalesConditionBill() throws RemoteException {
		return salesConditionDataService.showSalesConditionBill();
	}

	@Override
	public List<SalesBillPO> findSalesBillByType(String type) throws RemoteException {
		return salesBillDataService.findSalesBillByType(type);
	}

	@Override
	public List<SalesBillPO> findSalesBillByClient(String po) throws RemoteException {
		return salesBillDataService.findSalesBillByClient(po);
	}

	@Override
	public List<SalesBillPO> findSalesBillByCommodity(String commodity) throws RemoteException {
		return salesBillDataService.findSalesBillByCommodity(commodity);
	}

	@Override
	public SalesBillPO findSalesBillByID(String id) throws RemoteException {
		return salesBillDataService.findSalesBillByID(id);
	}

	@Override
	public List<SalesBillPO> getSalesBillPO(String startDate, String endDate, String client, String salesman,
			String commodity) throws ParseException, RemoteException {
		return salesBillDataService.getSalesBillPO(startDate, endDate, client, salesman, commodity);
	}

	@Override
	public List<SalesBillPO> getDraftSalesBill() throws RemoteException {
		return salesBillDataService.getDraftSalesBill();
	}

	@Override
	public List<SalesBillPO> getPassedSalesBill() throws RemoteException {
		return salesBillDataService.getPassedSalesBill();
	}

	@Override
	public feedback addSalesBill(SalesBillPO po) throws RemoteException {
		return salesBillDataService.addSalesBill(po);
	}

	@Override
	public feedback checkSalesBill(SalesBillPO po) throws RemoteException {
		return salesBillDataService.checkSalesBill(po);
	}

	@Override
	public feedback reverseSalesBill(String billID) throws RemoteException {
		return salesBillDataService.reverseSalesBill(billID);
	}

	@Override
	public feedback modifySalesBill(SalesBillPO po) throws RemoteException {
		return salesBillDataService.modifySalesBill(po);
	}

	@Override
	public PurchaseBillPO findPurchaseBillByBillID(String billID) throws RemoteException {
		return purchaseBillDataService.findPurchaseBillByBillID(billID);
	}

	@Override
	public List<PurchaseBillPO> findPurchaseBillByType(String type) throws RemoteException {
		return purchaseBillDataService.findPurchaseBillByType(type);
	}

	@Override
	public List<PurchaseBillPO> findPurchaseBillByClient(String po) throws RemoteException {
		return purchaseBillDataService.findPurchaseBillByClient(po);
	}

	@Override
	public List<PurchaseBillPO> findPurchaseBillByCommodity(String commodity) throws RemoteException {
		return purchaseBillDataService.findPurchaseBillByCommodity(commodity);
	}

	@Override
	public List<PurchaseBillPO> getPurchaseBillPO(String startDate, String endDate, String client, String salesman,
			String inventory) throws ParseException, RemoteException {
		return purchaseBillDataService.getPurchaseBillPO(startDate, endDate, client, salesman, inventory);
	}

	@Override
	public List<PurchaseBillPO> getDraftPurchaseBill() throws RemoteException {
		return purchaseBillDataService.getDraftPurchaseBill();
	}

	@Override
	public feedback addPurchaseBill(PurchaseBillPO po) throws RemoteException {
		return purchaseBillDataService.addPurchaseBill(po);
	}

	@Override
	public feedback checkPurchaseBill(PurchaseBillPO po) throws RemoteException {
		return purchaseBillDataService.checkPurchaseBill(po);
	}

	@Override
	public feedback reversePurchaseBill(String billID) throws RemoteException {
		return purchaseBillDataService.reversePurchaseBill(billID);
	}

	@Override
	public feedback modifyPurchaseBill(PurchaseBillPO po) throws RemoteException {
		return purchaseBillDataService.modifyPurchaseBill(po);
	}

	@Override
	public feedback addUser(UserPO user) throws RemoteException {
		return userDataService.addUser(user);
	}

	@Override
	public feedback updateAccountName(AccountPO po, String name) throws RemoteException {
		return accountDataService.updateAccountName(po, name);
	}
	
	
}

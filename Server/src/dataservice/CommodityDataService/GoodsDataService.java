package dataservice.CommodityDataService;

import common.feedback;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CommodityPO.ClassificationPO;
import po.CommodityPO.GoodsPO;

public interface    GoodsDataService extends Remote {

	public List<GoodsPO> showGoods()throws RemoteException;
	
	public feedback insertGoods(GoodsPO sort) throws RemoteException;
	
	public feedback deleteGoods(String name) throws RemoteException;
	
	public feedback modifyGoods(GoodsPO sort) throws RemoteException;
	
	public GoodsPO searchGoodsByName(String name) throws RemoteException;
	
	public List<GoodsPO> searchGoodsByType(String type) throws RemoteException;
	
	public List<GoodsPO> searchGoodsByClassification(String sort) throws RemoteException;

	public void endGoodDate() throws RemoteException;
}


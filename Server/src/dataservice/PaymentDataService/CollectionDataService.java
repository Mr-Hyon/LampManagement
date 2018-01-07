package Server.src.dataservice.PaymentDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

import Server.src.po.PaymentPO.CollectionPO;
import Server.src.feedback;

public interface CollectionDataService extends Remote {

	public List<CollectionPO> showCollectionBill()throws RemoteException;

	public List<CollectionPO> getCollectionBill(String startDate,String endDate) throws ParseException,RemoteException;

	public List<CollectionPO> getDraftCollectionBill()throws RemoteException;

	public feedback addCash(CollectionPO po)throws RemoteException;
	

	public feedback checkCollection(CollectionPO po)throws RemoteException;

	public feedback reverseCollectionBill(String billID)throws RemoteException;//红冲

}


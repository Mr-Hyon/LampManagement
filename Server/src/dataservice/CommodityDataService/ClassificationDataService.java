package Server.src.dataservice.CommodityDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.SessionException;
import Server.src.feedback;
import Server.src.po.CommodityPO.ClassificationPO;

public interface ClassificationDataService extends Remote {


	public feedback insertSort(ClassificationPO sort) throws RemoteException;

	public feedback deleteSort(String name) throws RemoteException;
	
	public feedback modifySort(ClassificationPO sort) throws RemoteException;
	
	public ClassificationPO searchSort(String name) throws RemoteException,SessionException;
	
	public List<ClassificationPO> showSort() throws RemoteException;
	
	public List<ClassificationPO> searchSortByParent(String parent) throws RemoteException;

	public void endClassificationData() throws RemoteException;
	
}


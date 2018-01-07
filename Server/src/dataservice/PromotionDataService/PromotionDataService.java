package Server.src.dataservice.PromotionDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

import Server.src.po.PromotionPO.PromotionPO;
import Server.src.feedback;

public interface PromotionDataService extends Remote {
	
	public feedback addPromotion(PromotionPO po)throws RemoteException;
	
	public feedback deletePromotion(int id)throws RemoteException;

	public feedback modifyPromotion(PromotionPO po)throws RemoteException;

	public List<PromotionPO> getPromotion(String date,String type,double amount,String level) throws ParseException,RemoteException;

	public List<PromotionPO> findPromotionByType(String type)throws RemoteException;
}


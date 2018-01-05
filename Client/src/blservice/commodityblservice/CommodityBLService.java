package blservice.commodityblservice;

import java.util.ArrayList;
import vo.CommodityVO;
import util.GoodType;
import java.rmi.RemoteException;
import util.ResultMessage;

public interface CommodityBLService {
	public ResultMessage addType(GoodType type) throws RemoteException;
	public ResultMessage deleteType(GoodType type) throws RemoteException;
	public ResultMessage updateType(GoodType type) throws RemoteException;
	public ResultMessage add(CommodityVO vo) throws RemoteException;
	public ResultMessage delete(CommodityVO vo) throws RemoteException;
	public ResultMessage update(CommodityVO vo) throws RemoteException;
	public ArrayList<CommodityVO> show(String beginTime,String endTime) throws RemoteException;
	public ArrayList<CommodityVO> showById(String id) throws RemoteException;
	public ArrayList<CommodityVO> showByName(String name) throws RemoteException;
	public ResultMessage check() throws RemoteException;
	public ResultMessage sendGift(CommodityVO vo) throws RemoteException;
	public ResultMessage analysis(long goodNum) throws RemoteException;
	public ResultMessage setWarningValue(long goodNum) throws RemoteException;
	public ResultMessage warning();
}

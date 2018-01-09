package blservice.commodityblservice;

import java.util.ArrayList;

import vo.CommodityTypeVO;
import vo.CommodityVO;
import java.rmi.RemoteException;
import util.ResultMessage;

public interface CommodityBLService {
	public ResultMessage addType(CommodityTypeVO vo) throws RemoteException;
	public ResultMessage deleteType(CommodityTypeVO vo) throws RemoteException;
	public ResultMessage updateType(CommodityTypeVO vo) throws RemoteException;
	public ResultMessage add(CommodityVO vo) throws RemoteException;
	public ResultMessage delete(CommodityVO vo) throws RemoteException;
	public ResultMessage update(CommodityVO vo) throws RemoteException;
	public ArrayList<CommodityVO> show() throws RemoteException;
	public ArrayList<CommodityVO> showByName(String name) throws RemoteException;
	public ResultMessage check() throws RemoteException;
	public ResultMessage sendGift(CommodityVO vo) throws RemoteException;
	public ResultMessage analysis(long goodNum) throws RemoteException;
	public ResultMessage setWarningValue(long goodNum) throws RemoteException;
	public ResultMessage warning();
}

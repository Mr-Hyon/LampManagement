package blservice.commodityblservice;

import java.util.ArrayList;
import vo.CommodityVO;
import util.GoodType;
import java.rmi.RemoteException;
import util.ResultMessage;

public interface CommodityBLService {
	public ResultMessage addType(GoodType type);
	public ResultMessage deleteType(GoodType type);
	public ResultMessage updateType(GoodType type);
	public ResultMessage add(CommodityVO vo);
	public ResultMessage delete(CommodityVO vo);
	public ResultMessage update(CommodityVO vo);
	public ArrayList<CommodityVO> show(String beginTime,String endTime)throws RemoteException;
	public ArrayList<CommodityVO> showById(String id)throws RemoteException;
	public ArrayList<CommodityVO> showByName(String name)throws RemoteException;
	public ResultMessage check();
	public ResultMessage sendGift(CommodityVO vo);
	public ResultMessage analysis(long goodNum);
	public ResultMessage setWarningValue(long goodNum);
	public ResultMessage warning();
}

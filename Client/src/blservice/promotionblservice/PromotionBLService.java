package blservice.promotionblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import util.ResultMessage;
import vo.StrategyVO;

public interface PromotionBLService {
	public ResultMessage add(StrategyVO vo) throws RemoteException;
	public ResultMessage delete(String StrategyNum) throws RemoteException;
	public ResultMessage update(StrategyVO vo) throws RemoteException;
	public ArrayList<StrategyVO> show() throws RemoteException;
	public ResultMessage addGiftReceipt(String rank, Double totalPrice) throws RemoteException;
}

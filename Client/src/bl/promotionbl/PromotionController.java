package bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.promotionblservice.PromotionBLService;
import vo.StrategyVO;
import util.ResultMessage;

public class PromotionController implements PromotionBLService{

	Promotion promotion = new Promotion();
	@Override
	public ResultMessage add(StrategyVO vo) throws RemoteException {
		return promotion.add(vo);
	}

	@Override
	public ResultMessage delete(String StrategyNum) throws RemoteException {
		return promotion.delete(StrategyNum);
	}

	@Override
	public ResultMessage update(StrategyVO vo) throws RemoteException {
		return promotion.update(vo);
	}

	@Override
	public ArrayList<StrategyVO> show() throws RemoteException {
		return promotion.show();
	}

	@Override
	public ResultMessage addGiftReceipt(String rank, Double totalPrice) throws RemoteException {
		return promotion.addGiftReceipt(rank, totalPrice);
	}

}

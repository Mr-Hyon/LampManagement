package blservice.promotionblservice;

import java.util.ArrayList;
import util.ResultMessage;
import vo.StrategyVO;

public interface PromotionBLService {
	public ResultMessage add(StrategyVO vo);
	public ResultMessage delete(String StrategyNum);
	public ResultMessage update(StrategyVO vo);
	public ArrayList<StrategyVO> show();
	public ResultMessage addGiftReceipt(String rank, Double totalPrice);
}

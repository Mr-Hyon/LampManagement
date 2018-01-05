package blservice.verifyblservice;

import java.util.ArrayList;
import vo.ReceiptVO;
import util.ResultMessage;

public interface VerifyBLService {
	public ArrayList<ReceiptVO> viewReceipts();
	public ResultMessage pass(ReceiptVO vo);
	public ResultMessage passAll(ArrayList List);
	public ResultMessage update(ReceiptVO vo);
	public void updateCommodity(ReceiptVO vo);
	public void informCommodity(ReceiptVO vo);
	public void updateCommodityAndClient(ReceiptVO vo);
	public void updateClient(ReceiptVO vo);
	public void informFinance(ReceiptVO vo);
}

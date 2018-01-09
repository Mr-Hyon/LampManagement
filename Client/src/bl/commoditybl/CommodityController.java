package bl.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.commodityblservice.CommodityBLService;
import util.ResultMessage;
import vo.CommodityTypeVO;
import vo.CommodityVO;

public class CommodityController implements CommodityBLService{

	Commodity commodity = new Commodity();
	@Override
	public ResultMessage addType(CommodityTypeVO vo) throws RemoteException {
		return commodity.addType(vo);
	}

	@Override
	public ResultMessage deleteType(CommodityTypeVO vo) throws RemoteException {
		return commodity.deleteType(vo);
	}

	@Override
	public ResultMessage updateType(CommodityTypeVO vo) throws RemoteException {
		return commodity.updateType(vo);
	}

	@Override
	public ResultMessage add(CommodityVO vo) throws RemoteException {
		return commodity.add(vo);
	}

	@Override
	public ResultMessage delete(CommodityVO vo) throws RemoteException {
		return commodity.delete(vo);
	}

	@Override
	public ResultMessage update(CommodityVO vo) throws RemoteException {
		return commodity.update(vo);
	}

	@Override
	public ArrayList<CommodityVO> show() throws RemoteException {
		return commodity.show();
	}

	@Override
	public ArrayList<CommodityVO> showByName(String name) throws RemoteException {
		return commodity.showByName(name);
	}

	@Override
	public ResultMessage check() throws RemoteException {
		return commodity.check();
	}

	@Override
	public ResultMessage sendGift(CommodityVO vo) throws RemoteException {
		return commodity.sendGift(vo);
	}

	@Override
	public ResultMessage analysis(long goodNum) throws RemoteException {
		return commodity.analysis(goodNum);
	}

	@Override
	public ResultMessage setWarningValue(long goodNum) throws RemoteException {
		return commodity.setWarningValue(goodNum);
	}

	@Override
	public ResultMessage warning() {
		return commodity.warning();
	}

}

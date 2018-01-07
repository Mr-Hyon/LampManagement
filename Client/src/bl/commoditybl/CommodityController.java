package bl.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.commodityblservice.CommodityBLService;
import util.GoodType;
import util.ResultMessage;
import vo.CommodityVO;

public class CommodityController implements CommodityBLService{

	Commodity commodity = new Commodity();
	@Override
	public ResultMessage addType(GoodType type) throws RemoteException {
		return commodity.addType(type);
	}

	@Override
	public ResultMessage deleteType(GoodType type) throws RemoteException {
		return commodity.deleteType(type);
	}

	@Override
	public ResultMessage updateType(GoodType type) throws RemoteException {
		return commodity.updateType(type);
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
	public ArrayList<CommodityVO> show(String beginTime, String endTime) throws RemoteException {
		return commodity.show(beginTime, endTime);
	}

	@Override
	public ArrayList<CommodityVO> showById(String id) throws RemoteException {
		return commodity.showById(id);
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

package bl.commoditybl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import blservice.commodityblservice.CommodityBLService;
import vo.CommodityBillVO;
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
	public CommodityVO showByName(String name) throws RemoteException {
		return commodity.showByName(name);
	}
	
	@Override
	public ArrayList<CommodityVO> showByType(String type) throws RemoteException {
		return commodity.showByType(type);
	}
	
	@Override
	public ArrayList<CommodityTypeVO> showSort() throws RemoteException {
		return commodity.showSort();
	}

	@Override
	public ResultMessage addCommodityBill(CommodityBillVO vo) throws RemoteException {
		return commodity.addCommodityBill(vo);
	}

	@Override
	public ArrayList<CommodityBillVO> showCommodityBill() throws RemoteException {
		return commodity.showCommodityBill();
	}
	
	@Override
	public ArrayList<CommodityBillVO> getCommodityBill(String startDate,String endDate) throws RemoteException, ParseException {
		return commodity.getCommodityBill(startDate,endDate);
	}
}

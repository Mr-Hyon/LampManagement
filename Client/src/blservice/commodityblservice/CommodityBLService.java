package blservice.commodityblservice;

import java.util.ArrayList;

import vo.CommodityBillVO;
import vo.CommodityTypeVO;
import vo.CommodityVO;
import java.rmi.RemoteException;
import java.text.ParseException;

import util.ResultMessage;

public interface CommodityBLService {
	public ResultMessage addType(CommodityTypeVO vo) throws RemoteException;
	public ResultMessage deleteType(CommodityTypeVO vo) throws RemoteException;
	public ResultMessage updateType(CommodityTypeVO vo) throws RemoteException;
	public ResultMessage add(CommodityVO vo) throws RemoteException;
	public ResultMessage delete(CommodityVO vo) throws RemoteException;
	public ResultMessage update(CommodityVO vo) throws RemoteException;
	public ArrayList<CommodityVO> show() throws RemoteException;
	public CommodityVO showByName(String name) throws RemoteException;
	public ArrayList<CommodityVO> showByType(String type) throws RemoteException;
	public ArrayList<CommodityTypeVO> showSort() throws RemoteException;
	public ResultMessage addCommodityBill(CommodityBillVO vo) throws RemoteException;
	public ArrayList<CommodityBillVO> showCommodityBill() throws RemoteException;
	public ArrayList<CommodityBillVO> getCommodityBill(String startDate,String endDate) throws RemoteException, ParseException;
}

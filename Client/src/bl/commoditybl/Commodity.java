package bl.commoditybl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import common.feedback;
import po.CommodityPO.ClassificationPO;
import po.CommodityPO.CommodityBillPO;
import po.CommodityPO.GoodsPO;
import rmi.RemoteHelper;
import util.ResultMessage;
import vo.CommodityBillVO;
import vo.CommodityTypeVO;
import vo.CommodityVO;

public class Commodity {
	//add a type of goods
	public ResultMessage addType(CommodityTypeVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getClassificationDataService().insertSort(toClassificationPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//delete a type of goods
	public ResultMessage deleteType(CommodityTypeVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getClassificationDataService().deleteSort(vo.getTypeName())==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//update a type of goods
	public ResultMessage updateType(CommodityTypeVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getClassificationDataService().modifySort(toClassificationPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//add goods
	public ResultMessage add(CommodityVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getGoodsDataService().insertGoods(toGoodsPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//delete goods
	public ResultMessage delete(CommodityVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getGoodsDataService().deleteGoods(vo.getGoodName())==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//update goods
	public ResultMessage update(CommodityVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getGoodsDataService().modifyGoods(toGoodsPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//show goods
	public ArrayList<CommodityVO> show() throws RemoteException{
		List<GoodsPO> list1 = (java.util.List<GoodsPO>) RemoteHelper.getInstance().getGoodsDataService().showGoods();
		ArrayList<CommodityVO> list2 = new ArrayList<CommodityVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toCommodityVO(list1.get(i)));
		}
		return list2;
	}
	//show goods by name
	public ArrayList<CommodityVO> showByName(String name) throws RemoteException{
		List<GoodsPO> list1 = (java.util.List<GoodsPO>) RemoteHelper.getInstance().getGoodsDataService().searchGoodsByName(name);
		ArrayList<CommodityVO> list2 = new ArrayList<CommodityVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toCommodityVO(list1.get(i)));
		}
		return list2;
	}
	//show goods by type
	public ArrayList<CommodityVO> showByType(String type) throws RemoteException {
		List<GoodsPO> list1 = (java.util.List<GoodsPO>) RemoteHelper.getInstance().getGoodsDataService().searchGoodsByClassification(type);
		ArrayList<CommodityVO> list2 = new ArrayList<CommodityVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toCommodityVO(list1.get(i)));
		}
		return list2;
	}
	//show all types
	public ArrayList<CommodityTypeVO> showSort() throws RemoteException{
		List<ClassificationPO> list1 = (java.util.List<ClassificationPO>) RemoteHelper.getInstance().getClassificationDataService().showSort();
		ArrayList<CommodityTypeVO> list2 = new ArrayList<CommodityTypeVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toCommodityTypeVO(list1.get(i)));
		}
		return list2;
	}
	//add warning bill
	public ResultMessage addCommodityBill(CommodityBillVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getCommodityDataService().addCommodityBill(toCommodityBillPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//show all warning bills
	public ArrayList<CommodityBillVO> showCommodityBill() throws RemoteException{
		List<CommodityBillPO> list1 = (java.util.List<CommodityBillPO>) RemoteHelper.getInstance().getCommodityDataService().getCommodityBill();
		ArrayList<CommodityBillVO> list2 = new ArrayList<CommodityBillVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toCommodityBillVO(list1.get(i)));
		}
		return list2;
	}
	//get warning bills by time
	public ArrayList<CommodityBillVO> getCommodityBill(String startDate,String endDate) throws RemoteException, ParseException{
		List<CommodityBillPO> list1 = (java.util.List<CommodityBillPO>) RemoteHelper.getInstance().getCommodityDataService().getCommodityList(startDate,endDate);
		ArrayList<CommodityBillVO> list2 = new ArrayList<CommodityBillVO>();
		for(int i = 0;i<list1.size();i++){
			list2.add(toCommodityBillVO(list1.get(i)));
		}
		return list2;
	}
	
	//transform CommodityTypeVO into ClassificationPO
	public static ClassificationPO toClassificationPO(CommodityTypeVO vo){
		ClassificationPO classificationPO = new ClassificationPO(vo.getTypeName(),vo.getUpperTypeName());
		return classificationPO;
	}
	//transform ClassificationPO into CommodityTypeVO
	public static CommodityTypeVO toCommodityTypeVO(ClassificationPO po){
		CommodityTypeVO commodityTypeVO = new CommodityTypeVO(po.getParentSort(),po.getId()+"",po.getName());
		return commodityTypeVO;
	}
	//transform CommodityVO into GoodsPO
	public static GoodsPO toGoodsPO(CommodityVO vo){
		GoodsPO goodsPO = new GoodsPO(vo.getType().getTypeName(),vo.getGoodName(),vo.getGoodModel(),Integer.parseInt(vo.getGoodNum()),Double.parseDouble(vo.getGoodRecentBP()),Double.parseDouble(vo.getGoodRecentRP()));
		return goodsPO;
	}
	//transform GoodsPO into CommodityVO
	public static CommodityVO toCommodityVO(GoodsPO po){
		CommodityVO commodityVO = new CommodityVO(po.getId()+"",po.getName(),po.getType(),po.getNum()+"",po.getPurPrice()+"",po.getSalePrice()+"");
		commodityVO.setType(new CommodityTypeVO(null,null,po.getClassification()));
		return commodityVO;
	}
	//transform CommodityBillVO into CommodityBillPO
	public static CommodityBillPO toCommodityBillPO(CommodityBillVO vo){
		List<GoodsPO> list= new ArrayList<GoodsPO>();
		GoodsPO goodsPO = toGoodsPO(vo.getGood());
		list.add(goodsPO);
		CommodityBillPO commodityBillPO = new CommodityBillPO(vo.getDate(),vo.getType(),list);
		return commodityBillPO;
	}
	//transform CommodityBillPO into CommodityBillVO
	public static CommodityBillVO toCommodityBillVO(CommodityBillPO po){
		CommodityBillVO commodityBillVO = new CommodityBillVO(po.getBillID(),po.getDate(),po.getType(),toCommodityVO(po.getGoodsList().get(0)));
		return commodityBillVO;
	}
}

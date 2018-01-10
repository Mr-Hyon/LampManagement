package bl.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import common.feedback;
import po.CommodityPO.ClassificationPO;
import po.CommodityPO.GoodsPO;
import rmi.RemoteHelper;
import util.ResultMessage;
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
	public ResultMessage check() throws RemoteException{
		return null;
	}
	public ResultMessage sendGift(CommodityVO vo) throws RemoteException{
		return null;
	}
	public ResultMessage analysis(long goodNum) throws RemoteException{
		return null;
	}
	public ResultMessage setWarningValue(long goodNum) throws RemoteException{
		return null;
	}
	public ResultMessage warning(){
		return null;
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
		return commodityVO;
	}
}

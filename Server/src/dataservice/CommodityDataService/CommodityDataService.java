package dataservice.CommodityDataService;

import po.CommodityPO.CommodityBillPO;

import common.feedback;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

public interface CommodityDataService extends Remote {


    public feedback addCommodityBill(CommodityBillPO po)throws RemoteException;

    public List<CommodityBillPO> getCommodityBill()throws RemoteException;

    public CommodityBillPO findCommodityBillByBillID(String billID) throws RemoteException;

    public List<CommodityBillPO> getCommodityList(String startDate,String endDate) throws ParseException,RemoteException;

    public feedback reverseCommodityBill(int id)throws RemoteException;
}
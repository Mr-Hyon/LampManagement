package dataservice.CommodityDataService;

import po.CommodityPO.CommodityBillPO;

import common.feedback;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

public interface CommodityDataService extends Remote {


    public feedback addInventoryBill(CommodityBillPO po)throws RemoteException;

    public List<CommodityBillPO> getInventoryBill()throws RemoteException;

    public CommodityBillPO findInventoryBillByBillID(String billID) throws RemoteException;

    public List<CommodityBillPO> getInventoryList(String startDate,String endDate) throws ParseException,RemoteException;

    public feedback redDashInventoryBill(int id)throws RemoteException;
}
package data.TableData;

import dataservice.SalesDataService.SalesBillDataService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dataservice.TableDataService.SalesConditionDataService;
import org.hibernate.criterion.Restrictions;
import po.TablePO.SalesConditionTablePO;
import po.SalesRecordInfo;
import po.ClientPO.ClientPO;
import po.GoodInfo;
import po.SalesPO.SalesBillPO;
import po.UserPO.UserPO;
import common.feedback;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

public class SalesConditionData implements SalesConditionDataService{

	public SalesConditionData() {
		
	}

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private SalesBillDataService saleBillDataService;
	
	@Override
	public feedback addSalesCondition(SalesConditionTablePO po) throws RemoteException {
		
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		session.save(po);

		transaction.commit();
		session.close();
		factory.close();
		return feedback.Success;
	}

	@Override
	public List<SalesRecordInfo> getSalesBill(String startDate, String endDate, String commodityName, String client, String salesman, String inventory) throws ParseException, RemoteException {
		List<SalesBillPO> saleBillPOList=saleBillDataService.getSaleBillPO(startDate,endDate,client,salesman,inventory);
		List<SalesRecordInfo> salesRecordInfoList=null;
		for(int i=0;i<saleBillPOList.size();i++){
			SalesRecordInfo info=new SalesRecordInfo();
			info.setDate(saleBillPOList.get(i).getDate());
			List<GoodInfo> goodsList=saleBillPOList.get(i).getGoodsList();
			for(int j=0;j<goodsList.size();j++){
				if(goodsList.get(i).getName().equals(commodityName)||commodityName==null) {
					info.setName(goodsList.get(i).getName());
					info.setAmount(goodsList.get(i).getAmount());
					info.setPrice(goodsList.get(i).getPrice());
					info.setTotalPrice(goodsList.get(i).getTotalPrice());
					info.setType(goodsList.get(i).getType());
					salesRecordInfoList.add(info);
				}
			}
		}
		return salesRecordInfoList;
	}

	@Override
	public SalesConditionTablePO searchSalesConditionBillByID(int id)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		SalesConditionTablePO po=(SalesConditionTablePO)session.createCriteria(SalesConditionTablePO.class).add(Restrictions.eq("id",id)).list().get(0);

		transaction.commit();
		session.close();
		factory.close();
		return po;
	}

	@Override
	public List<SalesConditionTablePO> showSalesConditionBill() throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesConditionTablePO> po=session.createCriteria(SalesConditionTablePO.class).list();

		transaction.commit();
		session.close();
		factory.close();
		return po;
	}

}


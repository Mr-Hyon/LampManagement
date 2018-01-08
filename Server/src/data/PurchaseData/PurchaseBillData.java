package data.PurchaseData;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import data.IDData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import dataservice.PurchaseDataService.PurchaseBillDataService;
import po.PaymentPO.PaymentPO;
import po.ClientPO.ClientPO;
import po.GoodInfo;
import po.PurchasePO.PurchaseBillPO;
import po.UserPO.UserPO;
import common.billstate;
import common.BillType;
import common.feedback;

public class PurchaseBillData implements PurchaseBillDataService{


	public PurchaseBillData() {
		
	}

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public feedback addPurchaseBill(PurchaseBillPO po) throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		po.setDate(sdf.format(new Date()));
		IDData idData=new IDData();
		po.setBillID(idData.getID(po.getType()));
		for(int i=0;i<po.getGoodsList().size();i++){
			session.save(po.getGoodsList().get(i));
		}
		session.save(po);

		transaction.commit();
		session.close();
		factory.close();
		return feedback.Success;
	}

	@Override
	public PurchaseBillPO findPurchaseBillByBillID(String billID) throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PurchaseBillPO> list=session.createCriteria(PurchaseBillPO.class).add(Restrictions.eq("billID", billID)).list();
		if(list.size()==0){
			transaction.commit();
			session.close();
			factory.close();
			return null;
		}

		transaction.commit();
		session.close();
		factory.close();
		return list.get(0);
	}

	@Override
	public List<PurchaseBillPO> findPurchaseBillByType(String type) throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PurchaseBillPO> list=session.createCriteria(PurchaseBillPO.class).add(Restrictions.eq("type", type)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<PurchaseBillPO> findPurchaseBillByClient(String po)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PurchaseBillPO> list=session.createCriteria(PurchaseBillPO.class).add(Restrictions.eq("supplier", po)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<PurchaseBillPO> findPurchaseBillByInventory(String inventory)throws RemoteException {

		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PurchaseBillPO> list=session.createCriteria(PurchaseBillPO.class).add(Restrictions.eq("inventory", inventory)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<PurchaseBillPO> getPurchaseBillPO(String startDate, String endDate, String client, String salesman, String inventory) throws ParseException,RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PurchaseBillPO> list=session.createCriteria(PurchaseBillPO.class).list();
		List<PurchaseBillPO> result = new ArrayList<PurchaseBillPO>();
		for(int i=0;i<list.size();i++){
			PurchaseBillPO po=list.get(i);
			if(po.getSupplier().equals(client)||client==null) {
				if(po.getSalesman().equals(salesman)||salesman==null) {
					if(po.getInventory().equals(inventory)||inventory==null) {
						Calendar start = Calendar.getInstance();
						Calendar end = Calendar.getInstance();
						Calendar mid = Calendar.getInstance();

						start.setTime(sdf.parse(startDate));
						end.setTime(sdf.parse(endDate));
						mid.setTime(sdf.parse(po.getDate()));

						if (mid.after(start) && mid.before(end)) {
							result.add(po);
						} else {
							continue;
						}
					}
				}
			}else{
				continue;
			}
		}

		transaction.commit();
		session.close();
		factory.close();
		return result;
	}
	@Override
	public List<PurchaseBillPO> getDraftPurchaseBill() throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PurchaseBillPO> list=session.createCriteria(PurchaseBillPO.class).add(Restrictions.eq("state", billstate.SUBMITTED)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public feedback checkPurchaseBill(PurchaseBillPO po)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PurchaseBillPO> list=session.createCriteria(PurchaseBillPO.class).add(Restrictions.eq("billID",po.getBillID())).list();
		if(list.size()>0) {
			PurchaseBillPO bill = list.get(0);
			bill.setState(po.getState());
			session.update(bill);

			transaction.commit();
			session.close();
			factory.close();
			return feedback.Success;
		}else {
			transaction.commit();
			session.close();
			factory.close();
			return feedback.Fail;
		}
	}

	@Override
	public feedback reversePurchaseBill(String billID)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PurchaseBillPO> list= session.createCriteria(PurchaseBillPO.class).add(Restrictions.eq("billID",billID)).list();
		if(list.size()>0) {
			PurchaseBillPO po = list.get(0);
			PurchaseBillPO red = null;
			red.setDate(po.getDate());
			//billID
			IDData idData=new IDData();
			if(po.getType().equals(BillType.PURCHASE)){
				red.setBillID(idData.getID(BillType.PURCHASERET));
			}else{
				red.setBillID(idData.getID(BillType.PURCHASE));
			}

			red.setInventory(po.getInventory());
			red.setGoodsList(po.getGoodsList());
			red.setOperator(po.getOperator());
			red.setSalesman(po.getSalesman());
			red.setRemark(po.getRemark());
			red.setState(billstate.PASSED);
			red.setSupplier(po.getSupplier());
			red.setType(po.getType());
			red.setTotalAmount(-po.getTotalAmount());
			session.save(red);

			transaction.commit();
			session.close();
			factory.close();
			return feedback.Success;
		}else {
			transaction.commit();
			session.close();
			factory.close();
			return feedback.Fail;
		}
	}

	@Override
	public feedback modifyPurchaseBill(PurchaseBillPO po) {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PurchaseBillPO> list= session.createCriteria(PurchaseBillPO.class).add(Restrictions.eq("billID",po.getBillID())).list();
		if(list.size()>0) {
			PurchaseBillPO red = list.get(0);
			red.setDate(po.getDate());
			red.setBillID(po.getBillID());
			red.setInventory(po.getInventory());
			red.setGoodsList(po.getGoodsList());
			red.setOperator(po.getOperator());
			red.setSalesman(po.getSalesman());
			red.setRemark(po.getRemark());
			red.setState(po.getState());
			red.setSupplier(po.getSupplier());
			red.setType(po.getType());
			red.setTotalAmount(po.getTotalAmount());
			session.update(red);

			transaction.commit();
			session.close();
			factory.close();
			return feedback.Success;
		}else {
			transaction.commit();
			session.close();
			factory.close();
			return feedback.Fail;
		}
	}
}

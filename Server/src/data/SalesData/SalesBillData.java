package data.SalesData;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import data.IDData;
import data.ClientData.ClientData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import dataservice.SalesDataService.SalesBillDataService;
import po.ClientPO.ClientPO;
import po.SalesPO.SalesBillPO;
import po.UserPO.UserPO;
import common.billstate;
import common.BillType;
import common.feedback;

import javax.persistence.Id;

public class SalesBillData implements SalesBillDataService{


	public SalesBillData() {
		
	}

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public feedback addSaleBill(SalesBillPO po)throws RemoteException {
		
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
	public List<SalesBillPO> findSaleBillByType(String type)throws RemoteException {
		
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesBillPO> list=session.createCriteria(SalesBillPO.class).add(Restrictions.eq("type", type)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<SalesBillPO> findSaleBillByClient(String po)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesBillPO> list=session.createCriteria(SalesBillPO.class).add(Restrictions.eq("seller", po)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<SalesBillPO> findSaleBillByInventory(String inventory)throws RemoteException {
		
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesBillPO> list=session.createCriteria(SalesBillPO.class).add(Restrictions.eq("inventory", inventory)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public SalesBillPO findSaleBillByID(String id) throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesBillPO> list=session.createCriteria(SalesBillPO.class).add(Restrictions.eq("billID", id)).list();
		if(list.size()>0){
			transaction.commit();
			session.close();
			factory.close();
			return list.get(0);
		}else{
			transaction.commit();
			session.close();
			factory.close();
			return null;
		}

	}

	@Override
	public List<SalesBillPO> getSaleBillPO(String startDate, String endDate, String client, String salesman, String inventory) throws ParseException,RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesBillPO> list=session.createCriteria(SalesBillPO.class).list();
		List<SalesBillPO> result = new ArrayList<SalesBillPO>();
		for(int i=0;i<list.size();i++){
			SalesBillPO po=list.get(i);
			if(po.getSeller().equals(client)||client==null) {
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
	public List<SalesBillPO> getDraftSaleBill() throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesBillPO> list=session.createCriteria(SalesBillPO.class).add(Restrictions.eq("state", billstate.SUBMITTED)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<SalesBillPO> getPassedSaleBill()throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesBillPO> list=session.createCriteria(SalesBillPO.class).add(Restrictions.eq("state", billstate.PASSED)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public feedback checkSaleBill(SalesBillPO po) throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesBillPO> list=session.createCriteria(SalesBillPO.class).add(Restrictions.eq("billID",po.getBillID())).list();
		if(list.size()>0) {
			SalesBillPO bill = list.get(0);
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
	public feedback reverseSalesBill(String billID) throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesBillPO> list=session.createCriteria(SalesBillPO.class).add(Restrictions.eq("billID",billID)).list();
		if(list.size()>0) {
			SalesBillPO bill = list.get(0);
			SalesBillPO po = null;
			//billID
			IDData idData=new IDData();
			if(bill.getType().equals(BillType.SALE)){
				po.setBillID(idData.getID(BillType.SALERET));
			}else{
				po.setBillID(idData.getID(BillType.SALE));
			}

			po.setDate(bill.getDate());
			po.setGoodsList(bill.getGoodsList());
			po.setInventory(bill.getInventory());
			po.setOperator(bill.getOperator());
			po.setSalesman(bill.getSalesman());
			po.setRemark(bill.getRemark());
			po.setSeller(bill.getSeller());
			po.setType(bill.getType());
			po.setOriginPrice(-bill.getOriginPrice());
			po.setRebate(-bill.getRebate());
			po.setVoucher(-bill.getVoucher());
			po.setFinalPrice(-bill.getFinalPrice());
			po.setState(billstate.PASSED);
			session.save(po);

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
	public feedback modifySaleBill(SalesBillPO po) {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<SalesBillPO> list=session.createCriteria(SalesBillPO.class).add(Restrictions.eq("billID",po.getBillID())).list();
		if(list.size()>0) {
			SalesBillPO bill = list.get(0);
			bill.setBillID(po.getBillID());
			bill.setDate(po.getDate());
			bill.setGoodsList(po.getGoodsList());
			for(int i=0;i<po.getGoodsList().size();i++){
				session.update(po.getGoodsList().get(i));
			}
			bill.setInventory(po.getInventory());
			bill.setOperator(po.getOperator());
			bill.setSalesman(po.getSalesman());
			bill.setRemark(po.getRemark());
			bill.setSeller(po.getSeller());
			bill.setType(po.getType());
			bill.setOriginPrice(po.getOriginPrice());
			bill.setRebate(po.getRebate());
			bill.setVoucher(po.getVoucher());
			bill.setFinalPrice(po.getFinalPrice());
			bill.setState(billstate.PASSED);
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
}


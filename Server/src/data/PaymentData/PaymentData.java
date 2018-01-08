package data.PaymentData;

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

import dataservice.PaymentDataService.PaymentDataService;
import po.PaymentPO.PaymentPO;
import po.ClientPO.ClientPO;
import po.UserPO.UserPO;
import common.billstate;
import common.BillType;
import common.feedback;

public class PaymentData implements PaymentDataService{


	public PaymentData() {
		
	}

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public feedback addPaymentBill(PaymentPO po) throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		po.setDate(sdf.format(new Date()));
		IDData idData=new IDData();
		po.setBillID(idData.getID(po.getType()));
		session.save(po);

		transaction.commit();
		session.close();
		factory.close();
		return feedback.Success;
	}

	@Override
	public List<PaymentPO> findPaymentBillByType(String type)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PaymentPO> list=session.createCriteria(PaymentPO.class).add(Restrictions.eq("type", type)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<PaymentPO> findPaymentBillByClient(String po) throws RemoteException{
		// TODO �Զ����ɵķ������
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PaymentPO> list=session.createCriteria(PaymentPO.class).add(Restrictions.eq("client", po)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public PaymentPO findPaymentBillByBillID(String billID) throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PaymentPO> list=session.createCriteria(PaymentPO.class).add(Restrictions.eq("billID", billID)).list();
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
	public List<PaymentPO> getPaymentPO(String startDate, String endDate, String client) throws ParseException,RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PaymentPO> list=session.createCriteria(PaymentPO.class).list();
		List<PaymentPO> result = new ArrayList<PaymentPO>();
		for(int i=0;i<list.size();i++){
			PaymentPO po=list.get(i);
			if(po.getClient().equals(client)||client==null) {
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
	public List<PaymentPO> getDraftPaymentBill()throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PaymentPO> list=session.createCriteria(PaymentPO.class).add(Restrictions.eq("state", billstate.SUBMITTED)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public feedback checkPaymentBill(PaymentPO po)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PaymentPO> list=session.createCriteria(PaymentPO.class).add(Restrictions.eq("billID",po.getBillID())).list();
		if(list.size()>0) {
			PaymentPO bill=list.get(0);
			bill.setState(po.getState());
			session.update(bill);

			transaction.commit();
			session.close();
			factory.close();
			return feedback.Success;
		}else{
			transaction.commit();
			session.close();
			factory.close();
			return feedback.Fail;
		}
	}

	@Override
	public feedback reversePaymentBill(String billID)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<PaymentPO> list=session.createCriteria(PaymentPO.class).add(Restrictions.eq("billID",billID)).list();
		if(list.size()>0) {
			PaymentPO bill = list.get(0);
			PaymentPO po = new PaymentPO();
			//billID
			IDData idData=new IDData();
			if(bill.getType().equals(BillType.PAY)){
				po.setBillID(idData.getID(BillType.RECEIVE));
			}else{
				po.setBillID(idData.getID(BillType.PAY));
			}

			po.setTransferList(bill.getTransferList());
			po.setClient(bill.getClient());
			po.setDate(bill.getDate());
			po.setOperator(bill.getOperator());
			po.setType(bill.getType());
			po.setTotalAmount(-bill.getTotalAmount());
			po.setState(billstate.PASSED);
			session.save(po);

			transaction.commit();
			session.close();
			factory.close();
			return feedback.Success;
		}else{
			transaction.commit();
			session.close();
			factory.close();
			return feedback.Fail;
		}
	}

	@Override
	public feedback modifyPaymentBill(PaymentPO po) throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		List<PaymentPO> list=session.createCriteria(PaymentPO.class).add(Restrictions.eq("billID",po.getBillID())).list();

		if(list.size()>0) {
			PaymentPO bill = list.get(0);
			bill.setBillID(po.getBillID());
			bill.setTransferList(po.getTransferList());
			bill.setClient(po.getClient());
			bill.setDate(po.getDate());
			bill.setOperator(po.getOperator());
			bill.setType(po.getType());
			bill.setTotalAmount(po.getTotalAmount());
			bill.setState(po.getState());
			session.update(bill);
			transaction.commit();
			session.close();
			factory.close();
			return feedback.Success;
		}else{
			transaction.commit();
			session.close();
			factory.close();
			return feedback.Fail;
		}
	}
}


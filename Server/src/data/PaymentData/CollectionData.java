package data.PaymentData;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dataservice.PaymentDataService.CollectionDataService;
import org.hibernate.criterion.Restrictions;
import po.PaymentPO.CollectionPO;
import common.feedback;
import common.billstate;

public class CollectionData implements CollectionDataService{

	public CollectionData() {

	}

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public feedback addCash(CollectionPO po)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		po.setDate(sdf.format(new Date()));
		session.save(po);

		transaction.commit();
		session.close();
		factory.close();
		return feedback.Success;
	}

	@Override
	public List<CollectionPO> showCollectionBill() throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<CollectionPO> list=session.createCriteria(CollectionPO.class).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<CollectionPO> getCollectionBill(String startDate, String endDate) throws ParseException,RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<CollectionPO> list=session.createCriteria(CollectionPO.class).list();
		List<CollectionPO> result = null;
		for(int i=0;i<list.size();i++){
			CollectionPO po=list.get(i);
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

		transaction.commit();
		session.close();
		factory.close();
		return result;
	}

	@Override
	public List<CollectionPO> getDraftCollectionBill() throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<CollectionPO> list=session.createCriteria(CollectionPO.class).add(Restrictions.eq("state", billstate.SUBMITTED)).list();

		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public feedback checkCollection(CollectionPO po)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<CollectionPO> list=session.createCriteria(CollectionPO.class).add(Restrictions.eq("billID",po.getBillID())).list();
		if(list.size()>0) {
			CollectionPO bill = list.get(0);
			bill.setState(po.getState());
			session.update(bill);

			transaction.commit();
			session.close();
			factory.close();
			return feedback.Success;
		}else {
			return feedback.Fail;
		}
	}

	@Override
	public feedback reverseCollectionBill(String billID)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<CollectionPO> list=session.createCriteria(CollectionPO.class).add(Restrictions.eq("billID",billID)).list();
		if(list.size()>0) {
			CollectionPO bill = list.get(0);
			CollectionPO po = new CollectionPO();
			po.setDate(bill.getDate());
			po.setBank(bill.getBank());
			po.setClausesList(bill.getClausesList());
			po.setOperator(bill.getOperator());
			po.setTotalAmount(-bill.getTotalAmount());
			po.setState(billstate.PASSED);
			session.save(po);

			transaction.commit();
			session.close();
			factory.close();
			return feedback.Success;
		}else {
			return feedback.Fail;
		}
	}

}


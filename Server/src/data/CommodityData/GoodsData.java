package data.CommodityData;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import dataservice.CommodityDataService.GoodsDataService;
import po.CommodityPO.ClassificationPO;
import po.CommodityPO.GoodsPO;
import common.feedback;

public class GoodsData implements GoodsDataService{

	public GoodsData() {

	}

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	@Override
	public List<GoodsPO> showGoods() throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<GoodsPO> list=session.createQuery("from GoodsPO ").list();
		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public feedback insertGoods(GoodsPO sort)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		session.save(sort);
		transaction.commit();
		session.close();
		factory.close();
		return feedback.Success;
	}

	@Override
	public feedback deleteGoods(String name)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<GoodsPO> list= session.createCriteria(GoodsPO.class).add(Restrictions.eq("name",name)).list();
		if(list.size()>0) {
			GoodsPO goodsPO = list.get(0);
			session.delete(goodsPO);
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
	public feedback modifyGoods(GoodsPO sort)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<GoodsPO> list= session.createCriteria(GoodsPO.class).add(Restrictions.eq("name",sort.getName())).list();
		if(list.size()>0) {
			GoodsPO goodsPO = list.get(0);
			goodsPO.setAlarmNum(sort.getAlarmNum());
			goodsPO.setNum(sort.getNum());
			goodsPO.setClassification(sort.getClassification());
			goodsPO.setDefaultPur(sort.getDefaultPur());
			goodsPO.setDefaultSale(sort.getDefaultSale());
			goodsPO.setPurPrice(sort.getPurPrice());
			goodsPO.setSalePrice(sort.getSalePrice());
			session.update(goodsPO);
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
	public GoodsPO searchGoodsByName(String name)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<GoodsPO> list= session.createCriteria(GoodsPO.class).add(Restrictions.eq("name",name)).list();
		if(list.size()>0) {
			GoodsPO goodsPO = list.get(0);
			transaction.commit();
			session.close();
			factory.close();
			return goodsPO;
		}else {
			transaction.commit();
			session.close();
			factory.close();
			return null;
		}
	}

	@Override
	public List<GoodsPO> searchGoodsByType(String type)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<GoodsPO> goodsList = session.createCriteria(GoodsPO.class).add(Restrictions.eq("type", type)).list();
		transaction.commit();
		session.close();
		factory.close();
		return goodsList;
	}

	@Override
	public List<GoodsPO> searchGoodsByClassification(String sort)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		List<GoodsPO> goodsList = session.createCriteria(GoodsPO.class).add(Restrictions.eq("classification", sort)).list();
		transaction.commit();
		session.close();
		factory.close();
		return goodsList;
	}



	@Override
	public void endGoodDate() {

	}

}


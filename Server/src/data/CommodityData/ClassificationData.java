package data.CommodityData;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import dataservice.CommodityDataService.ClassificationDataService;
import po.CommodityPO.ClassificationPO;
import common.feedback;

public class ClassificationData implements ClassificationDataService{

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	public ClassificationData() {
		
	}

	@Override
	public feedback insertSort(ClassificationPO sort) throws RemoteException {
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
	public feedback deleteSort(String name) throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClassificationPO> classificationPOList =  session.createCriteria(ClassificationPO.class).add(Restrictions.eq("name",name)).list();
		if(classificationPOList.size()>0) {
			session.delete(classificationPOList.get(0));
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
	public feedback modifySort(ClassificationPO sort)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClassificationPO> classificationPOList =  session.createCriteria(ClassificationPO.class).add(Restrictions.eq("name",sort.getName())).list();
		if(classificationPOList.size()>0) {
			ClassificationPO classificationPO=classificationPOList.get(0);
			classificationPO.setParentSort(sort.getParentSort());
			session.update(classificationPO);
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
	public ClassificationPO searchSort(String name)throws RemoteException,SessionException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClassificationPO> list=  session.createCriteria(ClassificationPO.class).add(Restrictions.eq("name",name)).list();
		if(list.size()>0) {
			ClassificationPO classificationPO=list.get(0);
			transaction.commit();
			session.close();
			factory.close();
			return classificationPO;
		}else{
			transaction.commit();
			session.close();
			factory.close();
			return null;
		}
	}

	@Override
	public List<ClassificationPO> showSort()throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClassificationPO> list=session.createCriteria(ClassificationPO.class).list();
		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<ClassificationPO> searchSortByParent(String parent)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClassificationPO> list=session.createCriteria(ClassificationPO.class).add(Restrictions.eq("parentSort",parent)).list();
		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	public void endClassificationData(){

	}
}


package data.AccountData;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import common.feedback;
import dataservice.AccountDataService.AccountDataService;
import po.AccountPO.AccountPO;
public class AccountData implements AccountDataService{
	public AccountData() {
		
	}
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	@Override
	public feedback addAccount(AccountPO po) throws RemoteException{

		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		po.setIsValid("Yes");
		session.save(po);
		transaction.commit();
		session.close();
		factory.close();
		return feedback.Success;
	}
	@Override
	public feedback deleteAccount(String name)throws RemoteException {
		Configuration configuration = new Configuration().configure();

		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		List<AccountPO> list=session.createCriteria(AccountPO.class).add(Restrictions.eq("name", name)).list();
		if(list.size()>0) {
			AccountPO account = list.get(0);
			account.setIsValid("No");
			session.update(account);
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
	public feedback updateAccount(AccountPO po)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		List<AccountPO> list=session.createCriteria(AccountPO.class).add(Restrictions.eq("name", po.getName())).list();
		if(list.size()>0) {
			AccountPO account = list.get(0);
			account.setBalance(po.getBalance());
			account.setBank(po.getBank());
			account.setIsValid("Yes");
			session.update(account);
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
	public AccountPO findAccountByKeyWord(String word)throws RemoteException {
		return null;
	}
	
	@Override
	public List<AccountPO> findAccountByBank(String bank) throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		List<AccountPO> list=session.createCriteria(AccountPO.class).add(Restrictions.eq("bank", bank)).list();
		Iterator<AccountPO> iterator=list.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getIsValid().equals("No")){
				iterator.remove();
			}
		}
		
		transaction.commit();
		session.close();
		factory.close();
		return list;
	}

	@Override
	public List<AccountPO> showAccount() throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		List<AccountPO> list=session.createCriteria(AccountPO.class).list();
		Iterator<AccountPO> iterator=list.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getIsValid().equals("No")){
				iterator.remove();
			}
		}
		transaction.commit();
		session.close();
		factory.close();
		return list;
	}
	
	@Override

	public AccountPO findAccountByName(String name) throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		List<AccountPO> list=session.createCriteria(AccountPO.class).add(Restrictions.eq("name", name)).list();
		if(list.size()>0) {
			AccountPO po = list.get(0);
			if (po.getIsValid().equals("No")) {
				return null;
			}
			transaction.commit();
			session.close();
			factory.close();
			return po;
		}else{
			transaction.commit();
			session.close();
			factory.close();
			return null;
		}
	}
}


package data.ClientData;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import dataservice.ClientDataService.ClientDataService;
import po.ClientPO.ClientPO;
import common.feedback;

public class ClientData implements ClientDataService{

	public ClientData() {
		
	}

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	@Override
	public feedback addClient(ClientPO po) throws RemoteException {
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
	public feedback deleteClient(String name) throws RemoteException{	
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClientPO> list=session.createCriteria(ClientPO.class).add(Restrictions.eq("name", name)).list();
		if(list.size()>0) {
			ClientPO client = list.get(0);
			client.setIsValid("No");
			session.update(client);

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
	public feedback updateClient(ClientPO po) throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClientPO> list=session.createCriteria(ClientPO.class).add(Restrictions.eq("name", po.getName())).list();
		if(list.size()>0) {
			ClientPO client = list.get(0);
			client.setAddress(po.getAddress());
			client.setAmount(po.getAmount());
			client.setEmail(po.getEmail());
			client.setLevel(po.getLevel());
			client.setName(po.getName());
			client.setOperator(po.getOperator());
			client.setPay(po.getPay());
			client.setPostcode(po.getPostcode());
			client.setRecieve(po.getRecieve());
			client.setTel(po.getTel());
			client.setType(po.getType());
			client.setPoint(po.getPoint());
			client.setIsValid("Yes");
			session.update(client);

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
	public ClientPO findClientById(int id) throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClientPO> list=session.createCriteria(ClientPO.class).add(Restrictions.eq("id", id)).list();
		if(list.size()>0) {
			ClientPO client = list.get(0);
			if (client.getIsValid().equals("No")) {
				return null;
			}

			transaction.commit();
			session.close();
			factory.close();
			return client;
		}else {
			transaction.commit();
			session.close();
			factory.close();
			return null;
		}
	}

	@Override
	public ClientPO findClientByKeyWord(String word)throws RemoteException {
		return null;
	}

	@Override
	public List<ClientPO> showClient() throws RemoteException{
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClientPO> list=session.createCriteria(ClientPO.class).list();
		Iterator<ClientPO> iterator=list.iterator();
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
	public List<ClientPO> findClientByType(String type)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClientPO> list=session.createCriteria(ClientPO.class).add(Restrictions.eq("type", type)).list();
		Iterator<ClientPO> iterator=list.iterator();
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
	public ClientPO findClientByName(String name)throws RemoteException {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		List<ClientPO> list=session.createCriteria(ClientPO.class).add(Restrictions.eq("name", name)).list();
		if(list.size()>0) {
			ClientPO client = list.get(0);
			if (client.getIsValid().equals("No")) {
				return null;
			}
			transaction.commit();
			session.close();
			factory.close();
			return client;
		}else {
			transaction.commit();
			session.close();
			factory.close();
			return null;
		}
	}

}

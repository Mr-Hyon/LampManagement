package data.UserData;

import org.hibernate.*;

import dataservice.UserDataService.UserDataService;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import po.UserPO.UserPO;
import common.feedback;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class UserData implements UserDataService{

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
	
	@Override
	public UserPO findUser(String username)throws RemoteException {
		
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		UserPO userPO=new UserPO();
		ArrayList<UserPO> list= (ArrayList<UserPO>)session.createCriteria(UserPO.class).add(Restrictions.eq("username",username)).list();
		if(list.size()==0)return null;
		else {
			transaction.commit();
			session.close();
			factory.close();
			userPO=list.get(0);
			return userPO;
		}
	}

	@Override
	public feedback modifyPassword(UserPO user) throws RemoteException{
		
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		 List<UserPO> list=  session.createCriteria(UserPO.class).add(Restrictions.eq("username",user.getUsername())).list();
		if(list.size()>0) {
			UserPO userPO = list.get(0);
			userPO.setPassword(user.getPassword());
			session.update(userPO);

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
	public feedback addUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}


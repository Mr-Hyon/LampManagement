package data.CommodityData;


import dataservice.CommodityDataService.CommodityDataService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import po.CommodityPO.GoodsPO;
import po.CommodityPO.CommodityBillPO;

import common.feedback;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CommodityData implements CommodityDataService {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public feedback addCommodityBill(CommodityBillPO po)throws RemoteException {
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
    public List<CommodityBillPO> getCommodityBill()throws RemoteException {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        List<CommodityBillPO> list=session.createCriteria(CommodityBillPO.class).list();

        transaction.commit();
        session.close();
        factory.close();
        return list;
    }

    @Override
    public CommodityBillPO findCommodityBillByBillID(String billID) throws RemoteException {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        List<CommodityBillPO> list=session.createCriteria(CommodityBillPO.class).add(Restrictions.eq("billID",billID)).list();
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
    public List<CommodityBillPO> getCommodityList(String startDate, String endDate) throws ParseException,RemoteException {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        List<CommodityBillPO> list=session.createCriteria(CommodityBillPO.class).list();
        List<CommodityBillPO> result=new ArrayList<CommodityBillPO>();
        for(int i=0;i<list.size();i++){
        	CommodityBillPO po=list.get(i);
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
    public feedback reverseCommodityBill(int id)throws RemoteException {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        List<CommodityBillPO> list=session.createCriteria(CommodityBillPO.class).add(Restrictions.eq("id",id)).list();
        if(list.size()>0) {
        	CommodityBillPO po = list.get(0);
        	CommodityBillPO red = new CommodityBillPO();
            red.setDate(po.getDate());
            red.setType(po.getType());
            red.setBillID(po.getBillID());
            List<GoodsPO> goodsPOList = null;
            for (int i = 0; i < po.getGoodsList().size(); i++) {
                GoodsPO goodsPO = po.getGoodsList().get(i);
                goodsPO.setNum(-goodsPO.getNum());
                goodsPOList.add(goodsPO);
            }
            red.setGoodsList(goodsPOList);

            session.save(red);

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


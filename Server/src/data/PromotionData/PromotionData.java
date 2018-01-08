package data.PromotionData;

import dataservice.PromotionDataService.PromotionDataService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import po.PromotionPO.PromotionPO;
import common.feedback;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PromotionData implements PromotionDataService {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public feedback addPromotion(PromotionPO po)throws RemoteException {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        session.save(po);

        transaction.commit();
        session.close();
        factory.close();
        return feedback.Success;    }

    @Override
    public List<PromotionPO> getPromotion(String date,String type,double amount,String level) throws ParseException,RemoteException {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        List<PromotionPO> list=session.createCriteria(PromotionPO.class).list();
        List<PromotionPO> result = new ArrayList<PromotionPO>();
        for(int i=0;i<list.size();i++){
            PromotionPO po=list.get(i);
            if(po.getType().equals(type)&&po.getLevel().equals(level)&&amount>=po.getOriginPrice()) {
                Calendar start = Calendar.getInstance();
                Calendar end = Calendar.getInstance();
                Calendar mid = Calendar.getInstance();

                start.setTime(sdf.parse(po.getStartDate()));
                end.setTime(sdf.parse(po.getEndDate()));
                mid.setTime(sdf.parse(date));

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
    public feedback deletePromotion(int id)throws RemoteException {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

         List<PromotionPO> list= session.createCriteria(PromotionPO.class).add(Restrictions.eq("id",id)).list();
        if(list.size()>0) {
            PromotionPO po = list.get(0);
            session.delete(po);

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
    public feedback modifyPromotion(PromotionPO po)throws RemoteException {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        List<PromotionPO> list=  session.createCriteria(PromotionPO.class).add(Restrictions.eq("id",po.getId())).list();
        if(list.size()>0) {
            PromotionPO promotion = list.get(0);
            promotion.setEndDate(po.getEndDate());
            promotion.setGoodsList(po.getGoodsList());
            promotion.setLevel(po.getLevel());
            promotion.setOriginPrice(po.getOriginPrice());
            promotion.setPriceAmount(po.getPriceAmount());
            promotion.setStartDate(po.getStartDate());
            session.update(promotion);

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
    public List<PromotionPO> findPromotionByType(String type) throws RemoteException{
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        List<PromotionPO> list=session.createCriteria(PromotionPO.class).add(Restrictions.eq("type",type)).list();

        transaction.commit();
        session.close();
        factory.close();
        return list;
    }
}


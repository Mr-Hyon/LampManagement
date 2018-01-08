package data;

import dataservice.IDService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import po.DatePO;
import po.UserPO.UserPO;
import common.BillNo;
import common.BillType;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IDData implements IDService {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    private static int[] IDPool={1,1,1,1,1,1,1,1,1,1,1};
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    private static DecimalFormat df=new DecimalFormat("00000");
    private static String previousdate="";
    private String determineHead(String type,String date){
        String out="";
        switch (type) {
            case BillType.PURCHASE:
                //System.out.print(IDPool[BillNo.PURCHASE]);
                out= "JHD-"+date+"-";
                break;
            case BillType.PURCHASERET:
                out= "JHTHD-"+date+"-";
                //IDPool[BillNo.]
                break;
            case BillType.SALE:
                out= "XSD-"+date+"-";
                break;
            case BillType.SALERET:
                out= "XSTHD-"+date+"-";
                break;
            case BillType.RECEIVE:
                out= "SKD-"+date+"-";
                break;
            case BillType.PAY:
                out="FKD-"+date+"-";
                //System.out.print(IDPool[BillNo.PAY]);
                break;
            case BillType.CASH:
                out="XJFYD-"+date+"-";
                break;
            case BillType.PRESENT:
                out="KCZSD-"+date+"-";
                break;
            case BillType.OVERFLOW:
                out="KCBYD-"+date+"-";
                break;
            case BillType.SHORTAGE:
                out="KCBSD-"+date+"-";
                break;
        }
        return out;
    }

   
    @Override
    public String getID(String type) {
        String out="";
        int no=0;
        String billtype="";
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        String date=sdf.format(new Date());

        if(session.createCriteria(DatePO.class).list().size()==0){
            for(int i=0;i<11;i++){
                IDPool[i]=1;
            }
            DatePO datepo=new DatePO();
            datepo.setDate(date);
            datepo.setPool(this.IDPool);
            session.save(datepo);
            transaction.commit();
            session.close();
            factory.close();
        }else{
            DatePO datepo=(DatePO)session.createCriteria(DatePO.class).list().get(0);;
            previousdate=datepo.getDate();
            if(previousdate.equals(date)){
                switch (type){
                    case BillType.SALE:no=(datepo.getPool()[BillNo.SALE]++);break;
                    case BillType.PAY:no=(datepo.getPool()[BillNo.PAY]++);break;
                    case BillType.RECEIVE:System.out.print(datepo.getPool().length);no=(datepo.getPool()[BillNo.COLLECTION]++);break;
                    case BillType.SALERET:no=(datepo.getPool()[BillNo.SALERETURN]++);break;
                    case BillType.PURCHASE:no=(datepo.getPool()[BillNo.PURCHASE]++);break;
                    case BillType.PURCHASERET:no=(datepo.getPool()[BillNo.PURCHASERETURN]++);break;
                    case BillType.CASH:no=(datepo.getPool()[BillNo.CASH]++);break;
                    case BillType.PRESENT:no=(datepo.getPool()[BillNo.PRESENT]++);break;
                    case BillType.OVERFLOW:no=(datepo.getPool()[BillNo.OVERFLOW]++);break;
                    case BillType.SHORTAGE:no=(datepo.getPool()[BillNo.SHORTAGE]++);break;
                }
                session.save(datepo);
                transaction.commit();
                session.close();
                factory.close();
            }else{
                datepo.setDate(date);
                int[] pool=new int[11];
                datepo.setPool(pool);
                session.save(datepo);
                transaction.commit();
                session.close();
                factory.close();
            }
        }
        out=determineHead(type,date)+df.format(no);
        return out;
    }

}


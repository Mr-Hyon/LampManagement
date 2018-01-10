package blservice.tableblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import vo.TableVO;
import util.ResultMessage;
import vo.SaleTableVO;
import vo.SituationTableVO;

public interface TableBLService {
	
	public SituationTableVO viewManagementSituation(String time) throws RemoteException;

}

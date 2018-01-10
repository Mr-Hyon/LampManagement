package bl.tablebl;

import java.rmi.RemoteException;
import vo.SituationTableVO;
import blservice.tableblservice.TableBLService;

public class TableController implements TableBLService{

	Table table = new Table();
	@Override
	public SituationTableVO viewManagementSituation(String time) throws RemoteException {
		return table.viewManagementSituation(time);
	}

}

package blservice.userblservice;

import java.rmi.RemoteException;
import util.ResultMessage;
import vo.UserVO;

public interface UserBLService {
	public ResultMessage add(UserVO vo) throws RemoteException;
	public ResultMessage update(UserVO vo) throws RemoteException;
	public UserVO findUser(String name) throws RemoteException;
	public ResultMessage login(String id,String password,String type) throws RemoteException;
}

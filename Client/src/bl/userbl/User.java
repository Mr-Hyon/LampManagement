package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMessage;
import util.UserType;
import vo.UserVO;

public class User {
	public ResultMessage add(UserVO vo) throws RemoteException{
		
	}
	public ResultMessage delete(UserVO vo) throws RemoteException{
		
	}
	public ResultMessage update(UserVO vo) throws RemoteException{
		
	}
	public ArrayList<UserVO> findById(String id) throws RemoteException{
		
	}
	public ArrayList<UserVO> findByName(String name) throws RemoteException{
		
	}
	public ArrayList<UserVO> findByType(UserType type) throws RemoteException{
		
	}
	public ArrayList<UserVO> show() throws RemoteException{
		
	}
	public UserType login(String id,String password) throws RemoteException{
		
	}
}

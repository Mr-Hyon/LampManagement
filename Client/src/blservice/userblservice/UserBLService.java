package blservice.userblservice;

import java.util.ArrayList;
import java.rmi.RemoteException;
import util.ResultMessage;
import util.UserType;
import vo.UserVO;

public interface UserBLService {
	public ResultMessage add(UserVO vo);
	public ResultMessage delete(UserVO vo);
	public ResultMessage update(UserVO vo);
	public ArrayList<UserVO> findById(String id);
	public ArrayList<UserVO> findByName(String name);
	public ArrayList<UserVO> findByType(UserType type);
	public ArrayList<UserVO> show();
	public UserType login(String id,String password)throws RemoteException;
}

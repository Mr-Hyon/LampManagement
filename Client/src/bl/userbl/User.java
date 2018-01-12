package bl.userbl;

import java.rmi.RemoteException;
import common.feedback;
import po.UserPO.UserPO;
import rmi.RemoteHelper;
import util.ResultMessage;
import vo.UserVO;

public class User {
	//add user
	public ResultMessage add(UserVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getUserDataService().addUser(toUserPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//modify password
	public ResultMessage update(UserVO vo) throws RemoteException{
		if(RemoteHelper.getInstance().getUserDataService().modifyPassword(toUserPO(vo))==feedback.Success){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//login
	public ResultMessage login(String id,String password,String type) throws RemoteException{
		UserPO userPO = RemoteHelper.getInstance().getUserDataService().findUser(id);
		if(userPO==null){
			return ResultMessage.FAILED;
		}
		else if(userPO.getPassword().equals(password)&&userPO.getPosition().equals(type)){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAILED;
		}
	}
	//transform userVO into userPO
	public static UserPO toUserPO(UserVO vo) {
		UserPO userPO = new UserPO(vo.getUserName(),vo.getUserPassword(),vo.getUserIdentity(),vo.getUserLevel());
		return userPO;
	}
	//transform userPO into userVO
	public static UserVO toUserVO(UserPO po) {
		UserVO userVO = new UserVO(po.getUsername(),po.getPassword(),po.getPosition(),po.getAuthority());
		return userVO;
	}
}

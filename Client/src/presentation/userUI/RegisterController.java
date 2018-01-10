package presentation.userUI;

import java.rmi.RemoteException;

import blservice.userblservice.UserBLService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.BLFactory.BLServiceFactory;
import util.ResultMessage;
import vo.UserVO;

public class RegisterController {
	
	@FXML
	TextField UserID;
	
	@FXML
	PasswordField password;
	
	@FXML
	PasswordField password1;
	
	@FXML
	ChoiceBox<String> identity;
	
	@FXML
	Button RegisterButton;
	
	@FXML
	Button ReturnButton;
	
	UserBLService userBLService=BLServiceFactory.getUserBLService();
	
	public void initialize(){
		identity.setItems(FXCollections.observableArrayList("总经理","财务人员","进销管理人员","库存管理人员"));
		identity.getSelectionModel().select(0);
	}
	
	public void RegisterUser() throws RemoteException{
		if(UserID.getText().equals("") || password.getText().equals("")){
			Alert warning=new Alert(Alert.AlertType.WARNING,"用户名或密码不能为空");
			warning.showAndWait();
			UserID.setText("");
			password.setText("");
		}
		
		else if(!password.getText().equals(password1.getText())){
			Alert warning=new Alert(Alert.AlertType.WARNING,"密码不一致");
			warning.showAndWait();
			UserID.setText("");
			password.setText("");
		}
		
		else{
			String UserName=UserID.getText();
			String pw=password.getText();
			String id=identity.getValue();

			System.out.println(UserName);
			System.out.println(pw);
			System.out.println(id);
			
			UserVO vo=new UserVO(UserName,pw,id,"2");
			
			ResultMessage rm=userBLService.add(vo);
			
			if(rm==ResultMessage.FAILED){
				Alert information=new Alert(Alert.AlertType.INFORMATION,"注册失败");
			}
			else if(rm==ResultMessage.SUCCESS){
				Alert information=new Alert(Alert.AlertType.INFORMATION,"注册成功");
				information.showAndWait();
				Registerui.hide();
				Loginui.show();
			}
		}
	}
	
	public void RegisterReturn(){
		Registerui.hide();
		Loginui.show();
	}

}

package presentation.userUI;

import presentation.BLFactory.BLServiceFactory;
import presentation.commodityUI.Commodityui;
import presentation.financeUI.FinanceController;
import presentation.financeUI.Financeui;
import rmi.RemoteHelper;
import util.ResultMessage;
import vo.UserVO;

import java.rmi.RemoteException;

import blservice.accountblservice.AccountBLService;
import blservice.userblservice.UserBLService;
import common.feedback;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import po.AccountPO.AccountPO;

public class LoginController {
	
	@FXML
	Button loginButton;
	
	@FXML
	Button registerButton;
	
	@FXML
	TextField UserID;
	
	@FXML
	PasswordField password;
	
	@FXML
	ChoiceBox identity;
	public static Object Identity;
	
	public static String CurrentUser;
	
	UserBLService userBLService = BLServiceFactory.getUserBLService();
	
	public void initialize(){
		identity.setItems(FXCollections.observableArrayList("总经理","财务人员","进销管理人员","库存管理人员"));
		identity.getSelectionModel().select(0);
	}

	public void onLoginAction() throws Exception{
		
		/*test rmi*/
//		feedback fb=RemoteHelper.getInstance().getAccountDataService().addAccount(new AccountPO("test 3","Bank A",200.0));
//		System.out.println(fb);
		/*test complete*/
		
		
		String username=UserID.getText();
		String pw=password.getText();
		
		System.out.println(username);
		System.out.println(pw);
		Identity=identity.getValue();
		if(username.equals("") || pw.equals("")){
			Alert warning=new Alert(Alert.AlertType.WARNING,"用户名或密码不能为空");
			warning.showAndWait();
			UserID.setText("");
			password.setText("");
		}
		
		else{
			if(identity.getValue().equals(null)){
				
			}
		
			if(identity.getValue().equals("财务人员")){
				ResultMessage rm=userBLService.login(username, pw, "财务人员");
				if(rm==ResultMessage.FAILED){
					Alert warning=new Alert(Alert.AlertType.WARNING,"用户名或密码填写不正确");
					warning.showAndWait();
					UserID.setText("");
					password.setText("");
				}
				else if(rm==ResultMessage.SUCCESS){
					CurrentUser=username;
					Loginui.hide();
					Financeui.show();
					UserID.setText("");
					password.setText("");
				}
			}
			//FinanceController.setCurrentUser(UserID.getText());
			else if(identity.getValue().equals("库存管理人员")){
				ResultMessage rm=userBLService.login(username, pw, "库存管理人员");
				if(rm==ResultMessage.FAILED){
					Alert warning=new Alert(Alert.AlertType.WARNING,"用户名或密码填写不正确");
					warning.showAndWait();
					UserID.setText("");
					password.setText("");
				}
				else if(rm==ResultMessage.SUCCESS){
					CurrentUser=username;
					Loginui.hide();
					Commodityui.show();
					UserID.setText("");
					password.setText("");
				}
			}
			else if(identity.getValue().equals("进销管理人员")){
				ResultMessage rm=userBLService.login(username, pw, "进销管理人员");
				if(rm==ResultMessage.FAILED){
					Alert warning=new Alert(Alert.AlertType.WARNING,"用户名或密码填写不正确");
					warning.showAndWait();
					UserID.setText("");
					password.setText("");
				}
				else if(rm==ResultMessage.SUCCESS){
					CurrentUser=username;
					Loginui.hide();
					SalesmanUI.show();
					UserID.setText("");
					password.setText("");
				}
			}
			else if(identity.getValue().equals("总经理")){
				ResultMessage rm=userBLService.login(username, pw, "总经理");
				if(rm==ResultMessage.FAILED){
					Alert warning=new Alert(Alert.AlertType.WARNING,"用户名或密码填写不正确");
					warning.showAndWait();
					UserID.setText("");
					password.setText("");
				}
				else if(rm==ResultMessage.SUCCESS){
					CurrentUser=username;
					Loginui.hide();
					ManagerUI.show();
					UserID.setText("");
					password.setText("");
				}
			}
		}
	}

	public void onRegisterAction(){
		Loginui.hide();
		Registerui.show();
	}
	public static Object getIdentity(){
		return Identity;
	}
}

package userUI;

import commodityUI.Commodityui;
import financeUI.FinanceController;
import financeUI.Financeui;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
	
	public void initialize(){
		identity.setItems(FXCollections.observableArrayList("总经理","财务人员","库存管理人员","销售人员"));
		identity.getSelectionModel().select(0);
	}

	public void onLoginAction(){
		
		String username=UserID.getText();
		String pw=password.getText();
		
		System.out.println(username);
		System.out.println(pw);
		
		if(username.equals("") || pw.equals("")){
			Alert warning=new Alert(Alert.AlertType.WARNING,"用户名或密码填写错误");
			warning.showAndWait();
			UserID.setText("");
			password.setText("");
		}
		
		else{
			if(identity.getValue().equals(null)){
				
			}
		
			if(identity.getValue().equals("财务人员")){
				Loginui.hide();
				Financeui.show();
				UserID.setText("");
				password.setText("");
			}
			//FinanceController.setCurrentUser(UserID.getText());
			else if(identity.getValue().equals("库存管理人员")){
				Loginui.hide();
				Commodityui.show();
				UserID.setText("");
				password.setText("");
			}
		}
	}
	
	public void onRegisterAction(){
		Loginui.hide();
		Registerui.show();
	}

}

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
		identity.setItems(FXCollections.observableArrayList("�ܾ���","������Ա","��������Ա","������Ա"));
		identity.getSelectionModel().select(0);
	}

	public void onLoginAction(){
		
		String username=UserID.getText();
		String pw=password.getText();
		
		System.out.println(username);
		System.out.println(pw);
		
		if(username.equals("") || pw.equals("")){
			Alert warning=new Alert(Alert.AlertType.WARNING,"�û�����������д����");
			warning.showAndWait();
			UserID.setText("");
			password.setText("");
		}
		
		else{
			if(identity.getValue().equals(null)){
				
			}
		
			if(identity.getValue().equals("������Ա")){
				Loginui.hide();
				Financeui.show();
				UserID.setText("");
				password.setText("");
			}
			//FinanceController.setCurrentUser(UserID.getText());
			else if(identity.getValue().equals("��������Ա")){
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

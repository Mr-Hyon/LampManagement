package presentation.userUI;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
	
	
	
	public void initialize(){
		identity.setItems(FXCollections.observableArrayList("总经理","财务人员","库存管理人员","销售人员"));
		identity.getSelectionModel().select(0);
	}
	
	public void RegisterUser(){
		if(UserID.getText().equals("") || password.getText().equals("")){
			Alert warning=new Alert(Alert.AlertType.WARNING,"用户名或密码填写错误");
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
			
			Alert information=new Alert(Alert.AlertType.INFORMATION,"注册成功");
			information.showAndWait();
			Registerui.hide();
			Loginui.show();
		}
	}
	
	public void RegisterReturn(){
		Registerui.hide();
		Loginui.show();
	}

}

package presentation.accountUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import vo.AccountVO;

public class AccountInputController extends AccountController{

	@FXML
	Button ConfirmButton;

	@FXML
	Button ReturnButton;
	
	@FXML
	TextField AccountName;
	
	@FXML
	TextField AccountCash;
	
	@Override
	public void initialize(){
		
	}
	
	public void Confirm(){
		AccountInputui.setAccess(true);
		AccountInputui.setData(AccountName.getText(),AccountCash.getText());
		AccountInputui.hide();
	}
	
	public void Return(){
		AccountInputui.setAccess(false);
		AccountInputui.hide();
	}
}

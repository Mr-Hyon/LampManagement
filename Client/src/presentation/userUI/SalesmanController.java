package presentation.userUI;




import presentation.ClientUI.ClientUI;
import presentation.PurchaseUI.PurchaseUI;
import presentation.PurchaseUI.UnPurchaseUI;
import presentation.SalesUI.SalesUI;
import presentation.SalesUI.UnSalesUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

public class SalesmanController {
	public static Stage stage;
	static FXMLLoader loader;
	@FXML
	private Button jinhuo1;
	@FXML
	private Button xiaoshou1;
	@FXML
	private Button xiaoshou2;
	@FXML
	private Button jinhuo2;
	@FXML
	private Button kehu;
	@FXML
	private Label label1;
	@FXML
	private Button logout;
	public void Purchase(ActionEvent event){
		PurchaseUI pc=new PurchaseUI();
		pc.setUp();
		SalesmanUI.hide();
	}
	public void Unpurchase(ActionEvent event){
		UnPurchaseUI upc=new UnPurchaseUI();
		upc.setUp();
		SalesmanUI.hide();
	}
	public void Sell(ActionEvent event){
		SalesUI sc=new SalesUI();
		sc.setUp();
		SalesmanUI.hide();
	}
	public void Unsell(ActionEvent event){
		UnSalesUI usc=new UnSalesUI();
		usc.setUp();
		SalesmanUI.hide();
	}
	public void ClientManage(ActionEvent event){
		ClientUI cc=new ClientUI();
		cc.setUp();
		SalesmanUI.hide();
	}
	public void logout(ActionEvent event){
		Loginui.show();
		SalesmanUI.hide();
	} 
}

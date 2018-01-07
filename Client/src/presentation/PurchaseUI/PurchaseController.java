package presentation.PurchaseUI;

import java.io.IOException;

import presentation.userUI.Loginui;
import presentation.userUI.SalesmanUI;
import presentation.PurchaseUI.PurchaseUI;
import presentation.SalesUI.SalesUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.MenuButton;

import javafx.scene.control.ChoiceBox;

public class PurchaseController {

	@FXML
	private Button Confirm;
	@FXML
	private Label NumberofDoc;
	@FXML
	private TextField NameofClient;
	@FXML
	private TextField Storage;
	@FXML
	private TextField Operator;
	@FXML
	private TextField Sum;
	@FXML
	private TextField Note1;
	@FXML
	private TextField IDofGoods;
	@FXML
	private ChoiceBox NameofGoods;
	@FXML
	private TextField Xinghao;
	@FXML
	private TextField NumberofGoods;
	@FXML
	private TextField PriceofGoods;
	@FXML
	private TextField Sum2;
	@FXML
	private TextField Note2;
	@FXML
	private Button BacktoMain;
	@FXML
	private Button logout;
	@FXML
	private Label id;
	
	public void BacktoMain(ActionEvent event){
		System.out.println("Button Clicked 5!");
		PurchaseUI.hide();
		SalesmanUI.show();
	}
	public void Confirm(ActionEvent event){
		System.out.println("Button Clicked 5!");
		PurchaseUI.hide();
		SalesmanUI.show();
	}
	public void setID(String ID){
		id.setText("您好，"+ID);
	}
	public void logout(ActionEvent event){
		PurchaseUI.hide();
		Loginui.show();
	}
	
}

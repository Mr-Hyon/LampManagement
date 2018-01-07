package presentation.SalesUI;

import java.io.IOException;

import presentation.userUI.Loginui;
import presentation.userUI.SalesmanUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.MenuButton;

import javafx.scene.control.ChoiceBox;

public class SalesController {

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
	private TextField Businessman;
	@FXML
	private TextField Discount;
	@FXML
	private TextField DiscountUsed;
	@FXML
	private TextField SumAfterDiscount;
	public void BacktoMain(ActionEvent event){
		System.out.println("Button Clicked 5!");
		SalesUI.hide();
		SalesmanUI.show();
	}
	public void Confirm(ActionEvent event){
		if(NumberofGoods.getText().equals("")){
			Alert warning=new Alert(Alert.AlertType.WARNING,"商品数量不能为空。");
		    warning.showAndWait();
		}
		if(Integer.parseInt(NumberofGoods.getText())<=0){
			Alert warning=new Alert(Alert.AlertType.WARNING,"商品数量应为正整数。");
		    warning.showAndWait();
		}	
		else{
			SalesUI.hide();
			SalesmanUI.show();
		}
	}
	public void logout(ActionEvent event){
		SalesUI.hide();
		Loginui.show();
	}
}

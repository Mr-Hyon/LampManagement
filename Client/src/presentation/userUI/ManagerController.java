package presentation.userUI;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import presentation.SalesUI.SalesUI;
import presentation.tableUI.CheckBusinessProgressui;
import presentation.tableUI.CheckBusinessStateui;
import presentation.tableUI.CheckSalesDetailui;
import presentation.userUI.SalesmanUI;
import presentation.verifyUI.VerifyUI;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.MenuButton;

public class ManagerController {
	@FXML
	private Button SalesDetail;
	@FXML
	private Button BusinessProgress;
	@FXML
	private Button BusinessState;
	@FXML
	private Button Promotion;
	@FXML
	private Button Verify;
	@FXML
	private Label label1;
	@FXML
	private Button logout;

	@FXML
	public void CheckSalesDetail(ActionEvent event) {
		System.out.println("Button Clicked 4!");
		ManagerUI.hide();
		CheckSalesDetailui.show();
	}
	@FXML
	public void CheckBusinessProgress(ActionEvent event) {
		System.out.println("Button Clicked 4!");
		ManagerUI.hide();
		CheckBusinessProgressui.show();
	}
	@FXML
	public void CheckBusinessState(ActionEvent event) {
		System.out.println("Button Clicked 4!");
		ManagerUI.hide();
		CheckBusinessStateui.show();
	}
	@FXML
	public void Verify(ActionEvent event) {
		System.out.println("Button Clicked 4!");
		VerifyUI ve=new VerifyUI();
		ve.setUp();
		ManagerUI.hide();
	}
	@FXML
	public void Promotion(ActionEvent event) {
		// TODO Autogenerated
	}
	public void logout(ActionEvent event){
		Loginui.show();
		ManagerUI.hide();
	}
}

package presentation.verifyUI;

import presentation.SalesUI.SalesUI;
import presentation.userUI.Loginui;
import presentation.userUI.ManagerUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.MenuButton;

import javafx.scene.control.ChoiceBox;

import javafx.scene.control.TableColumn;

public class VerifyController {
	@FXML
	private Button logout;
	@FXML
	private ChoiceBox DocumentType;
	@FXML
	private TextField Operator;
	@FXML
	private Button Inquire;
	@FXML
	private TableColumn Number;
	@FXML
	private TableColumn Type;
	@FXML
	private TableColumn operator;
	@FXML
	private TableColumn time;
	@FXML
	private Button Verify;
	@FXML
	private Button BacktoMain;

	public void BacktoMain(ActionEvent event){
		System.out.println("Button Clicked 5!");
		VerifyUI.hide();
		ManagerUI.show();
	}
	public void Verify(ActionEvent event){
		System.out.println("Button Clicked 5!");
	}
	public void Inquire(ActionEvent event){
		System.out.println("Button Clicked 5!");
	}
	/*public void Inquire(ActionEvent event){
		System.out.println("Button Clicked 5!");
	}
	public void Inquire(ActionEvent event){
		System.out.println("Button Clicked 5!");
	}*/
	public void logout(ActionEvent event){
		VerifyUI.hide();
		Loginui.show();
	}
}
package presentation.ClientUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import presentation.userUI.Loginui;
import presentation.userUI.SalesmanUI;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.MenuButton;

import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TableColumn;

public class ClientController {
	@FXML
	private Button ShowMessage;
	@FXML
	private Button AddClient;
	@FXML
	private Button Delete;
	@FXML
	private Button Modify;
	@FXML
	private Button BacktoMain;
	@FXML
	private TableView ShowClientMes;
	@FXML
	private TableColumn ClientID;
	@FXML
	private TableColumn ClientName;
	@FXML
	private Label Label1;
	@FXML
	private Button Find;
	@FXML
	private MenuButton Menu;
	
	public void ShowUser(){
		Label1.setText("您好！YYY");
	}

	public void ShowMessage(ActionEvent event){
		System.out.println("Button Clicked 1!");
	}
	public void AddClient(ActionEvent event){
		System.out.println("Button Clicked 2!");
	}
	public void Delete(ActionEvent event){
		System.out.println("Button Clicked 3!");
	}
	public void Modify(ActionEvent event){
		System.out.println("Button Clicked 4!");
	}
	public void BacktoMain(ActionEvent event){
		System.out.println("Button Clicked 5!");
		SalesmanUI.show();
		ClientUI.hide();
	}
	public void Find(ActionEvent event){
		System.out.println("Button Clicked 6!");
		ClientFindUI cf=new ClientFindUI();
		cf.setUp();
		ClientUI.hide();
	}
	public void logout(ActionEvent event){
		System.out.println("Button Clicked 7!");
		ClientUI.hide();
		Loginui.show();
	}


}

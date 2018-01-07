package presentation.ClientUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import presentation.userUI.SalesmanUI;

public class ClientFindController {
	@FXML
	private Button Find;
	@FXML
	private TextField FindbyId;
	@FXML
	private TextField FindbyString;
	@FXML
	private Button Back;
	
	
	public void Back(ActionEvent event){
		System.out.println("Button Clicked 5!");
		ClientFindUI.hide();
		ClientUI cc=new ClientUI();
		cc.setUp();
	}
	public void Find(ActionEvent event){
		System.out.println("Button Clicked 5!");
		ClientFindUI.hide();
		ClientUI cc=new ClientUI();
		cc.setUp();
	}
}

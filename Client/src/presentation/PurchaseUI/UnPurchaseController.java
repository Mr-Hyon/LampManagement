package presentation.PurchaseUI;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import blservice.accountblservice.AccountBLService;
import blservice.clientblservice.ClientBLService;
import blservice.commodityblservice.CommodityBLService;
import blservice.paymentblservice.PaymentBLService;
import blservice.purchaseblservice.PurchaseBLService;
import presentation.userUI.LoginController;
import presentation.userUI.Loginui;
import presentation.userUI.SalesmanUI;
import util.ResultMessage;
import vo.CommodityVO;
import vo.PurchaseVO;
import presentation.BLFactory.BLServiceFactory;
import presentation.PurchaseUI.PurchaseUI;
import presentation.SalesUI.SalesUI;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
import javafx.stage.StageStyle;
import javafx.scene.control.MenuButton;

import javafx.scene.control.ChoiceBox;

public class UnPurchaseController {

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
	CommodityBLService commodityBLService=BLServiceFactory.getCommodityBLService();
	PurchaseBLService purchaseBLService=BLServiceFactory.getPurchaseBLService();
	public void initialize() throws RemoteException{
		Operator.setText(LoginController.CurrentUser);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String Id=df.format(new Date());
		Id="JHTHD-"+Id;
		NumberofDoc.setText(Id);
		id.setText("您好！"+LoginController.CurrentUser);
		ArrayList<CommodityVO> accountList=commodityBLService.show();
		ArrayList<String> goodsname = null;
		for(int i=0;i<accountList.size();i++)
			goodsname.add(accountList.get(i).getGoodName());
		NameofGoods.setItems(FXCollections.observableArrayList(goodsname));
		NameofGoods.getSelectionModel().select(0);
		NameofGoods.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val)->{  
			IDofGoods.setText(accountList.get(new_val.intValue()).getGoodId());
			Xinghao.setText(accountList.get(new_val.intValue()).getGoodModel());
			PriceofGoods.setText(accountList.get(new_val.intValue()).getGoodBuyPrice());
		});
	}
	public void BacktoMain(ActionEvent event){
		UnPurchaseUI.hide();
		SalesmanUI.show();
	}
	public void Confirm(ActionEvent event) throws RemoteException{
		if(NumberofGoods.getText().equals("")){
			Alert warning=new Alert(Alert.AlertType.WARNING,"商品数量不能为空。");
		    warning.showAndWait();
		}
		if(Integer.parseInt(NumberofGoods.getText())<=0){
			Alert warning=new Alert(Alert.AlertType.WARNING,"商品数量应为正整数。");
		    warning.showAndWait();
		}
		PurchaseVO vo=new PurchaseVO(NumberofDoc.getText(), NameofClient.getText(), Operator.getText(), Storage.getText(), Double.parseDouble(Sum.getText()), Note1.getText(), IDofGoods.getText(), NameofGoods.getValue().toString(), Xinghao.getText(), Integer.parseInt(NumberofGoods.getText()), PriceofGoods.getText(), Double.parseDouble(Sum2.getText()), Note2.getText());
		ResultMessage rm=purchaseBLService.addRefunds(vo);
		
		if(rm==ResultMessage.SUCCESS){
			Alert information=new Alert(Alert.AlertType.INFORMATION,"制定成功");
			information.showAndWait();
		}
		else if(rm==ResultMessage.FAILED){
			Alert information=new Alert(Alert.AlertType.INFORMATION,"制定失败");
			information.showAndWait();
		}
		UnPurchaseUI.hide();
		SalesmanUI.show();
	}
	public void logout(ActionEvent event){
		UnPurchaseUI.hide();
		Loginui.show();
	}
	
}


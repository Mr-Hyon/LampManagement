package presentation.SalesUI;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import blservice.commodityblservice.CommodityBLService;
import blservice.salesblservice.SalesBLService;
import presentation.BLFactory.BLServiceFactory;
import presentation.userUI.LoginController;
import presentation.userUI.Loginui;
import presentation.userUI.SalesmanUI;
import util.ResultMessage;
import vo.CommodityVO;
import vo.SalesVO;
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
import javafx.scene.control.MenuButton;

import javafx.scene.control.ChoiceBox;

public class UnSalesController {

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
	@FXML
	private Label Label;
	SalesBLService salesBLService = BLServiceFactory.getSalesBLService();
	CommodityBLService commodityBLService = BLServiceFactory.getCommodityBLService();
	public void initialize() throws RemoteException{
		Operator.setText(LoginController.CurrentUser);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String id=df.format(new Date());
		id="XSTHD-"+id;
		NumberofDoc.setText(id);
		ArrayList<CommodityVO> accountList=commodityBLService.show();
		ArrayList<String> goodsname = null;
		for(int i=0;i<accountList.size();i++)
			goodsname.add(accountList.get(i).getGoodName());
		NameofGoods.setItems(FXCollections.observableArrayList(goodsname));
		NameofGoods.getSelectionModel().select(0);
		Label.setText("您好！"+LoginController.CurrentUser);
		NameofGoods.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val)->{  
			IDofGoods.setText(accountList.get(new_val.intValue()).getGoodId());
			Xinghao.setText(accountList.get(new_val.intValue()).getGoodModel());
			PriceofGoods.setText(accountList.get(new_val.intValue()).getGoodBuyPrice());
        });;
	}
	public void BacktoMain(ActionEvent event){
		UnSalesUI.hide();
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
		else{
			SalesVO vo=new SalesVO(NumberofDoc.getText(), NameofClient.getText(),Businessman.getText(), Operator.getText(), Storage.getText(), Double.parseDouble(Sum.getText()),Double.parseDouble(Discount.getText()),Double.parseDouble(DiscountUsed.getText()),Double.parseDouble(SumAfterDiscount.getText()), Note1.getText(), IDofGoods.getText(), NameofGoods.getValue().toString(), Xinghao.getText(), Integer.parseInt(NumberofGoods.getText()), Double.parseDouble(PriceofGoods.getText()), Double.parseDouble(Sum2.getText()), Note2.getText());
		ResultMessage rm=salesBLService.addRefunds(vo);
		
		if(rm==ResultMessage.SUCCESS){
			Alert information=new Alert(Alert.AlertType.INFORMATION,"制定成功");
			information.showAndWait();
		}
		else if(rm==ResultMessage.FAILED){
			Alert information=new Alert(Alert.AlertType.INFORMATION,"制定失败");
			information.showAndWait();
		}
			UnSalesUI.hide();
			SalesmanUI.show();
		}
	}
	public void logout(ActionEvent event){
		UnSalesUI.hide();
		Loginui.show();
	}
}

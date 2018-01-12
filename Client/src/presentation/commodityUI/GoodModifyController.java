package presentation.commodityUI;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.accountUI.AccountInputui;

public class GoodModifyController {
	
	@FXML
	Button ConfirmButton;

	@FXML
	Button ReturnButton;
	
	@FXML
	TextField GoodNum;
	
	@FXML
	TextField GoodRBP;
	
	@FXML
	TextField GoodRRP;
	
	public void initialize(){
		
	}
	
	public void Confirm(){
		if(GoodNum.getText().equals("")||GoodRBP.getText().equals("")||GoodRRP.getText().equals("")){
			Alert alert=new Alert(Alert.AlertType.WARNING,"信息不完整");
			alert.showAndWait();
		}
		else if(!checkNum(GoodNum.getText())){
			Alert alert=new Alert(Alert.AlertType.WARNING,"库存数量非法");
			alert.showAndWait();
		}
		else if(!checkPrice(GoodRBP.getText())){
			Alert alert=new Alert(Alert.AlertType.WARNING,"进价非法");
			alert.showAndWait();
		}
		else if(!checkPrice(GoodRRP.getText())){
			Alert alert=new Alert(Alert.AlertType.WARNING,"零售价非法");
			alert.showAndWait();
		}
		else{
			GoodModifyui.setAccess(true);
			GoodModifyui.setData(GoodNum.getText(),GoodRBP.getText(),GoodRRP.getText());
			GoodModifyui.hide();
		}
	}
	
	public void Return(){
		GoodModifyui.setAccess(false);
		GoodModifyui.hide();
	}
	
	public boolean checkPrice(String price){
		try{
			double d=Double.parseDouble(price);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean checkNum(String num){
		try{
			int n=Integer.parseInt(num);
		}catch(Exception e){
			return false;
		}
		return true;
	}

}

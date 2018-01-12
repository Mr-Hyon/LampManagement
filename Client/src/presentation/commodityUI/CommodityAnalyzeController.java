package presentation.commodityUI;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.commodityblservice.CommodityBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.BLFactory.BLServiceFactory;
import util.ResultMessage;
import vo.CommodityVO;

public class CommodityAnalyzeController {
	
	@FXML
	Button ReturnButton;
	
	@FXML
	Button AnalyzeButton;
	
	@FXML
	TableView<CommodityVO> GoodsTable;
	
	@FXML
	TableColumn GoodsIdCol;
	
	@FXML
	TableColumn GoodsNameCol;
	
	@FXML
	TableColumn GoodsNumCol;
	
	@FXML
	TextField RealNum;
	
	ObservableList<CommodityVO> data=FXCollections.observableArrayList();
	CommodityBLService commodityBLService=BLServiceFactory.getCommodityBLService();
	
	
	public void initialize() throws RemoteException{
		ArrayList<CommodityVO> list=commodityBLService.show();
		for(int i=0;i<list.size();i++){
			data.add(list.get(i));
		}
		GoodsTable.setEditable(true);
		GoodsIdCol.setCellValueFactory(new PropertyValueFactory<>("goodId"));
		GoodsNameCol.setCellValueFactory(new PropertyValueFactory<>("goodName"));
		GoodsNumCol.setCellValueFactory(new PropertyValueFactory<>("goodNum"));
		GoodsTable.setItems(data);
	}
	
	public void Return(){
		CommodityAnalyzeui.hide();
		Commodityui.show();
	}
	
	public void Analyze() throws RemoteException{
		CommodityVO vo=GoodsTable.getSelectionModel().getSelectedItem();
		int index=GoodsTable.getSelectionModel().getSelectedIndex();
		String num=RealNum.getText();
		if(vo==null){
			Alert alert=new Alert(Alert.AlertType.WARNING,"请选择一个商品进行库存分析");
			alert.showAndWait();
		}
		else if(num.equals("")){
			Alert alert=new Alert(Alert.AlertType.WARNING,"请输入商品实际库存");
			alert.showAndWait();
		}
		else if(!checkNum(num)){
			Alert alert=new Alert(Alert.AlertType.WARNING,"实际库存数非法");
			alert.showAndWait();
			RealNum.clear();
		}
		else{
			vo.setGoodNum(num);
			ResultMessage rm=commodityBLService.update(vo);
			if(rm==ResultMessage.SUCCESS){
				Alert alert=new Alert(Alert.AlertType.INFORMATION,"更新成功");
				alert.showAndWait();
				data.set(index, vo);
			}
			else{
				Alert alert=new Alert(Alert.AlertType.INFORMATION,"更新失败");
				alert.showAndWait();
			}
		}
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

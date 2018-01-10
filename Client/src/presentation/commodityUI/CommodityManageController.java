package presentation.commodityUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blservice.commodityblservice.CommodityBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import presentation.BLFactory.BLServiceFactory;
import vo.*;

public class CommodityManageController {
	
	@FXML
	TreeTableView<CommodityTypeVO> GoodTypeTree;
	
	@FXML
	TreeTableColumn<CommodityTypeVO,String> GoodTypeCol;
	
	@FXML
	TableView<CommodityVO> GoodTable;
	
	@FXML
	TableColumn GoodIdCol;
	
	@FXML
	TableColumn GoodNameCol;
	
	@FXML
	TableColumn GoodModelCol;
	
	@FXML
	TableColumn GoodNumCol;
	
	@FXML
	TableColumn GoodBPCol;
	
	@FXML
	TableColumn GoodRPCol;
	
	@FXML
	TableColumn GoodRBPCol;
	
	@FXML
	TableColumn GoodRRPCol;
	
	@FXML
	Button ReturnButton;
	
	@FXML
	Button AddGoodTypeButton;
	
	@FXML
	Button DeleteGoodTypeButton;
	
	@FXML
	Button ModifyGoodTypeButton;
	
	@FXML
	Button AddGoodButton;
	
	@FXML
	Button DeleteGoodButton;
	
	@FXML
	Button ModifyGoodButton;
	
	@FXML
	Button SearchGoodButton;
	
	@FXML
	TextField MainType;
	
	@FXML
	TextField SubType;
	
	@FXML
	TextField GoodNameSearch;
	
	@FXML
	TextField GoodIdSearch;
	
	CommodityBLService commodityBLService=BLServiceFactory.getCommodityBLService();
	
	private ObservableList<CommodityVO> commodity=FXCollections.observableArrayList(
			new CommodityVO("0001","PS4","XM01","100","2000","2200"),
			new CommodityVO("0002","NS","XM02","50","1670","2200"),
			new CommodityVO("0003","X1X","XM03","100","3000","3500")
			);
	
	ArrayList<CommodityTypeVO> type=new ArrayList<>();	
	
	TreeItem<CommodityTypeVO> root=new TreeItem<>(new CommodityTypeVO(null,null,"商品管理"));
			
	
	public void initialize(){

		type.add(new CommodityTypeVO(null,null,"MainType A"));
		type.add(new CommodityTypeVO(null,null,"MainType B"));
		type.add(new CommodityTypeVO(null,null,"MainType C"));
		type.add(new CommodityTypeVO("MainType A",null,"Type B"));
		type.add(new CommodityTypeVO("MainType B",null,"Type C"));
		type.add(new CommodityTypeVO("MainType C",null,"Type D"));
		type.add(new CommodityTypeVO("Type B",null,"Type E"));

		GoodTypeTree.setEditable(true);

		GoodTypeCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("typeName"));
		GoodTypeTree.setRoot(root);
		for(int i=0;i<type.size();i++){
			if(type.get(i).getUpperTypeName()==null){
				root.getChildren().add(new TreeItem<CommodityTypeVO>(type.get(i)));
			}
		}
		for(int i=0;i<root.getChildren().size();i++){
			BuildTypeTree(root.getChildren().get(i));
		}
		
		GoodTable.setEditable(true);
		GoodIdCol.setCellValueFactory(new PropertyValueFactory<>("goodId"));
		GoodNameCol.setCellValueFactory(new PropertyValueFactory<>("goodName"));
		GoodModelCol.setCellValueFactory(new PropertyValueFactory<>("goodModel"));
		GoodNumCol.setCellValueFactory(new PropertyValueFactory<>("goodNum"));
		GoodBPCol.setCellValueFactory(new PropertyValueFactory<>("goodBuyPrice"));
		GoodRPCol.setCellValueFactory(new PropertyValueFactory<>("goodRetailPrice"));
		GoodRBPCol.setCellValueFactory(new PropertyValueFactory<>("goodRecentBP"));
		GoodRRPCol.setCellValueFactory(new PropertyValueFactory<>("goodRecentRP"));
		GoodTable.setItems(commodity);
	}
	
	public void Return(){
		CommodityManageui.hide();
		Commodityui.show();
	}
	
	public void AddMainType(){
		String typeName=MainType.getText();
		if(typeName.equals("")){
			Alert alert=new Alert(Alert.AlertType.WARNING,"商品类型不能为空");
			alert.showAndWait();
		}
		else{
			CommodityTypeVO Type=new CommodityTypeVO(null,null,typeName);
			TreeItem<CommodityTypeVO> mainType=new TreeItem<>(Type);
			root.getChildren().add(mainType);
			MainType.clear();
		}
	}
	
	public void AddSubType(){
		String typeName=SubType.getText();
		TreeItem<CommodityTypeVO> parent=GoodTypeTree.getSelectionModel().getSelectedItem();
		CommodityTypeVO parentType=parent.getValue();
		CommodityTypeVO childType=new CommodityTypeVO(parentType.getTypeName(),null,typeName);
		TreeItem<CommodityTypeVO> child=new TreeItem<>(childType);
		parent.getChildren().add(child);
		SubType.clear();
	}
	
	public void DeleteGoodType(){
		
	}
	
	public void ModifyGoodType(){
		
	}
	
	public void AddGood(){
		
	}
	
	public void DeleteGood(){
		
	}
	
	public void ModifyGood(){
		
	}
	
	public void SearchGood(){
		
	}
	
	public void BuildTypeTree(TreeItem<CommodityTypeVO> root){
		//前置条件:type=commodityBLService.showAllType();
		for(int j=0;j<type.size();j++){
			if(type.get(j).getUpperTypeName()==null){
				
			}
			else if(type.get(j).getUpperTypeName().equals(root.getValue().getTypeName())){
				root.getChildren().add(new TreeItem<CommodityTypeVO>(type.get(j)));
			}
		}
		for(int k=0;k<root.getChildren().size();k++){
			BuildTypeTree(root.getChildren().get(k));
		}
		
	}
}

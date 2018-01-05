package presentation.commodityUI;

import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import vo.*;

public class CommodityManageController {
	
	@FXML
	TreeTableView<CommodityTypeVO> GoodTypeTree;
	
	@FXML
	TreeTableColumn<CommodityTypeVO,String> GoodTypeCol;
	
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
	TextField GoodNameSearch;
	
	@FXML
	TextField GoodIdSearch;
	
	private ObservableList<CommodityVO> commodity=FXCollections.observableArrayList(
			new CommodityVO("0001","PS4","XM01","100","2000","2200"),
			new CommodityVO("0002","NS","XM02","50","1670","2200"),
			new CommodityVO("0003","X1X","XM03","100","3000","3500")
			);
	
	private ObservableList<CommodityTypeVO> type=FXCollections.observableArrayList(
			new CommodityTypeVO(null,"0001","MainType A"),
			new CommodityTypeVO(null,"0002","MainType B"),
			new CommodityTypeVO(null,"0003","MainType C")
			);
	
	
	TreeItem<CommodityTypeVO> root=new TreeItem<>(new CommodityTypeVO(null,"0000","商品分类"));
			
	
	public void initialize(){
		GoodTypeTree.setEditable(true);
		CommodityTypeVO subType1=new CommodityTypeVO(null,"0002","Type B");
		CommodityTypeVO subType2=new CommodityTypeVO(null,"0003","Type C");
		CommodityTypeVO subType3=new CommodityTypeVO(null,"0004","Type D");
		TreeItem<CommodityTypeVO> child1=new TreeItem<>(subType1);
		TreeItem<CommodityTypeVO> child2=new TreeItem<>(subType2);
		TreeItem<CommodityTypeVO> child3=new TreeItem<>(subType3);
		GoodTypeCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("typeName"));
		GoodTypeTree.setRoot(root);
		child2.getChildren().setAll(child3);
		root.getChildren().setAll(child1,child2);
	}
	
	public void Return(){
		CommodityManageui.hide();
		Commodityui.show();
	}
	
	public void AddGoodType(){
		
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
}

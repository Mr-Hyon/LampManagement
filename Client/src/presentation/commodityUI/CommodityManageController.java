package presentation.commodityUI;

import java.rmi.RemoteException;
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
import po.CommodityPO.GoodsPO;
import presentation.BLFactory.BLServiceFactory;
import presentation.accountUI.AccountInputui;
import rmi.RemoteHelper;
import util.ResultMessage;
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
	Button AddGoodTypeButton1;
	
	@FXML
	Button DeleteGoodTypeButton;
	
	@FXML
	Button showGoodButton;
	
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
	TextField KeyWord;
	
	@FXML
	TextField GoodsName;
	
	@FXML
	TextField GoodsModel;
	
	@FXML
	TextField GoodsNum;
	
	@FXML
	TextField GoodsBP;
	
	@FXML
	TextField GoodsRP;
	
	CommodityBLService commodityBLService=BLServiceFactory.getCommodityBLService();
	
	private ObservableList<CommodityVO> commodity=FXCollections.observableArrayList(
			new CommodityVO("0001","PS4","XM01","100","2000","2200"),
			new CommodityVO("0002","NS","XM02","50","1670","2200"),
			new CommodityVO("0003","X1X","XM03","100","3000","3500")
			);
	
	ArrayList<CommodityTypeVO> type=new ArrayList<>();	
	
	TreeItem<CommodityTypeVO> root=new TreeItem<>(new CommodityTypeVO(null,null,"商品管理"));
			
	
	public void initialize() throws RemoteException{
/*
		type.add(new CommodityTypeVO(null,null,"MainType A"));
		type.add(new CommodityTypeVO(null,null,"MainType B"));
		type.add(new CommodityTypeVO(null,null,"MainType C"));
		type.add(new CommodityTypeVO("MainType A",null,"Type B"));
		type.add(new CommodityTypeVO("MainType B",null,"Type C"));
		type.add(new CommodityTypeVO("MainType C",null,"Type D"));
		type.add(new CommodityTypeVO("Type B",null,"Type E"));
*/
		type=commodityBLService.showSort();
		
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
		
		commodity.clear();
		
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
	
	public void AddMainType() throws RemoteException{
		String typeName=MainType.getText();
		if(typeName.equals("")){
			Alert alert=new Alert(Alert.AlertType.WARNING,"商品类型不能为空");
			alert.showAndWait();
		}
		else{
			CommodityTypeVO Type=new CommodityTypeVO(null,null,typeName);
			ResultMessage rm=commodityBLService.addType(Type);
			if(rm==ResultMessage.SUCCESS){
				Alert alert=new Alert(Alert.AlertType.INFORMATION,"添加成功");
				alert.showAndWait();
				TreeItem<CommodityTypeVO> mainType=new TreeItem<>(Type);
				root.getChildren().add(mainType);
				MainType.clear();
			}
			else{
				Alert alert=new Alert(Alert.AlertType.INFORMATION,"添加失败");
				alert.showAndWait();
				MainType.clear();
			}
		}
	}
	
	public void AddSubType() throws RemoteException{
		String typeName=SubType.getText();
		if(typeName.equals("")){
			Alert alert=new Alert(Alert.AlertType.WARNING,"商品类型不能为空");
			alert.showAndWait();
		}
		else{
			TreeItem<CommodityTypeVO> parent=GoodTypeTree.getSelectionModel().getSelectedItem();
			if(parent==null){
				Alert alert=new Alert(Alert.AlertType.WARNING,"请选择一个商品类别进行添加商品操作");
				alert.showAndWait();
				SubType.clear();
			}
			else if(parent.getValue().getTypeName().equals("商品管理")){
				Alert alert=new Alert(Alert.AlertType.WARNING,"请选择一个商品类别进行添加商品操作");
				alert.showAndWait();
				SubType.clear();
			}
			else {
				ArrayList<CommodityVO> temp=commodityBLService.showByType(parent.getValue().getTypeName());
				if(temp.size()>0){
					Alert alert=new Alert(Alert.AlertType.WARNING,"该商品分类下已有商品，不可添加子类");
					alert.showAndWait();
					SubType.clear();
				}
				else{
					CommodityTypeVO parentType=parent.getValue();
					CommodityTypeVO childType=new CommodityTypeVO(parentType.getTypeName(),null,typeName);
					ResultMessage rm=commodityBLService.addType(childType);
					if(rm==ResultMessage.SUCCESS){
						Alert info=new Alert(Alert.AlertType.INFORMATION,"添加成功");
						info.showAndWait();
						TreeItem<CommodityTypeVO> child=new TreeItem<>(childType);
						parent.getChildren().add(child);
						SubType.clear();
					}
					else{
						Alert info=new Alert(Alert.AlertType.INFORMATION,"添加失败");
						info.showAndWait();
						SubType.clear();
					}
				}
			}
		}
	}
	
	public void DeleteGoodType() throws RemoteException{
		TreeItem<CommodityTypeVO> node=GoodTypeTree.getSelectionModel().getSelectedItem();
		if(node==null){
			Alert alert=new Alert(Alert.AlertType.WARNING,"请选择一个商品类别进行操作");
			alert.showAndWait();
		}
		else if(node.getValue().getTypeName().equals("商品管理")){
			Alert alert=new Alert(Alert.AlertType.WARNING,"请选择一个商品类别进行操作");
			alert.showAndWait();
		}
		else if(!node.isLeaf()){			
			Alert alert=new Alert(Alert.AlertType.WARNING,"该商品分类下尚有子分类，不能删除");
			alert.showAndWait();
		}
		else{
			ArrayList<CommodityVO> temp=commodityBLService.showByType(node.getValue().getTypeName());
			if(temp.size()>0){
				Alert alert=new Alert(Alert.AlertType.WARNING,"该商品分类下已有商品，不可添加子类");
				alert.showAndWait();
			}
			else{
				ResultMessage rm=commodityBLService.deleteType(node.getValue());
				if(rm==ResultMessage.SUCCESS){
					Alert alert=new Alert(Alert.AlertType.INFORMATION,"删除成功");
					alert.showAndWait();
					node.getParent().getChildren().removeAll(node);
				}
				else{
					Alert alert=new Alert(Alert.AlertType.INFORMATION,"删除失败");
					alert.showAndWait();
				}
			}
		}
	}
	
	public void showGood() throws RemoteException{
		TreeItem<CommodityTypeVO> node=GoodTypeTree.getSelectionModel().getSelectedItem();
		if(node==null){
			commodity.clear();
			ArrayList<CommodityVO> goodList=commodityBLService.show();
			for(int i=0;i<goodList.size();i++){
				commodity.add(goodList.get(i));
			}
		}
		else{
			String type=node.getValue().getTypeName();
			if(type.equals("商品管理")){
				commodity.clear();
				ArrayList<CommodityVO> goodList=commodityBLService.show();
				for(int i=0;i<goodList.size();i++){
					commodity.add(goodList.get(i));
				}
			}
			else{
				commodity.clear();
				ArrayList<CommodityVO> goodList=commodityBLService.showByType(type);
				for(int i=0;i<goodList.size();i++){
					commodity.add(goodList.get(i));
				}
			}
		}
	}
	
	public void AddGood() throws RemoteException{
		String name=GoodsName.getText();
		String model=GoodsModel.getText();
		String num=GoodsNum.getText();
		String bp=GoodsBP.getText();
		String rp=GoodsRP.getText();
		TreeItem<CommodityTypeVO> node=GoodTypeTree.getSelectionModel().getSelectedItem();
		if(node==null){
			Alert alert=new Alert(Alert.AlertType.WARNING,"请选择一个商品类别进行添加商品操作");
			alert.showAndWait();
		}
		else if(node.getValue().getTypeName().equals("商品管理")){
			Alert alert=new Alert(Alert.AlertType.WARNING,"请选择一个商品类别进行添加商品操作");
			alert.showAndWait();
		}
		else if(!node.isLeaf()){
			Alert alert=new Alert(Alert.AlertType.WARNING,"该商品类别下有子分类，不能添加商品");
			alert.showAndWait();
			GoodsName.clear();
			GoodsModel.clear();
			GoodsNum.clear();
			GoodsBP.clear();
			GoodsRP.clear();
		}
		else if(name.equals("") || model.equals("") || num.equals("") || bp.equals("") || rp.equals("")){
			Alert alert=new Alert(Alert.AlertType.WARNING,"信息填写不完整");
			alert.showAndWait();
			GoodsName.clear();
			GoodsModel.clear();
			GoodsNum.clear();
			GoodsBP.clear();
			GoodsRP.clear();
		}
		else if(!checkNum(num)){
			Alert alert=new Alert(Alert.AlertType.WARNING,"库存数量非法");
			alert.showAndWait();
			GoodsName.clear();
			GoodsModel.clear();
			GoodsNum.clear();
			GoodsBP.clear();
			GoodsRP.clear();
		}
		else if(!checkPrice(bp)){
			Alert alert=new Alert(Alert.AlertType.WARNING,"进价非法");
			alert.showAndWait();
			GoodsName.clear();
			GoodsModel.clear();
			GoodsNum.clear();
			GoodsBP.clear();
			GoodsRP.clear();
		}
		else if(!checkPrice(rp)){
			Alert alert=new Alert(Alert.AlertType.WARNING,"零售价非法");
			alert.showAndWait();
			GoodsName.clear();
			GoodsModel.clear();
			GoodsNum.clear();
			GoodsBP.clear();
			GoodsRP.clear();
		}
		else{
			ArrayList<CommodityVO> list=commodityBLService.show();
			String id=String.valueOf(list.size()+1);
			CommodityVO vo=new CommodityVO(id,name,model,num,bp,rp);
			vo.setType(node.getValue());
			ResultMessage rm = commodityBLService.add(vo);
			if(rm==ResultMessage.SUCCESS){
				Alert info=new Alert(Alert.AlertType.INFORMATION,"添加成功");
				info.showAndWait();
				GoodsName.clear();
				GoodsModel.clear();
				GoodsNum.clear();
				GoodsBP.clear();
				GoodsRP.clear();
				showGood();
			}
			else{
				Alert info=new Alert(Alert.AlertType.INFORMATION,"添加失败");
				info.showAndWait();
				GoodsName.clear();
				GoodsModel.clear();
				GoodsNum.clear();
				GoodsBP.clear();
				GoodsRP.clear();
			}
		}
	}
	
	public void DeleteGood() throws RemoteException{
		CommodityVO vo=GoodTable.getSelectionModel().getSelectedItem();
		if(vo==null){
			Alert alert=new Alert(Alert.AlertType.WARNING,"请选择一个商品进行删除商品操作");
			alert.showAndWait();
		}
		else{
			ResultMessage rm=commodityBLService.delete(vo);
			if(rm==ResultMessage.SUCCESS){
				Alert alert=new Alert(Alert.AlertType.INFORMATION,"删除成功");
				alert.showAndWait();
				showGood();
			}
			else{
				Alert alert=new Alert(Alert.AlertType.INFORMATION,"删除失败");
				alert.showAndWait();
			}
		}
	}
	
	public void ModifyGood() throws RemoteException{
		CommodityVO target=GoodTable.getSelectionModel().getSelectedItem();
		int index=GoodTable.getSelectionModel().getSelectedIndex();
		if(target==null){
			Alert warning=new Alert(Alert.AlertType.WARNING,"请选中一个商品进行操作");
			warning.showAndWait();
		}
		else{
			CommodityVO vo=GoodModifyui.show();
			if(GoodModifyui.getAccess()){
				target.setGoodNum(vo.getGoodNum());
				target.setGoodRecentBP(vo.getGoodRecentBP());
				target.setGoodRecentRP(vo.getGoodRecentRP());
				target.setGoodBuyPrice(vo.getGoodRecentBP());
				target.setGoodRetailPrice(vo.getGoodRecentRP());
				ResultMessage rm = commodityBLService.update(target);
				if(rm==ResultMessage.SUCCESS){
					Alert information=new Alert(Alert.AlertType.INFORMATION,"修改成功");
					information.showAndWait();
					commodity.set(index, target);
				}
				else if(rm==ResultMessage.FAILED){
					Alert information=new Alert(Alert.AlertType.INFORMATION,"修改失败");
					information.showAndWait();
				}
			}
		}
	}
	
	public void SearchGood() throws RemoteException{
		String key=KeyWord.getText();
		if(key.equals("")){
			Alert warning=new Alert(Alert.AlertType.WARNING,"关键字不能为空");
			warning.showAndWait();
		}
		else{
			ArrayList<CommodityVO> list=commodityBLService.show();
			ObservableList<CommodityVO> list2=FXCollections.observableArrayList();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getGoodName().indexOf(key)>=0){
					list2.add(list.get(i));
				}
			}
			SearchResultController.setData(list2);
			SearchResultui.show();
			KeyWord.clear();
		}
	}
	
	public void BuildTypeTree(TreeItem<CommodityTypeVO> root){
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

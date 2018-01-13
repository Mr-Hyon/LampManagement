package presentation.commodityUI;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import vo.CommodityBillVO;
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
			String type="";	//用来区分是报损还是报溢单
			int n1=Integer.parseInt(vo.getGoodNum());
			int n2=Integer.parseInt(num);
			vo.setGoodNum(num);
			if(n1==n2){
				Alert info=new Alert(Alert.AlertType.INFORMATION,"数量一致，无需更改");
				info.showAndWait();
			}
			else{
				int delta=0;
				if(n1>n2){
					type="Lost";
					delta=n1-n2;
				}
				else{
					type="Earn";
					delta=n2-n1;
				}
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String date=sdf.format(new Date());
				CommodityVO good=new CommodityVO(vo.getGoodId(),vo.getGoodName(),vo.getGoodModel(),vo.getGoodNum(),vo.getGoodBuyPrice(),vo.getGoodRetailPrice());
				good.setGoodNum(String.valueOf(delta));
				good.setType(vo.getType());
				CommodityBillVO cbv=new CommodityBillVO("0000",date,type,good);
				ResultMessage rm2=commodityBLService.addCommodityBill(cbv);
				if(rm2==ResultMessage.SUCCESS){
					Alert alert=new Alert(Alert.AlertType.INFORMATION,"表单添加成功");
					alert.showAndWait();
				}
				else{
					Alert alert=new Alert(Alert.AlertType.INFORMATION,"表单添加失败");
					alert.showAndWait();
				}
				
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

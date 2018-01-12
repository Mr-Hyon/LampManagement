package presentation.commodityUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.CommodityVO;

public class SearchResultController {

	@FXML
	Button ReturnButton;
	
	@FXML
	TableView<CommodityVO> SearchGoodTable;
	
	@FXML
	TableColumn SearchGoodIdCol;
	
	@FXML
	TableColumn SearchGoodNameCol;
	
	@FXML
	TableColumn SearchGoodModelCol;
	
	@FXML
	TableColumn SearchGoodNumCol;
	
	@FXML
	TableColumn SearchGoodBPCol;
	
	@FXML
	TableColumn SearchGoodRPCol;
	
	@FXML
	TableColumn SearchGoodRBPCol;
	
	@FXML
	TableColumn SearchGoodRRPCol;
	
	private static ObservableList<CommodityVO> data=FXCollections.observableArrayList();
	
	public void initialize(){
		SearchGoodTable.setEditable(true);
		SearchGoodIdCol.setCellValueFactory(new PropertyValueFactory<>("goodId"));
		SearchGoodNameCol.setCellValueFactory(new PropertyValueFactory<>("goodName"));
		SearchGoodModelCol.setCellValueFactory(new PropertyValueFactory<>("goodModel"));
		SearchGoodNumCol.setCellValueFactory(new PropertyValueFactory<>("goodNum"));
		SearchGoodBPCol.setCellValueFactory(new PropertyValueFactory<>("goodBuyPrice"));
		SearchGoodRPCol.setCellValueFactory(new PropertyValueFactory<>("goodRetailPrice"));
		SearchGoodRBPCol.setCellValueFactory(new PropertyValueFactory<>("goodRecentBP"));
		SearchGoodRRPCol.setCellValueFactory(new PropertyValueFactory<>("goodRecentRP"));
		SearchGoodTable.setItems(data);
	}
	
	public void Return(){
		SearchResultui.hide();
		data.clear();
	}
	
	public static void setData(ObservableList<CommodityVO> transfer){
		data=transfer;
	}
}

package presentation.accountUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.AccountVO;

public class AccountShowController {
	
	@FXML
	Button ReturnButton;
	
	@FXML
	TableView<AccountVO> SearchAccountTable;
	
	@FXML
	TableColumn SearchAccountName;
	
	@FXML
	TableColumn SearchAccountCash;
	
	private static ObservableList<AccountVO> data=FXCollections.observableArrayList();
	
	public void initialize(){
		SearchAccountTable.setEditable(true);
		SearchAccountName.setCellValueFactory(new PropertyValueFactory<>("AccountName"));
		SearchAccountCash.setCellValueFactory(new PropertyValueFactory<>("AccountCash"));
		SearchAccountTable.setItems(data);
	}
	
	public void Return(){
		AccountShowui.hide();
		data.clear();
	}
	
	public static void setData(ObservableList<AccountVO> transfer){
		data=transfer;
	}

}

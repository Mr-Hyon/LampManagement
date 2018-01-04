package presentation.commodityUI;

import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import vo.CommodityTypeVO;

public class CommodityManageController {
	
	@FXML
	TreeTableView<CommodityTypeVO> GoodTypeTree;
	
	@FXML
	TreeTableColumn GoodTypeCol;
	
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
	
	private List<String> GoodType=Arrays.<String>asList(
			new String("商品类别b"),
			new String("商品类别c"),
			new String("商品类别d")
			);
			
	
	public void initialize(){
		CommodityTypeVO mainType=new CommodityTypeVO(null,"0001","Type A");
		TreeItem<CommodityTypeVO> root=new TreeItem<>(mainType);
		GoodTypeTree.setRoot(root);
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

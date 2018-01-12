package presentation.commodityUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SearchResultui {
		public static Stage SearchResultStage;
		
			private SearchResultui(){
				try{
					Parent root=FXMLLoader.load(getClass().getResource("SearchResultui.fxml"));
					Scene scene=new Scene(root);
					SearchResultStage=new Stage();
					SearchResultStage.setTitle("查询结果");
					SearchResultStage.setScene(scene);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		
			public static void show(){
				new SearchResultui();
				SearchResultStage.show();
			}
		
			public static void hide(){
				SearchResultStage.hide();
			}
}

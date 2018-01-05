package presentation.accountUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountShowui {
	public static Stage AccountShowStage;
	
		private AccountShowui(){
			try{
				Parent root=FXMLLoader.load(getClass().getResource("AccountShowui.fxml"));
				Scene scene=new Scene(root);
				AccountShowStage=new Stage();
				AccountShowStage.setTitle("查询结果");
				AccountShowStage.setScene(scene);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
		public static void show(){
			new AccountShowui();
			AccountShowStage.show();
		}
	
		public static void hide(){
			AccountShowStage.hide();
		}
	}

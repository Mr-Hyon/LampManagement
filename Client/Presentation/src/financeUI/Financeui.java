package financeUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Financeui {
	
	public static Stage FinanceStage;
	
	private static String operator;

	private Financeui() {
		try{
			Parent root=FXMLLoader.load(Financeui.class.getResource("/financeUI/Financeui.fxml"));
			Scene scene = new Scene(root);
			FinanceStage=new Stage();
			FinanceStage.setTitle("财务管理系统");
			FinanceStage.setScene(scene);
			//FinanceStage.show();
			} catch(Exception e){
				e.printStackTrace();
			}
	}
	
	public static void setOperator(String UserName){
		operator=UserName;
	}
	
	public static void show(){
		new Financeui();
		FinanceStage.show();
	}
	
	public static void hide(){
		FinanceStage.hide();
	}

}

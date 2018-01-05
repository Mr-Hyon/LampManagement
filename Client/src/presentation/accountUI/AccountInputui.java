package presentation.accountUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vo.AccountVO;

public class AccountInputui {
	
public static Stage AccountInputStage;

	private static AccountVO vo;
	private static boolean confirm;
	
	private AccountInputui(){
		confirm=false;
		try{
			Parent root=FXMLLoader.load(getClass().getResource("AccountInputui.fxml"));
			Scene scene=new Scene(root);
			AccountInputStage=new Stage();
			AccountInputStage.setTitle("修改账户");
			AccountInputStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static AccountVO show(){
		new AccountInputui();
		AccountInputStage.showAndWait();
		return getData();
	}
	
	public static void setAccess(boolean bool){
		confirm=bool;
	}
	
	public static boolean getAccess(){
		return confirm;
	}
	
	public static void setData(String name,String cash){
		vo=new AccountVO(name,cash);
	}
	
	public static AccountVO getData(){
		return vo;
	}
	
	public static void hide(){
		AccountInputStage.hide();
		
	}

}

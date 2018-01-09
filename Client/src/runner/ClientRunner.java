package runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.RemoteHelper;

public class ClientRunner extends Application {
	
	private static RemoteHelper remoteHelper;

	@Override
	public void start(Stage primaryStage) throws Exception {
			Parent root=FXMLLoader.load(getClass().getResource("/presentation/userUI/Loginui.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Welcome");
			primaryStage.setScene(scene);
			primaryStage.show();
			presentation.userUI.Loginui.LoginStage=primaryStage;
	}
	
	private static void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://127.0.0.1:8887/DataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {		
		//linkToServer();
		launch(args);
	}

}

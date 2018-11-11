package application;
	
import java.io.IOException;

import application.controller.Logincontroller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.PopupWindow.AnchorLocation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	BorderPane root;
	private Stage primaryStage;
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("로그인");
		try { 
			 initLoginLayout();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		showLoginview();
	}
	public void initLoginLayout() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
		root = (BorderPane) loader.load();
		Scene scene = new Scene(root,600,300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void showLoginview() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/LoginView.fxml"));
		try {
			AnchorPane loginView=(AnchorPane) loader.load();
			root.setCenter(loginView);
			
			Logincontroller controller = loader.getController();
			if(controller != null) {
				controller.setMainapp(this);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
				
	}
	public static void main(String[] args) {
		launch(args);
	}
}

package application.controller;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.Scanner;
import java.util.function.Function;

import javax.annotation.Resources;

import org.json.JSONObject;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Logincontroller {

	@FXML
	private TextField idTextField;

	@FXML
	private TextField pwTextField;

	@FXML
	private Button Loginbutton;

	@FXML
	private Button joinbutton;


	@FXML
	private Main main;

	public Logincontroller() {
		//		System.out.println("Logincontroller()");
	}

	@FXML
	private void initialize() {
		//		System.out.println("initialize()");
	}
	public void setMainapp(Main main) {
		this.main = main;
	}

	@FXML
	private void handleLoginButton() {
		System.out.println("클릭");
		String loginUrl = "http://game.bacoder.kr/login.jsp?login=suhan&pwd=1111";
		try(Scanner scanner = new Scanner(new URL(loginUrl).openStream(),"UTF-8")){
			String result = scanner.next();
			JSONObject json = new JSONObject(result);
			if(json.getInt("id")>0) {
				System.out.println("succes");
			}else {
				System.out.println("fail");
			}
		}catch (MalformedInputException e) {

		}catch (IOException e) {

		}
	}
	
	@FXML
	
	    public void handleJoinButton(ActionEvent event) {
	        Parent root;
	        try {
	            root = FXMLLoader.load(getClass().getClassLoader().getResource("Joinview.fxml"), Resources);
	            Stage stage = new Stage();
	            stage.setTitle("My New Stage Title");
	            stage.setScene(new Scene(root, 450, 450));
	            stage.show();
	            // Hide this current window (if this is what you want)
	            ((Node)(event.getSource())).getScene().getWindow().hide();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	







}

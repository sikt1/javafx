package application.controller;

import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.Scanner;

import org.json.JSONObject;

import application.Main;
import javafx.fxml.FXML;

public class Logincontroller {
	
	@FXML
	private TextField idTextField;
	
	@FXML
	private TextField pwTextField;
	
	@FXML
	private Button Loginbutton;
	
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
		this.main=main;
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
	
	

}

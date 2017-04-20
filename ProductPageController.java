package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProductPageController {
	
	@FXML
	private Button IpadButton;
	
	@FXML
	private Button	HeadsetButton;

	@FXML
	private Button ApplewatchButton;
	
	@FXML
	private Button MouseButton;
	
	@FXML
	private Button Profile;
	
	private java.sql.Connection con;
	private java.sql.PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs =null;
	
	public void ipadClick(){
		Stage stage = (Stage) IpadButton.getScene().getWindow();
		stage.setTitle("Order");
		// load mainMenu scene
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/Order.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root,900,700);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void headsetClick(){
		Stage stage = (Stage) HeadsetButton.getScene().getWindow();
		stage.setTitle("Order");
		// load mainMenu scene
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/Order.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root,900,700);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void applewatchClick(){
		Stage stage = (Stage) ApplewatchButton.getScene().getWindow();
		stage.setTitle("Order");
		// load mainMenu scene
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/Order.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root,900,700);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void mouseClick(){
		Stage stage = (Stage) MouseButton.getScene().getWindow();
		stage.setTitle("Order");
		// load mainMenu scene
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/Order.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root,900,700);
		stage.setScene(scene);
		stage.show();
		
	}

}



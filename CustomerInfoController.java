package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerInfoController {

	@FXML
	private Button Submit;
	@FXML
	private Button Cancel;

	@FXML
	private Label firstName;
	@FXML
	private TextField firstNameText;

	@FXML
	private Label lastName;
	@FXML
	private TextField lastNameText;

	@FXML
	private Label email;
	@FXML
	private TextField emailText;;

	@FXML
	private Label phoneNumber;
	@FXML
	private TextField phoneNumbertText;

	@FXML
	private Label address;
	@FXML
	private TextField addressText;

	@FXML
	private Label zip;
	@FXML
	private TextField zipText;

	@FXML
	private Label city;
	@FXML
	private TextField cityText;

	@FXML
	private Label state;
	@FXML
	private TextField stateText;

	@FXML
	private Label country;
	@FXML
	private TextField countryText;

	@FXML
	private Label username;
	@FXML
	private TextField usernameText;

	@FXML
	private Label password;
	@FXML
	private TextField passwordText;

	private sqlConnector SQLConnection = new sqlConnector();
	private Connection conn;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public void addInfo() {
		
	}
	public void SubmitClicked(){
		SQLConnection.Connector();
		String fname = this.firstNameText.getText();
		String lname = this.lastNameText.getText();
		String e_mail = this.emailText.getText();
		String p_num = this.phoneNumbertText.getText();
		String ad = this.addressText.getText();
		String city = this.cityText.getText();
		String zip = this.zipText.getText();
		String state = this.stateText.getText();
		String country = this.countryText.getText();
		String username = this.usernameText.getText();
		String pword = this.passwordText.getText();
		
		
		try {
			String updateQuery = "INSERT INTO LOG_IN(user_name, P_word)"+"values(?,?)";
			ps = sqlConnector.Connector().prepareStatement(updateQuery);
			ps.setString(1, username);
			ps.setString(2, pword);
			ps.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			String inputQuery = "INSERT INTO Customer (first_name, last_name, email, phone_num, address, city, zip, state, country, username, passw)" +
					"values(?,?,?,?,?,?,?,?,?,?,?)";
			ps =  sqlConnector.Connector().prepareStatement(inputQuery);
			
			ps.setString(1, fname);
			ps.setString(2,lname);
			ps.setString(3,e_mail);
			ps.setString(4,p_num);
			ps.setString(5,ad);
			ps.setString(6,city);
			ps.setString(7,zip);
			ps.setString(8,state);
			ps.setString(9,country);
			//ps.setInt(10, login_id);
			ps.setString(10,username);
			ps.setString(11,pword);
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("inserted");
		
		
	}
	public void cancelClick(){
		Stage stage = (Stage)Cancel.getScene().getWindow();
		stage.close();
	}

	
}

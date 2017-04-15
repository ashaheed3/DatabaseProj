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
	
	public void addInfo() throws IOException, SQLException {
		String f = this.firstNameText.getText();
		String l = this.lastNameText.getText();
		String e_mail = this.emailText.getText();
		String p_num = this.passwordText.getText();
		String a = this.addressText.getText();
		String z = this.zipText.getText();
		String c = this.cityText.getText();
		String s = this.stateText.getText();
		String country = this.countryText.getText();
		String u = this.usernameText.getText();
		String pa = this.passwordText.getText();
		
		Submit.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				SQLConnection.Connector();
				System.out.println("after sql connection");
				String inputquery = "insert into Customer(first_name, last_name, email, phone_number, address,"
						+ "city, zip, state, country, username, passw)"+"values(?,?,?,?,?,?,?,?,?,?,?)";
				try {
					ps.setString(1, f);
					ps.setString(2, l);
					ps.setString(3, e_mail);
					ps.setString(4, p_num);
					ps.setString(5, a);
					ps.setString(6, c);
					ps.setString(7, z);
					ps.setString(8, s);
					ps.setString(9, country);
					ps.setString(10, u);
					ps.setString(11, pa);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("e1");
				}
				System.out.println("info added");
				
			}
		});
	}

	
}

package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OrderController {
	
	@FXML
	private Label firstNameLabel;
	
	@FXML
	private Label lastNameLabel;
	
	@FXML 
	private Label creditCardNumberLabel;
	
	@FXML 
	private Label creditCardTypeLabel;

	@FXML 
	private Label expirationDateLabel;
	
	@FXML 
	private TextField firstnameText;
	
	@FXML 
	public TextField lastnameText;
	
	@FXML 
	private TextField creditCardNumberText;
	
	@FXML 
	private TextField expirationText;
	
	@FXML 
	private TextField cardTypeText;
	
	@FXML 
	private Button purchase;
	
	@FXML 
	private Button cancel;
	//////////////////////////////////////////////////
	
	@FXML
	private Label firstNameLabel2;
	
	@FXML
	private Label lastNameLabel2;
	
	@FXML
	private Label orderIDLabel;
	
	@FXML
	private Label productNameLabel;
	
	@FXML
	private Label creditcardNum;
//////////////////////////////////////////////////
	
	private java.sql.PreparedStatement ps = null;
	private ResultSet rs = null;
	private java.sql.Statement st = null;
	private Connection con;
	
	public void purchaseClick(){
		
		String lastname = this.lastnameText.getText();
		String firstname = this.firstnameText.getText();
		String creditcardnumber = this.creditCardNumberText.getText();
		String creditcardtype = this.cardTypeText.getText();
		String expirationdate = this.expirationText.getText();
		//connects to the database using sqlConnector class.
		con = sqlConnector.Connector();
		
		//extracts customer id that is the same as the last name being entered.
		String extractCid = "select idCustomer FROM Customer Where last_name=?";
		try {
			ps = con.prepareStatement(extractCid);
			ps.setString(1, lastname);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sets the variable cid  as the idcustomer.
		int cid=0;
		try {
			while(rs.next()){
				cid = rs.getInt("idCustomer");
			}
			System.out.println(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//insert payment_info.
		
		String insert_cid = "insert into Payment_info(card_num, name_on_card, expiration_date, customer_id)"+"value(?,?,?,?)";
		try {
			ps=con.prepareStatement(insert_cid);
			ps.setString(1, creditcardnumber);
			ps.setString(2, lastname);
			ps.setString(3, expirationdate);
			ps.setInt(4, cid);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String productNamequery = "select product_name FROM Product Where idProduct = 1";
		String pname = "";
		try {
			ps=con.prepareStatement(productNamequery);
			rs = ps.executeQuery(productNamequery);
			
			while(rs.next()){
				pname = rs.getString("product_name");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(pname);
		
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Order placed for " + firstname+" "+lastname+ ". Thank you!");
		alert.showAndWait();
		
		
		
	/*
		/////////////////////opens order confirm page/////////////////////////////////
		Stage stage = (Stage) purchase.getScene().getWindow();
		stage.setTitle("Order Confirmation");
		// load mainMenu scene
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/orderConfirm.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(root,900,700);
		stage.setScene(scene);
		stage.show();
		this.firstNameLabel2.setText(firstname);
		this.lastNameLabel2.setText(lastname);
		this.creditcardNum.setText(creditcardnumber);
		this.productNameLabel.setText(pname);
*/
		
	}
	public void cancelClick(){
		Stage stage = (Stage) cancel.getScene().getWindow();

		stage.setTitle("Products");

		// load mainMenu scene
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/ProductPage.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scene scene = new Scene(root,900,700);
		stage.setScene(scene);
		stage.show();
	}

}

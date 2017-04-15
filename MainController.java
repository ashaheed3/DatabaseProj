package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
	

	@FXML
	private Button signInBttn;

	@FXML
	private Label statusLbl;

	@FXML
	private TextField userNameTxt;

	@FXML
	private PasswordField passwordTxt;

	private Stage stage;
	private Parent root;
	private LoginModel loginModel = new LoginModel();

	// username: admin password: admin
	public void Login(ActionEvent actionEvent) throws IOException, SQLException {
		
			if (loginModel.isLogin(userNameTxt.getText(), passwordTxt.getText())) {
				
					stage = (Stage) signInBttn.getScene().getWindow();

					stage.setTitle("Products");

					// load mainMenu scene
					root = FXMLLoader.load(getClass().getResource("/application/products.fxml"));

					Scene scene = new Scene(root, 600, 400);
					stage.setScene(scene);
					stage.show();
				
				} else if (loginModel.isUser(userNameTxt.getText())) {
				
					// correct username wrong password get 4 tries before lockout
					statusLbl.setText("Incorrect password, please try again!");
					
				
				} else if(userNameTxt.getText().equals("")) {
					statusLbl.setText("Please enter username!");
				} else 
					statusLbl.setText("Username does not exist!");
				


	}
	}

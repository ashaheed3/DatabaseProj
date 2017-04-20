package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;

public class testOrderController {
	
	
    
	@FXML
	private Label orderIdLbl;

    @FXML
	private Label orderDateLbl;
    
    @FXML
	private Label shipInfoLbl;
    
    @FXML
	private Label productsLbl;
    
    @FXML
	private Label orderTotLbl;
    
    private sqlConnector SQLConnection = new sqlConnector();	
	private Connection conn;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
    
    public void setOrderId(){
    	conn = SQLConnection.Connector();
    	
    	
		try {
			String getOrderID = "SELECT MAX(idOrder) FROM c_order";
			ps = conn.prepareStatement(getOrderID);
			rs = ps.executeQuery();
			
			
			 while(rs.next()){
				 orderIdLbl.setText(rs.getString("MAX(idOrder)"));   
		        }
		        rs.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    }
    
    public void setOrderDate(){
    	
    }
    
    public void setShipInfo(){
    	
    }

    public void setProducts(){
	
    }

    public void setOrderTot(){
	
    }
    
}

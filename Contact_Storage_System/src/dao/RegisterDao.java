package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import beans.RegisterBean;
import dbconnectivity.ConnectionProvider;

public class RegisterDao {
	
	public String userName = "";
	
	public String useCheck(RegisterBean registerBean) {
		this.userName=registerBean.getUser();
		try {
			
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement("select user_name from users where user_name=?");
			ps.setString(1, registerBean.getUser());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return "Same";
			}
			else {
				String status = useAdd(registerBean);
				return status;
			}
			
		}
		catch(Exception e) {
			return "Fail";
		}
	}
	
	public String useAdd(RegisterBean registerBean) {
		this.userName=registerBean.getUser();
		try {
			
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement("insert into users values(?,?,?,?)");
			ps.setString(1, registerBean.getUser());
			ps.setString(2, registerBean.getPass());
			ps.setString(3, registerBean.getQuestion());
			ps.setString(4, registerBean.getAnswer());
			
			int i=ps.executeUpdate();
			if(i>0) {
				String status = createTable(registerBean);
				return status;
			}
			else {
				return "Fail";
			}
			
		}
		catch(Exception e) {
			return "Fail";
		}
	}
	
	public String createTable(RegisterBean registerBean) {
		
		String tableName = "Contact_Dtls_"+userName;
		
		String sqlQuery = "CREATE TABLE "+tableName+" (Name VARCHAR2(30) not NULL, Mobile_No Number not NULL, Nick_Name VARCHAR2(20), Mail_ID VARCHAR2(50), Gender Varchar2(10), D_O_B Date, Note Varchar2(100),  PRIMARY KEY ( mobile_no ))";
		try {
			
			Connection c = ConnectionProvider.getConnection();
			Statement stmt = c.createStatement();
	        stmt.executeUpdate(sqlQuery);
			return "Success";
		}
		catch(Exception e) {
			return "Different";
		}
		
	}
}

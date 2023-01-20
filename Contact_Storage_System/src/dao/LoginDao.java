package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import beans.LoginBean;
import dbconnectivity.ConnectionProvider;


public class LoginDao {
	//LoginForm loginForm;
	public String useLogin(LoginBean loginBean) {
		try {
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement("select user_name, password from users where user_name=? and password=?");
			ps.setString(1, loginBean.getUser());
			ps.setString(2, loginBean.getPass());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				//ProfileStore prof = new ProfileStore("RRR");
				//prof.setUserName("RRR");
				return "Valid";
			}
			else {
				
				//JOptionPane.showConfirmDialog(null, "Invalid User Name & Password");
				return "Invalid";
			}
		}
		catch(Exception e) {
			return "Error";
		}
	}
	
}

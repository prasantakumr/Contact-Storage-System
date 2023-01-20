package dao;

import java.sql.*;
import beans.ChangeBean;
import dbconnectivity.ConnectionProvider;

public class ChangeDao {
	
	public String useChange(ChangeBean changeBean) {
		
		try {
			
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement("select user_name, password from users where user_name=? and password=?");
			ps.setString(1, changeBean.getUser());
			ps.setString(2, changeBean.getPass());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				//JOptionPane.showMessageDialog(null, rs.getString(1)+"OK"+rs.getString(2));
				String status = useUpdate(changeBean);
				return status;
			}
			else {
				
				return "Different";
			}
			
		}
		catch(Exception e) {
			return "Fail";
		}
		
	}
	
	public String useUpdate(ChangeBean changeBean) {
		String fatchUser = (changeBean.getUser()).toLowerCase();
		
		try {
			
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement("update users set user_name=?, password=?, question=?, answer=? where lower(user_name)=?");
			
			ps.setString(1, changeBean.getNewUser());
			ps.setString(2, changeBean.getNewPass());
			ps.setString(3, changeBean.getQuestion());
			ps.setString(4, changeBean.getAnswer());
			ps.setString(5, fatchUser);
			
			int i=ps.executeUpdate();
			if(i>0) {
				
				return "Success";
			}
			else {
				
				return "Fail";
			}
		}
		catch(Exception e) {
			return "Fail";
		}
	}
}

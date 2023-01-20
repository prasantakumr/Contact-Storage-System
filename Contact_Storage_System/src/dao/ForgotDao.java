package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import beans.ForgotBean;
import dbconnectivity.ConnectionProvider;


public class ForgotDao {
	public String useView(ForgotBean forgotBean) {
		String dUser = null;
		String dPass = null;
		String dAns = null;
		String user = (forgotBean.getUser()).toLowerCase();
		String ans = (forgotBean.getAnswer()).toLowerCase();
		try {
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement("select lower(user_name), password, lower(answer) from users where user_name=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dUser = rs.getString(1);
				dPass = rs.getString(2);
				dAns = rs.getString(3);
			}
			if(ans.equalsIgnoreCase(dAns)) {
				JOptionPane.showMessageDialog(null, "User Name : "+dUser+"\nPassword   : "+dPass);
				return "Success";
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Incorrect Answer");
				return "Fail";
			}
		}
		catch(Exception e) {
			return "Fail";
		}
	}
	
	
	public String useQuestion(ForgotBean forgotBean) {
		String question = null;
		String user = (forgotBean.getUser()).toLowerCase();;
		try {
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement("select question from users where user_name=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				question = rs.getString(1); 
			}
			return question;
		}
		catch(Exception e) {
			return "Fail";
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.spire.data.table.DataTable;
import com.spire.data.table.common.JdbcAdapter;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import beans.DashBean;
import dbconnectivity.ConnectionProvider;


public class DashDao {
	
	
	public ArrayList al;

	
	public String useCheck(DashBean dBean) {
		
		String userName = dBean.getUserName();
		String tableName = "Contact_Dtls_"+userName;
		String sqlQuery = "select mobile_no from "+tableName+" where mobile_no=?";
		
		String checkMobile = dBean.getMobile();
		String dMobile = null;
		try {
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement(sqlQuery);
			ps.setString(1, checkMobile);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				dMobile = rs.getString(1);
	         }
			if(checkMobile.equals(dMobile)) {
				return "Same";
			}
			else {
				return "NotSame";
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Error";
		}
		
		
	}
	
	public String useAdd(DashBean dBean) {
		
		String userName = dBean.getUserName();
		String tableName = "Contact_Dtls_"+userName;
		String sqlQuery = "insert into "+tableName+" values(?,?,?,?,?,?,?)";
		try {
			
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement(sqlQuery);
			ps.setString(1, dBean.getName());
			ps.setString(2, dBean.getMobile());
			ps.setString(3, dBean.getNick());
			ps.setString(4, dBean.getMail());
			ps.setString(5, dBean.getGender());
			ps.setDate(6, dBean.getDOB());
			ps.setString(7, dBean.getNote());
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
	
	
	
	public String useDelete(DashBean dBean) {
		String userName = dBean.getUserName();
		String tableName = "Contact_Dtls_"+userName;
		String sqlQuery = "delete from "+tableName+" where lower(name)=?";
		String fatchName = (dBean.getName()).toLowerCase();
		try {
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement(sqlQuery);
			ps.setString(1, fatchName);
			int i=ps.executeUpdate();
			if(i>0) {
				return "Success";
			}
			else {
				return "Fail";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		
	}
	
	
	public String useUpdate(DashBean dBean) {

		
		String userName = dBean.getUserName();
		String tableName = "Contact_Dtls_"+userName;
		String sqlQuery = "update "+tableName+" set name=?, mobile_no=?, nick_name=?, mail_id=?, gender=?, d_o_b=?, note=? where lower(name)=?";
		
		String fatchName = (dBean.getName()).toLowerCase();
		try {
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement(sqlQuery);
			ps.setString(1, dBean.getName());
			ps.setString(2, dBean.getMobile());
			ps.setString(3, dBean.getNick());
			ps.setString(4, dBean.getMail());
			ps.setString(5, dBean.getGender());
			ps.setDate(6, dBean.getDOB());
			ps.setString(7, dBean.getNote());
			ps.setString(8, fatchName);
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
	
	public ArrayList useView(DashBean dBean) {
		
		String userName = dBean.getUserName();
		String tableName = "Contact_Dtls_"+userName;
		String sqlQuery = "select * from "+tableName+" where lower(name)=?";
		
		al = new ArrayList();
		String fatchName = (dBean.getName()).toLowerCase();
		try {
			Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement(sqlQuery);
			ps.setString(1, fatchName);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				al.add(rs.getString(1));
				al.add(rs.getString(2));
				al.add(rs.getString(3));
				al.add(rs.getString(4));
				al.add(rs.getString(5));
				al.add(rs.getDate(6));
				al.add(rs.getString(7));
	         }
			return al;
		}
		catch(Exception e) {
			e.printStackTrace();
			return al;
		}
		
		
	}
	
	public String useExport(String filePath, String userName) {
		
		
		String tableName = "Contact_Dtls_"+userName;
		String sqlQuery = "select * from "+tableName+" order by lower(name)";
		
		//Create a Workbook object
        Workbook wb = new Workbook();

        //Get the first worksheet
        Worksheet sheet = wb.getWorksheets().get(0);

        //Create a DataTable object
        DataTable dataTable = new DataTable();
        
        try {
        	Connection c = ConnectionProvider.getConnection();
			PreparedStatement ps = c.prepareStatement(sqlQuery);
			ResultSet rs =ps.executeQuery();
			JdbcAdapter jdbcAdapter = new JdbcAdapter();

            //Export data from database to datatable
            jdbcAdapter.fillDataTable(dataTable, rs);
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
      //Write datatable to the worksheet
        sheet.insertDataTable(dataTable, true, 1, 1);

        //Auto fit column width
        sheet.getAllocatedRange().autoFitColumns();

        //Save to an Excel file
        wb.saveToFile(filePath+"/"+tableName+".xlsx");
        
        return "Success";
		
	}
	
}

package listeners;

import java.awt.event.*;
import javax.swing.JOptionPane;
import beans.LoginBean;
import dao.LoginDao;
import gui_forms.DashBoardForm;
import gui_forms.HomeFrame;
import gui_forms.LoginForm;

public class LoginListener implements ActionListener{
	
	LoginForm loginForm;
	public String userName;
	
	public LoginListener(LoginForm loginForm) {
		
		this.loginForm = loginForm;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o==loginForm.loginBtn) {
			String user = loginForm.userText.getText();
			String pass = loginForm.passText.getText();
			this.userName = user;
			LoginBean loginBean = new LoginBean(user, pass);
			LoginDao loginDao = new LoginDao();
			String status = loginDao.useLogin(loginBean);
			if(status.equalsIgnoreCase("Valid")) {
				loginForm.lFrame.setVisible(false);
				new DashBoardForm(user).dFrame.setVisible(true);
			} 
			else if(status.equalsIgnoreCase("Invalid")) {
				JOptionPane.showMessageDialog(null, "Invalid User Name & Password");
			} 
			else if(status.equalsIgnoreCase("Error")) {
				JOptionPane.showMessageDialog(null, "Something Went Wrong");
			}
			
		} 
		else if (o == loginForm.clearBtn) {
			loginForm.userText.setText("");
			loginForm.passText.setText("");
		}
		else if (o == loginForm.backBtn) {
			new HomeFrame().hFrame.setVisible(true);
			loginForm.lFrame.setVisible(false);
		}
	}
	
	

}

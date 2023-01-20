package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import beans.ForgotBean;
import dao.ForgotDao;
import gui_forms.ForgotForm;
import gui_forms.LoginForm;

public class ForgotListener implements ActionListener{

	ForgotForm forgotForm;
	
	
	public ForgotListener(ForgotForm forgotForm) {
		this.forgotForm = forgotForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == forgotForm.viewBtn) {
			String ans = forgotForm.ansText.getText();
			String user = forgotForm.userText.getText();
			String qst = forgotForm.secLabel.getText();
			
			if (qst.equals("Show Sequerity Question")) {
				JOptionPane.showMessageDialog(null, "Please Check the Security Question");
			}
			else {
				if (ans.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Answer of the Security Question");
				}
				else {
					ForgotBean forgotBean = new ForgotBean();
					forgotBean.setAnswer(ans);
					forgotBean.setUser(user);
					ForgotDao forgotDao = new ForgotDao();
					String status = forgotDao.useView(forgotBean);
					if(status.equalsIgnoreCase("Success")) {
						forgotForm.fFrame.setVisible(false);
						new LoginForm().lFrame.setVisible(true);
					}
					else {
						forgotForm.fFrame.setVisible(true);
						forgotForm.ansText.setText("");
					}
				}
			}
		}
		
		else if(o == forgotForm.backBtn) {
			new LoginForm().lFrame.setVisible(true);
			forgotForm.fFrame.setVisible(false);
		}
		
		else if(o == forgotForm.qstBtn) {
			String user = forgotForm.userText.getText();
			if (user.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter User Name");
			}
			else {
				ForgotBean forgotBean = new ForgotBean();
				forgotBean.setUser(user);
				ForgotDao forgotDao = new ForgotDao();
				String status = forgotDao.useQuestion(forgotBean);
				if(status.equalsIgnoreCase("Fail")) {
					forgotForm.fFrame.setVisible(true);
					JOptionPane.showMessageDialog(null, "Please Wrong User Name");
					forgotForm.userText.setText("");
				}
				else {
					forgotForm.fFrame.setVisible(true);
					//forgotForm.question = status;
					forgotForm.secLabel.setText(status);
				}
			}
		}
	}
	
}

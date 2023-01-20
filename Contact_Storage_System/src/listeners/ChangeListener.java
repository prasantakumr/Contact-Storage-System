package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import beans.ChangeBean;
import dao.ChangeDao;
import gui_forms.ChangeForm;
import gui_forms.LoginForm;

public class ChangeListener implements ActionListener{

	

	ChangeForm changeForm;
	
	public ChangeListener(ChangeForm changeForm) {
		this.changeForm = changeForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if(o == changeForm.updateBtn) {
			String user = changeForm.userText.getText();
			String pass = changeForm.passText.getText();
			String newUser = changeForm.newUserText.getText();
			String newPass = changeForm.newPassText.getText();
			String question = changeForm.qstText.getText();
			String answer = changeForm.ansText.getText();
			
			if (user.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter User Name.");
			}
			else if(newUser.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter New User Name.");
			}
			else if(pass.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Password.");
			}
			else if(newPass.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter New Password.");
			}
			else if(question.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Security Question.");
			}
			else if(answer.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Security Answer.");
			}
			else {
				ChangeBean changeBean = new ChangeBean();
				changeBean.setUser(user);
				changeBean.setPass(pass);
				changeBean.setNewUser(newUser);
				changeBean.setNewPass(newPass);
				changeBean.setQuestion(question);
				changeBean.setAnswer(answer);
				ChangeDao changeDao = new ChangeDao();
				String msg = changeDao.useChange(changeBean);
				
				if(msg.equalsIgnoreCase("Success")) {
					JOptionPane.showMessageDialog(null, "Successfully User Details Changed ...");
					new LoginForm().lFrame.setVisible(true);
					
				}
				else if (msg.equalsIgnoreCase("Different")){
					JOptionPane.showMessageDialog(null, "Invalid User Name & Password...");
				}
				else if(msg.equalsIgnoreCase("Fail")) {
					JOptionPane.showMessageDialog(null, "Something Went Wrong ...");
				}
			}
		}
		else if(o == changeForm.clearBtn) {
			changeForm.newUserText.setText("");
			changeForm.newPassText.setText("");
			changeForm.userText.setText("");
			changeForm.passText.setText("");
			changeForm.qstText.setText("");
			changeForm.ansText.setText("");
		}
		else if(o == changeForm.backBtn) {
			new LoginForm().lFrame.setVisible(true);
			changeForm.uFrame.setVisible(false);
		}
	}

}

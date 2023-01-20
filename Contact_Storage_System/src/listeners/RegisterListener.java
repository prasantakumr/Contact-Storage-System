package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import beans.RegisterBean;
import dao.RegisterDao;
import gui_forms.LoginForm;
import gui_forms.RegisterForm;

public class RegisterListener implements ActionListener{

	RegisterForm registerForm;
	
	public RegisterListener(RegisterForm registerForm) {
		this.registerForm = registerForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if(o == registerForm.registerBtn) {
			String user = registerForm.userText.getText();
			String pass = registerForm.passText.getText();
			String newPass = registerForm.newPassText.getText();
			String question = registerForm.qstText.getText();
			String answer = registerForm.ansText.getText();
			
			if (user.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter User Name.");
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
			else if(pass.equals(newPass) == false) {
				JOptionPane.showMessageDialog(null, "Password and Verify Password is not Matched.");
			}
			else {
				RegisterBean registerBean = new RegisterBean();
				registerBean.setUser(user);
				registerBean.setPass(pass);
				registerBean.setNewPass(newPass);
				registerBean.setQuestion(question);
				registerBean.setAnswer(answer);
				RegisterDao registerDao = new RegisterDao();
				String msg = registerDao.useCheck(registerBean);
				
				if(msg.equalsIgnoreCase("Success")) {
					JOptionPane.showMessageDialog(null, "Successfully User Created ...");
					registerForm.rFrame.setVisible(false);
					new LoginForm().lFrame.setVisible(true);
					
				}
				else if (msg.equalsIgnoreCase("Same")){
					JOptionPane.showMessageDialog(null, "User Name Already Exist ...");
				}
				else if (msg.equalsIgnoreCase("Different")){
					JOptionPane.showMessageDialog(null, "Something Went Wrong ...");
				}
				else if(msg.equalsIgnoreCase("Fail")) {
					JOptionPane.showMessageDialog(null, "Something Went Wrong ...");
				}
			}
		}
		else if(o == registerForm.clearBtn) {
			registerForm.newPassText.setText("");
			registerForm.userText.setText("");
			registerForm.passText.setText("");
			registerForm.qstText.setText("");
			registerForm.ansText.setText("");
		}
		else if(o == registerForm.backBtn) {
			new LoginForm().lFrame.setVisible(true);
			registerForm.rFrame.setVisible(false);
		}
	}

}

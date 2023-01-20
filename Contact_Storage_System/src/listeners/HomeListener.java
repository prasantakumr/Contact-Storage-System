package listeners;

import java.awt.event.*;
import gui_forms.*;

public class HomeListener implements ActionListener {

	HomeFrame homeFrame;
	public HomeListener (HomeFrame hFrame) {
		this.homeFrame = hFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if (o==homeFrame.loginBtn) {
			new LoginForm().lFrame.setVisible(true);
			homeFrame.hFrame.setVisible(false);
		} 
		else if (o == homeFrame.changeBtn) {
			new ChangeForm().uFrame.setVisible(true);
			homeFrame.hFrame.setVisible(false);
		}
		else if (o == homeFrame.registerBtn) {
			new RegisterForm().rFrame.setVisible(true);
			homeFrame.hFrame.setVisible(false);
		}
		else if (o == homeFrame.forgotBtn) {
			new ForgotForm().fFrame.setVisible(true);
			homeFrame.hFrame.setVisible(false);
		}
		else if (o == homeFrame.hintBtn) {
//			homeFrame.hintALabel.setText("This is The Contact Storing App");
//			homeFrame.hintBLabel.setText("First Register Then Use This Application");
		}
	}
	
}
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import beans.DashBean;
import dao.DashDao;
import gui_forms.DashBoardForm;
import gui_forms.HomeFrame;
import gui_forms.LoginForm;
import gui_forms.PathFrame;

public class DashBoardListener implements ActionListener {

	DashBoardForm dashForm;
	
	

	public DashBoardListener(DashBoardForm dashForm) {
		this.dashForm = dashForm;
	}
	
	

	public void clearField() {
		dashForm.nameText.setText("");
		dashForm.mobileText.setText("");
		dashForm.nickText.setText("");
		dashForm.noteArea.setText("");
		dashForm.mailText.setText("");
		dashForm.male.setSelected(false);
		dashForm.female.setSelected(false);
		dashForm.dobDatePicker.getModel().setValue(null);

		dashForm.nameText.setEditable(true);
		dashForm.mobileText.setEditable(true);
		dashForm.nickText.setEditable(true);
		dashForm.noteArea.setEditable(true);
		dashForm.mailText.setEditable(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String userName = dashForm.user;
		Object o = e.getSource();
		// For Add Button
		if (o == dashForm.addBtn) {
			String name = dashForm.nameText.getText();
			String mobile = dashForm.mobileText.getText();
			String nick = dashForm.nickText.getText();
			String mail = dashForm.mailText.getText();

			
			
			String gender;
			if (dashForm.male.isSelected()) {
				gender = "Male";
			} else if (dashForm.female.isSelected()) {
				gender = "Female";
			} else {
				gender = "";
			}

			// Refer DateMyCode Program to apply date fatch from window
			java.util.Date date = (java.util.Date) dashForm.dobDatePicker.getModel().getValue();
			java.sql.Date dob = new java.sql.Date(date.getTime());

			String note = dashForm.noteArea.getText();

			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Name");
			} else if (mobile.length() < 10) {
				if (mobile.length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter Mobile No");
				} else {
					JOptionPane.showMessageDialog(null,
							"You Entered " + mobile.length() + " Digit! \n Please Enter 10 Digit Mobile No");
				}

			} else if (mobile.length() > 10) {
				JOptionPane.showMessageDialog(null, "You Enter Incorrect Mobile No");
			}
			else if (gender.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Select Gender");
			}
//			else if(date.equals(null)) {
//				JOptionPane.showMessageDialog(null, "Please Select Date");
//			}
			else {
				DashBean dashBean = new DashBean();
				dashBean.setName(name);
				dashBean.setMobile(mobile);
				dashBean.setNick(nick);
				dashBean.setMail(mail);
				dashBean.setGender(gender);
				dashBean.setDOB(dob);
				dashBean.setNote(note);
				dashBean.setUserName(userName);
				DashDao dashDao = new DashDao();
				String msgCheck = dashDao.useCheck(dashBean);
				if(msgCheck.equals("Same")) {
					JOptionPane.showMessageDialog(null, "Mobile Number is Already Exist");
				}
				else if(msgCheck.equals("NotSame")) {
//					JOptionPane.showMessageDialog(null, "NotSame");
					String msg = dashDao.useAdd(dashBean);
					if (msg.equals("Success")) {
						JOptionPane.showMessageDialog(null, "Contact Saved Success...");
						clearField();
					} else {
						JOptionPane.showMessageDialog(null, "Somethig Went Wrong...");
					}
				}
				else if(msgCheck.equals("Error")) {
					JOptionPane.showMessageDialog(null, "Some Technical Error...!");
				}
			}
		}

		// For Delete Button
		else if (o == dashForm.deleteBtn) {

			String name = dashForm.nameText.getText();
			DashBean dashBean = new DashBean();
			dashBean.setName(name);
			dashBean.setUserName(userName);
			DashDao dashDao = new DashDao();
			String msg = dashDao.useDelete(dashBean);
			if (msg.equals("Success")) {
				JOptionPane.showMessageDialog(null, "Delete Success...");
				clearField();
			} else {
				JOptionPane.showMessageDialog(null, "Somethig Went Wrong...");
			}

		}

		// For Update Button
		else if (o == dashForm.updateBtn) {

			String name = dashForm.nameText.getText();
			String mobile = dashForm.mobileText.getText();
			String nick = dashForm.nickText.getText();
			String mail = dashForm.mailText.getText();

			String gender;
			if (dashForm.male.isSelected()) {
				gender = "Male";
			} else if (dashForm.female.isSelected()) {
				gender = "Female";
			} else {
				gender = "";
			}

			java.util.Date date = (java.util.Date) dashForm.dobDatePicker.getModel().getValue();
			java.sql.Date dob = new java.sql.Date(date.getTime());

			String note = dashForm.noteArea.getText();

			DashBean dashBean = new DashBean();
			dashBean.setName(name);
			dashBean.setMobile(mobile);
			dashBean.setNick(nick);
			dashBean.setMail(mail);
			dashBean.setGender(gender);
			dashBean.setDOB(dob);
			dashBean.setNote(note);
			dashBean.setUserName(userName);
			DashDao dashDao = new DashDao();
			String msg = dashDao.useUpdate(dashBean);

			if (msg.equals("Success")) {
				JOptionPane.showMessageDialog(null, "Update Success...");
				clearField();
			} else {
				JOptionPane.showMessageDialog(null, "Somethig Went Wrong...");
			}

		}

		// For View Button
		else if (o == dashForm.viewBtn) {

			String name = dashForm.nameText.getText();
			DashBean dashBean = new DashBean();
			dashBean.setName(name);
			dashBean.setUserName(userName);
			DashDao dashDao = new DashDao();
			ArrayList al = dashDao.useView(dashBean);
			if (al.size() > 0) {
				dashForm.nameText.setEditable(false);
				dashForm.mobileText.setEditable(false);
				dashForm.nickText.setEditable(false);
				dashForm.mailText.setEditable(false);
				dashForm.noteArea.setEditable(false);

				dashForm.nameText.setText((String) al.get(0));
				dashForm.mobileText.setText((String) al.get(1));
				dashForm.nickText.setText((String) al.get(2));
				dashForm.mailText.setText((String) al.get(3));

				String radio = (String) al.get(4);
				if (radio.equalsIgnoreCase("Male")) {
					dashForm.male.setSelected(true);
				} 
				else if (radio.equalsIgnoreCase("Male")) {
					dashForm.female.setSelected(true);
				}

				java.sql.Date dob = new java.sql.Date(((Date) al.get(5)).getTime());
				dashForm.model.setValue(dob);

				dashForm.noteArea.setText((String) al.get(6));

			} 
			else {
				JOptionPane.showMessageDialog(null, "No Record Found\nPlease Enter Currect Name");
			}

		}

		// For Export Button
		else if (o == dashForm.exportBtn) {
			
//			dashForm.dFrame.setVisible(true);
			new PathFrame(userName).pFrame.setVisible(true);
			
			
			
		}

		// For CLear Button
		else if (o == dashForm.clearBtn) {
			clearField();
		}

		// For Close Current Window and open Home Window
		else if (o == dashForm.backBtn) {
			new HomeFrame().hFrame.setVisible(true);
			dashForm.dFrame.setVisible(false);
		}
		
		else if (o == dashForm.logoutItem) {
			new LoginForm().lFrame.setVisible(true);
			dashForm.dFrame.setVisible(false);
		}
	}

}

package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import dao.DashDao;
import gui_forms.PathFrame;


public class PathListener implements ActionListener{

	PathFrame pathFrame;
	public String filePath;
	
	public PathListener(PathFrame pathFrame) {
		this.pathFrame = pathFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String userName = pathFrame.userName;
		Object o = e.getSource();
		if (o==pathFrame.okBtn) {
			filePath=pathFrame.pathText.getText();
			pathFrame.pFrame.setVisible(false);
			
			DashDao dashDao = new DashDao();
			
			String status = dashDao.useExport(filePath, userName);
			
			if (status.equalsIgnoreCase("Success")) {
				JOptionPane.showMessageDialog(null, "Sucessfully Exported");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Export Not Sucessfull");
			}
		} 
		else if (o == pathFrame.clearBtn) {
			pathFrame.pathText.setText("");
		}
	}
	
	
}

package gui_forms;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import listeners.DashBoardListener;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class DashBoardForm {
	
	
	public String user;
	
	public JFrame dFrame;
	public JButton addBtn, deleteBtn, updateBtn, viewBtn, exportBtn, clearBtn, backBtn;
	public JTextField mobileText,nameText, nickText, mailText, dobText;
	public JTextArea noteArea;
	public JLabel mobileLabel, nameLabel, nickLabel, mailLabel, dobLabel, noteLabel, genderLabel, profile;
	public JRadioButton male, female;
	public ButtonGroup gender;
	public JDatePanelImpl dobDatePanel;
	public JDatePickerImpl dobDatePicker;
	public UtilDateModel model;
	public JPopupMenu popupmenu;
	public JMenuItem logoutItem;
	public MyImagePanel panel;
	
	
	
	
	
	public DashBoardForm(String userName) {
		
		this.user = userName;
		
//		ProfileCall profCall = new ProfileCall();
//		ProfileBean proflBean = new ProfileBean();
//		this.user = profCall.callProfile(proflBean);
		
		
		
		
		dFrame = new JFrame("DashBoard");
		
		
		panel = new MyImagePanel(new ImageIcon(ImagePathAssign.IMAGEPATH+"background.jpg").getImage());
		dFrame.getContentPane().add(panel);
		
		
		popupmenu = new JPopupMenu("Profile");
		
		addBtn = new JButton("Add");
		deleteBtn = new JButton("Delete");
		updateBtn = new JButton("Update");
		viewBtn = new JButton("View");
		exportBtn = new JButton("Export");
		clearBtn = new JButton("Clear");
		backBtn = new JButton("Logout");
		mobileText = new JTextField(20);
		nameText = new JTextField(20);
		nickText = new JTextField(20);
		mailText = new JTextField(20);
        
		
		model = new UtilDateModel();
		dobDatePanel = new JDatePanelImpl(model);
		dobDatePicker = new JDatePickerImpl(dobDatePanel);

		
		noteArea = new JTextArea(2, 20);
		
		mobileLabel = new JLabel("Mobile No");
		nameLabel = new JLabel("Name");
		nickLabel = new JLabel("Nick Name");
		mailLabel = new JLabel("Mail ID");
		genderLabel = new JLabel("Gender");
		dobLabel = new JLabel("D-O-B");
		noteLabel = new JLabel("Note");
		profile = new JLabel("Profile : "+this.user);
		
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);
		
		male.setOpaque(false);
		male.setContentAreaFilled(false);
		male.setBorderPainted(false);
		
		female.setOpaque(false);
		female.setContentAreaFilled(false);
		female.setBorderPainted(false);
		
		dFrame.setLayout(null);
		
		panel.add(profile);
		panel.add(popupmenu);
		
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(mobileLabel);
		panel.add(mobileText);
		panel.add(nickLabel);
		panel.add(nickText);
		panel.add(mailLabel);
		panel.add(mailText);
		panel.add(genderLabel);
		panel.add(male);
		panel.add(female);
		panel.add(dobLabel);
		panel.add(dobDatePicker);
		panel.add(noteLabel);
		panel.add(noteArea);
		
		
		panel.add(addBtn);
		panel.add(deleteBtn);
		panel.add(updateBtn);
		panel.add(viewBtn);
		panel.add(exportBtn);
		panel.add(clearBtn);
		panel.add(backBtn);
		
		
		mobileText.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	               mobileText.setEditable(true);
	            } else {
	            	//mobileText.setEditable(false);
	               JOptionPane.showMessageDialog(null, "Please Enter Only Numeric Digits");
	               mobileText.setText("");
	            }
	         }
	    });
		
		
        //Logout Profile
		   
        logoutItem = new JMenuItem("Logout"); 
        popupmenu.add(logoutItem);
        profile.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {              
                popupmenu.show(profile , e.getX(), e.getY());  
            }                 
         });
		
		profile.setBounds(350,5,100,20);
		
		nameLabel.setBounds(50,20,100,20);
		nameText.setBounds(150,20,150,20);
		
		mobileLabel.setBounds(50,50,100,20);
		mobileText.setBounds(150,50,150,20);
		
		nickLabel.setBounds(50,80,100,20);
		nickText.setBounds(150,80,150,20);
		
		mailLabel.setBounds(50,110,100,20);
		mailText.setBounds(150,110,150,20);
		
		genderLabel.setBounds(50,140,100,20);
		male.setBounds(150,140,60,20);
		female.setBounds(220,140,80,20);		
		
		dobLabel.setBounds(50,170,100,20);
		dobDatePicker.setBounds(150,170,150,20);
		
		noteLabel.setBounds(50,200,100,20);
		noteArea.setBounds(150,200,150,40);
		
		addBtn.setBounds(350,30,80,20);
		deleteBtn.setBounds(350,60,80,20);
		updateBtn.setBounds(350,90,80,20);
		viewBtn.setBounds(350,120,80,20);
		exportBtn.setBounds(350,150,80,20);
		clearBtn.setBounds(350,180,80,20);
		backBtn.setBounds(350,210,80,20);
		
		dFrame.setSize(500, 300);
		dFrame.setLocation(500,300);
//		dFrame.setVisible(true);
		dFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		DashBoardListener dl = new DashBoardListener(this);
		addBtn.addActionListener(dl);
		deleteBtn.addActionListener(dl);
		updateBtn.addActionListener(dl);
		viewBtn.addActionListener(dl);
		exportBtn.addActionListener(dl);
		clearBtn.addActionListener(dl);
		backBtn.addActionListener(dl);
		logoutItem.addActionListener(dl);

//		
	}
//
//	public static void main(String[] args) throws Exception{
//		new DashBoardForm().dFrame.setVisible(true);
//		
//	}
}

package gui_forms;


import javax.swing.*;
import listeners.ChangeListener;

public class ChangeForm {
	
	public JFrame uFrame;
	public JButton updateBtn, clearBtn, backBtn;
	public JTextField userText,newUserText, newPassText, passText, qstText, ansText;
	public JLabel newUserLabel,userLabel, newPassLabel, passLabel, qstLabel, ansLabel;
	public MyImagePanel panel;
	
	public ChangeForm (){
		uFrame = new JFrame("Update Password");
		updateBtn = new JButton("Update");
		clearBtn = new JButton("Clear");
		backBtn = new JButton("Back");
		newUserText = new JTextField(20);
		newPassText = new JPasswordField(20);
		userText = new JTextField(20);
		passText = new JPasswordField(20);
		qstText = new JTextField(20);
		ansText = new JTextField(20);
		newUserLabel = new JLabel("New User Name");
		newPassLabel = new JLabel("New Password");
		userLabel = new JLabel("Old User Name");
		passLabel = new JLabel("Old Password");
		qstLabel = new JLabel("Question");
		ansLabel = new JLabel("Answer");
	
		panel = new MyImagePanel(new ImageIcon(ImagePathAssign.IMAGEPATH+"background.jpg").getImage());
		uFrame.getContentPane().add(panel);
		
		uFrame.setLayout(null);
		
		panel.add(newUserLabel);
		panel.add(newUserText);
		panel.add(newPassLabel);
		panel.add(newPassText);
		panel.add(userLabel);
		panel.add(userText);
		panel.add(passLabel);
		panel.add(passText);
		panel.add(qstLabel);
		panel.add(qstText);
		panel.add(ansLabel);
		panel.add(ansText);
		panel.add(updateBtn);
		panel.add(clearBtn);
		panel.add(backBtn);
		
				
		userLabel.setBounds(100,10,100,20);
		userText.setBounds(230,10,150,20);
		
		newUserLabel.setBounds(100,40,100,20);
		newUserText.setBounds(230,40,150,20);
		
		passLabel.setBounds(100,70,100,20);
		passText.setBounds(230,70,150,20);
		
		newPassLabel.setBounds(100,100,100,20);
		newPassText.setBounds(230,100,150,20);
		
		qstLabel.setBounds(100,130,100,20);
		qstText.setBounds(230,130,150,20);
		
		ansLabel.setBounds(100,160,100,20);
		ansText.setBounds(230,160,150,20);
		
		
		
		updateBtn.setBounds(100,200,80,20);
		clearBtn.setBounds(200,200,80,20);
		backBtn.setBounds(300,200,80,20);
		
		
		
		ChangeListener cl = new ChangeListener(this);
		updateBtn.addActionListener(cl);
		clearBtn.addActionListener(cl);
		backBtn.addActionListener(cl);
		
		
		uFrame.setSize(500, 300);
		uFrame.setLocation(500,300);
		//rFrame.setVisible(true);
		uFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
//	public static void main(String[] args) throws Exception{
//		new ChangeForm().uFrame.setVisible(true);;
//		
//	}

}


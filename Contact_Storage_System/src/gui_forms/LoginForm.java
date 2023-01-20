package gui_forms;

import javax.swing.*;
import listeners.LoginListener;


public class LoginForm {
	
	public JFrame lFrame;
	public JButton loginBtn, clearBtn, backBtn;
	public JTextField userText, passText;
	public JLabel userLabel, passLabel;
	public MyImagePanel panel;
		
	public LoginForm() {
		lFrame = new JFrame("Login");
		loginBtn = new JButton("Login");
		clearBtn = new JButton("Clear");
		backBtn = new JButton("Back");
		userText = new JTextField(20);
		passText = new JPasswordField(20);
		userLabel = new JLabel("User Name");
		passLabel = new JLabel("Password");
		
		
		panel = new MyImagePanel(new ImageIcon(ImagePathAssign.IMAGEPATH+"background.jpg").getImage());
		lFrame.getContentPane().add(panel);
		
		
		lFrame.setLayout(null);
		
		panel.add(userLabel);
		panel.add(userText);
		panel.add(passLabel);
		panel.add(passText);
		panel.add(loginBtn);
		panel.add(clearBtn);
		panel.add(backBtn);
		
		userLabel.setBounds(120,50,100,20);
		passLabel.setBounds(120,80,100,20);
		
		userText.setBounds(220,50,150,20);
		passText.setBounds(220,80,150,20);
		
		
		loginBtn.setBounds(100,200,80,20);
		clearBtn.setBounds(200,200,80,20);
		backBtn.setBounds(300,200,80,20);
		
		
		LoginListener ll = new LoginListener(this);
		loginBtn.addActionListener(ll);
		clearBtn.addActionListener(ll);
		backBtn.addActionListener(ll);
		
		
		lFrame.setSize(500, 300);
		lFrame.setLocation(500,300);
		//lFrame.setVisible(true);
		lFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	public static void main(String[] args) {
//		new LoginForm().lFrame.setVisible(true);; 
//	}

}

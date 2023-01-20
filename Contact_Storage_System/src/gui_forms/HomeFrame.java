package gui_forms;


import javax.swing.*;
import listeners.HomeListener;

public class HomeFrame {

	
	public JFrame hFrame;
	public JButton loginBtn, changeBtn, forgotBtn, registerBtn, hintBtn;
	public MyImagePanel panel;
	


	
	public HomeFrame(){
		hFrame = new JFrame("Contact App");
		loginBtn = new JButton("Login");
		changeBtn = new JButton("Reset");
		forgotBtn = new JButton("Forgot");
		registerBtn = new JButton("Register");
		
		
		panel = new MyImagePanel(new ImageIcon(ImagePathAssign.IMAGEPATH+"home_background.jpg").getImage());
		hFrame.getContentPane().add(panel);
		
		hintBtn = new JButton();
		

		hintBtn.setOpaque(false);
		hintBtn.setContentAreaFilled(false);
		hintBtn.setBorderPainted(false);
		
		hFrame.setLayout(null);	
		
		panel.add(loginBtn);
		panel.add(changeBtn);
		panel.add(forgotBtn);
		panel.add(registerBtn);
		panel.add(hintBtn);

		
		hintBtn.setBounds(5,15,50,30);
		loginBtn.setBounds(50,200,80,20);
		registerBtn.setBounds(145,200,90,20);
		changeBtn.setBounds(250,200,80,20);
		forgotBtn.setBounds(350,200,80,20);
		
		
		HomeListener ha = new HomeListener(this);
		loginBtn.addActionListener(ha);
		changeBtn.addActionListener(ha);
		forgotBtn.addActionListener(ha);
		registerBtn.addActionListener(ha);
		hintBtn.addActionListener(ha);
		

		
		hFrame.setSize(500, 300);
		hFrame.setLocation(500,300);
		//hFrame.setVisible(true);
		hFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) throws Exception{
		new HomeFrame().hFrame.setVisible(true);;
		
	}


	
}

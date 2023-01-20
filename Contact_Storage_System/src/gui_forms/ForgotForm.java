package gui_forms;

import javax.swing.*;

import listeners.ForgotListener;

public class ForgotForm {
	public JFrame fFrame;
	public JButton viewBtn, qstBtn, backBtn;
	public JLabel qstLabel, ansLabel, secLabel, userLabel;
	public JTextField ansText, userText;
	//public String question = "Show Sequerity Question";
	public MyImagePanel panel;
	
	public ForgotForm(){
		
		fFrame = new JFrame("Forgot Password");
		viewBtn = new JButton("View");
		qstBtn = new JButton("Click");
		backBtn = new JButton("Back");
		secLabel = new JLabel("Show Sequerity Question");
		ansLabel = new JLabel("Answer");
		ansText = new JTextField();
		userText = new JTextField();
		userLabel = new JLabel("User Name");
		qstLabel = new JLabel("Question");
		
		panel = new MyImagePanel(new ImageIcon(ImagePathAssign.IMAGEPATH+"background.jpg").getImage());
		fFrame.getContentPane().add(panel);
		
		fFrame.setLayout(null);	
		
//		qstBtn.setBackground(null);
		
		qstBtn.setOpaque(false);
		qstBtn.setContentAreaFilled(false);
		qstBtn.setBorderPainted(false);
		
		panel.add(qstLabel);
		panel.add(ansLabel);
		panel.add(ansText);
		panel.add(viewBtn);
		panel.add(qstBtn);
		panel.add(backBtn);
		panel.add(userLabel);
		panel.add(userText);
		panel.add(secLabel);
		
		
		
		userLabel.setBounds(120,50,100,20);
		userText.setBounds(220,50,150,20);
		
		qstLabel.setBounds(120,80,100,20);
		secLabel.setBounds(220,80,300,20);
		qstBtn.setBounds(385,80,70,20);
		
		ansLabel.setBounds(120,110,100,20);
		ansText.setBounds(220,110,150,20);
		
		viewBtn.setBounds(150,200, 80,20);
		backBtn.setBounds(270, 200, 80, 20);
		
		
		ForgotListener fl = new ForgotListener(this);
		viewBtn.addActionListener(fl);
		qstBtn.addActionListener(fl);
		backBtn.addActionListener(fl);
	
		fFrame.setSize(500, 300);
		fFrame.setLocation(500,300);
		//hFrame.setVisible(true);
		fFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
//	
//	public static void main(String[] args) throws Exception{
//		new ForgotForm().fFrame.setVisible(true);
//	}
}

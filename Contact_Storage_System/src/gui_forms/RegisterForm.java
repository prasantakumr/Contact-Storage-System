package gui_forms;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listeners.RegisterListener;

public class RegisterForm {
	public JFrame rFrame;
	public JButton registerBtn, clearBtn, backBtn;
	public JTextField userText, newPassText, passText, qstText, ansText;
	public JLabel userLabel, newPassLabel, passLabel, qstLabel, ansLabel;
	public MyImagePanel panel;

	public RegisterForm() {
		rFrame = new JFrame("Registration Form");
		registerBtn = new JButton("Register");
		clearBtn = new JButton("Clear");
		backBtn = new JButton("Back");
		newPassText = new JPasswordField(20);
		userText = new JTextField(20);
		passText = new JPasswordField(20);
		qstText = new JTextField(20);
		ansText = new JTextField(20);
		newPassLabel = new JLabel("Verify Password");
		userLabel = new JLabel("User Name");
		passLabel = new JLabel("Password");
		qstLabel = new JLabel("Question");
		ansLabel = new JLabel("Answer");
		
		
		panel = new MyImagePanel(new ImageIcon(ImagePathAssign.IMAGEPATH+"background.jpg").getImage());
		rFrame.getContentPane().add(panel);
		

		rFrame.setLayout(null);

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
		panel.add(registerBtn);
		panel.add(clearBtn);
		panel.add(backBtn);

		userLabel.setBounds(100, 30, 100, 20);
		userText.setBounds(230, 30, 150, 20);

		passLabel.setBounds(100, 60, 100, 20);
		passText.setBounds(230, 60, 150, 20);

		newPassLabel.setBounds(100, 90, 100, 20);
		newPassText.setBounds(230, 90, 150, 20);

		qstLabel.setBounds(100, 120, 100, 20);
		qstText.setBounds(230, 120, 150, 20);

		ansLabel.setBounds(100, 150, 100, 20);
		ansText.setBounds(230, 150, 150, 20);

		registerBtn.setBounds(100, 200, 80, 20);
		clearBtn.setBounds(200, 200, 80, 20);
		backBtn.setBounds(300, 200, 80, 20);
		
		
		RegisterListener rl = new RegisterListener(this);
		registerBtn.addActionListener(rl);
		clearBtn.addActionListener(rl);
		backBtn.addActionListener(rl);

		rFrame.setSize(500, 300);
		rFrame.setLocation(500, 300);
		// rFrame.setVisible(true);
		rFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

//	public static void main(String[] args) throws Exception {
//		new RegisterForm().rFrame.setVisible(true);
//
//	}
}

package gui_forms;

import javax.swing.*;
import listeners.PathListener;

public class PathFrame {
	public JFrame pFrame;
	public JButton okBtn, clearBtn;
	public JTextField pathText;
	public JLabel pathLabel, hintLabel, msgLabel;
	public String userName;
	public MyImagePanel panel;
	
	public PathFrame(String userName) {
		this.userName= userName;
		pFrame = new JFrame("Set Path");
		okBtn = new JButton("OK");
		clearBtn = new JButton("Clear");
		pathLabel = new JLabel("Path");
		msgLabel = new JLabel("(Enter Path To Export Excel File)");
		hintLabel = new JLabel("C:/folder/ . . . /folder");
		pathText = new JTextField(20);
		
		panel = new MyImagePanel(new ImageIcon(ImagePathAssign.IMAGEPATH+"path_background.jpg").getImage());
		pFrame.getContentPane().add(panel);
		
		panel.add(pathLabel);
		panel.add(msgLabel);
		panel.add(hintLabel);
		panel.add(pathText);
		panel.add(okBtn);
		panel.add(clearBtn);
		
		pFrame.setLayout(null);
		
		msgLabel.setBounds(40,3,200,20);
		hintLabel.setBounds(105,25,200,20);
		pathLabel.setBounds(30,45,80,20);
		pathText.setBounds(100,45,150,20);
		

		okBtn.setBounds(50,75,80,20);
		clearBtn.setBounds(150,75,80,20);

		PathListener pl = new PathListener(this);
		okBtn.addActionListener(pl);
		clearBtn.addActionListener(pl);
		
		
		pFrame.setSize(300, 150);
		pFrame.setLocation(500,300);
		//hFrame.setVisible(true);
		pFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
//	public static void main(String[] args) throws Exception{
//		new PathFrame().pFrame.setVisible(true);;
//		
//	}
}

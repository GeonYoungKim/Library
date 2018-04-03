package admin;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import client.ClientBtnEventHandler2; 

public class Firstf extends JFrame {
	
	AdminBtnEventHandler adminBtnEventHandler;
	
	public Firstf(AdminBtnEventHandler adminBtnEventHandler){
		this.adminBtnEventHandler=adminBtnEventHandler;
	}
	JButton adminBtn;
	JButton clientBtn;
	JPanel panel;
	
	public void start(){
	setSize(500, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	setTitle("도서관 관리 프로그램");
	adminBtn= new JButton("관리자");
	clientBtn = new JButton("사용자");
	panel=new JPanel();
	adminBtn.addActionListener(adminBtnEventHandler);
	clientBtn.addActionListener(new ClientBtnEventHandler2());
	
	panel.add(adminBtn);
	panel.add(clientBtn);
	
	add(panel,BorderLayout.CENTER);
	setVisible(true);
	}
}

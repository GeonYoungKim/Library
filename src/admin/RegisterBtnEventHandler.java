package admin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.MemberDAO;

import java.sql. *;
import java.util.ArrayList; 

public class RegisterBtnEventHandler implements ActionListener {
	MemberDAO dao;
	ArrayList<String> list;
	String[] strList;
	AdminBtnEventHandler adminBtnEventHandler;
	public RegisterBtnEventHandler(AdminBtnEventHandler adminBtnEventHandler){
		this.adminBtnEventHandler=adminBtnEventHandler;
	}
	
	public void actionPerformed(ActionEvent e){
		JFrame registerf=new JFrame("등록 창");
		registerf.setSize(800, 200);
		registerf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		
		JTextField booknumtext =new JTextField(10);
		JTextField booknametext =new JTextField(10);
		JTextField authortext =new JTextField(10);
		
		JButton addbook=new JButton("추가");
		
		addbook.addActionListener(new AddBookBtnEventHandler(booknumtext,booknametext,authortext,this.adminBtnEventHandler));
		
		JLabel booknum=new JLabel("책 번호");
		JLabel bookname=new JLabel("책 이름");
		JLabel author=new JLabel("저자");
		
		JPanel registerpanel=new JPanel();
		
		registerpanel.add(booknum);
		registerpanel.add(booknumtext);
		registerpanel.add(bookname);
		registerpanel.add(booknametext);
		registerpanel.add(author);
		registerpanel.add(authortext);
		registerpanel.add(addbook);
		
		registerf.add(registerpanel,BorderLayout.CENTER);
		
		
		registerf.setVisible(true);
	}

}

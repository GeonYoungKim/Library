package admin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateBtnEventHandler implements ActionListener{
	
	AdminBtnEventHandler adminBtnEventHandler;
	JTextField bookNumText;
	public UpdateBtnEventHandler(JTextField bookNumText,AdminBtnEventHandler adminBtnEventHandler){
		this.bookNumText=bookNumText;
		this.adminBtnEventHandler=adminBtnEventHandler;
	}
	public void actionPerformed(ActionEvent e){
		JFrame registerf=new JFrame("등록 창");
		registerf.setSize(800, 200);
		registerf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		
		JTextField booknametext =new JTextField(10);
		JTextField authortext =new JTextField(10);
		JTextField borrowtext = new JTextField(10);
		JButton updatebookbtn=new JButton("수정");
		
		updatebookbtn.addActionListener(new UpdateBookBtnEventHandler(bookNumText,booknametext,authortext,borrowtext,adminBtnEventHandler));
		
		
		JLabel borrow = new JLabel("대여");
		JLabel bookname=new JLabel("책이름");
		JLabel author=new JLabel("저자");
		
		JPanel registerpanel=new JPanel();
		
		registerpanel.add(bookname);
		registerpanel.add(booknametext);
		registerpanel.add(author);
		registerpanel.add(authortext);
		registerpanel.add(borrow);
		registerpanel.add(borrowtext);
		registerpanel.add(updatebookbtn);
		
		registerf.add(registerpanel,BorderLayout.CENTER);
		
		
		registerf.setVisible(true);
	}

}

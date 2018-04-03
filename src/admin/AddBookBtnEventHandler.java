package admin;
import java.sql. *; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.MemberDAO;
import DB.MemberVO;

public class AddBookBtnEventHandler implements ActionListener {
	JTextField bookNum;
	JTextField bookName;
	JTextField author;
	AdminBtnEventHandler adminBtnEventHandler;
	public AddBookBtnEventHandler(JTextField bookNum, JTextField bookName, JTextField author,AdminBtnEventHandler adminBtnEventHandler){
		this.bookNum=bookNum;
		this.bookName=bookName;
		this.author=author;
		this.adminBtnEventHandler=adminBtnEventHandler;
	}
	
	public void actionPerformed(ActionEvent e){
		
		MemberDAO dao=new MemberDAO();
		MemberVO vo=new MemberVO();
		
		vo.setBookNum(bookNum.getText());
		vo.setBookName(bookName.getText());
		vo.setAuthor(author.getText());
		dao.insertMember(vo);
		
		adminBtnEventHandler.listPanel.removeAll();
		adminBtnEventHandler.btnPanel.removeAll();
		adminBtnEventHandler.actionPerformed(e);
		
		bookName.setText("");
		bookNum.setText("");
		author.setText("");
		
	}

}

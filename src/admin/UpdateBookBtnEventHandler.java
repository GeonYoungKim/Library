package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import DB.MemberDAO;
import DB.MemberVO;

public class UpdateBookBtnEventHandler implements ActionListener {
	
	JTextField bookNumText;
	JTextField bookName;
	JTextField author;
	JTextField borrow;
	AdminBtnEventHandler adminBtnEventHandler;
	
	public UpdateBookBtnEventHandler(JTextField bookNumText, JTextField bookName, JTextField author,JTextField borrow,AdminBtnEventHandler adminBtnEventHandler){
		this.bookNumText=bookNumText;
		this.bookName=bookName;
		this.author=author;
		this.borrow=borrow;
		this.adminBtnEventHandler=adminBtnEventHandler;
	}
	
	public void actionPerformed(ActionEvent e){
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(bookNumText.getText());
		vo.setBookName(bookName.getText());
		vo.setAuthor(author.getText());
		if(borrow.getText().equals("대여 가능")){
			vo.setBorrow("1");
		}else if(borrow.getText().equals("대여 완료")){
			vo.setBorrow("2");
		}
		
		dao.updateMember(vo);
		
		
		adminBtnEventHandler.actionPerformed(e);
		
		bookName.setText("");
		author.setText("");
		borrow.setText("");
	}
}

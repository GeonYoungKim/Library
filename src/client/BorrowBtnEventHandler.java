package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import DB.MemberDAO;
import DB.MemberVO;

public class BorrowBtnEventHandler implements ActionListener {
	
	ClientBtnEventHandler2 clientBtnEventHandler2;
	JTextField booknumtext;
	public BorrowBtnEventHandler(JTextField booknumtext,ClientBtnEventHandler2 clientBtnEventHandler2){
		this.booknumtext=booknumtext;
		this.clientBtnEventHandler2=clientBtnEventHandler2;
	}
	
	public void actionPerformed(ActionEvent e){
		
		MemberDAO dao= new MemberDAO();
		MemberVO vo=dao.getMember(booknumtext.getText());
		
		if(vo.getBorrow().equals("1")){
			vo.setBorrow("2");
		}else{
			vo.setBorrow("1");
		}
		dao.updateMember(vo);
		
		clientBtnEventHandler2.actionPerformed(e);
		
	}

}

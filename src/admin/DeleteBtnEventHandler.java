package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import DB.MemberDAO;
import DB.MemberVO;

public class DeleteBtnEventHandler implements ActionListener {
	JTextField searchtext;
	AdminBtnEventHandler adminBtnEventHandler;
	public DeleteBtnEventHandler(JTextField searchtext, AdminBtnEventHandler adminBtnEventHandler){
		this.searchtext=searchtext;
		this.adminBtnEventHandler=adminBtnEventHandler;
	}
	public void actionPerformed(ActionEvent e){
		MemberDAO dao=new MemberDAO();
		MemberVO vo=dao.getMember(searchtext.getText());
		
		if(vo==null){
			JFrame searchf = new JFrame("삭제 창");
			searchf.setSize(500,100);
			searchf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
			searchf.setVisible(true);
		}else{
			dao.deleteMember(vo);
			adminBtnEventHandler.actionPerformed(e);
		}
	}
}

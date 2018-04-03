package admin;
import java.sql. *;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.MemberDAO;
import DB.MemberVO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBtnEventHandler implements ActionListener {
	MemberDAO dao;
	JTextField searchText;
	AdminBtnEventHandler adminBtnEventHandler;
	
	public SearchBtnEventHandler(JTextField searchText,AdminBtnEventHandler adminBtnEventHandler){
		this.searchText=searchText;
		this.adminBtnEventHandler=adminBtnEventHandler;
	}
	
	public void actionPerformed(ActionEvent e){
		DeleteBtnEventHandler deletebtn=new DeleteBtnEventHandler(searchText, adminBtnEventHandler);
		dao=new MemberDAO();
		MemberVO vo=dao.getBook(searchText.getText());
		List<MemberVO> memberlist=dao.getMemberList();
		
		if(vo==null){
			JFrame searchf = new JFrame("검색창");
			searchf.setSize(500,100);
			searchf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
			searchf.setVisible(true);
		}else{
			int i=0;
			adminBtnEventHandler.x=1;
			for(int j=0;j<adminBtnEventHandler.str.length;j++){
				adminBtnEventHandler.str[j]=null;
			}
			for(MemberVO vo1:memberlist){
				if(vo1.getBookName().equals(searchText.getText())){
					if(vo1.getBorrow().equals("1")){
						vo1.setBorrow("대여 가능");
					}else{
						vo1.setBorrow("대여 완료");
					}
					adminBtnEventHandler.str[i]=vo1.toString();
					++i;
				}
			}
			adminBtnEventHandler.actionPerformed(e);
		}
	}
}
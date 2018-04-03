package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;

import DB.MemberDAO;
import DB.MemberVO;

public class SearchBtnEventHandler implements ActionListener{
	JTextField bookNameText;
	ClientBtnEventHandler2 clientBtnEventHandler2;
	public SearchBtnEventHandler(JTextField bookNameText,ClientBtnEventHandler2 clientBtnEventHandler2) {
		this.bookNameText=bookNameText;
		this.clientBtnEventHandler2=clientBtnEventHandler2;
	}
	public void actionPerformed(ActionEvent e){
		MemberDAO dao=new MemberDAO();
		MemberVO vo=dao.getBook(bookNameText.getText());
		List<MemberVO> memberlist=dao.getMemberList();
		
		if(vo==null){
			JFrame searchf = new JFrame("검색");
			searchf.setSize(500,100);
			searchf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
			searchf.setVisible(true);
		}else{
			
			int i=0;
			clientBtnEventHandler2.x=1;
			for(int j=0;j<clientBtnEventHandler2.str.length;j++){
				clientBtnEventHandler2.str[j]=null;
			}
			clientBtnEventHandler2.x=1;
			for(MemberVO vo1:memberlist){
				if(vo1.getBookName().equals(bookNameText.getText())){
					if(vo1.getBorrow().equals("1")){
						vo1.setBorrow("대여 가능");
					}else{
						vo1.setBorrow("대여 완료");
					}
					clientBtnEventHandler2.str[i]=vo1.toString();
					++i;
				}
			}
			
			clientBtnEventHandler2.actionPerformed(e);
		}
	}

}

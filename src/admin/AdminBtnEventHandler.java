package admin;
import java.sql. *;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import DB.MemberDAO;
import DB.MemberVO;

public class AdminBtnEventHandler implements ActionListener {
	
	int x;	
	String str[]=new String[1000];
	MemberDAO dao;
	ArrayList<String> list;
	String[] strList;
	JScrollPane scroll=new JScrollPane();
	JList jlist=new JList();
	JFrame adminf= new JFrame("관리자 창");
	JPanel listPanel=new JPanel();
	JTextField searchText;
	JTextField bookNumText;
	JPanel btnPanel=new JPanel();
	
	BtnPanelRemove btn =new BtnPanelRemove(this);
	
	
	public void book_info(){
		strList=new String[1000];
		dao=new MemberDAO();
		list=new ArrayList();
		List<MemberVO> memberlist=dao.getMemberList();
		for(MemberVO vo:memberlist){
			if(vo.getBorrow().equals("1")){
				vo.setBorrow("대여 가능");
			}else{
				vo.setBorrow("대여 완료");
			}
			list.add(vo.toString());
		}
		for(int i=0;i<list.size();i++){
			strList[i]=list.get(i);
		}
	}
	public void actionPerformed(ActionEvent e){
		
		btn.remove();
		JLabel bookname=new JLabel("책 이름");
		JLabel booknum = new JLabel("책 번호");
		
		bookNumText=new JTextField(10);
		searchText=new JTextField(10);
		
		if(x==0){
			book_info();
		}else{
			for(int i=0;i<str.length;i++){
				strList[i]=str[i];
			}
			for(int i=str.length;i<list.size();i++){
				strList[i]=null;
			}
		}
		
		scroll.setViewportView(jlist);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.setListData(strList); 
		
		adminf.setSize(500,500 );
		adminf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		
		JButton deletebtn = new JButton("삭제");
		JButton registerbtn = new JButton("등록");
		JButton searchbtn = new JButton("검색");
		JButton alllistbtn=new JButton("모든목록");
		JButton updatebtn=new JButton("수정");
		
		listPanel.add(scroll);
		deletebtn.addActionListener(new DeleteBtnEventHandler(bookNumText,this));
		registerbtn.addActionListener(new RegisterBtnEventHandler(this));
		searchbtn.addActionListener(new SearchBtnEventHandler(searchText,this));
		alllistbtn.addActionListener(new AlllistBtnEventHandler(this));
		updatebtn.addActionListener(new UpdateBtnEventHandler(bookNumText,this));
			
		btnPanel.add(bookname);
		btnPanel.add(searchText);
		btnPanel.add(searchbtn);
		btnPanel.add(alllistbtn);
		btnPanel.add(registerbtn);
		btnPanel.add(booknum);
		btnPanel.add(bookNumText);
		btnPanel.add(deletebtn);
		btnPanel.add(updatebtn);
		
		adminf.add(listPanel,BorderLayout.WEST);
		adminf.add(btnPanel,BorderLayout.CENTER);
		
		searchText.setText("");
				
		adminf.setVisible(true);
		
	}

}

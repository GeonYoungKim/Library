package client;
import java.sql. *;
import java.util.ArrayList;
import java.util.List;

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
import client.BtnPanelRemove;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientBtnEventHandler2 implements ActionListener {
	
	BtnPanelRemove btn =new BtnPanelRemove(this);
	String str[]=new String[1000];
	int x;
	JFrame clientf = new JFrame("고객창");
	JScrollPane scroll=new JScrollPane();
	JList jlist=new JList();
	String[] strList=new String[1000];
	MemberDAO dao;
	ArrayList<String> list;
	JPanel listPanel=new JPanel();
	JPanel btnPanel=new JPanel();
	public void book_info(){
		strList=new String[1000];
		dao=new MemberDAO();
		list=new ArrayList();
		List<MemberVO> memberlist=dao.getMemberList();
		for(MemberVO vo:memberlist){
			if(vo.getBorrow().equals("1")){
				vo.setBorrow("대여 가능");
			}else if(vo.getBorrow().equals("2")){
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
		JLabel booknum=new JLabel("책 번호");
		JLabel bookname=new JLabel("책 이름");
		JTextField booknametext = new JTextField(10);
		JTextField booknumtext = new JTextField(10);
		
		JButton alllistbtn=new JButton("전체 목록");
		JButton searchbtn=new JButton("검색");
		JButton borrowbtn = new JButton("대여");
		
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
		
		clientf.setSize(500,500 );
		clientf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		
		listPanel.add(scroll);
		
		searchbtn.addActionListener(new SearchBtnEventHandler(booknametext,this));
		borrowbtn.addActionListener(new BorrowBtnEventHandler(booknumtext,this));
		alllistbtn.addActionListener(new AlllistBtnEventHandler(this));
		
		btnPanel.add(bookname);
		btnPanel.add(booknametext);
		btnPanel.add(searchbtn);
		btnPanel.add(alllistbtn);
		btnPanel.add(booknum);
		btnPanel.add(booknumtext);
		btnPanel.add(borrowbtn);
		
		
		clientf.add(listPanel,BorderLayout.WEST);
		clientf.add(btnPanel,BorderLayout.CENTER);
		
		booknametext.setText("");
				
		clientf.setVisible(true);
		
		
		
	}

}

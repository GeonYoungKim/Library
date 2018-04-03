package DB;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql. *; 

public class MemberDAO {
	
	Connection conn=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 
 public List<MemberVO> getMemberList(){
  List<MemberVO> memberList=new ArrayList<>();
  
   Connection conn=null;
   PreparedStatement ps=null;
   ResultSet rs=null;
   try{
	   
	conn=DBUtil.getConnection("kgy", "c2619zz");
   
    ps=conn.prepareStatement("select * from book");
   
    rs=ps.executeQuery();
   
    while(rs.next()){
     MemberVO vo=new MemberVO();
     vo.setBookNum(rs.getString(1));
     vo.setBookName(rs.getString(2));
     vo.setAuthor(rs.getString(3));
     vo.setBorrow(rs.getString(4));
     memberList.add(vo);
    }
   }catch (Exception e) {
    e.printStackTrace();
   }finally {
    DBUtil.close(conn, ps,rs);
   }
 return memberList;  
 }
 
 
 public MemberVO getBook(String bookname){
	 
	   MemberVO vo=null;
	   
	    Connection conn=null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	    try{
	    
	    conn=DBUtil.getConnection("kgy", "c2619zz");
	    
	    ps=conn.prepareStatement("select * from book where bookname=?");
	    ps.setString(1,bookname);
	    
	    rs=ps.executeQuery();
	    
	    if(rs.next()){
	     vo=new MemberVO();
	     vo.setBookNum(rs.getString(1));
	     vo.setBookName(rs.getString(2));
	     vo.setAuthor(rs.getString(3));
	     vo.setBorrow(rs.getString(4));
	    }
	   }catch (Exception e) {
	    e.printStackTrace();
	   }finally {
	    DBUtil.close(conn, ps,rs);
	   }
	 return vo;
 } 
 
 public MemberVO getMember(String booknum){
   MemberVO vo=null;
   
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    try{
    
    conn=DBUtil.getConnection("kgy", "c2619zz");
    
     ps=conn.prepareStatement("select * from book where booknum=?");
     ps.setString(1,booknum);
    
     rs=ps.executeQuery();
    
     if(rs.next()){
      vo=new MemberVO();
      vo.setBookNum(rs.getString(1));
      vo.setBookName(rs.getString(2));
      vo.setAuthor(rs.getString(3));
      vo.setBorrow(rs.getString(4));
     }
    }catch (Exception e) {
     e.printStackTrace();
    }finally {
     DBUtil.close(conn, ps,rs);
    }
  return vo;
  
 }
 
 public boolean updateMember(MemberVO vo){
  boolean resultflag=false;
 
    try{
    	conn=DBUtil.getConnection("kgy", "c2619zz");

    
     String sql="update book set bookname=?,author=?,borrow=? where booknum=?";
     ps=conn.prepareStatement(sql);
     ps.setString(1, vo.getBookName());
     ps.setString(2, vo.getAuthor());
     ps.setString(3, vo.getBorrow());
     ps.setString(4, vo.getBookNum());
     
     int resultCount=ps.executeUpdate();  
     
     if(resultCount>0){
      resultflag=true;
     }
    }catch (Exception e) {
     e.printStackTrace();
    }finally {
     DBUtil.close(conn, ps);
    }
    return resultflag;
   }
 
 public boolean insertMember(MemberVO vo){
  boolean resultflag=false;
  
  
    try{
    	conn=DBUtil.getConnection("kgy", "c2619zz");
    
     String sql="insert into book (booknum,bookname,author,borrow) values(?,?,?,1)";
     ps=conn.prepareStatement(sql);
     ps.setString(1, vo.getBookNum());
     ps.setString(2, vo.getBookName());
     ps.setString(3, vo.getAuthor());
     
     
     int resultCount=ps.executeUpdate();   
     
     if(resultCount>0){
      resultflag=true;
     }
    }catch (Exception e) {
     e.printStackTrace();
    }finally {
     DBUtil.close(conn, ps);
    }
    return resultflag;
   }
 
 public boolean deleteMember(MemberVO vo){
  boolean resultflag=false;
  
  
    try{
    	conn=DBUtil.getConnection("kgy", "c2619zz");
     
     String sql="delete from book where booknum=?";
     ps=conn.prepareStatement(sql);
     ps.setString(1, vo.getBookNum());
     
     
     int resultCount=ps.executeUpdate();   
     
     if(resultCount>0){
      resultflag=true;
     }
    }catch (Exception e) {
     e.printStackTrace();
    }finally {
     DBUtil.close(conn, ps);
    }
    return resultflag;
   }

}
 

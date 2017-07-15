package tw.org.iii.bean;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Member2 {
	private String id,account,passwd,realname;
	private Connection conn;
	private PreparedStatement pstmt;
	public Member2() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection
				("jdbc:mysql://127.0.0.1/brad","root","root");
	}
	
	public void setPasswd(String passwd) {this.passwd=passwd;}
	public void setAccount(String account) {this.account=account;}
	public void setRealname(String realname) {this.realname=realname;}
	public String getPasswd() {return passwd;}
	public String getAccount() {return account;}
	public String getRealname() {return this.realname;}
	
	public boolean newInsert() throws Exception{
		pstmt = conn.prepareStatement
				("INSERT INTO member (account,passwd,realname) VALUES (?,?,?)");
		pstmt.setString(1, account);
		pstmt.setString(2, passwd);
		pstmt.setString(3, realname);
		int n = pstmt.executeUpdate();
		return n > 0;
	}
	public boolean isValidMember() throws Exception{
		
		pstmt = conn.prepareStatement
				("SELECT * FROM member WHERE account=? AND passwd=?");
		pstmt.setString(1, account);
		pstmt.setString(2, passwd);
		
		ResultSet rs= pstmt.executeQuery();
		boolean ret = rs.next();
		if(ret) {
			realname = rs.getString("realname");
			id = rs.getString("id");
		}
		return ret;
	}
}

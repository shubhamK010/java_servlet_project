package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.bo.BookInfoBo;
import com.bo.StudentInfoBo;

public class BookDao {

public static Connection getConnection() {
		
		Connection con=null;
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/elibrary";
			
			String username="root";
			
			String pass="shubham123";
			
			con=DriverManager.getConnection(url,username,pass);
			
			
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return con;

		}
		
		
	
		
		
	
		
		public static boolean adminValidate(String adminemail,String adminpassword)
		{
			boolean status=false;
			
			
			try
			{
				
				
				Connection con=BookDao.getConnection();
				
				String sql="select * from admin where adminemail=? and adminpassword=?";
				
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setString(1, adminemail);
				ps.setString(2, adminpassword);
				
				ResultSet rs=ps.executeQuery();
				
				status=rs.next();
				
				
				
				
				
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
			return status;
		
		
	}
		
		public static int addStudent(StudentInfoBo sb) {
			
			int status=0;
			
			
			try 
			{
				
				
				
				Connection con=BookDao.getConnection();
				
				String sql="Insert into addStudent (fullName,email,dob,phone,subject,idType,idNumber) values(?,?,?,?,?,?,?) ";
				
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setString(1, sb.getFullName());
				ps.setString(2, sb.getEmail());
				ps.setString(3, sb.getDob());
				ps.setString(4, sb.getPhone());
				ps.setString(5, sb.getSubject());
				ps.setString(6, sb.getIdType());
				ps.setString(7, sb.getIdNumber());
				
				status=ps.executeUpdate();
			}
			
			catch(Exception e) 
			{
				System.out.println(e);
				
			}
			
			return status;
			
			
		}
		
		public static List getStudentData()
		{
			
			List <StudentInfoBo>list=new ArrayList<>();
			
			
			try
			{
				
				Connection con=BookDao.getConnection();
				String sql="select * from addStudent";
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
					
				{
					
					StudentInfoBo sb=new StudentInfoBo();
					
					sb.setId(rs.getInt(1));
					sb.setFullName(rs.getString(2));
					sb.setEmail(rs.getString(3));
					sb.setDob(rs.getString(4));
					sb.setPhone(rs.getString(5));
					sb.setSubject(rs.getString(6) );
					sb.setIdType(rs.getString(7));
					sb.setIdNumber(rs.getString(8));
					
					list.add(sb);
					
					
					
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
			
			
			
			
			
			return list;
			
			
		}
		
		public static StudentInfoBo getInfoById(int id)
		{
			StudentInfoBo sb=new StudentInfoBo();
			
			try {
				
				Connection con=BookDao.getConnection();
				String sql="select * from addStudent where id=?";
				
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					sb=new StudentInfoBo();
					
					sb.setId(rs.getInt(1));
					sb.setFullName(rs.getString(2));
                    sb.setEmail(rs.getString(3));
					sb.setDob(rs.getString(4));
					sb.setPhone(rs.getString(5));
					sb.setSubject(rs.getString(6) );
					sb.setIdType(rs.getString(7));
					sb.setIdNumber(rs.getString(8));
					
					
				}
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			return sb;
			
		}
		
		
		public static int updateStudent(StudentInfoBo sb)
		{
			int status=0;
			try {
				
				Connection con=BookDao.getConnection();
				
				String sql="update  addstudent set  fullName =? , email =? ,dob =? , phone=? ,subject=? ,idType =? ,idNumber =? where id=?";
				
				
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,sb.getFullName());
				ps.setString(2,sb.getEmail());
				ps.setString(3,sb.getDob());
				ps.setString(4,sb.getPhone());
				ps.setString(5,sb.getSubject());
				ps.setString(6,sb.getIdType());
				ps.setString(7,sb.getIdNumber());
				ps.setInt(8,sb.getId());
				
				status=ps.executeUpdate();
				
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
			
			return status;
			
			
			
		}
		
		public static int deleteStudentData(int id)
		{
			
			int status=0;
			
			try {
				Connection con=BookDao.getConnection();
				String sql="delete from addStudent where id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				status=ps.executeUpdate();
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return status;
			
		}
		
		
   public static int addBook(BookInfoBo bb) {
			
			int status=0;
			
			
			try 
			{
				
				
				
				Connection con=BookDao.getConnection();
				
				String sql="Insert into addBook (bookName,authorName,bookId) values(?,?,?) ";
				
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setString(1, bb.getBookName());
				ps.setString(2, bb.getAuthorName());
				ps.setString(3, bb.getBookId());
				
				status=ps.executeUpdate();
			}
			
			catch(Exception e) 
			{
				System.out.println(e);
				
			}
			
			return status;
			
			
		}
		
   public static List getBookData()
	{
		
		List <BookInfoBo>list=new ArrayList<>();
		
		
		try
		{
			
			Connection con=BookDao.getConnection();
			String sql="select * from addBook";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
				
			{
				
				BookInfoBo bb=new BookInfoBo();
				
				bb.setId(rs.getInt(1));
				bb.setBookName(rs.getString(2));
				bb.setAuthorName(rs.getString(3));
				bb.setBookId(rs.getNString(4));
				
				list.add(bb);
				
				
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		
		
		
		
		return list;
		
		
	}
   
   public static BookInfoBo getInfoByIdBook(int id)
	{
		BookInfoBo bb=new BookInfoBo();
		
		try {
			
			Connection con=BookDao.getConnection();
			String sql="select * from addBook where id=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				bb=new BookInfoBo();
				
				bb.setId(rs.getInt(1));
				bb.setBookName(rs.getString(2));
               bb.setAuthorName(rs.getString(3));
				bb.setBookId(rs.getString(4));
				
				
				
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return bb;
		
	}
	
   public static int deleteBookData(int id)
	{
		
		int status=0;
		
		try {
			Connection con=BookDao.getConnection();
			String sql="delete from addBook where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
		
   public static int updateBook(BookInfoBo bb)
	{
		int status=0;
		try {
			
			Connection con=BookDao.getConnection();
			
			String sql="update  addBook set  bookName =? , authorName =? ,    bookId =? where id=?";
			
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,bb.getBookName());
			ps.setString(2,bb.getAuthorName());
			ps.setString(3,bb.getBookId());
			ps.setInt(4, bb.getId());
			
			status=ps.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		return status;
		
		
		
	}	
}
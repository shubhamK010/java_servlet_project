package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.BookInfoBo;
import com.bo.StudentInfoBo;
import com.dao.BookDao;

/**
 * Servlet implementation class EditServlet2Book
 */
@WebServlet("/EditServlet2Book")
public class EditServlet2Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2Book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		BookInfoBo bb=BookDao.getInfoByIdBook(id);
		
		pw.print("<form  action='updteBookController' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+bb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='bookName' value='"+bb.getBookName()+"'/></td></tr>");
	   	pw.print("<tr><td>authorName: </td> <td><input type='text' name='authorName' value='"+bb.getAuthorName()+"'/></td></tr>");
	   	pw.print("<tr><td>BookId:</td> <td><input type='text' name='bookId' value='"+bb.getBookId()+"'/></td></tr>");
	  
	    pw.print("<tr><td><input type='submit' value='Update'></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		
	}

}
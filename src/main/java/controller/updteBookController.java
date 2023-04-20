package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.BookInfoBo;
import com.bo.StudentInfoBo;
import com.dao.BookDao;

/**
 * Servlet implementation class updteBookController
 */
@WebServlet("/updteBookController")
public class updteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updteBookController() {
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
		
		String bookName=request.getParameter("bookName");
		String authorName=request.getParameter("authorName");
		String bookId=request.getParameter("bookId");
		
		
		BookInfoBo bb=new BookInfoBo( id, bookName, authorName, bookId);
		
		int status=BookDao.updateBook(bb);
		
		if(status>0)
		{
			pw.print("<script>alert('Your data has been updated succesfully')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("AllBookDataController");
			rd.include(request, response);	
			
		}
		
		else
		{
			pw.print("<script>alert('Something went erong')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("AllBookDataController");
			rd.include(request, response);
			
			
		}
		
	}

}
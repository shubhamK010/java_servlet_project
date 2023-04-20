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
 * Servlet implementation class AddBookController
 */
@WebServlet("/AddBookController")
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
         response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String bookName=request.getParameter("bookName");
		String authorName=request.getParameter("authorName");
		String bookId=request.getParameter("bookId");
		
		BookInfoBo  bb=new BookInfoBo(bookName, authorName, bookId);
		
		int status=BookDao.addBook(bb);
		
		if(status>0)
		{
			
			pw.print("<script>alert('Your data is inserted')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("welcome.html");
			rd.forward(request, response);
			
		}
		else
		{
			
			pw.print("<script>alert('Data not inserted')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("welcome.html");
			rd.forward(request, response);
		}
		
	}

}
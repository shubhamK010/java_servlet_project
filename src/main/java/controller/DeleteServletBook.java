package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;

/**
 * Servlet implementation class DeleteServletBook
 */
@WebServlet("/DeleteServletBook")
public class DeleteServletBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServletBook() {
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
		
		int status=BookDao.deleteBookData(id);
		
		
		if (status>0)
		{
			
			pw.print("<script>alert('Your data has been succesfully deleted')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("AllBookDataController");
			rd.include(request, response);
			
			
		}
		
		else
		{
			pw.print("<script>alert('Something went wrong!!!!')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("AllStudentDataController");
			rd.include(request, response);
			
		}
	}

}
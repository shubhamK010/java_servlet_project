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
 * Servlet implementation class adminController
 */
@WebServlet("/adminController")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminController() {
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
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		
		
		boolean status=false;
		
		
		status = BookDao.adminValidate(email, password);
		
		
		if(status)
		{
			pw.print("<script>alert('Succesfully login')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("welcome.html");
			rd.forward(request, response);
		}
		
		
		
		else
		{
			 pw.print("<script> alert('username or password invalid!!')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("admin.html");
			rd.include(request, response);
			
		}
	}

}

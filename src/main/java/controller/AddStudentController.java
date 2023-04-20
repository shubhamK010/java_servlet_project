package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.StudentInfoBo;
import com.dao.BookDao;

/**
 * Servlet implementation class AddStudentController
 */
@WebServlet("/AddStudentController")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentController() {
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
		
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String phone=request.getParameter("phone");
		String subject=request.getParameter("subject");
		String idType=request.getParameter("idType");
		String idNumber=request.getParameter("idNumber");
		
		StudentInfoBo sb=new StudentInfoBo(  fullName, email, dob, phone, subject, idType, idNumber);
		
		int status=BookDao.addStudent(sb);
		
		if(status>0)
		{
			
			pw.print("Your data is inserted");
			
		}
		else
		{
			
			pw.print("Data not inserted");
		}
		
		
		
		
		
	}

}

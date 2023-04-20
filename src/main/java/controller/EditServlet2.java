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
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
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
		
		StudentInfoBo sb=BookDao.getInfoById(id);
		
		pw.print("<form  action='updateController' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+sb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='fullName' value='"+sb.getFullName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+sb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Dob:</td> <td><input type='date' name='dob' value='"+sb.getDob()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone : </td> <td><input type='text' name='phone' value='"+sb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>Subject: </td> <td> <select name =\"subject\">\r\n"
	   			+ "          \r\n"
	   			+ "          <option value=\"Polity\" <% if (sb.getSubject().equals(\"Polity\"))  %>Polity</option>\r\n"
	   			+ "				<option value=\"History\" <% if (sb.getSubject().equals(\"History\"))  %>  >History</option>\r\n"
	   			+ "				<option value=\"Science\" <% if (sb.getSubject().equals(\"Science\"))  %> >Science</option>\r\n"
	   			+ "				<option value=\"Marathi\" <% if (sb.getSubject().equals(\"Marathi\"))  %> >Marathi</option>\r\n"
	   			+ "				<option value=\"Current_Affairs\" <% if (sb.getSubject().equals(\"Current_Affairs\")) %> >Current_Affairs</option>\r\n"
	   			+ "				<option value=\"English\" <% if (sb.getSubject().equals(\"English\"))  %> >English</option>\r\n"
	   			+ "				<option value=\"Economics\" <% if (sb.getSubject().equals(\"Economics\")) %>>Economics</option>"
	   			+ "             \r\n"
	   			+ "\r\n"
	   			+ "\r\n"
	   			+ "        </select></td></tr>");
	   	pw.print("<tr><td>IdType: </td> <td><input type='text' name='idType' value='"+sb.getIdType()+"'/></td></tr>");
	   	pw.print("<tr><td>IdNumber </td> <td><input type='text' name='idNumber' value='"+sb.getIdNumber()+"'/></td></tr>");
	    pw.print("<tr><td><input type='submit' value='Update'></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		
		
		
	}

}
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.BookInfoBo;
import com.bo.StudentInfoBo;
import com.dao.BookDao;

/**
 * Servlet implementation class AllBookDataController
 */
@WebServlet("/AllBookDataController")
public class AllBookDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBookDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<script src='https://kit.fontawesome.com/a076d05399.js'crossorigin='anonymous'></script>");

		
		pw.print("<link rel=\"stylesheet\" href=\"css/style.css\">");
		
		
		List<BookInfoBo> list=BookDao.getBookData();
		
		pw.print("<table border='1px solid black'; width ='100%'>");
        pw.print("<tr><th> id</th><th> bookName</th><th> authorName</th><th> bookId</th><th>  Edit</th><th>  Delete</th></tr>"); //<th>  Actions</th>
		
		for(BookInfoBo bb:list)
		{
			pw.print("<tr><td>"+bb.getId()+"</td><td>"+bb.getBookName()+"</td><td>"+bb.getAuthorName()+"</td><td>"+bb.getBookId()+"</td><td>"+"<a href='EditServlet2Book?id="+bb.getId()+"'> <i class='fas fa-edit'></i> </a>  </td> <td><a href='DeleteServletBook?id="+bb.getId()+"'><i class=\"fas fa-trash-alt\" style=\" color:red; \"></i> </a></td></tr>");
			
			
		}
			
		
		pw.print("</table>");
	}

}
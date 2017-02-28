package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import conn.ConnectDB;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name= request.getParameter("name");
		String gen= request.getParameter("gender");
		String age= request.getParameter("age");
		User user= new User(null,name,gen,age);
		ConnectDB conn=new ConnectDB();
		try {
			if(conn.insert(user)){
				response.sendRedirect("index.jsp");	
			}
			else response.sendRedirect("insert.jsp");
		} catch (Exception e) {response.sendRedirect("insert.jsp");}
	}

}

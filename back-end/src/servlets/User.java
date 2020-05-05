package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

/**
 * Servlet implementation class User
 */
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append(request.getContextPath());
		String key = request.getParameter("key");
		response.setContentType("text/JSON");
		PrintWriter out = response.getWriter();
		try {
			out.println(services.Users.getUser(key));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append(request.getContextPath());
		String firstname = request.getParameter("firstname");
		String login = request.getParameter("login");
		String mobilePhone = request.getParameter("mobilePhone");
		String password = request.getParameter("password");
		String lastname = request.getParameter("lastname");
		String  sexe = request.getParameter("sexe"); 
		
		response.setContentType("text/JSON");
		PrintWriter out = response.getWriter();
		try {
			//System.out.println("--------------------------------------------------------------");
			out.println(services.Users.createUser(firstname,lastname ,login, mobilePhone, password,Integer.parseInt(sexe)));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append(request.getContextPath());
		String key = request.getParameter("key");
		response.setContentType("text/JSON");
		PrintWriter out = response.getWriter();
		try {
			out.println(services.Users.removeUser(key));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

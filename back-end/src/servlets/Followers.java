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
 * Servlet implementation class Posts
 */
public class Followers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Followers() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append(request.getContextPath());
		String key = request.getParameter("key");
		String nameFollowed = request.getParameter("nameFollowed");
		String behaviour = request.getParameter("behaviour");
		response.setContentType("text/JSON");
		PrintWriter out = response.getWriter();

		try {
			out.println(services.Followers.getFollower(key, nameFollowed,Integer.parseInt(behaviour)));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append(request.getContextPath());
		String key = request.getParameter("key");
		String idFollow = request.getParameter("idFollow");
		response.setContentType("text/JSON");
		PrintWriter out = response.getWriter();
		try {
			out.println(services.Followers.follow(key, idFollow));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append(request.getContextPath());
		String key = request.getParameter("key");
		String idFollowed = request.getParameter("idFollowed");
		response.setContentType("text/JSON");
		PrintWriter out = response.getWriter();
		try {
			out.println(services.Followers.unfollow( key , idFollowed));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}

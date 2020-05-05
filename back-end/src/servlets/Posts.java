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
public class Posts extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Posts() {
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
			out.println(services.Posts.getPost(key));
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
		//System.out.println("je suis la ");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String key = request.getParameter("key");
		String text = request.getParameter("text");
		response.setContentType("text/JSON");
		PrintWriter out = response.getWriter();
		try {
			out.println(services.Posts.addPost(key, text));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String key = request.getParameter("key");
		String idPost = request.getParameter("idPost");
		String text = request.getParameter("text");
		response.setContentType("text/JSON");
		PrintWriter out = response.getWriter();
		try {
			out.println(services.Posts.editPost(key, idPost, text));
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String key = request.getParameter("key");
		String idPost = request.getParameter("idPost");
		response.setContentType("text/JSON");
		PrintWriter out = response.getWriter();
		try {
			out.println(services.Posts.removePost( key , idPost));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}

package services;

import java.sql.SQLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

public class Posts {

	public static JSONObject getPost(String key) throws JSONException {
		// TODO Auto-generated method stub
		try {
			if (key == null || key == "")
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.SessionTools.isConnected(key))
				return tools.AnswerJson.serviceRefused("code", 2);
			if (!tools.UserTools.userExist(tools.SessionTools.getIdUserByKey(key)))
				return tools.AnswerJson.serviceRefused("code", -1);

			return tools.PostsTools.getPosts(tools.SessionTools.getIdUserByKey(key));

		} catch (JSONException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 100));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 100);
		} catch (SQLException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 1000));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		}
	}

	// ===========================================================================
	public static JSONObject addPost(String key, String text) throws JSONException {
		// TODO Auto-generated method stub
		try {
			if (key == null || text == null || key == "" || text == "")
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.SessionTools.isConnected(key))
				return tools.AnswerJson.serviceRefused("code", 2);
			if (!tools.UserTools.userExist(tools.SessionTools.getIdUserByKey(key)))
				return tools.AnswerJson.serviceRefused("code", -1);

			return tools.PostsTools.addPost(tools.SessionTools.getIdUserByKey(key), text);

		} catch (JSONException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 100));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 100);
		} catch (SQLException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 1000));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		}

	}
	// =======================================================================================

	public static JSONObject editPost(String key, String idPost, String text) throws JSONException {
		// TODO Auto-generated method stub
		try {
			if (key == null || key == "" || idPost == "" || idPost == null || text == null || text == "")
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.SessionTools.isConnected(key))
				return tools.AnswerJson.serviceRefused("code", 2);
			if (!tools.UserTools.userExist(tools.SessionTools.getIdUserByKey(key)))
				return tools.AnswerJson.serviceRefused("codes", -1);
			return tools.PostsTools.editPost(tools.SessionTools.getIdUserByKey(key), idPost, text);

		} catch (JSONException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 100));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 100);
		} catch (SQLException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 1000));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		}
	}

	// ========================================================================================
	public static JSONObject removePost(String key, String idPost) throws JSONException {
		// TODO Auto-generated method stub
		try {
			if (key == null || key == "" || idPost == null || idPost == "")
				return tools.AnswerJson.serviceRefused("code ", -1);
			if (!tools.SessionTools.isConnected(key))
				return tools.AnswerJson.serviceRefused("code", 2);
			if (!tools.UserTools.userExist(tools.SessionTools.getIdUserByKey(key)))
				return tools.AnswerJson.serviceRefused("code", -1);

			return tools.PostsTools.removePost(key, idPost);

		} catch (JSONException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 100));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 100);
		} catch (SQLException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 1000));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		}
	}
	// ===============================================================================

}

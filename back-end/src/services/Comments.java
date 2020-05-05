package services;

import java.sql.SQLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

public class Comments {

	public static JSONObject comment(String idPost, String text, String firstName, String lastName, String idUser)
			throws JSONException {
		// TODO Auto-generated method stub
		try {
			if (idPost == null || text == null || idPost == "" || text == "")
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.UserTools.userExist(idUser))
				return tools.AnswerJson.serviceRefused("code", -1);

			return tools.CommentTools.comment(firstName, lastName, idPost, text);

		} catch (JSONException e) {
			System.out.println(tools.AnswerJson.serviceRefused("code", -1));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 100);
		} catch (SQLException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 1000));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);
		}
	}

	public static JSONObject getComments(String idPost) throws JSONException {
		// TODO Auto-generated method stub
		try {
			if (idPost == null || idPost == "")
				return tools.AnswerJson.serviceRefused("code", -1);
			
			return tools.CommentTools.getComments(idPost);

		} catch (JSONException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 100));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 100);
		}
	}
	
	

}

package services;

import java.sql.SQLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

public class Like {

	public static JSONObject unlike(String idUser, String idPost) throws JSONException, SQLException {

		try {
			if (idPost == null || idUser == null || idUser == "" || idPost == "")
				return tools.AnswerJson.serviceRefused("code", -1);

			

			return tools.likeTools.unlike(idUser, idPost);

		} catch (JSONException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 100));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 100);
		}
	}

	public static JSONObject like(String idUser, String idPost) throws JSONException {

		try {
			if (idPost == null || idUser == null || idUser == "" || idPost == "")
				return tools.AnswerJson.serviceRefused("code", -1);

			

			return tools.likeTools.like(idUser, idPost);

		} catch (JSONException | SQLException e) {
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 100));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 100);
		}
	}

}

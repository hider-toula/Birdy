package services;

import java.sql.SQLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

public class Followers {

	// =================================================================================
	public static JSONObject unfollow(String key, String idFollowed) throws JSONException {

		// TODO Auto-generated method stub
		try {
			if (key == null || idFollowed == null)
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.SessionTools.isConnected(key))
				return tools.AnswerJson.serviceRefused("code", 2);
			if (!tools.UserTools.userExist(idFollowed))
				return tools.AnswerJson.serviceRefused("code", -1);
			tools.FollowersTools.unfollow(tools.SessionTools.getIdUserByKey(key), idFollowed);
			return tools.AnswerJson.serviceAccepted("code", -1);
		} catch (JSONException e) {
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1001);

		} catch (SQLException e) {
			e.printStackTrace();
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		}
	}
	// =============================================================================

	public static JSONObject getFollower(String key, String nameFollowed, int behaviour) throws JSONException {
		// TODO Auto-generated method stub
		
		try {
			if (key == null || key == "")
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.SessionTools.isConnected(key))
				return tools.AnswerJson.serviceRefused("code", 2);
			if (!tools.UserTools.userExist(tools.SessionTools.getIdUserByKey(key)))
				return tools.AnswerJson.serviceRefused("code", -11);
			
			

			return tools.FollowersTools.getFollowing(tools.SessionTools.getIdUserByKey(key),nameFollowed, behaviour);

		} catch (JSONException e) {
			e.printStackTrace();
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 1000));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 1000));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		}
	}

	// =====================================================================================

	public static JSONObject follow(String key, String idFollow) throws JSONException {
		// TODO Auto-generated method stub
		try {

			if (key == null || idFollow == null)
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.SessionTools.isConnected(key))
				return tools.AnswerJson.serviceRefused("code", 2);
			if (!tools.UserTools.userExist(idFollow))
				return tools.AnswerJson.serviceRefused("code", -1);
			return tools.FollowersTools.follow(tools.SessionTools.getIdUserByKey(key), idFollow);

		} catch (JSONException e) {
			e.printStackTrace();
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 1000));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 1000));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		}

	}

}

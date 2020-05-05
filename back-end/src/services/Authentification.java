package services;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;


public class Authentification {

	public static JSONObject login(String login, String password) throws JSONException {
		if (login == null || password == null || login == "" || password == "")
			return tools.AnswerJson.serviceRefused("code", -1);
		try {
			if (!tools.UserTools.loginExist(login))
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.UserTools.checkPsswd(login, password))
				return tools.AnswerJson.serviceRefused("code", -1);
			return tools.AthentificationTools.login(login);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tools.AnswerJson.serviceRefused("code", -1);

		}catch(JSONException e) {
			System.out.println("json probleme !");
			return tools.AnswerJson.serviceRefused("code ", -1);

		}

	}

	public static JSONObject logout(String key) throws JSONException {
		// TODO Auto-generated method stub

		if (key == null || key == "")
			return tools.AnswerJson.serviceRefused("code", -1);
		
		try {
			return tools.AthentificationTools.logout(key);
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tools.AnswerJson.serviceRefused("code", -1);
		}

	}
}

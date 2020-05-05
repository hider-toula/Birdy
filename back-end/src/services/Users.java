package services;

import java.sql.SQLException;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;


public class Users {

	// ==============================================================================
	public static JSONObject getUser(String key) throws JSONException {
		try {
			if (key == null || key == "")
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.SessionTools.isConnected(key))
				return tools.AnswerJson.serviceRefused("code", 2);
			else
				return tools.UserTools.getUser(tools.SessionTools.getIdUserByKey(key));
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			System.out.println(tools.AnswerJson.serviceRefused(e.getMessage(), 1000));
			return tools.AnswerJson.serviceRefused(e.getMessage(), 1000);

		}
	}

	// ========================================================================
	public static JSONObject createUser(String firstname, String lastname, String login, String mobilePhone,
			String password ,int sexe ) throws JSONException {
		// TODO Auto-generated method stub
		

		try {
			if (lastname == null || login == null || password == null || mobilePhone == null || lastname == ""
					|| login == "" || password == "" || mobilePhone == "" || (sexe != -1 && sexe != 1))
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.AthentificationTools.mailValid(login))
				return tools.AnswerJson.serviceRefused("code", -1);
			if (tools.UserTools.loginExist(login))
				return tools.AnswerJson.serviceRefused("code", -1);
			return tools.UserTools.createUser(lastname, firstname, login, mobilePhone, password,sexe);

		} catch (Exception e) {
			// TODO: handle exception
			return tools.AnswerJson.serviceRefused(e.getMessage(), 100);

		}

	}

	// ========================================================================
	public static JSONObject removeUser(String key) throws JSONException {
		try {
			if (key == null)
				return tools.AnswerJson.serviceRefused("code", -1);
			if (!tools.SessionTools.isConnected(key)) {
				System.out.println("zebi");
				return tools.AnswerJson.serviceRefused("code", 2);
			}
			
			System.out.println(tools.SessionTools.getIdUserByKey(key));
			 tools.UserTools.removeUser(Integer.parseInt(tools.SessionTools.getIdUserByKey(key)));
			 return tools.AnswerJson.serviceAccepted("code", 1);

		} catch (JSONException e ) {
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

package tools;

import org.json.JSONException;
import org.json.JSONObject;

public class AnswerJson {

	public static JSONObject serviceRefused(String message, int code) throws JSONException {
		// TODO Auto-generated method stub
		return new JSONObject().put(message, code);
	}
	
	public static JSONObject serviceAccepted(String message, int code) throws JSONException {
		// TODO Auto-generated method stub
		 return new JSONObject().put(message, code);
	}

}

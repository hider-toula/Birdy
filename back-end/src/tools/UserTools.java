package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;


public class UserTools {
	
	public static boolean userExist(String idUser) throws JSONException, SQLException {
		Connection connection = bd.Database.getMySQLConnection();
		String query = "SELECT * FROM user WHERE idUser='" + idUser + "'";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		boolean bool = false;
		if (rs.next())
			bool = true;
		rs.close();
		st.close();
		connection.close();
		return bool;
	}
	
	

	public static JSONObject removeUser(int idUserByKey) throws SQLException, JSONException {
		// TODO Auto-generated method stub
		Connection connection = bd.Database.getMySQLConnection();
		String query = "delete from user where idUser =" + idUserByKey;
		Statement st = connection.createStatement();
		int rs = 0;
		rs = st.executeUpdate(query);
		st.close();
		connection.close();
		if (rs > 0)
			return tools.AnswerJson.serviceAccepted("code", 1);
		return tools.AnswerJson.serviceRefused("code", -1);
	}

	public static JSONObject createUser(String lastname, String firstname, String login, String mobilePhone,
			String password, int sexe) throws SQLException, JSONException {
		System.out.println("je suis mmeme pas la");

		Connection connection = bd.Database.getMySQLConnection();
		System.out.println("je suis laaaaa");
		tests.sexe s = tests.sexe.femme;
		if (sexe == 1)
			s = tests.sexe.homme;

		String query = "INSERT INTO user(`lastname`, `firstname`, `login`, `mobilePhone`, `password`,`sexe`) VALUES ('"
				+ lastname + "','" + firstname + "','" + login + "','" + mobilePhone + "','" + password + "','" + s
				+ "')";

		Statement st = connection.createStatement();
		int rs = 0;
		rs = st.executeUpdate(query);
		st.close();
		connection.close();
		if (rs > 0)
			return tools.AnswerJson.serviceAccepted("code", 1);
		return tools.AnswerJson.serviceRefused("code", -1);

	}

	public static boolean checkPsswd(String login, String password) throws SQLException {
		Connection connection = bd.Database.getMySQLConnection();
		String query = "SELECT * FROM user WHERE user.login='" + login + "' AND user.password='" + password + "'";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		boolean bool = false;
		if (rs.next()) {
			bool = true;
			
		} else
			
		rs.close();
		st.close();
		connection.close();
		return bool;
	}

	public static JSONObject getUser(String idUser) throws SQLException, JSONException {
		Connection connection = bd.Database.getMySQLConnection();
		String query = "SELECT * FROM user WHERE user.idUser='" + idUser + "'";
		Statement st = connection.createStatement();
		ResultSet result = st.executeQuery(query);
		result.next();
		String name = result.getString("firstName");
		String lastname = result.getString("lastName");
		String nbPhone = result.getString("mobilePhone");
		String login = result.getString("login");
		@SuppressWarnings("unused")
		String date = result.getString("date");
		@SuppressWarnings("unused")
		String nbComents = result.getString("nbComents");
		@SuppressWarnings("unused")
		String nbFollowing = result.getString("nbFollowing");
		@SuppressWarnings("unused")
		String nbFllowers = result.getString("nbFollowers");
		@SuppressWarnings("unused")
		String sexe = result.getString("sexe");
		System.out.println( "votre nom est :"+name+"\nvotre prenom est ;" +lastname +"\n votre login est "+login +"\n votre numero de tel est :" +nbPhone);

		JSONObject res = new JSONObject();
		res.put("idUser", idUser);
		res.put("firstName", name);
		res.put("lastName", lastname);
		res.put("date", date);
		res.put("nbFollowing", nbFollowing);
		res.put("nbFllowers", nbFllowers);
		res.put("code", 1);
		
		return res;
	}

	public static boolean loginExist(String login) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = bd.Database.getMySQLConnection();
		String query = "SELECT * FROM user WHERE user.login='" + login + "'";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		boolean bool = false;
		if (rs.next())
			bool = true;
		rs.close();
		st.close();
		connection.close();
		return bool;
	}
	
	public static String getName(String idUser) throws SQLException {
		
		Connection connection = bd.Database.getMySQLConnection();
		String query = "SELECT user.firstName FROM user WHERE user.idUser='" + idUser +  "'";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String result = rs.getString("firstName");

		rs.close();
		st.close();
		connection.close();
		
		return result;
		
	}

}

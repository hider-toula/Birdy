package tools;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;


public class AthentificationTools {

	public static JSONObject login(String login) throws SQLException, JSONException {

		Connection connection = bd.Database.getMySQLConnection();
		String query = "SELECT * FROM USER WHERE USER.login= '"+login+"'";
		Statement st1 = connection.createStatement();
		ResultSet rs=st1.executeQuery(query);
		int idUser=0;
		String firstName ="";
		String lastName ="";
		int  nbFollowing=0;
		int nbFollowers=0;
		Date date = null ;
		if(rs.next()) {
			System.out.println("le probleme est surment la !!");
			idUser=rs.getInt("idUser");
			firstName=rs.getString("firstName");
			lastName=rs.getString("lastName");
			nbFollowing=rs.getInt("nbFollowing");
			nbFollowers=rs.getInt("nbFollowers");
			date=rs.getDate("date");

		}
		
		String key=tools.AthentificationTools.generateKey(); //cr�ation d'une session
		//String date =new SimpleDateFormat("dd/MM/yyyy/hh/mm/ss").format(new Date());
		String query2="INSERT INTO session(`idUser`,`idS`)  VALUES ('"+idUser+"','"+key+"')";
		
		@SuppressWarnings("unused")
		int rs2=st1.executeUpdate(query2);
		
		rs.close();
		st1.close();
		connection.close();
		
		JSONObject res = new JSONObject();
		
		res.put("code", 1);
		res.put("key", key);
		res.put("date", date);
		res.put("idUser", idUser);
		res.put("firstName", firstName);
		res.put("lasName", lastName);
		res.put("nbFollowings", nbFollowing);
		res.put("nbFollowers", nbFollowers);
		
		
		return res;
	}

	public static boolean mailValid(String login) {
		// TODO Auto-generated method stub
		return login.matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+");
	}

	public static JSONObject logout(String key) throws SQLException, JSONException {

		Connection connection = bd.Database.getMySQLConnection();
		String query = "DELETE FROM session WHERE session.idS='" + key + "'";
		Statement st = connection.createStatement();
		st.executeUpdate(query);
		JSONObject json = new JSONObject().put("code", 1); // IL Faut gerer la session
		st.close();
		connection.close();
		return json; 

	}

	public static String generateKey() {
		String ch1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String pass = "";
		Random rand = new Random();
		for (int i = 0; i < 32; i++) {
			int j = (int) rand.nextInt(ch1.length());
			pass = pass + ch1.charAt(j);
		}
		return pass;

	}

}

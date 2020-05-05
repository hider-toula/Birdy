
package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

public class FollowersTools {

	public static JSONObject follow(String idUser, String idFollow) throws SQLException, JSONException {

		Connection connection = bd.Database.getMySQLConnection();
		Statement st = connection.createStatement();
		String query = "INSERT INTO followrs(`idUser` , `idFollower`) VALUES ('" + idUser + "','" + idFollow + "')";
		int cpt = 0;
		cpt = st.executeUpdate(query);
		query = "UPDATE USER SET nbFollowing = nbFollowing+ 1 WHERE USER.idUser='" + idUser + "'";
		cpt = st.executeUpdate(query);
		query = "UPDATE USER SET nbFollowers = nbFollowers+ 1 WHERE USER.idUser='" + idFollow + "'";
		cpt = st.executeUpdate(query);

		if (cpt == 0) {
			return tools.AnswerJson.serviceRefused("probleme d'insertion", 404);
		}
		// incr�menter dans la table user
		return tools.AnswerJson.serviceAccepted("code", 1);
		
	}

	public static JSONObject unfollow(String idUser, String idFollowed) throws SQLException, JSONException {
		// TODO Auto-generated method stub
		Connection connection = bd.Database.getMySQLConnection();
		Statement st = connection.createStatement();
		String query = "DELETE FROM followrs WHERE idUser='" + idUser + "' AND idFollower='" + idFollowed + "'";
		int cpt = 0;
		cpt = st.executeUpdate(query);
		query = "UPDATE USER SET nbFollowing = nbFollowing- 1 WHERE USER.idUser='" + idUser + "'";
		cpt = st.executeUpdate(query);
		query = "UPDATE USER SET nbFollowers = nbFollowers- 1 WHERE USER.idUser='" + idFollowed + "'";
		cpt = st.executeUpdate(query);

		if (cpt == 0) {
			return tools.AnswerJson.serviceRefused("code", -1);
		}

		return tools.AnswerJson.serviceAccepted("code", 1);
	}

	public static JSONObject getFollowing(String idUser, String nameFollowed, int behaviour)
			throws SQLException, JSONException {

		Connection connection = bd.Database.getMySQLConnection();
		if (nameFollowed == "") {
			if (behaviour == 1) {
				String query = "SELECT * FROM followrs WHERE followrs.idUser='" + idUser + "'";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);
				JSONObject resultat = new JSONObject();
				int cpt=0;
				while (rs.next()) {
					String label = ""+cpt;
					resultat.put(label, tools.UserTools.getUser(rs.getString("idFollower")));
					cpt++;
				}
				rs.close();
				st.close();
				connection.close();
				return resultat.put("code", 1);
			} else if (behaviour == 2) {
				String query = "SELECT * FROM Followrs WHERE idFollower='" + idUser + "'";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);
				JSONObject resultat = new JSONObject();
				int cpt =0;
				while (rs.next()) {
					String label = ""+cpt;
					resultat.put(label, tools.UserTools.getUser(rs.getString("idUser")));
					cpt++;
					System.out.println(rs.getString("idUser"));
				}
				rs.close();
				st.close();
				connection.close();
				return resultat.put("code", 1);
			}
		} else {
			String query = "SELECT * FROM user WHERE user.firstName='" + nameFollowed + "'";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			JSONObject resultat = new JSONObject();
			int cpt =0;
			while (rs.next()) {
				String label = ""+cpt;
				resultat.put(label, tools.UserTools.getUser(rs.getString("idUser")));
				cpt++;
				System.out.println(rs.getString("firstName"));
			}
			rs.close();
			st.close();
			connection.close();
			return resultat.put("code", 1);

		}

		return null;

	}

}

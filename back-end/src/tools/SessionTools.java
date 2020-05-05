package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;

public class SessionTools {
	public static String getIdUserByKey(String key) throws SQLException {
		Connection connection = bd.Database.getMySQLConnection();
		String query = "SELECT idUser FROM session WHERE idS='" + key + "'";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		String idUser = " ";
		if (rs.next()) {
			idUser = rs.getString("idUser");

		}
		rs.close();
		st.close();
		connection.close();
		System.out.println(idUser);
		return idUser;
	}

	public static boolean isConnected(String key) throws SQLException, ParseException, JSONException {
		

		Connection connection = bd.Database.getMySQLConnection();
		String query = "SELECT * FROM session WHERE idS='" + key + "'";

		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);

		System.out.println(rs.toString());
		boolean bool = false;
		bool = rs.next();
		
		if (bool) {
			String dateS = rs.getString("date");
			
			System.out.println(dateS);

			Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateS);

			long diff = new Date().getTime() - date1.getTime();
			System.out.println("date mnt=" + new Date().getTime());
			System.out.println("dateS = " + date1.getTime());
			System.out.println("avant diff = " + diff);
			diff = TimeUnit.MILLISECONDS.toSeconds(diff);
			System.out.println("diff apr�s est :" + diff);
			if (diff > 695465550) {
				bool = false;
				System.out.println("je me deconecte");
				tools.AthentificationTools.logout(key);
			} else {
				query = "UPDATE session set date= CURRENT_TIMESTAMP() WHERE idS='" + key + "'";
				@SuppressWarnings("unused")
				int m = st.executeUpdate(query);

			}
		}
		rs.close();
		st.close();
		connection.close();

		return bool;
	}

	public static String generateKey() {
		String ch1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String pass = "";
		Random rand = new Random();
		for (int i = 0; i < 32; i++) {
			int j = (int) rand.nextInt(ch1.length());
			pass = pass + ch1.charAt(j);
		}
		return ch1;

	}
}

package tools;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import bd.Database;

public class PostsTools {

//AVEC MONGODB

	public static JSONObject addPost(String idUser, String text) throws SQLException, JSONException {
		// TODO Auto-generated method stub

		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> coll = db.getCollection("post");
		Document doc = new Document();
		GregorianCalendar calendar = new GregorianCalendar();
		JSONObject user = UserTools.getUser(idUser);
		Object id = user.get("idUser");
		Object lastName = user.get("lastName");
		Object firstName = user.get("firstName");
		doc.append("lastName", lastName);
		doc.append("id_user", id);
		doc.append("firstName", firstName);
		doc.append("text", text);
		doc.append("date", calendar.getTime());
		doc.append("nb_comments", 0);
		doc.append("nb_likes", 0);
		doc.append("likes", new ArrayList());
		coll.insertOne(doc);
		System.out.println("vous ete des chikoours ");
		return new JSONObject().put("post", doc).put("code", 1);

	}

	public static JSONObject removePost(String idUser, String idPost) throws SQLException, JSONException {
		// TODO Auto-generated method stub
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> coll = db.getCollection("post");

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("_id", new ObjectId(idPost));
		MongoCursor<Document> result = coll.find(whereQuery).iterator();
		if (result.hasNext()) {
			coll.deleteOne(result.next());
		}
		return tools.AnswerJson.serviceAccepted("code ", 1);
	}

	public static JSONObject editPost(String idUser, String idPost, String newText) throws JSONException, SQLException {

		// TODO Auto-generated method stub
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> coll = db.getCollection("post");
		// coll.updateOne({"_id" , new ObjectId(idPost)}, { $set: { age: 50 } } )

		Document found = (Document) coll.find(new Document("_id", new ObjectId(idPost))).first();
		if (found != null) {
			Bson updatedValue = new Document().append("text", newText);
			Bson updateOperation = new Document("$set", updatedValue);
			coll.updateOne(found, updateOperation);
		}

		return tools.AnswerJson.serviceAccepted("code ", 1);
	}

	public static JSONObject getPosts(String idUserByKey) throws JSONException {
		// TODO Auto-generated method stub
		JSONObject res = new JSONObject();
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> coll = db.getCollection("post");
		Document doc = new Document();

		MongoCursor<Document> result = coll.find().iterator();
		int cpt = 0;
		while (result.hasNext()) {
			doc = result.next();
			res.put("" + cpt, doc);
			cpt++;
		}

		return res;
	}

}

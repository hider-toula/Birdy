package tools;

import java.sql.SQLException;
import java.util.ArrayList;

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

public class likeTools {

	public static JSONObject like(String idUser, String idPost) throws SQLException, JSONException {
		
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> coll = db.getCollection("post");
		// coll.updateOne({"_id" , new ObjectId(idPost)}, { $set: { age: 50 } } )
		
		Document found = (Document) coll.find(new Document("_id", new ObjectId(idPost))).first();
		
		if(found != null) {
			ArrayList likes = (ArrayList) found.get("likes");
			ArrayList like = (ArrayList) likes.clone();
			like.add(idUser);
			System.out.println(found);
			Bson updatedValue = new Document().append("nb_likes", (int) found.get("nb_likes")+1).append("likes", like);
			Bson updateOperation = new Document("$set",updatedValue);
			System.out.println(updateOperation);
			coll.updateOne(found,updateOperation );
		}
		return tools.AnswerJson.serviceAccepted("code ", 1);
	}

	public static JSONObject unlike(String idUser, String idPost) throws JSONException {
		// TODO Auto-generated method stub
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> coll = db.getCollection("post");
		// coll.updateOne({"_id" , new ObjectId(idPost)}, { $set: { age: 50 } } )
		
		Document found = (Document) coll.find(new Document("_id", new ObjectId(idPost))).first();
		
		if(found != null) {
			ArrayList likes = (ArrayList) found.get("likes");
			ArrayList like = (ArrayList) likes.clone();
			like.remove(idUser);
			System.out.println(found);
			Bson updatedValue = new Document().append("nb_likes", (int) found.get("nb_likes")-1).append("likes", like);
			Bson updateOperation = new Document("$set",updatedValue);
			System.out.println(updateOperation);
			coll.updateOne(found,updateOperation );
		}
		return tools.AnswerJson.serviceAccepted("code ", 1);
	}
}

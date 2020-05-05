package tools;

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

public class CommentTools {

	public static JSONObject comment(String firstName, String lastName, String idPost, String text)
			throws JSONException {
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> col = db.getCollection("comment");
		Document doc = new Document();
		GregorianCalendar calendar = new GregorianCalendar();
		doc.append("idPost", idPost);
		doc.append("firstName", firstName);
		doc.append("lastName", lastName);
		doc.append("text", text);
		doc.append("date", calendar.getTime());
		col.insertOne(doc);

		
		MongoCollection<Document> coll = db.getCollection("post");
		// coll.updateOne({"_id" , new ObjectId(idPost)}, { $set: { age: 50 } } )
		
		Document found = (Document) coll.find(new Document("_id", new ObjectId(idPost))).first();
		if(found != null) {
			Bson updatedValue = new Document().append("nb_comments", (int) found.get("nb_comments")+1);
			Bson updateOperation = new Document("$set",updatedValue);
			coll.updateOne(found,updateOperation );
		}
		


		return new JSONObject().put("comment", doc).put("code", 1);
	}

	public static JSONObject getComments(String idPost) throws JSONException {
		// TODO Auto-generated method stub

		JSONObject res = new JSONObject();
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> comments = db.getCollection("comment");
		Document doc = new Document();
		BasicDBObject whereQuery = new BasicDBObject();
		System.out.println(idPost);
		whereQuery.put("idPost", idPost);

		MongoCursor<Document> result = comments.find(whereQuery).iterator();
		System.out.println(result);
		System.out.println(doc);
		int cpt = 0;
		while (result.hasNext()) {
			doc = result.next();
			System.out.println(res);
			res.put("" + cpt, doc);
			cpt++;
		}

		return res;
	}

}

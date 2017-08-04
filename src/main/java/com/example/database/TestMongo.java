package com.example.database;

import java.util.ArrayList;
import java.util.List;

import com.example.Entity.OximeterModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class TestMongo {
	
	public static void main(String[] args) {
		List<DBObject> owners = new ArrayList<DBObject>();
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("test");
		DBCollection userCollection = db.getCollection("myNewCollection");
		
		DBObject query = new BasicDBObject();
		
		OximeterModel oxi = new OximeterModel(98);
		
		query.put("oxygenContent", oxi.getOxygenContent());
		//query.put("pulse", oxi.getPulse());
		query.put("mac", "");
		//query.put("timestamp", oxi.getTimestamp());
		
		DBCursor ownerCursor = userCollection.find(query);
		
		System.out.println(query.toString());


		int i=0;
		while(ownerCursor.hasNext()){
			owners.add(ownerCursor.next());
			System.out.println("owners "+owners.get(i++).toString());
		}
		if(owners == null) System.out.println("the list is empty");
		
	}

}

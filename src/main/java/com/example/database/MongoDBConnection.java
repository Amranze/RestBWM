package com.example.database;


import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.example.Entity.UserEntity;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
	
	public DBCollection MongodbConnection() {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("test");
		DBCollection userCollection = db.getCollection("myNewCollection");
		return userCollection;
	}
	
	public static void main(String[] args){
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			System.out.println("The database is connected succefully ");
			List<String> databases = mongo.getDatabaseNames();
			for(String database : databases){
				System.out.println(" database name "+  database);
			}
			DB db = mongo.getDB("test");
			System.out.println(" Name "+  db.getName());
			Set<String> Collections = db.getCollectionNames();
			for(String collection : Collections){
				System.out.println(" Collection name "+  collection);
			}
			DBCollection userCollection = db.getCollection("myNewCollection");
			System.out.println(" Count "+  userCollection.count());
			/* Query find */
	        BasicDBObject newUser = new BasicDBObject();

			newUser.put("id", 2);
			newUser.put("username", "MonogDB");
			newUser.put("password", "159753");
			newUser.put("age", 27);
			newUser.put("addresse", " 11 rue des herbages");
			
			userCollection.insert(newUser);
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("age", new BasicDBObject("$gte", 10));
			
			DBCursor users = userCollection.find();
			
			while(users.hasNext()){
				DBObject user = users.next();
				System.out.println("The User id is " + user.get("id") + " username " + user.get("username") + " password " + user.get("password") +
					" Age " + user.get("age") + " Adresse " + user.get("addresse") );
			}

			
//			if(users.length() == 0) System.out.println(" There is nothing "); 
//			while(users.hasNext() || users.count()!=0){
//				System.out.println(" There is something "); 
//				DBObject user = users.next();
//				System.out.println("The User id is " +user.get("id") + " username " + user.get("username") + " password " + user.get("password") +
//						" Age " + user.get("age") + " Adresse " + user.get("addresse") );
//			}
			mongo.close();
			/*MongoDatabase db = mongo.getDatabase("db");
			MongoCollection<Document> table = db.getCollection("myNewCollection");*/
			
		} catch (MongoException exp) {
	    	exp.printStackTrace();
	    }
	}

}

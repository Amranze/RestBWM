package com.example.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@RestController
@RequestMapping(value = "/Users")
public class UserController {
	private List<UserEntity> users;
	private long id=0;
	private DBCollection collection = MongodbConnection();
	private int counter = 0;
	
	public UserController() {
		users = new ArrayList<>();
		users.add(new UserEntity(id++, "Amrane", "123456789",23, "11 rue des herbages"));
		users.add(new UserEntity(id++, "Test", "123456789",15, "Test"));
		users.add(new UserEntity(id++, "All", "48454675484",15, "All in Test"));
	}
	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public List<UserEntity> getUsers(){
		return users;
	}
	
	
	@RequestMapping(value = "/All", method = RequestMethod.POST)
	public String setUsers(){
		return "User is added";
	}
	
	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String home(){
		return "Hello";
	}
	@RequestMapping(value = "/Age/{age}", method = RequestMethod.GET)
	public List<UserEntity> getAge(@PathVariable int age) {
		return users.parallelStream().filter(x -> x.getAge() == age).collect(Collectors.toList());
	}
	@RequestMapping(value = "/AddUser/{username}&{password}&{age}&{addresse}", method = RequestMethod.POST)
	public String addUser(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("age") int age, 
			@PathVariable("addresse") String addresse){
		users.add(new UserEntity(id++, username, password, age, addresse ));
		BasicDBObject newUser = new BasicDBObject();
		
		newUser.put("id", id);
		newUser.put("username", username);
		newUser.put("password", password);
		newUser.put("age", age);
		newUser.put("addresse", addresse);
		
		collection.insert(newUser);
		return "User is added";
	}
	
	@RequestMapping(value = "/AddUser/{username}&{password}&{age}&{addresse}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addUserWithConsumer(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("age") int age, 
			@PathVariable("addresse") String addresse){
		users.add(new UserEntity(id++, username, password, age, addresse ));
		BasicDBObject newUser = new BasicDBObject();
		
		newUser.put("id", id);
		newUser.put("username", username);
		newUser.put("password", password);
		newUser.put("age", age);
		newUser.put("addresse", addresse);
		
		collection.insert(newUser);
		return "User is added";
	}
	
	@RequestMapping(value = "/Create", method = RequestMethod.POST)
	public String addUserWithRequestedbody(@RequestBody UserEntity user){
		System.out.println("Someone Accessed to it");
		System.out.println("User is " + user.UsertoString());
		users.add(user);
		
		BasicDBObject newUser = new BasicDBObject();
		
		newUser.put("id", user.getId());
		newUser.put("username", user.getUsername());
		newUser.put("password", user.getPassword());
		newUser.put("age", user.getAge());
		newUser.put("addresse", user.getAddresse());
		
		collection.insert(newUser);
		return "User wth Body request is added";
	}
	
	@RequestMapping(value = "/AddUser", method = RequestMethod.POST)
	public String setUsersFromJson(@RequestBody UserEntity user){
		System.out.println("Someone Accessed to it");
		System.out.println("User is " + user.UsertoString());
		users.add(user);
		return "User " + counter++ +" is added"; 
	}

	@RequestMapping(value="/Oximeter", method = RequestMethod.POST)
	public String addOximeter(@RequestBody OximeterModel oximeterData){
		System.out.println("Someone Accessed to it");
		System.out.println("oximeterData is " + oximeterData.toString());
		BasicDBObject oxiData = new BasicDBObject();
		oxiData.put("oxygenContent", oximeterData.getOxygenContent());
		oxiData.put("pulse", oximeterData.getPulse());
		oxiData.put("mac", oximeterData.getMac());
		oxiData.put("timestamp", oximeterData.getTimestamp());
		collection.insert(oxiData);
		return "Oximeter"+oximeterData.toString();
		}
	
	@RequestMapping(value="/OximeterTest", method = RequestMethod.POST)
	public String addOximeterTest(@RequestBody OximeterModel oximeterData){
		System.out.println("Someone Accessed to it");
		System.out.println("oximeterData is " + oximeterData.toString());
		//String json = (new Gson()).toJson(oximeterData);
		//BasicDBObject basicdbObject = new BasicDBObject("oximeterData", json);
		//collection.insert(basicdbObject);
		return "Oximeter"+oximeterData.toString();
		}
	
	@RequestMapping(value="getOximeter", method = RequestMethod.GET)
	public List<DBObject> getOximeter(){
		System.out.println("getOximeter Someone Accessed to it");
		DBCursor oxidb = collection.find();
		List<DBObject> oxiData = new ArrayList<>();
		int j=0;
		while(oxidb.hasNext()){
			oxidb.next().removeField("_id");
			oxiData.add(oxidb.curr());
			System.out.println(oxiData.get(j++).toString());
		}
		return oxiData;
	}
	
	@SuppressWarnings("restriction")
	@RequestMapping(value="getAllOximeter", method = RequestMethod.GET)
	public String getAllOximeter(){
		DBCursor oxidb = collection.find();
		List<OximeterModel> oxiData = new ArrayList<>();
		List<DBObject> oxiDBObject = new ArrayList<>();
		while(oxidb.hasNext()){
			oxidb.next().removeField("_id");
			oxiDBObject.add(oxidb.curr());
		}
		int i =0;
		for(DBObject obj : oxiDBObject){
			oxiData.add(new OximeterModel(Integer.valueOf(obj.get("oxygenContent").toString()).intValue(), Integer.valueOf(obj.get("pulse").toString()).intValue(), obj.get("mac").toString(), Long.valueOf(obj.get("timestamp").toString()).longValue()));
			System.out.println(oxiData.get(i++));
		}
		MyOxyChart oxyChart = new MyOxyChart();
		byte out[] = oxyChart.generateChart(oxiData);
		DBObject returnOut = new BasicDBObject();
		String bytesOut = "<body><img src=\"data:image/jpeg;base64,";
		String newString = new sun.misc.BASE64Encoder().encode(out);
		bytesOut += newString;
		bytesOut += "\"></body>";
		returnOut.put("out", out);
		return bytesOut;
	}
	
	@RequestMapping(value = "/getID/{id}", method = RequestMethod.GET)
	public List<DBObject> findById(@PathVariable("id") String id){
		DBObject query = new BasicDBObject();
		query.put("username", "us1541");
		DBCursor usersDb = collection.find(query);
		List<DBObject> listDB = new ArrayList<>();
		int i=0;
		while(usersDb.hasNext()){
			listDB.add(usersDb.next());
			System.out.println(listDB.get(i).get("_id"));
			i++;
		}
		return listDB;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@RequestHeader("X-POPS") String xpops){
		return "The String is "+ xpops; 
	}
	@RequestMapping(value = "/Mongodb", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserEntity> getFromMongoDB() {
		List<UserEntity> usersEntity = new ArrayList<>();
		DBCursor usersDb = collection.find();
		while(usersDb.hasNext()){
			DBObject userdb = usersDb.next();
			String iddb = userdb.get("id").toString();
			String agedb = userdb.get("age").toString();
			UserEntity user = new UserEntity(Integer.valueOf(iddb).longValue(), userdb.get("username").toString(), 
					userdb.get("password").toString(), Integer.valueOf(agedb).intValue() , userdb.get("addresse").toString() );
			usersEntity.add(user);
		}
		return usersEntity;
	}
	
	public DBCollection MongodbConnection() {
		@SuppressWarnings("resource")
		MongoClient mongo = new MongoClient("localhost", 27017);
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("test");
		for(String name : db.getCollectionNames())
			System.out.println(" name of the collection : "+name);
		DBCollection userCollection = db.getCollection("myNewCollection");
		return userCollection;
	}
	
}

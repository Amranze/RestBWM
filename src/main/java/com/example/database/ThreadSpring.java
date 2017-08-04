package com.example.database;

import org.json.*;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.Entity.UserEntity;

public class ThreadSpring implements Runnable {
	private int id=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadSpring thread = new ThreadSpring();
	}


	ThreadSpring(){
		Thread mythreads = new Thread(this, "My runnable Thread");
		System.out.println("My thread is created " + mythreads);
		mythreads.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//final String urlString = "http://localhost:8080/AddUser";
		final String urlString = "http://localhost:8080/Users/AddUser/";
		//UserEntity user = new UserEntity(id++, "Amrane", "123456789",23, "Multi Thread");
		UserEntity user;
		for(int i=0; i<1000; i++){
			user = new UserEntity(i, "User "+i, "123456789",23+i, "Multi Thread : "+i);
			HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setContentType(MediaType.APPLICATION_JSON);

            JSONObject jsonObject = new JSONObject();
            try {
				jsonObject.put("id", 10);
	            jsonObject.put("username", "User "+i);
	            jsonObject.put("password", "Pass"+Math.random());
	            jsonObject.put("age", 23+i);
	            jsonObject.put("addresse", "Multi Thread : "+i);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HttpEntity<String> requestEntity = new HttpEntity<String>(
                    jsonObject.toString(), requestHeaders);

            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();

            // Make the network request, posting the message, expecting a String in response from the server
            ResponseEntity<String> response = restTemplate.exchange(urlString, HttpMethod.POST, requestEntity,
                    String.class);
            System.out.println("The response "+i+" is :" + response.getBody());
		}
	}

	
	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		final String urlString = "http://192.168.1.132:8080/Users/Create/";
//		//UserEntity user = new UserEntity(id++, "Amrane", "123456789",23, "Multi Thread");
//		UserEntity user;
//		for(int i=0; i<10000; i++){
//			user = new UserEntity(i, "User "+i, "123456789",23+i, "Multi Thread : "+i);
//			HttpHeaders requestHeaders = new HttpHeaders();
//            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
//
//            JSONObject jsonObject = new JSONObject();
//            try {
//				jsonObject.put("id", 10);
//	            jsonObject.put("username", "User "+i);
//	            jsonObject.put("password", "Pass"+Math.random());
//	            jsonObject.put("age", 23+i);
//	            jsonObject.put("addresse", "Multi Thread : "+i);
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			HttpEntity<String> requestEntity = new HttpEntity<String>(
//                    jsonObject.toString(), requestHeaders);
//
//            // Create a new RestTemplate instance
//            RestTemplate restTemplate = new RestTemplate();
//
//            // Make the network request, posting the message, expecting a String in response from the server
//            ResponseEntity<String> response = restTemplate.exchange(urlString, HttpMethod.POST, requestEntity,
//                    String.class);
//            System.out.println("The response "+i+" is :" + response.getBody());
//		}
//	}
}

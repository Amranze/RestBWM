package com.example.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ScaleStore")
public class ScaleStore {
	
	private MyScaleModel t;
}

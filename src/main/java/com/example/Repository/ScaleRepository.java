package com.example.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Entity.DeviceModel;
import com.example.Entity.MyScaleModel;

public interface ScaleRepository  extends MongoRepository<MyScaleModel, String>{
	
	void saveModel(DeviceModel<MyScaleModel> model);
	

}

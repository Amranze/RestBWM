package com.example.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Entity.DeviceModel;
import com.example.Entity.MyScaleEntity;
import com.example.Entity.MyScaleModel;

@Repository
public interface MyScaleRepository extends MongoRepository<MyScaleEntity, String>{

	@Query
	List<MyScaleEntity> getAllMeasurements();

}

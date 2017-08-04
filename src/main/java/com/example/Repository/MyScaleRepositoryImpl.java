package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.Entity.MyScaleEntity;
import com.example.database.MongoDBConfig;

@Repository
public class MyScaleRepositoryImpl implements MyScaleRepository {
	
	//@Autowired
	MongoDBConfig mongodbConfig = new MongoDBConfig();
	MongoTemplate mongoTemplate = mongodbConfig.mongoTemplate();

	@Override
	public <S extends MyScaleEntity> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyScaleEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyScaleEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MyScaleEntity> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MyScaleEntity> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MyScaleEntity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MyScaleEntity> List<S> findAll(Example<S> example,
			Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MyScaleEntity> findAll(Pageable pageable) {
		//remongoTemplate.findAll(MyScaleEntity.class);
		return null;
	}

	@Override
	public <S extends MyScaleEntity> S save(S entity) {
		System.out.println("save entity "+ entity.getT());
		System.out.println("save mongoTemplate "+ mongoTemplate.getCollectionName(entity.getClass()));

		mongoTemplate.save(entity);
		return entity;
	}

	@Override
	public MyScaleEntity findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<MyScaleEntity> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MyScaleEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends MyScaleEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends MyScaleEntity> S findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MyScaleEntity> Page<S> findAll(Example<S> example,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MyScaleEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends MyScaleEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MyScaleEntity> getAllMeasurements() {
		System.out.println(" mongoTemplate == null "+ mongoTemplate == null);
		return mongoTemplate.findAll(MyScaleEntity.class);
	}
}

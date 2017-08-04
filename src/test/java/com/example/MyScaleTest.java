package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Entity.MeasurementModel;
import com.example.Entity.MyScaleEntity;
import com.example.Entity.ValuesModel;
import com.example.Repository.MyScaleRepository;
import com.example.Repository.MyScaleRepositoryImpl;
import com.example.database.MongoDBConfig;


@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration({"file:src/main/resources/applicationContext.xml" })
@ComponentScan(basePackages = {"com.example"})
public class MyScaleTest {
	
	private Logger logger = LoggerFactory.getLogger(MyScaleTest.class);
	@Autowired
	private MyScaleRepository repository;
	
	MongoDBConfig mongodbConfig = new MongoDBConfig();
	MongoTemplate mongoTemplate = mongodbConfig.mongoTemplate();
	
	private MyScaleEntity measurement = new MyScaleEntity();
	private List<MeasurementModel> model = new ArrayList<MeasurementModel>();
	private List<ValuesModel> values = new ArrayList<ValuesModel>();
	
	
	@Before
	public void setUp() {
		
		System.getProperty("user.dir");

		repository = new MyScaleRepositoryImpl();
		
		values.add(new ValuesModel("15","MO"));
		values.add(new ValuesModel("25","PL"));
		values.add(new ValuesModel("89","OK"));
		values.add(new ValuesModel("87","TY"));
		values.add(new ValuesModel("12","MMH"));

		model.add(new MeasurementModel(new Date().toString(), values));
		
		measurement.setT("Balance");
		measurement.setVs(model);
	}
	
	@Test
	public void TestMyScaleRepository() {
		mongoTemplate.save(measurement);
		//repository.save(measurement);
	}
	
	/*@Test
	public void contextLoads() {
		//repostiroty = new ScaleRepositoryImpl();
		
		values.add(new ValuesModel("72.5","P"));
		values.add(new ValuesModel("35","MO"));
		values.add(new ValuesModel("65","MG"));
		values.add(new ValuesModel("55","MH"));
		values.add(new ValuesModel("22","MM"));
		values.add(new ValuesModel("183","HY"));

		measurement.add(new MyScaleModel("2017-08-01T13:56:54.123Z", values));
		
		
		model.setT("Balance");
		model.setVs(measurement);
		
		convertDeviceToDBObject();

		mongoTemplate.save(model);
		//repostiroty.saveModel(model);
		
		//MongodbConnection();
	}*/
	
	private void convertDeviceToDBObject() {
		/*for(ValuesModel value : values) {
			measurementValues.put("v", value.getV());
			measurementValues.put("ch", value.getCh());
		}
		
		System.out.println("measurementValues size "+measurementValues.size());
		
		measurementScale.append("h", measurement.getH());
		measurementScale.append("c", measurementValues);

		measurementData.append("t", model.getT());
		measurementData.append("vs", measurementScale);*/
	}

}

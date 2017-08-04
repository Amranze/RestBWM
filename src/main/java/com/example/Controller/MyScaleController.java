package com.example.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.MyScaleEntity;
import com.example.Repository.MyScaleRepository;
import com.example.Repository.MyScaleRepositoryImpl;

@RestController
@RequestMapping(value = "/MyScale")
public class MyScaleController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyScaleController.class);
	private MyScaleRepository repository = new MyScaleRepositoryImpl();
	
	@RequestMapping(value="/getAllMeasurements", method=RequestMethod.GET)
	@ResponseBody
	public List<MyScaleEntity> getAllMeasurements(){
		List<MyScaleEntity> measurements = repository.getAllMeasurements();
		logger.debug("Size "+measurements.size());
		return measurements;
	}
	
	@RequestMapping(value="/saveMeasurement", method=RequestMethod.POST)
	@ResponseBody
	public void saveMeasurement(@RequestBody MyScaleEntity measurement){
		repository.save(measurement);
		logger.debug("Measurement "+ measurement.getT() + " is saved");
	}
	
	
	@RequestMapping(value="/saveScaleMeasurement/{emei}/pops/{phoneNumber}", method=RequestMethod.POST)
	@ResponseBody
	public void saveScaleMeasurement(@PathVariable String emei, @PathVariable String phoneNumber, @RequestBody MyScaleEntity measurement){
		logger.debug("emei "+ emei + " phoneNumber "+phoneNumber);
		System.out.println("emei "+ emei + " phoneNumber "+phoneNumber);
		repository.save(measurement);
		System.out.println("Measurement "+ measurement.getT() + " is saved");
		logger.debug("Measurement "+ measurement.getT() + " is saved");
	}


}

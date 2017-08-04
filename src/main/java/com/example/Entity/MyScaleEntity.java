package com.example.Entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="MyScale")
public class MyScaleEntity {
	
	private String t; 
	private List<MeasurementModel> vs;
	
	public MyScaleEntity() {
	}	
	
	public MyScaleEntity(String t, List<MeasurementModel> vs) {
		super();
		this.t = t;
		this.vs = vs;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public List<MeasurementModel> getVs() {
		return vs;
	}
	public void setVs(List<MeasurementModel> vs) {
		this.vs = vs;
	}
	
	
	
}

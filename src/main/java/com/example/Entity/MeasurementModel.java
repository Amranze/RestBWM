package com.example.Entity;

import java.util.List;

public class MeasurementModel {

	private String h; 
	private List<ValuesModel> c;

	public MeasurementModel() {
	}
	
	public MeasurementModel(String h, List<ValuesModel> c) {
		super();
		this.h = h;
		this.c = c;
	}
	
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	public List<ValuesModel> getC() {
		return c;
	}
	public void setC(List<ValuesModel> c) {
		this.c = c;
	}
	
	
}
package com.example.Entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DeviceModel")
public class DeviceModel<T> {

    private String t;
    private List<T> vs;

    public DeviceModel() {
    }

    public DeviceModel(String t, List<T> vs) {
        this.t = t;
        this.vs = vs;
    }

    public DeviceModel(DeviceModel model) {
        this.t = model.getT();
        this.vs = model.getVs();
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public List<T> getVs() {
        return vs;
    }

    public void setVs(List<T> vs) {
        this.vs = vs;
    }

	@Override
	public String toString() {
		return "DeviceModel [t=" + t + ", vs=" + vs.toString() + "]";
	}
    
    
}
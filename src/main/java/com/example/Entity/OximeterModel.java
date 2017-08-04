package com.example.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OximeterModel {
    private int oxygenContent;
    private int pulse;
    private String mac;
    private long timestamp;

    public OximeterModel(){
    }

    public OximeterModel(int oxygenContent, int pulse, String mac, long timestamp) {
    	super();
        this.oxygenContent = oxygenContent;
        this.pulse = pulse;
        this.mac = mac;
        this.timestamp = timestamp;
    }
    
    public OximeterModel(int oxygenContent) {
    	super();
        this.oxygenContent = oxygenContent;
    }


    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getOxygenContent() {
        return oxygenContent;
    }

    public void setOxygenContent(int oxygenContent) {
        this.oxygenContent = oxygenContent;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
    
    @Override
    public String toString(){
    	return "Oxy :"+this.getOxygenContent()+" Pulse :"+this.getPulse()+" Mac :"+
    			this.getMac()+" Time :"+this.getTimestamp();
    }
}
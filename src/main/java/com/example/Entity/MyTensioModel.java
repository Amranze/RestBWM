package com.example.Entity;

import java.util.List;

public class MyTensioModel {

    private static final String TENSIOMETER_TYPE = "tensio";
    private static final String SYS = "TAS";
    private static final String DIA = "TAD";
    private static final String HEARTRATE  = "FC";
    private static final String HEARTRATE_FREQ = "HRF";
    private static final String BETTERY = "BAT";

    private String h;
    private List<ValuesModel> c;

    public MyTensioModel() {
    }

    public MyTensioModel(String h, List<ValuesModel> c) {
        this.h = h;
        this.c = c;
    }

    public MyTensioModel(MyTensioModel model) {
        this.h = model.getH();
        this.c = model.getC();
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
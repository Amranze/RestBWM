package com.example.Entity;

import java.util.List;

public class MyScaleModel {

    private static final String SCALE_TYPE = "balance";
    private static final String WEIGHT = "P";
    private static final String BONE_WEIGHT = "MO";
    private static final String FAT_PERCENTAGE  = "MG";
    private static final String WATER_PERCENTAGE = "MH";
    private static final String MUSCLE = "MM";
    private static final String HEIGHT = "HY";

    private String h;
    private List<ValuesModel> c;

    public MyScaleModel() {
    }

    public MyScaleModel(String h, List<ValuesModel> c) {
        this.h = h;
        this.c = c;
    }

    public MyScaleModel(MyScaleModel model) {
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
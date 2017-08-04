package com.example.Entity;

public class ValuesModel {

    private String v;
    private String ch;

    public ValuesModel() {
    }

    public ValuesModel(String v, String ch) {
        this.v = v;
        this.ch = ch;
    }

    public ValuesModel(ValuesModel model) {
        this.v = model.getV();
        this.ch = model.getCh();
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }
}

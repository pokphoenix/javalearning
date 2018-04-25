package com.pok.tutorial.web.utility;

public class DataResponse {
    public String t;
    public Integer s;

    public DataResponse(String t, Integer s) {
        this.t = t;
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public Integer getS() {
        return s;
    }

    @Override
    public String toString() {
        return "DataResponse [t=" + t + ", s=" + s + "]";
    }
}

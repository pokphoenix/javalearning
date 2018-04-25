package com.pok.tutorial.web.utility;

public class GenericData<T, S> {

    public T t;
    public S s;

    public void add(T t, S s) {
        this.t = t;
        this.s = s;
    }

    public T getT() {
        return t;
    }

    public S getS() {
        return s;
    }
}
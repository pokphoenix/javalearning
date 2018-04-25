package com.pok.tutorial.web.master;

public abstract class Result<T> {
    public boolean result;
    public String error;

    public T response;

    public void setResponse(T response) {
        this.response = response;
    }

    public abstract T unmarshall(T response);

    public T getResponse() {
        return response;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean r) {
        this.result = r;
    }

    public String getError() {
        return error;
    }

    public void setError(String text) {
        this.error = text;
    }

}

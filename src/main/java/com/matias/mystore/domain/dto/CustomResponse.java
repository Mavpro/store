package com.matias.mystore.domain.dto;



public class CustomResponse<T> {

    private String message;
    private boolean error;
    private T data;

    public CustomResponse() {
    }

    public CustomResponse(String message, boolean error, T data) {
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

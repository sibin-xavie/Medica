package com.gerimedica.medica.util;

public class RestResponse<T> {
    private String status;
    private String message;
    private T data;

    public String getStatus() {
        return status;
    }

    public RestResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RestResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public RestResponse setData(String showRatings, T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

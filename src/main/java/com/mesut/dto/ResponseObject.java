package com.mesut.dto;

public class ResponseObject<T> {

    boolean errorExist=false;
    String errorkod="0";
    String errorMessage="";
    T responseObject;

    public boolean isErrorExist() {
        return errorExist;
    }

    public void setErrorExist(boolean errorExist) {
        this.errorExist = errorExist;
    }

    public String getErrorkod() {
        return errorkod;
    }

    public void setErrorkod(String errorkod) {
        this.errorkod = errorkod;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(T responseObject) {
        this.responseObject = responseObject;
    }


    public ResponseObject()
    {
       super();
    }
    public ResponseObject(T presponseObject)
    {
        this();
        responseObject= presponseObject;
    }
    public ResponseObject(boolean errorExist, String errorkod, String errorMessage, T responseObject) {
        this(responseObject);
        this.errorExist = errorExist;
        this.errorkod = errorkod;
        this.errorMessage = errorMessage;
    }





}

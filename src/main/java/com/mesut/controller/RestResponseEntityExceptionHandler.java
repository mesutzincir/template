package com.mesut.controller;


import com.mesut.dto.ResponseObject;
import com.mesut.model.ApiBaseException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {
    public RestResponseEntityExceptionHandler() {
        super();
    }
// API

    /*
    // 400

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleBadRequest(final DataIntegrityViolationException ex, final WebRequest request) {
        final String bodyOfResponse = "Bad Request:"+ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final String bodyOfResponse = "Http Message Not Readable:"+ex.getMessage();
        // ex.getCause() instanceof JsonMappingException, JsonParseException // for additional information later on
        return handleExceptionInternal(ex, bodyOfResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final String bodyOfResponse = "Method Argument Not Valid"+ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    // 403
    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(final Exception ex, final WebRequest request) {
        System.out.println("request" + request.getUserPrincipal());
        return new ResponseEntity<Object>("Access denied", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    // 409

    @ExceptionHandler({ InvalidDataAccessApiUsageException.class, DataAccessException.class })
    protected ResponseEntity<Object> handleConflict(final RuntimeException ex, final WebRequest request) {
        final String bodyOfResponse = "DataAccess Exception"+ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    // 412

    // 500


     */
    /*
    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
        logger.error("500 Status Code", ex);
        //final String bodyOfResponse = "INTERNAL_SERVER_ERROR:"+ex.getMessage();
        final String bodyOfResponse = ex.getClass().getSimpleName()+":"+ex.getMessage();
        ResponseObject<String> responseObj = new ResponseObject<String>();
        responseObj.setErrorExist(true);
        responseObj.setErrorkod(ex.getClass().getSimpleName());
        responseObj.setErrorMessage(bodyOfResponse);
        responseObj.setResponseObject(responseObj.getErrorkod()+":"+responseObj.getErrorMessage());
        //return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        return handleExceptionInternal(ex, responseObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);

        ///return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    */


    @ExceptionHandler({ ApiBaseException.class })
    public ResponseEntity<Object> handleApiBaseException(final ApiBaseException ex, final WebRequest request) {
        ResponseObject<String> responseObj = new ResponseObject<String>();
        responseObj.setErrorExist(true);
        responseObj.setErrorkod(ex.getErrorKod());
        responseObj.setErrorMessage(ex.getErrorMessage());
        responseObj.setResponseObject(ex.getErrorKod()+"-"+ex.getErrorMessage());

        //logger.error("500 Status Code", ex);
        //final String bodyOfResponse = "ApiBaseException Exception:"+ex.getMessage();
        //return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        return new ResponseEntity<Object>(responseObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


/*
    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<Object> handleRuntimeException(final RuntimeException ex, final WebRequest request) {
        //TODO: Log errors logger.error("500 Status Code", ex);
        final String bodyOfResponse = "Runtime Exception:"+ex.getLocalizedMessage();
        ResponseObject<String> responseObj = new ResponseObject<String>();
        responseObj.setErrorExist(true);
        responseObj.setErrorkod("RuntimeException");
        responseObj.setErrorMessage(bodyOfResponse);
        responseObj.setResponseObject(responseObj.getErrorkod()+":"+responseObj.getErrorMessage());
        ex.printStackTrace();
        //return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        return handleExceptionInternal(ex, responseObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    */
}

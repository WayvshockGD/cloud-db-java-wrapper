package com.wayv.cloud.db.exceptions;

public class APIException extends Exception {

    public APIException(String content) {
        super(content);
    }

    public static APIException createKeyError() {
        return new APIException("Key is empty or null!");
    }
}

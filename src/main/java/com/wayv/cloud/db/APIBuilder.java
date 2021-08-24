package com.wayv.cloud.db;

import com.wayv.cloud.db.exceptions.APIException;

import java.io.IOException;

public class APIBuilder {

    public String key;
    public String baseURL;
    public APIManager manager;

    public APIBuilder(String key) throws APIException {
        if (key == null) throw APIException.createKeyError();

        this.key = key;
        this.manager = new APIManager(this);
        this.baseURL = "https://cloud-db.ml";
    }

    public void editOrCreate(String key, String ...value) throws IOException {
        this.manager.editOrCreate(key, value);
    }
}
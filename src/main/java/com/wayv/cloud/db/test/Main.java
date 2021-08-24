package com.wayv.cloud.db.test;

import com.wayv.cloud.db.APIBuilder;
import com.wayv.cloud.db.exceptions.APIException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws APIException, IOException {
        final APIBuilder db = new APIBuilder("Gz8nnseuOyztCxEOYE7A1kEPd");
        db.editOrCreate("this", "that");
    }
}

package com.wayv.cloud.db;

import com.wayv.cloud.db.utils.ParameterStringBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class APIManager {

    public APIBuilder api;

    public APIManager(APIBuilder api) {
        this.api = api;
    }

    public void editOrCreate(String key, String ...value) throws IOException {
        this.makeAPIRequest("/set?name=" + key, value);
    }

    public String getValue(String key) throws IOException {
        return this.makeAPIRequest("/get?name="+key);
    }

    private String makeAPIRequest(String endpoint, String ...body) throws IOException {
        final URL req = new URL(this.api.baseURL + endpoint);
        final HttpsURLConnection connection = (HttpsURLConnection) req.openConnection();

        connection.setRequestProperty("Authorization", this.api.key);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        if (body != null) {
            Map<String, String> params = new HashMap<>();
            params.put("value", Arrays.toString(body));

            connection.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(params));
            out.flush();
            out.close();
        }

        return connection.getInputStream().toString();
    }
}

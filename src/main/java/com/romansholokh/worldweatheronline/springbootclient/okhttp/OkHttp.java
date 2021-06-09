package com.romansholokh.worldweatheronline.springbootclient.okhttp;

import net.minidev.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class OkHttp {

    public JSONObject getFromUrl(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            JSONObject json = new JSONObject();
            json.put("response", Objects.requireNonNull(response.body()));

            return json;
        }
    }
}

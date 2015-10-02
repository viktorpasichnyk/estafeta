package com.example.pasichnyk.estafeta.tools;

import android.util.Base64;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class MyBasicAuthJsonArrayRequest extends JsonArrayRequest {

    public MyBasicAuthJsonArrayRequest(String url, Response.Listener<JSONArray> listener,
                                       Response.ErrorListener errorListener, String username, String password, String idCompany) {
        super(url, listener, errorListener);
        if (username != null && password != null && idCompany != null) {
            String loginEncoded = new String(Base64.encode((username + "@" + idCompany + ":" + password).getBytes(), Base64.NO_WRAP));
            this.headers.put("Authorization", "Basic " + loginEncoded);
        }
    }

    private Map<String, String> headers = new HashMap<>();

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers;
    }


}
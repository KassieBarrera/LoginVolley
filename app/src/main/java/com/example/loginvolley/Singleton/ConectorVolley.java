package com.example.loginvolley.Singleton;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

public class ConectorVolley {
    private static ConectorVolley intanciaVolley;
    private RequestQueue request;
    private static Context contexto;

    private ConectorVolley(Context context) {
        contexto = context;
        request = getRequestQueue();
    }

    public static synchronized ConectorVolley getIntanciaVolley(Context context) {
        if (intanciaVolley == null) {
            intanciaVolley = new ConectorVolley(context);
        }

        return intanciaVolley;
    }

    public RequestQueue getRequestQueue() {
        if (request == null) {
            request = com.android.volley.toolbox.Volley.newRequestQueue(contexto.getApplicationContext());
        }

        return request;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }
}

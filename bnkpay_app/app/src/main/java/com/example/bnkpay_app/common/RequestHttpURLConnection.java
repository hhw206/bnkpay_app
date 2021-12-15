package com.example.bnkpay_app.common;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RequestHttpURLConnection {

    //----------------------------------------------------------------------------------------
    // 결제원 통신
    //----------------------------------------------------------------------------------------
    // pMethod : POST, GET (결제원)
    // pParams : httpInfo HashMap, header HashMap, parameter HashMap
    //----------------------------------------------------------------------------------------
    public String requestOpenBanking(HashMap pParams) {

        String sResult = "";

        System.out.println("------------------------------------------------------");
        System.out.println("requestOpenBanking || Start");
        System.out.println("pParams -> " + pParams);
        System.out.println("------------------------------------------------------");

        System.out.println("------------------------------------------------------");
        System.out.println("requestDBServer sResult -> " + sResult);
        System.out.println("------------------------------------------------------");

        System.out.println("------------------------------------------------------");
        System.out.println("requestDBServer || End");
        System.out.println("------------------------------------------------------");

        return sResult;
    }

    //----------------------------------------------------------------------------------------
    // DB 서버 통신
    //----------------------------------------------------------------------------------------
    // pMethod : POST
    //----------------------------------------------------------------------------------------
    public String requestDBServer(String pUrl, HashMap<String, String> pParams) {
        String sResult = "";

        System.out.println("------------------------------------------------------");
        System.out.println("requestDBServer || Start");
        System.out.println("------------------------------------------------------");

        System.out.println("------------------------------------------------------");
        System.out.println("requestDBServer sResult -> " + sResult);
        System.out.println("------------------------------------------------------");

        System.out.println("------------------------------------------------------");
        System.out.println("requestDBServer || End");
        System.out.println("------------------------------------------------------");

        return sResult;
    }

    public String testServer(Context context) {
        String sResult = "";

        System.out.println("------------------------------------------------------");
        System.out.println("testServer || Start");
        System.out.println("------------------------------------------------------");

        String url = "https://www.google.co.kr";
        HashMap paramMap = new HashMap();
//        paramMap.put("ID", "anonymous");
//        paramMap.put("VERSION_NAME", "test");

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
            }
        };

        Response.ErrorListener responseErrListener = new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }

        };

        sendRequest(context, url, paramMap, responseListener, responseErrListener);

        System.out.println("------------------------------------------------------");
        System.out.println("testServer sResult -> " + sResult);
        System.out.println("------------------------------------------------------");

        System.out.println("------------------------------------------------------");
        System.out.println("testServer || End");
        System.out.println("------------------------------------------------------");

        return sResult;
    }

    //----------------------------------------------------------------------------------------
    // Volley 통신
    //----------------------------------------------------------------------------------------
    public void sendRequest(Context context, String url, HashMap paramMap,Response.Listener listener, Response.ErrorListener errorListener) {
        System.out.println("------------------------------------------------------");
        System.out.println("sendGetRequest || Start");
        System.out.println("------------------------------------------------------");

        RequestQueue queue ;
        List<Map<String, String>> returnList = null;
        queue = Volley.newRequestQueue(context);

        // GET 파라미터 추출
        if (paramMap.size() > 0) {
            Set set = paramMap.keySet();
            Iterator iterator = set.iterator();

            int keyCnt = 0;
            while (iterator.hasNext()) {
                keyCnt++;
                String key = (String) iterator.next();
                if (keyCnt == 1) {
                    url += "?" + key + "=" + paramMap.get(key);
                } else {
                    url += "&" + key + "=" + paramMap.get(key);
                }
            }
        }

        System.out.println("url: "+ url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, listener, errorListener);
        stringRequest.setRetryPolicy(new com.android.volley.DefaultRetryPolicy(
                0 ,
                com.android.volley.DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                com.android.volley.DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(stringRequest);

        System.out.println("------------------------------------------------------");
        System.out.println("sendGetRequest || End");
        System.out.println("------------------------------------------------------");
    }

    //    public void sendRideLogRequest(Context context, String url, List<HashMap> rideLogList,HashMap rideLogM,Response.Listener listener, Response.ErrorListener errorListener) {
//        queue = Volley.newRequestQueue(context);
//        String strRequestUrl = strBaseUrl + url;
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST,strRequestUrl,listener,errorListener){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> params = new HashMap<>();
//
//                String logData = new Gson().toJson(rideLogList);
//                String mData   = new Gson().toJson(rideLogM);
//                params.put("RIDE_LOG",logData);
//                params.put("RIDE_LOG_M",mData);
//
//                return params;
//            }
//        };
//
//        stringRequest.setRetryPolicy(new com.android.volley.DefaultRetryPolicy(
//                0 ,
//                com.android.volley.DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                com.android.volley.DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        queue.add(stringRequest);
//    }


//    public void SyncLogRequest(Context context,HashMap paramMap, List<HashMap> localIndexKeyList, Response.Listener listener, Response.ErrorListener errorListener){
//        queue = Volley.newRequestQueue(context);
//        String strRequestUrl = strBaseUrl + "/rideLog/syncRideLog_001.do";
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST,strRequestUrl,listener,errorListener){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> params = new HashMap<>();
//
//                String localIndexkey = new Gson().toJson(localIndexKeyList);
//                String mData   = new Gson().toJson(paramMap);
//
//                params.put("LOCAL_INDEXKEY_LIST",localIndexkey);
//                params.put("USER_INFO",mData);
//
//                return params;
//            }
//        };
//        queue.add(stringRequest);
//    }
}

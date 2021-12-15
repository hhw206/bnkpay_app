package com.example.bnkpay_app.common;

import android.net.Uri;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ComUtil {
    //-----------------------------------------------------------------------------------
    // 난수 만드는 함수
    //-----------------------------------------------------------------------------------
    public static String Random_Text(){

        StringBuffer temp = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 32; i++) {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
                case 0:
                    // a-z
                    temp.append((char) (rnd.nextInt(26) + 97));
                    break;
                case 1:
                    // A-Z
                    temp.append((char) (rnd.nextInt(26) + 65));
                    break;
                case 2:
                    // 0-9
                    temp.append((rnd.nextInt(10)));
                    break;
            }
        }
        return temp.toString();
    }
    //-----------------------------------------------------------------------------------
    // URL encoding wrapper
    //-----------------------------------------------------------------------------------
    public static String getUrlEncode(String pParam){

        String sResult = "";
        try {
            sResult = URLEncoder.encode(pParam, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sResult;
    }

    //-----------------------------------------------------------------------------------
    // URL encoding wrapper
    //-----------------------------------------------------------------------------------
    public String getURLDecode(String pParam){

        String sResult = null;

        try {
            sResult = URLDecoder.decode(pParam, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sResult;
    }

    //---------------------------------------------------------------------------------------
    // http 통신할때 url에 사용하는 파라미터를 생성해서 RETURN
    //---------------------------------------------------------------------------------------
    // get -> http://www.test.com?id=aa&pw=1111
    // post -> id=aa&pw=1111
    //---------------------------------------------------------------------------------------
    public String getUrlParam(String pUrl, HashMap<String, String> pParam){
        System.out.println("getUrlParam()");
        String sKey = "";
        String sValue = "";

        Uri.Builder builder;

        //파라미터에 url이 없으면 파라미터만 생성
        if(pUrl == null || "".equals(pUrl.trim())){
            builder = new Uri.Builder();
        }else{
            builder = Uri.parse(pUrl).buildUpon();
        }

        for (Map.Entry<String, String> entry : pParam.entrySet()) {

            sValue = entry.getValue();
            sKey = entry.getKey();

            // 파라미터를 만들어줌.
            builder.appendQueryParameter(sKey, sValue);
        }

        return getURLDecode(builder.build().toString());
    }
}

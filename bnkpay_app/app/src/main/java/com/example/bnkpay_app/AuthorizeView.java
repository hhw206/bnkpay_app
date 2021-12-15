package com.example.bnkpay_app;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bnkpay_app.common.ComOpenBankingData;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;

public class AuthorizeView extends AppCompatActivity {
    private WebView mWebView;
    private WebSettings mWebSettings;

    Intent intent;
    private String strUrl;
    private String sState;
    private String sGubun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("------------------------------------------------------");
        System.out.println("AuthorizeView || Start || onCreate");
        System.out.println("------------------------------------------------------");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        intent = getIntent();
        sState = intent.getStringExtra("state"); // 난수값

        mWebView = findViewById(R.id.web_view);
        mWebSettings = mWebView.getSettings(); //세부 세팅 등록
        mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
        mWebSettings.setSupportMultipleWindows(true); // 새창 띄우기 허용 여부
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부

        mWebSettings.setAllowFileAccess(true);
        mWebSettings.setAllowContentAccess(true);
        mWebSettings.setAllowFileAccessFromFileURLs(true);
        mWebSettings.setAllowUniversalAccessFromFileURLs(true);


        mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
        mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
        mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부
        mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
        mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부

        strUrl = intent.getStringExtra("url");
        sGubun = intent.getStringExtra("gubun");

        try {
            String encodeResult = "";
            HashMap<String, String> map = new HashMap<>();

            // 회원가입
            if(sGubun.equals("0")){
                ComOpenBankingData comOpenBankingData = new ComOpenBankingData();

                map.put("gubun", sGubun);
                map.put("state", sState);

                strUrl = comOpenBankingData.getAuthorize(map);
                encodeResult = URLDecoder.decode(strUrl, "UTF-8");
                mWebView.loadUrl(encodeResult);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading (WebView view, WebResourceRequest request){

                try {
                    URL url = new URL(request.getUrl().toString());

                    String getUrl = "";

                    // 주소에 포트가 없으면 -1
                    if(url.getPort() != -1){
                        // url에 포트가 있는 경우
                        getUrl = url.getProtocol() + "://" + url.getHost()+":"+url.getPort()+"/";
                    }else{
                        // url에 포트가 없는 경우
                        getUrl = url.getProtocol() + "://" + url.getHost()+"/";
                    }

                    System.out.println("---------------------------------------> getUrl : " + getUrl);

/*                    if(getUrl.equals("https://www.sjkim.net/")){
                        finish();
                        if(request.getUrl().toString().indexOf("authCodeCallBack.do") > 0) {
                            String sCode = request.getUrl().getQueryParameter("code");
                            // 서버에 코드 발급이 완료여부 확인
                            ((SignUpActivity)SignUpActivity.mContext).act_finish(sCode);
                        }
                    }*/


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                System.out.println("---------------------------------------> request.getUrl().toString() : " + request.getUrl().toString());
                // 클릭시 새창 안뜨게
                return false;
            }

        });
    }
}

package com.example.bnkpay_app.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ComOpenBankingData {
    String sResult = "";
    String sUrl = "";
    ComUtil comUtil = new ComUtil();

    //-------------------------------------------------------------------------------------------------------------
    // 사용자 인증
    // < param >
    // 사용자인증타입 구분(0:최초인증, 1:재인증, 2:인증생략)
    // headers(hashmap)
    //-------------------------------------------------------------------------------------------------------------
    public  String getAuthorize(HashMap map){

        System.out.println("------------------------------------------------------");
        System.out.println("START");
        System.out.println("getAuthorize || Start || 사용자인증");
        System.out.println(map);
        System.out.println("------------------------------------------------------");

        sUrl = "https://testapi.openbanking.or.kr/oauth/2.0/authorize";


        //----------------------------------------------------------------------------------------------------------------------------------------------------
        // < param >
        //----------------------------------------------------------------------------------------------------------------------------------------------------
        // response_type -> OAuth 2.0 인증 요청 시 반환되는 형태 (고정)
        // client_id -> 오픈뱅킹에서 발급한 이용기관 앱의 Client ID
        // redirect_uri -> 사용자인증이 성공하면 이용기관으로 연결되는 URL
        // scope -> Access Token 권한 범위(다중 scope 가능)
        // state -> CSRF 보안위협에 대응하기 위해 이용기관이 셋팅하는 난수값 (Callback 호출 시 그대로 전달됨)
        // auth_type -> 사용자인증타입 구분(0:최초인증, 1:재인증, 2:인증생략)
        // lang -> 다국어 설정
        // cellphone_cert_yn -> 휴대전화 인증 사용여부(미지정시 기본값 : “Y”)
        // authorized_cert_yn -> 공인인증서 사용여부(미지정시 기본값 : “Y”)
        // account_hold_auth_yn -> 계좌소유인증 사용여부
        //----------------------------------------------------------------------------------------------------------------------------------------------------
        // < headers >
        // Kftc-Bfop-UserSeqNo -> 기존 고객의 사용자일련번호
        // Kftc-Bfop-UserCI -> 사용자 CI(Connect Info)
        // Kftc-Bfop-AccessToken -> "login" scope 을 포함한 토큰(유효한 접속토큰이어야 함)
        //----------------------------------------------------------------------------------------------------------------------------------------------------
        String pAuthType        = map.get("gubun").toString(); // 최초인증 : 0, 인증생략 : 2
        String sRedirectUri      = "";
        String sState           = "";

        // 사용자인증(0 : 최초인증, 2 : 인증생략)
        if(pAuthType.equals("0")){
            System.out.println("최초인증");
            sRedirectUri     = "https://localhost:8000";
            sState          = map.get("state").toString();
        }else if(pAuthType.equals("2")){
//            sRedirectUri     = "https://www.sjkim.net/hap/signUp/default.do";
//            sState          = "11111111111111111111111111111111";
        }

        HashMap<String, String> paramMap = new HashMap<>();

        paramMap.put("response_type", "code");
        paramMap.put("client_id", ComConst.clientId);
        paramMap.put("redirect_uri" , sRedirectUri);
        paramMap.put("scope", ComUtil.getUrlEncode("login inquiry transfer"));
        paramMap.put("client_info", "BnkSystem");
        paramMap.put("auth_type", pAuthType);
        paramMap.put("state", sState);
        paramMap.put("lang", "kor");
        paramMap.put("cellphone_cert_yn"    , "Y");                                  // 휴대전화 인증 사용여부(미지정 기본 : Y)
        paramMap.put("authorized_cert_yn"   , "Y");                                 // 공인인증서 사용여부(미지정 기본 Y)
        paramMap.put("account_hold_auth_yn" , "N");                                  // 계좌소유인증 사용여부

        //GET방식 URL생성
        String sResult = comUtil.getUrlParam(sUrl ,paramMap);

        System.out.println("sResult -> " + sResult);

        System.out.println("------------------------------------------------------");
        System.out.println("END");
        System.out.println("getAuthorize || End || 사용자인증");
        System.out.println("------------------------------------------------------");

        return sResult;
    }

}

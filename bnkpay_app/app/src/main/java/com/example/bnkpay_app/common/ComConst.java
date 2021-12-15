package com.example.bnkpay_app.common;

public interface ComConst {
    String apiUrl   = "https://testapi.openbanking.or.kr";

    //---------------------------------------------------
    // APP_INFO
    //---------------------------------------------------
    String clientId     = "057ba50d-204a-4858-9b73-684b57d23586";
    String clientSecret = "41c34932-b5c0-4b7c-8d86-97b6aed9523f";
    String clientToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJUOTkxNjI2MTgwIiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjA3OTI4MzYxLCJqdGkiOiIwNjZmZjVkYi03OTE5LTRkNTktYmY3NS05NWQ2MTA5MzA2ODMifQ.x6cLvVcZn841YZLXASntPqjSIz4NPjl7IIjmiQfFZVk";

    //---------------------------------------------------
    // API_URL
    //---------------------------------------------------
    // 토큰 발급 API
    String tokenUrl             = apiUrl+"/oauth/2.0/token";
    // 사용자인증 API
    String userMeUrl            = apiUrl+"/v2.0/user/me";
}

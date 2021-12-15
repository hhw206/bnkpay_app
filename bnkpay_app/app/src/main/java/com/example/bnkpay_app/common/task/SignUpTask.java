package com.example.bnkpay_app.common.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.bnkpay_app.AuthorizeView;
import com.example.bnkpay_app.SignUpActivity;

//import org.json.JSONObject;

import java.util.HashMap;

public class SignUpTask extends AsyncTask<String, Void, HashMap<String, String>> {
    private HashMap<String, String> map;
    private ProgressDialog asyDialog = null;
    Activity eachAct;
    private String sState;

    public SignUpTask(HashMap<String, String> paramMap, Activity act) {
        this.map = paramMap;
        this.eachAct = act;
    }

    @Override
    protected void onPreExecute() {
        asyDialog = new ProgressDialog(eachAct);
        asyDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        asyDialog.setMessage("잠시만 기다려주세요.");
        asyDialog.setCancelable(false);
        asyDialog.show();
        super.onPreExecute();

    }

    @Override
    protected HashMap<String, String> doInBackground(String... params) {
        System.out.println("SignUpTask doInBackground map ----->>>"+map+"<<<-----");

        // map은 SignUpActivity 에서 보낸 값
        String sCode = params[0];
        String sResult = "";

        sState = map.get("RAND_VAL");

        // 난수 등록 요청
        if("01".equals(sCode)){
            HashMap<String, String> prmMap = new HashMap<>();
            prmMap.put("USER_ID"    , map.get("USER_ID"));
            prmMap.put("RAND_VAL"   , map.get("RAND_VAL"));
//            sResult = dbData.insertRandVal(prmMap);
            sResult = "OK";
        }

        map.put("code"  , sCode);
        map.put("result", sResult);

        return map;
    }

    @Override
    protected void onPostExecute(HashMap<String, String> pResult) {
        System.out.println("SignUpTask onPostExecute");
        String sCode    = pResult.get("code");
//        String sResult  = pResult.get("result");    // result의 RESULT 체크

        try{
//            JSONObject jO = new JSONObject(sResult);

            // 난수 등록 요청
            if("01".equals(sCode)){
//                String result = jO.getString("RESULT");
                String result = "OK";
                //등록 완료
                if(result.equals("OK")){
                    Intent intent = new Intent(SignUpActivity.mContext, AuthorizeView.class);   // 웹뷰 호출
                    intent.putExtra("gubun" , "0");  // 회원가입
                    intent.putExtra("state" , sState);  // 난수값
                    eachAct.startActivity(intent);
                }else{
                    Toast.makeText(SignUpActivity.mContext,  result, Toast.LENGTH_SHORT).show();
                    return;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

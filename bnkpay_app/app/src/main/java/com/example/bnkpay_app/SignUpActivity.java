package com.example.bnkpay_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bnkpay_app.common.ComUtil;
import com.example.bnkpay_app.common.task.SignUpTask;

import java.util.HashMap;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    public static Context mContext;
    private String sState;      // 난수값
    private String sName;       // 이름값
    private String sId;         // 아이디값
    private String sPw;         // 비밀번호값

    private EditText edName;    // 이름
    private EditText edId;      // 아이디
    private EditText edPw;      // 비밀번호

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        mContext = this;

        edName = (EditText) findViewById(R.id.edit_name);
        edId = (EditText) findViewById(R.id.edit_id);
        edPw = (EditText) findViewById(R.id.edit_pw);

        Button certifyButton = (Button) findViewById(R.id.btn_certify);
        certifyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sName = edName.getText().toString();
                sId = edId.getText().toString();
                sPw = edPw.getText().toString();

                // 필수값 체크
                if (sName.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),  "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    edName.requestFocus();
                } else if ( sId.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),  "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                    edId.requestFocus();
                } else if ( sPw.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),  "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    edPw.requestFocus();
                } else {
                    sState = ComUtil.Random_Text();

                    HashMap<String, String> map =  new HashMap<>();

                    map.put("USER_ID"   , sId);
                    map.put("RAND_VAL"  , sState);

                    // 난수 등록 요청
                    SignUpTask signUpTask = new SignUpTask(map, SignUpActivity.this);
                    signUpTask.execute("01");
                }

//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
            }
        });
    }

    // 코드 발급 후 서버에 조회해서 정상 발급되어 있는지 확인
    public void act_finish(String sCode) {
        // 회원가입 사용자인증 코드발급 결과 확인
        HashMap<String, String> map =  new HashMap<>();

        map.put("USER_ID"   , sId);
        map.put("RAND_VAL"  , sState);
        map.put("CODE"      , sCode);

        // 코드 정상 발급 확인 후 결제원으로 토큰 발급 요청
        SignUpTask authTask = new SignUpTask(map, this);
        authTask.execute("03");
    }
}

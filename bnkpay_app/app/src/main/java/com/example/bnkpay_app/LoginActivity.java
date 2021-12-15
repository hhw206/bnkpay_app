package com.example.bnkpay_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.bnkpay_app.common.RequestHttpURLConnection;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    public static Context mContext;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextView signUpButton = (TextView) findViewById(R.id.btn_sign_up);

        signUpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                try {
//                    RequestHttpURLConnection http = new RequestHttpURLConnection();
//                    http.testServer(mContext);
//
//                } catch(Exception e ){
//                    Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
//                }

                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });


    }
}

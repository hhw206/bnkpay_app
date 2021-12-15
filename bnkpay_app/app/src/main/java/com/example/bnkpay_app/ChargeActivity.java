package com.example.bnkpay_app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class ChargeActivity extends AppCompatActivity {
    ArrayAdapter<CharSequence> adspin;

    private DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private EditText wonEt;
    private String result="";

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(!TextUtils.isEmpty(charSequence.toString()) && !charSequence.toString().equals(result)){
                result = decimalFormat.format(Double.parseDouble(charSequence.toString().replaceAll(",","")));
                wonEt.setText(result);
                wonEt.setSelection(result.length());
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charge);

        wonEt = (EditText) findViewById(R.id.wonEt);
        wonEt.addTextChangedListener(watcher);

        Spinner spinner = (Spinner) findViewById(R.id.charge_account_spinner);
        spinner.setPrompt("계좌 선택");

        adspin = ArrayAdapter.createFromResource(this, R.array.charge_account_array, android.R.layout.simple_spinner_item);
        adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adspin);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ChargeActivity.this,
//                        adspin.getItem(position) + "을 선택 했습니다.", 1).show();
            }
            public void onNothingSelected(AdapterView<?>  parent) {
            }
        });
    }
}

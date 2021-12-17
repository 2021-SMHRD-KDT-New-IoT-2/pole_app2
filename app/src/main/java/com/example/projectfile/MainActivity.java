package com.example.projectfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_list2, pole_number, tv_business, tv_address, tv_date, tv_remark,
            tv_business1, tv_address1, tv_date1, tv_remark1;
    Button btn_previous2, btn_confirm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list2);

        tv_list2 = findViewById(R.id.tv_list2);
        pole_number = findViewById(R.id.pole_number);

        tv_business = findViewById(R.id.tv_business);
        tv_address = findViewById(R.id.tv_address);
        tv_date = findViewById(R.id.tv_date);
        tv_remark = findViewById(R.id.tv_remark);

        tv_business1 = findViewById(R.id.tv_business1);
        tv_address1 = findViewById(R.id.tv_address1);
        tv_date1 = findViewById(R.id.tv_date1);
        tv_remark1 = findViewById(R.id.tv_remark1);

        btn_previous2 = findViewById(R.id.btn_previous2);
        btn_confirm2 = findViewById(R.id.btn_confirm2);

    }
}
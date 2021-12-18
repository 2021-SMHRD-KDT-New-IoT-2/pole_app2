package com.example.projectfile.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectfile.Controller.List_Adapter;
import com.example.projectfile.Model.ListVO;
import com.example.projectfile.R;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    ImageButton btn_addPole, show_dialog;
    ArrayList<ListVO> items = new ArrayList<ListVO>();
    TextView tv_list;
    ListView pole_listview;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        List_Adapter listAdapter;

        listAdapter = new List_Adapter();


        tv_list = findViewById(R.id.tv_list);
        btn_addPole = findViewById(R.id.btn_addPole);
        show_dialog = findViewById(R.id.show_dialog);
        pole_listview = (ListView) findViewById(R.id.pole_listview);
        // 키보드 제어 (키보드 보이기)
        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE); // 입력 방법을 관리
        pole_listview.setAdapter(listAdapter);

        listAdapter.addItem("전주 번호", "담당 사업소", "위치");
        listAdapter.addItem("1001", "동구 지사", "풍암동 22번지");
        listAdapter.addItem("1002", "서구 지사", "금호동 11번지");
        listAdapter.addItem("1003", "남구 지사", "봉선동 32번지");
        listAdapter.addItem("1004", "북구 지사", "지산동 66번지");
        listAdapter.addItem("", "", "");
        listAdapter.addItem("", "", "");


        btn_addPole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Enrollment.class);
                startActivity(intent);
                finish();
            }
        });


        show_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Thread.class);
                startActivity(intent);
                finish();
            }
        });
    }
}




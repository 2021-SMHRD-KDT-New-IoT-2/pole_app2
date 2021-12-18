package com.example.projectfile.View;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectfile.Model.ListVO;
import com.example.projectfile.R;

import java.util.ArrayList;

public class Main extends AppCompatActivity implements TextWatcher{

    ImageButton btn_search, btn_plus, showDialog;
    ArrayList<ListVO> items = new ArrayList<ListVO>();
    ArrayAdapter<String> arrayAdapter;
    TextView tv_list;
    ListView listView;
    EditText edt_search;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//        List_Adapter listAdapter;
//        listAdapter = new List_Adapter();

        tv_list = findViewById(R.id.tv_list);
        edt_search = findViewById(R.id.edt_search);
        listView = (ListView) findViewById(R.id.listView);
        btn_search = findViewById(R.id.btn_search);
        btn_plus = findViewById(R.id.btn_plus);
        showDialog = findViewById(R.id.showDialog);
        // 키보드 제어 (키보드 보이기)
        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE); // 입력 방법을 관리
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        arrayAdapter.add("1001 동구 지사 풍암동 22번지");
        arrayAdapter.add("1002 서구 지사 금호동 11번지");
        arrayAdapter.add("1003 남구 지사 봉선동 32번지");
        arrayAdapter.add("1004 북구 지사 지산동 66번지");
        arrayAdapter.add("");
        arrayAdapter.add("");
        arrayAdapter.add("");
        arrayAdapter.add("");
        arrayAdapter.add("");
        arrayAdapter.add("");
        arrayAdapter.add("");
        listView.setAdapter(arrayAdapter);
        listView.setTextFilterEnabled(true);
        edt_search.addTextChangedListener(this);

//        listAdapter.addItem("전주 번호", "담당 사업소", "위치");
//        listAdapter.addItem("1001", "동구 지사", "풍암동 22번지");
//        listAdapter.addItem("1002", "서구 지사", "금호동 11번지");
//        listAdapter.addItem("1003", "남구 지사", "봉선동 32번지");
//        listAdapter.addItem("1004", "북구 지사", "지산동 66번지");
//        listAdapter.addItem("", "", "");
//        listAdapter.addItem("", "", "");
//        listAdapter.addItem("", "", "");
//        listAdapter.addItem("", "", "");
//        listAdapter.addItem("", "", "");
//        listAdapter.addItem("", "", "");
//        listAdapter.addItem("", "", "");
//        listAdapter.addItem("", "", "");
//        listAdapter.addItem("", "", "");

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, List2.class);
                startActivity(intent);
                finish();
            }
        });

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Thread.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        listView.setFilterText(edt_search.getText().toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        if(edt_search.getText().length() == 0) {
            listView.clearTextFilter();
        }
    }
}






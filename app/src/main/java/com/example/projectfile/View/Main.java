package com.example.projectfile.View;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import com.example.projectfile.Controller.SearchableAdapter;

import com.example.projectfile.Model.Pole_infoVO;
import com.example.projectfile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends AppCompatActivity implements TextWatcher {

    private ImageButton btn_addPole, show_dialog;
    private ListView M_pole_listview;
    private EditText edt_search;
    private ArrayList<Pole_infoVO> items = new ArrayList<Pole_infoVO>();

    InputMethodManager imm;  // 키보드 제어 (키보드 보이기)

    // 웹통신에 필요한 3가지
    // Server로 요청하는 객체
    private RequestQueue queue;
    // Server로 요청시 필요한 정보를 담는 객체
    private StringRequest stringRequest;
    // client를 판별하는 값
    private String TAG = "main";

    SearchableAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        M_pole_listview = (ListView) findViewById(R.id.M_pole_listview);

        adapter = new SearchableAdapter(this, new ArrayList<Pole_infoVO>()); // s_a



        edt_search = findViewById(R.id.edt_search);
        btn_addPole = findViewById(R.id.btn_addPole);
        show_dialog = findViewById(R.id.show_dialog);
        M_pole_listview.setAdapter(adapter);
        // 키보드 제어 (키보드 보이기)
        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE); // 입력 방법을 관리


        M_pole_listview.setTextFilterEnabled(true);
        edt_search.addTextChangedListener(this);


        sendRequest();



        btn_addPole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, add_Pole.class);
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






    public void sendRequest() {
        // Volley Lib 새로운 요청객체 생성
        queue = Volley.newRequestQueue(this);
        // 서버에 요청할 주소
        String url = "http://172.30.1.11:8087/team1/poleList_and";

        // 요청 문자열 저장
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);


                try {
                    Log.v("dk","넘어옴");
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String pole_code = jsonObject.getString("pole_code");
                        String mac_code = jsonObject.getString("mac_code");
                        String pole_office = jsonObject.getString("pole_office");
                        String pole_addr = jsonObject.getString("pole_addr");
                        String pole_height = jsonObject.getString("pole_height");
                        String pole_date = jsonObject.getString("pole_date");
                        String emp_id = jsonObject.getString("emp_id");
                        String transformer_yn = jsonObject.getString("transformer_yn");
                        String pole_com = jsonObject.getString("pole_com");
                        String pole_high = jsonObject.getString("pole_high");
                        String pole_down = jsonObject.getString("pole_down");
                        String pole_comment = jsonObject.optString("pole_comment","없음");
                        String pole_eday = jsonObject.optString("pole_eday","없음");
                        String pole_level = jsonObject.optString("pole_level","없음");







                       /* Log.v("resultValue", pole_code + "/" + pole_office + "/" + pole_addr
                                + "/" + pole_height + "/" + pole_date + "/" + emp_id + "/" + transformer_yn
                                + "/" + pole_com + "/" + pole_high + "/" + pole_down + "/" + pole_comment
                                + "/" + pole_eday + "/" + pole_level); */

                        Log.v("resultValue", pole_code + "/" + pole_office + "/" + pole_addr);
                        adapter.addItem(pole_code,mac_code,pole_height,pole_addr,pole_date, emp_id,transformer_yn,pole_com,pole_high,pole_down,pole_comment,pole_eday,pole_level,pole_office);
                        M_pole_listview.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            // 서버와의 연동 에러시 출력
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override //response를 UTF8로 변경해주는 소스코드
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }

            // 보낼 데이터를 저장하는 곳
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        stringRequest.setTag(TAG);
        queue.add(stringRequest);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.d("test", "onTextChanged: "+edt_search.getText().toString());
        M_pole_listview.setFilterText(edt_search.getText().toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (edt_search.getText().length() == 0) {
            M_pole_listview.clearTextFilter();
        }
    }


}


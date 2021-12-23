/*
package com.example.projectfile.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

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
import com.example.projectfile.R;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class delete_Popup extends Activity {


    // Server로 요청하는 객체
    private RequestQueue queue;
    // Server로 요청시 필요한 정보를 담는 객체
    private StringRequest stringRequest;
    // client를 판별하는 값
    private String TAG = "main";



    TextView tv_pop_up_p;
    Button btn_close_p, btn_delete_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup);

        tv_pop_up_p = findViewById(R.id.tv_pop_up_p);
        btn_close_p = findViewById(R.id.btn_close_p);
        btn_delete_p = findViewById(R.id.btn_delete_p);




     */
/*   //코드추가
        Intent intent = getIntent();
        String a = intent.getStringExtra("text");
        if(a.equals("1")){
            tv.setText("00번 전신주에 기울기 변화가 감지되었습니다.");
        } else if (a.equals("2")){
            tv.setText("00번 전신주에 센서값 변화가 감지되었습니다.");
        } else if(a.equals("3")){
            tv.setText("00번 전신주에 충격이 감지되었습니다.");
        }*//*





        btn_close_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
        btn_delete_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(delete_Popup.this, Notice_alarm.class);
                tv_pop_up_p.setText(intent.getStringExtra("pole_code"));
                sendRequest();
                startActivity(intent);
                finish();
            }
        });
    }


    public void sendRequest() {
        // Volley Lib 새로운 요청객체 생성
        queue = Volley.newRequestQueue(this);
        // 서버에 요청할 주소
        String url = "http://172.30.1.11:8087/team1/deletePole_and";

        // 요청 문자열 저장
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);

                Intent intent = new Intent(delete_Popup.this, Main.class);
                startActivity(intent);
                finish();
                // 데이터를 수정된 상태로 보내줌?

        */
/*        try {
                    JSONObject object = new JSONObject(response);

                } catch (JSONException e) {
                    e.printStackTrace();
                }*//*

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
                params.put("pole_code", tv_pop_up_p.getText().toString());

                return params;
            }
        };
        stringRequest.setTag(TAG);
        queue.add(stringRequest);


    }
}*/

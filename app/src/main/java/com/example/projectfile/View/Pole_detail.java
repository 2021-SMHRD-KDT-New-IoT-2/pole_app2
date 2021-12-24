package com.example.projectfile.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import android.widget.ImageButton;
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

public class Pole_detail extends Activity {

  /*  private com.github.mikephil.charting.charts.LineChart chart;*/

    // Server로 요청하는 객체
    private RequestQueue queue;
    // Server로 요청시 필요한 정보를 담는 객체
    private StringRequest stringRequest;
    // client를 판별하는 값
    private String TAG = "main";



    Button btn_update_d,btn_delete_d;
    ImageButton btn_close_d;

    TextView tv_pole_code_d, tv_pole_height_d, tv_pole_addr_d, tv_pole_date_d, tv_emp_id_d,
            tv_transformer_yn_d, tv_pole_com_d, tv_pole_high_d, tv_pole_down_d,
            tv_pole_comment_d,  tv_pole_office_d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pole_detail);

        Intent intent = getIntent();
        tv_pole_code_d = findViewById(R.id.tv_pole_code_d);
        tv_pole_height_d = findViewById(R.id.tv_pole_height_d);
        tv_pole_addr_d = findViewById(R.id.tv_pole_addr_d);
        tv_pole_date_d = findViewById(R.id.tv_pole_date_d);
        tv_emp_id_d = findViewById(R.id.tv_emp_id_d);
        tv_transformer_yn_d = findViewById(R.id.tv_transformer_yn_d);
        tv_pole_com_d = findViewById(R.id.tv_pole_com_d);
        tv_pole_high_d = findViewById(R.id.tv_pole_high_d);
        tv_pole_down_d = findViewById(R.id.tv_pole_down_d);
        tv_pole_comment_d = findViewById(R.id.tv_pole_comment_d);


        tv_pole_office_d = findViewById(R.id.tv_pole_office_d);

        tv_pole_code_d.setText(intent.getStringExtra("pole_code"));
        tv_pole_height_d.setText(intent.getStringExtra("pole_height"));
        tv_pole_addr_d.setText(intent.getStringExtra("pole_addr"));
        tv_pole_date_d.setText(intent.getStringExtra("pole_date"));
        tv_emp_id_d.setText(intent.getStringExtra("emp_id"));
        tv_transformer_yn_d.setText(intent.getStringExtra("transformer_yn"));
        tv_pole_com_d.setText(intent.getStringExtra("pole_com"));
        tv_pole_high_d.setText(intent.getStringExtra("pole_high"));
        tv_pole_down_d.setText(intent.getStringExtra("pole_down"));
        tv_pole_comment_d.setText(intent.getStringExtra("pole_comment"));

        tv_pole_office_d.setText(intent.getStringExtra("pole_office"));


        String code = tv_pole_code_d.getText().toString();


        btn_close_d = findViewById(R.id.btn_close_d);
        btn_update_d = findViewById(R.id.btn_update_d);
        btn_delete_d = findViewById(R.id.btn_delete_d);

        btn_delete_d = findViewById(R.id.btn_delete_d);

        btn_close_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pole_detail.this, Main.class);
                startActivity(intent);
                finish();
            }
        });

        btn_update_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pole_detail.this, update_Pole.class);
                intent.putExtra("pole_code", code);
                startActivity(intent);
                finish();

            }
        });
        btn_delete_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pole_detail.this, delete_Popup.class);
                intent.putExtra("pole_code", code);
                startActivity(intent);
                //sendRequest();
                finish();

            }
        });









/*
        chart = findViewById(R.id.pole_linechart);
        
        // 수정부분
        ArrayList<Entry> values = new ArrayList<>();





        float val = 90;

        for (int i = 1; i <= 11; i++) {

            values.add(new Entry(i, val));
            val -= 0.3;
        }
        //핵심!!!!!!!!!!!!     values.add(x축(날짜),y축(기울기값));
        values.add(new Entry(12, (float)99.1));







        LineDataSet set1;
        set1 = new LineDataSet(values, "기울기");

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);

        chart.setData(data);
*/

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

                Intent intent = new Intent(Pole_detail.this, Main.class);
                startActivity(intent);
                finish();
                // 데이터를 수정된 상태로 보내줌?

        /*        try {
                    JSONObject object = new JSONObject(response);

                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
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
                params.put("pole_code", tv_pole_code_d.getText().toString());

                return params;
            }
        };
        stringRequest.setTag(TAG);
        queue.add(stringRequest);


    }


}

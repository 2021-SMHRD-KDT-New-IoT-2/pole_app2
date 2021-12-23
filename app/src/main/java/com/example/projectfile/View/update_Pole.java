package com.example.projectfile.View;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
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
import com.example.projectfile.R;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class update_Pole extends AppCompatActivity {
                                // 팝업 쓸려면 Activity

    private Button btn_cancel_u, btn_update_u;
    private EditText edt_pole_height_u, edt_pole_addr_u, edt_pole_office_u,
            edt_emp_id_u, edt_pole_date_u;
    private TextView tv_pole_code_u;
    private Switch swc_transformer_yn_u, swc_pole_com_u, swc_pole_high_u, swc_pole_down_u;
    private String check1 = "N", check2 = "N", check3 = "N", check4 = "N";


    // Server로 요청하는 객체
    private RequestQueue queue;
    // Server로 요청시 필요한 정보를 담는 객체
    private StringRequest stringRequest;
    // client를 판별하는 값
    private String TAG = "main";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.updatepole);

        Intent intent = getIntent();

        tv_pole_code_u = findViewById(R.id.tv_pole_code_u);
        btn_cancel_u = findViewById(R.id.btn_close_u);
        btn_update_u = findViewById(R.id.btn_update_u);

        /*edt_pole_height_u = findViewById(R.id.edt_pole_height_u);
        edt_pole_addr_u = findViewById(R.id.edt_pole_addr_u);*/
        edt_pole_office_u = findViewById(R.id.edt_pole_office_u);
        edt_emp_id_u = findViewById(R.id.edt_emp_id_u);
       /* edt_pole_date_u = findViewById(R.id.edt_pole_date_u);*/

        swc_transformer_yn_u = findViewById(R.id.swc_transformer_yn_u);
        swc_pole_com_u = findViewById(R.id.swc_pole_com_u);
        swc_pole_high_u = findViewById(R.id.swc_pole_high_u);
        swc_pole_down_u = findViewById(R.id.swc_pole_down_u);

        tv_pole_code_u.setText(intent.getStringExtra("pole_code"));


        swc_transformer_yn_u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check1 = "Y";
                } else {
                    check1 = "N";
                }
            }
        });
        swc_pole_com_u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check2 = "Y";
                } else {
                    check2 = "N";
                }
            }
        });
        swc_pole_high_u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check3 = "Y";
                } else {
                    check3 = "N";
                }
            }
        });
        swc_pole_down_u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check4 = "Y";
                } else {
                    check4 = "N";
                }
            }
        });






        btn_cancel_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(update_Pole.this, Main.class);
                startActivity(intent);
                finish();
            }
        });


        btn_update_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(update_Pole.this, Main.class);
                startActivity(intent);
                finish();
                sendRequest();
            }
        });


    }


            public void sendRequest() {
                // Volley Lib 새로운 요청객체 생성
                queue = Volley.newRequestQueue(this);
                // 서버에 요청할 주소
                String url = "http://172.30.1.11:8087/team1/updatePole_and";

                // 요청 문자열 저장
                stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    // 응답데이터를 받아오는 곳
                    @Override
                    public void onResponse(String response) {
                        Log.v("resultValue", response);

                        Intent intent = new Intent(update_Pole.this, Main.class);
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

                        params.put("pole_code", tv_pole_code_u.getText().toString());
                        params.put("pole_office", edt_pole_office_u.getText().toString());
                        params.put("emp_id", edt_emp_id_u.getText().toString());
                        params.put("transformer_yn", check1);
                        params.put("pole_com", check2);
                        params.put("pole_high", check3);
                        params.put("pole_down", check4);

                        return params;
                    }
                };
                stringRequest.setTag(TAG);
                queue.add(stringRequest);



    }


}


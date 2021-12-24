package com.example.projectfile.View;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

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

public class add_Pole extends AppCompatActivity {
                                // 팝업 쓸려면 Activity

    private Button btn_cancel, btn_add;
    private EditText edt_pole_code, edt_pole_height, edt_pole_addr, edt_pole_office, edt_emp_id, edt_pole_date;
    private Switch swc_transformer_yn, swc_pole_com, swc_pole_high, swc_pole_down;
    private String check1 = "N", check2 = "N", check3 = "N", check4 = "N";


    // Server로 요청하는 객체
    private RequestQueue queue;
    // Server로 요청시 필요한 정보를 담는 객체
    private StringRequest stringRequest;
    // client를 판별하는 값
    private String TAG = "main";

    InputMethodManager imm;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.addpole);

        btn_cancel = findViewById(R.id.btn_close_a);
        btn_add = findViewById(R.id.btn_update_a);
        edt_pole_code = findViewById(R.id.tv_pole_code_a);
        edt_pole_height = findViewById(R.id.edt_pole_height_a);
        edt_pole_addr = findViewById(R.id.edt_pole_addr_a);
        edt_pole_office = findViewById(R.id.edt_pole_office_a);
        edt_emp_id = findViewById(R.id.edt_emp_id_a);
        edt_pole_date = findViewById(R.id.edt_pole_date_a);

        swc_transformer_yn = findViewById(R.id.swc_transformer_yn_a);
        swc_pole_com = findViewById(R.id.swc_pole_com_a);
        swc_pole_high = findViewById(R.id.swc_pole_high_a);
        swc_pole_down = findViewById(R.id.swc_pole_down_a);


        // 키보드 제어 (키보드 보이기)
        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE); // 입력 방법을 관리



        swc_transformer_yn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check1 = "Y";
                } else {
                    check1 = "N";
                }
            }
        });
        swc_pole_com.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check2 = "Y";
                } else {
                    check2 = "N";
                }
            }
        });
        swc_pole_high.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check3 = "Y";
                } else {
                    check3 = "N";
                }
            }
        });
        swc_pole_down.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    check4 = "Y";
                } else {
                    check4 = "N";
                }
            }
        });






        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add_Pole.this, Main.class);
                startActivity(intent);
                finish();
            }
        });


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(add_Pole.this, Main.class);
                startActivity(intent);
                finish();*/
                sendRequest();
            }
        });


    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }


            public void sendRequest() {
                // Volley Lib 새로운 요청객체 생성
                queue = Volley.newRequestQueue(this);
                // 서버에 요청할 주소
                String url = "http://172.30.1.11:8087/team1/assignpole_and";

                // 요청 문자열 저장
                stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    // 응답데이터를 받아오는 곳
                    @Override
                    public void onResponse(String response) {
                        Log.v("resultValue", response);

                        Intent intent = new Intent(add_Pole.this, Main.class);
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
                        params.put("pole_code", edt_pole_code.getText().toString());
                        params.put("pole_height", edt_pole_height.getText().toString());
                        params.put("pole_addr", edt_pole_addr.getText().toString());
                        params.put("pole_office", edt_pole_office.getText().toString());
                        params.put("emp_id", edt_emp_id.getText().toString());
                        params.put("pole_date", edt_pole_date.getText().toString());
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


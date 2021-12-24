package com.example.projectfile.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import com.example.projectfile.Model.Emp_infoVO;
import com.example.projectfile.R;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView, textView2;
    private EditText edt_id, edt_pw;
    private Button btn_login, btn_emp_add;
    private CheckBox checkBox;

    // 웹통신에 필요한 3가지
    // Server로 요청하는 객체
    private RequestQueue queue;
    // Server로 요청시 필요한 정보를 담는 객체
    private StringRequest stringRequest;
    // client를 판별하는 값
    private String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        checkBox = findViewById(R.id.checkBox);
        btn_login = findViewById(R.id.btn_login);
  /*      btn_emp_add = findViewById(R.id.btn_emp_add);*/

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();

            }
        });



      /* //나중에 지움
        btn_emp_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this, Main.class);
                startActivity(intent);
                finish();

            }
        });*/



        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences prefer = getSharedPreferences("temp", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefer.edit();

                if(isChecked){
                    editor.putString("emp_id", edt_id.getText().toString());
                    editor.putBoolean("cb", checkBox.isChecked());
                }else{
                    editor.clear();
                }
                editor.commit();
                Log.d("LoginActivity", "체크상태: "+(isChecked?"체크됨":"체크풀림")+"");
            }
        });

        SharedPreferences sp = getSharedPreferences("temp", MODE_PRIVATE);

        String s = sp.getString("emp_id", "");
        Boolean b = sp.getBoolean("cb", false);

        edt_id.setText(s);
        checkBox.setChecked(b);
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


    @Override
    protected void onStop() {
        super.onStop();
    }

    public void sendRequest() {
        // Volley Lib 새로운 요청객체 생성
        queue = Volley.newRequestQueue(this);
        // 서버에 요청할 주소
        String url = "http://172.30.1.11:8087/team1/LoginService_and";

        // 요청 문자열 저장
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);
                if(response.equals("fail")){
                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String emp_id = jsonObject.getString("emp_id");
                        String emp_pw = jsonObject.getString("emp_pw");
                        String emp_name = jsonObject.getString("emp_name");
                        String emp_office = jsonObject.getString("emp_office");
                        String emp_phone = jsonObject.getString("emp_phone");
                        String emp_yesno = jsonObject.getString("emp_yesno");


                        Log.v("resultValue", emp_id + "/" + emp_pw + "/" + emp_name
                                + "/" + emp_office + "/" + emp_phone + "/" + emp_yesno);


                        Emp_infoVO info = new Emp_infoVO();

                        Intent intent = new Intent(Login.this, Main.class);
                        intent.putExtra("info", info);
                        startActivity(intent);
                        finish();



/*
                        // 회원가입용 나중에 삭제
                        public String getLoginID(){
                            return getApplicationContext().getSharedPreferences("LoginInfo", Context.MODE_PRIVATE).getString("LoginID", "아이디정보 없음");
                        }


                        public void successLogin(String id) {
                            SharedPreferences spf = getSharedPreferences("LoginInfo", MODE_PRIVATE);
                            spf.edit().putString("LoginID", id).commit();
                        }*/




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            // 서버와의 연동 에러시 출력
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
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
                params.put("emp_id",edt_id.getText().toString());
                params.put("emp_pw",edt_pw.getText().toString());
                return params;
            }
        };
        stringRequest.setTag(TAG);
        queue.add(stringRequest);
    }





}

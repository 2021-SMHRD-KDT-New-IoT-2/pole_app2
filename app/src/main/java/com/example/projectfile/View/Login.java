package com.example.projectfile.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    private Button btn_login;
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

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();

            }
        });

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
    protected void onStop() {
        super.onStop();
    }

    public void sendRequest() {
        // Volley Lib 새로운 요청객체 생성
        queue = Volley.newRequestQueue(this);
        // 서버에 요청할 주소
        String url = "http://127.0.0.1:8087/AndroidServer/LoginService";

        // 요청 문자열 저장
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                /*Log.v("resultValue",response);*/
                if(response.equals("fail")){
                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                }else{
                    // json 타입 문자열을 json 객체로 변환해주는 코드
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String emp_id = jsonObject.getString("emp_id");
                        String emp_pw = jsonObject.getString("emp_pw");
                        String emp_name = jsonObject.getString("emp_name");
                        String emp_phone = jsonObject.getString("emp_phone");
                        String emp_joindate = jsonObject.getString("emp_joindate");
                        String admin_yesno = jsonObject.getString("admin_yesno");

                        Log.v("resultValue",emp_id + "/" + emp_pw + "/" + emp_name +
                                "/" + emp_phone + "/" + emp_joindate + "/" + admin_yesno);

                        Emp_infoVO emp_infoVO = new Emp_infoVO(emp_id, emp_pw, emp_name, emp_phone,
                                emp_joindate, admin_yesno);

                        Intent intent = new Intent(Login.this, List.class);
                        intent.putExtra("emp_infoVO", emp_infoVO);
                        startActivity(intent);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
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

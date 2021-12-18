package com.example.projectfile.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projectfile.R;

public class List2 extends Activity {

    TextView tv_enrollment, tv_id, tv_location, tv_transformers, tv_manager;
    EditText edt_number, edt_location, edt_transformers, edt_manager;
    Button btn_previous, btn_enrollment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.list2);

        tv_enrollment = findViewById(R.id.btn_enrollment);
        tv_id = findViewById(R.id.tv_id);
        edt_number = findViewById(R.id.edt_number);
        tv_location = findViewById(R.id.tv_location);
        edt_location = findViewById(R.id.edt_location);
        tv_transformers = findViewById(R.id.tv_transformers);
        edt_transformers = findViewById(R.id.edt_transformers);
        tv_manager = findViewById(R.id.tv_manager);
        edt_manager = findViewById(R.id.edt_manager);

        btn_previous = findViewById(R.id.btn_previous);
        btn_enrollment = findViewById(R.id.btn_enrollment);

        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(List2.this, Main.class);
                startActivity(intent);
                finish();
            }
        });
    }
}


package com.example.projectfile.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.projectfile.R;

public class Enrollment extends Activity {

    TextView tv_enrollment, tv_id, tv_id1, tv_location, tv_location1, tv_transformers, tv_transformers1
            , tv_manager, tv_manager1, btn_previous, btn_enrollment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.enrollment);

        tv_enrollment = findViewById(R.id.tv_enrollment);
        tv_id = findViewById(R.id.tv_id);
        tv_id1 = findViewById(R.id.tv_id1);
        tv_location = findViewById(R.id.tv_location);
        tv_location1 = findViewById(R.id.tv_location1);
        tv_transformers = findViewById(R.id.tv_transformers);
        tv_transformers1 = findViewById(R.id.tv_transformers1);
        tv_manager = findViewById(R.id.tv_manager);
        tv_manager1 = findViewById(R.id.tv_manager1);
        btn_previous = findViewById(R.id.btn_previous);
        btn_enrollment = findViewById(R.id.btn_enrollment);

        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Enrollment.this, Main.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
package com.example.projectfile.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.projectfile.R;

public class Pole_detail extends Activity {

    private com.github.mikephil.charting.charts.LineChart chart;

    Button btn_close_d, btn_update_d;
    TextView tv_pole_code_d, tv_pole_height_d, tv_pole_addr_d, tv_pole_date_d, tv_emp_id_d,
            tv_transformer_yn_d, tv_pole_com_d, tv_pole_high_d, tv_pole_down_d,
            tv_pole_comment_d, tv_pole_level_d, tv_pole_office_d;
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

        tv_pole_level_d = findViewById(R.id.tv_pole_level_d);
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
        tv_pole_level_d.setText(intent.getStringExtra("pole_level"));
        tv_pole_office_d.setText(intent.getStringExtra("pole_office"));


        String code = tv_pole_code_d.getText().toString();


        btn_close_d = findViewById(R.id.btn_close_d);
        btn_update_d = findViewById(R.id.btn_update_d);



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
}

package com.example.exe2_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Results extends AppCompatActivity implements AdapterView.OnItemClickListener {
    double[] ser = new double[20];
    double mod, sum;
    String[] vser = new String[20];
    ListView lstv;
    TextView tvx, tvd, tvn, tvsn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        lstv = (ListView) findViewById(R.id.lstv);
        tvx = findViewById(R.id.tvx);
        tvd = findViewById(R.id.tvd);
        tvn = findViewById(R.id.tvn);
        tvsn = findViewById(R.id.tvsn);

        Intent gi = getIntent();
        ser[0] = gi.getDoubleExtra("first", 0.0);
        mod = gi.getDoubleExtra("mod", 0.0);

        if (gi.getBooleanExtra("type", true)) {
            for (int i = 1; i < 20; i++) {
                ser[i] = ser[i - 1] * mod;
            }
        } else {
            for (int i = 1; i < 20; i++) {
                ser[i] = ser[i - 1] + mod;
            }
        }
        for (int i = 0; i < 20; i++) {
            vser[i] = (ser[i]) + "";
        }

        lstv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lstv.setOnItemClickListener(this);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, vser);
        lstv.setAdapter(adp);


    }

    public void ret(View view) {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvx.setText("X1 = "+ ser[0]);
        tvd.setText("d = "+mod);
        tvn.setText("n = "+ (position+1));
        sum = 0;
        for (int i = 0; i <= position; i++) {sum+=ser[i];}
        tvsn.setText("Sn = "+ sum);
    }
}
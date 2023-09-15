package com.example.exe2_2024;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etf, etm;
    boolean ty = true;//true = geo, false = art

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etf = (EditText) findViewById(R.id.etf);
        etm = (EditText) findViewById(R.id.etm);
    }

    public void tog(View view) {
        ty = !ty;
    }

    public void next(View view) {
        Intent si = new Intent(this, Results.class);
        si.putExtra("type", ty);
        si.putExtra("first", parseDouble(etf.getText().toString()));
        si.putExtra("mod", parseDouble(etm.getText().toString()));
        startActivity(si);
    }
}
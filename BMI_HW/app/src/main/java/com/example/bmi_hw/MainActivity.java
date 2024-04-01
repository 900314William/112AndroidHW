package com.example.bmi_hw;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvShow = (TextView) findViewById(R.id.txvShow);
        txvShow.setTextSize(36);
        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnCalc.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    public void onClick(View v){
        EditText edtHeight = (EditText) findViewById(R.id.edtHeight);
        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);

        try {
            if (v.getId() == R.id.btnCalc) {
                double height = Double.parseDouble(edtHeight.getText().toString());
                double weight = Double.parseDouble(edtWeight.getText().toString());
                double bmi = weight / Math.pow(height / 100.0, 2);
                if (bmi >= 24) {
                    txvShow.setTextColor(Color.RED);
                } else if (bmi < 18.5) {
                    txvShow.setTextColor(Color.BLUE);
                } else
                    txvShow.setTextColor(Color.GREEN);

                txvShow.setText(String.format("%.2f", bmi));
            } else {
                edtHeight.setText("");
                edtWeight.setText("");
                txvShow.setText("");
            }
        }
        catch (NumberFormatException e){
            Toast.makeText(this, "請輸入數字", Toast.LENGTH_SHORT).show();
        }
    }
}
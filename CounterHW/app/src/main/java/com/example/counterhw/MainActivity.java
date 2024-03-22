package com.example.counterhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_Click(View view){
        int counter;
        TextView output = (TextView) findViewById(R.id.textView);
        counter = Integer.parseInt(output.getText().toString());
        counter++;
        output.setText(Integer.toString(counter));
    }

    public void button2_Click(View view){
        TextView output = (TextView) findViewById(R.id.textView);
        output.setText(R.string.ini_value);
    }

    public void button3_Click(View view){
        int counter;
        TextView output = (TextView) findViewById(R.id.textView);
        counter = Integer.parseInt(output.getText().toString());
        counter--;
        output.setText(Integer.toString(counter));
    }
}
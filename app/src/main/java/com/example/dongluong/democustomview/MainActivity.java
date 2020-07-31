package com.example.dongluong.democustomview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int TOTAL_TIME = 10;

    demo d;
    Button btn;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        d = findViewById(R.id.demo_d);
        btn = findViewById(R.id.btn_start);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<20;i++){
                    d.setCount(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
      //  t.start();

        a=0;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setCount(a++);
                Log.d("123", "onClick: ");
            }
        });
    }



}

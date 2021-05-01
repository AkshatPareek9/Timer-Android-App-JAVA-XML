package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class B extends AppCompatActivity {
Button next,back;
TextView textView;
Thread t;
int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        textView = findViewById(R.id.tvb);
        next = findViewById(R.id.nextb);
        back = findViewById(R.id.backb);

        Intent i = getIntent();
        String str = i.getStringExtra("count");
        count = Integer.parseInt(str);
        textView.setText(str);

        t = new Thread(){
            @Override
            public void run(){
                while(!isInterrupted()){
                    try {
                        Thread.sleep(5000);  //5000ms = 5 sec
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count = count+5;
                                textView.setText(String.valueOf(count));
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t.start();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),C.class);
                String str = textView.getText().toString();
                intent.putExtra("count",str);
                startActivityForResult(intent,3);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),A.class);
                String str = textView.getText().toString();
                intent.putExtra("count",str);
                setResult(2,intent);
                finish();
            }
        });
    }
}
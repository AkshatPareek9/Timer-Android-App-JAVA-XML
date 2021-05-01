package com.example.timer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A extends AppCompatActivity {
Button next,stoptimer;
int count=0;
TextView textView;
Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        textView = findViewById(R.id.tv);
        stoptimer = findViewById(R.id.stoptimer);
        next = findViewById(R.id.nexta);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),B.class);
                String str = textView.getText().toString();
                intent.putExtra("count",str);
                startActivityForResult(intent,2);
            }
        });

        t = new Thread(){
            @Override
            public void run(){
                while(!isInterrupted()){
                    try {
                        Thread.sleep(5000);  //5000ms = 5 sec
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count= count+5;
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

        stoptimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2) {
            if(resultCode == RESULT_OK)
            {
                String str = data.getStringExtra("count");
                count = Integer.parseInt(str);
                textView.setText(str);
            }
        }
    }
}



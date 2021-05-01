package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class C extends AppCompatActivity {
Button back;
TextView textView;
Thread t;
int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        textView = findViewById(R.id.tvc);
        back = findViewById(R.id.backc);

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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),B.class);
                String str = textView.getText().toString();
                intent.putExtra("count",str);
                setResult(3,intent);
                finish();
            }
        });
    }
}
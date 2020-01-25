package com.ir_sj.speakingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText e1, e2;
    TextView t1;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.button);
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        t1 = (TextView)findViewById(R.id.textView);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.9f);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s3;
                String s = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s == "" || s2 == "")
                {
                    s3 = "The fields cannot be empty!";
                }
                else
                {
                    Integer i1 = Integer.parseInt(s);
                    Integer i2 = Integer.parseInt(s2);
                    Integer i3 = i1+i2;
                    s3 = "The answer is " + i3.toString();
                }
                t1.setText(s3);
                ts.speak(s3, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
}

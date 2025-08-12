package com.leon.romequizapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.gson.*;

import java.io.IOException;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //////////////////////////////------------------

        TextView textViewQuestion = findViewById(R.id.textViewQuestion);
        Button button1 = findViewById(R.id.buttonOption1);
        Button button2 = findViewById(R.id.buttonOption2);
        Button button3 = findViewById(R.id.buttonOption3);



        new Thread(() -> {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("http://10.0.2.2:4567/quiz/random").build();

            try {
                Response response = client.newCall(request).execute();
                String json = response.body().string();
                Gson gson = new Gson();
                QuizQuestion question = gson.fromJson(json,QuizQuestion.class);

                runOnUiThread(() -> {
                    textViewQuestion.setText(question.getQuestion());
                    button1.setText(question.getOptions().get(0));
                    button2.setText(question.getOptions().get(1));
                    button3.setText(question.getOptions().get(2));


                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }).start();

        //////////////////////////////------------------

    }
}
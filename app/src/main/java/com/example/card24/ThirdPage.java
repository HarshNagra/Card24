package com.example.card24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ThirdPage extends AppCompatActivity {

    private Button launchSecondPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchSecondPage=(Button) findViewById(R.id.inputnumber);
        launchSecondPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity();
            }
        });

    }

    private void launchActivity(){
        Intent intent = new Intent(this, SecondPage.class);
        startActivity(intent);
    }



}

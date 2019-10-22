package com.example.card24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private Button launchSecondPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        launchSecondPage=(Button) findViewById(R.id.inputnumber);
        EditText mEdit=(EditText) findViewById(R.id.mytextText);
        final String content = mEdit.getText().toString(); //gets you the contents of edit text

        launchSecondPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity(content);
            }
        });

    }

    private void launchActivity(String content){
        Intent intent = new Intent(this, SecondPage.class);
        int result = Integer.parseInt(content);
        intent.putExtra("input_key", result);
        startActivity(intent);
    }



}

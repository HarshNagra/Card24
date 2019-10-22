package com.example.card24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private Button launchSecondPage;
    public static final String EXTRA_MESSAGE = "com.example.card24";

    public void launchActivity(View view) {

        Intent intent = new Intent(this, SecondPage.class);
        EditText editText = (EditText) findViewById(R.id.mytextText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        launchSecondPage=(Button) findViewById(R.id.inputnumber);

        launchSecondPage.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view) {
                launchActivity(view);
            }
        });

    }




}

package com.example.card24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.Jep;
import com.singularsys.jep.ParseException;

public class MainActivity extends AppCompatActivity {
    Button rePick; Button checkInput; Button clear;
    Button left;
    Button right;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    TextView expression;
    ImageButton[] cards;
    int[] data;
    int[] card;
    int[] imageCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cards = new ImageButton[4];

        rePick = (Button)findViewById(R.id.repick); checkInput = (Button)findViewById(R.id.checkinput); left = (Button)findViewById(R.id.left);
        right = (Button)findViewById(R.id.right);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multiply = (Button)findViewById(R.id.multiply); divide = (Button)findViewById(R.id.divide);
        clear = (Button)findViewById(R.id.clear);
        expression = (TextView)findViewById(R.id.input);

        cards[0] = (ImageButton) findViewById(R.id.card1);
        cards[1] = (ImageButton) findViewById(R.id.card2);
        cards[2] = (ImageButton) findViewById(R.id.card3);
        cards[3] = (ImageButton) findViewById(R.id.card4);

        imageCount = new int[4];

        cards[0].setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View view) {
            clickCard(0); }
        });
        cards[1].setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View view) {
                clickCard(1); }
        });
        cards[2].setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View view) {
                clickCard(2); }
        });
        cards[3].setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View view) {
                clickCard(3); }
        });

        left.setOnClickListener(new Button.OnClickListener(){ public void onClick(View view) {
            expression.append("(");
        }
        });
        right.setOnClickListener(new Button.OnClickListener(){ public void onClick(View view) {
            expression.append(")");
        }
        });
        plus.setOnClickListener(new Button.OnClickListener(){ public void onClick(View view) {
            expression.append("+");
        }
        });
        minus.setOnClickListener(new Button.OnClickListener(){ public void onClick(View view) {
            expression.append("-");
        }
        });
        multiply.setOnClickListener(new Button.OnClickListener(){ public void onClick(View view) {
            expression.append("*");
        }
        });
        divide.setOnClickListener(new Button.OnClickListener(){ public void onClick(View view) {
            expression.append("/");
        }
        });

        clear.setOnClickListener(new Button.OnClickListener(){ public void onClick(View view){
            setClear();
            }
        });

        checkInput.setOnClickListener(new Button.OnClickListener() { public void onClick(View view) {
            String inputStr = expression.getText().toString();
            if (checkInput(inputStr)) {
                Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                pickCard();
            } else {
                Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                setClear();
            }
        }
        });




        initCardImage();
        pickCard();
    }

    private void initCardImage() { for (int i = 0; i < 4; i++) {
        int resID = getResources().getIdentifier("back_0","drawable","com.example.card24");
        cards[i].setImageResource(resID); }
    }


    private void pickCard(){ data = new int[4]; card = new int[4];
        card[0]=4; card[1]=5; card[2]=9; card[3]=10;
        data[0]=4; data[1]=5; data[2]=9; data[3]=10;
        setClear();
    }

    private void setClear(){ int resID;
        expression.setText(""); for (int i = 0; i < 4; i++) {
            imageCount[i] = 0;
            resID = getResources().getIdentifier("card"+card[i],"drawable", "com.example.card24");
            cards[i].setImageResource(resID);
            cards[i].setClickable(true);
        }
    }

    private void clickCard(int i) {
        int resId;
        String num;
        Integer value;
        if (imageCount[i] == 0) {
            resId = getResources().getIdentifier("back_0","drawable", "com.example.card24");
            cards[i].setImageResource(resId);
            cards[i].setClickable(false);
            value = data[i];
            num = value.toString();
            expression.append(num);
            imageCount[i] ++;
        }
    }

    private boolean checkInput(String input) {
        Jep jep = new Jep();
        Object res;
        try {
            jep.parse(input);
            res = jep.evaluate();
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Wrong Expression", Toast.LENGTH_SHORT).show();
            return false;
            } catch (EvaluationException e) { e.printStackTrace();
            Toast.makeText(MainActivity.this, "Wrong Expression", Toast.LENGTH_SHORT).show(); return false;
            }
            Double ca = (Double)res;
            if (Math.abs(ca - 24) < 1e-6)
                return true; return false;
        }
}

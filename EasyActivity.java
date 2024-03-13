package com.cookandroid.termproject1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class EasyActivity extends Activity {

    int dep1, dep2, dep3;
    String num1, num2, num3;
    int count;
    EditText edit1, edit2, edit3;
    TextView tvCount, tvResult;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy);

        tvCount = findViewById(R.id.tvCount);
        tvResult = findViewById(R.id.tvResult);

        count = 0;

        if (count == 0) {
            tvResult.setText("");

            tvResult.setText("게임이 시작되었습니다.\n");


            dep1 = (int) (Math.random() * 9);
            dep2 = (int) (Math.random() * 9);
            dep3 = (int) (Math.random() * 9);

            while (dep2 == dep1) {
                dep2 = (int) (Math.random() * 9);
            }
            while (dep3 == dep1 || dep3 == dep2) {
                dep3 = (int) (Math.random() * 9);
            }
        }

        Button btnCheck = (Button) findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edit1 = findViewById(R.id.edit1);
                edit2 = findViewById(R.id.edit2);
                edit3 = findViewById(R.id.edit3);


                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                num3 = edit3.getText().toString();

                int Num1 = Integer.parseInt(num1);
                int Num2 = Integer.parseInt(num2);
                int Num3 = Integer.parseInt(num3);

                int strike = 0;
                int ball = 0;

                if (dep1 == Num1) {
                    strike++;
                } else if (dep1 == Num2 || dep1 == Num3) {
                    ball++;
                }

                if (dep2 == Num2) {
                    strike++;
                } else if (dep2 == Num1 || dep2 == Num3) {
                    ball++;
                }

                if (dep3 == Num3) {
                    strike++;
                } else if (dep3 == Num1 || dep3 == Num2) {
                    ball++;
                }

                count++;
                tvCount.setText(count + "번째");


                String resultstr =  count + " : ";
                if (strike == 0 && ball == 0) {
                    resultstr += "아웃 " +"1번째 :" +"<" + Num1 +">"+ "2번째:"  +"<" + Num2 +">"+ "3번째:" + "<" +Num3 +">"+ "\n";
                }
                else if (strike == 3) {
                    Intent intent = new Intent(getApplication(), Win.class);
                    startActivity(intent);
                }
                else {
                    resultstr += strike + "S, " + ball + "B ";
                    resultstr += "1번째 :" +"<" + Num1 +">"+ "2번째:"  +"<" + Num2 +">"+ "3번째:" + "<" +Num3 +">"+ "\n";
                }

                if (tvResult.getText().toString() == null || tvResult.getText().toString() == "") {
                    tvResult.setText(resultstr);
                } else {
                    tvResult.append(resultstr);
                }

                if(count == 7)
                {
                    if (strike == 3) {
                        Intent intent = new Intent(getApplication(), Win.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(getApplication(),Restart.class);
                        startActivity(intent);
                    }
                }
                edit1.setText(null);
                edit2.setText(null);
                edit3.setText(null);
            }
        });
    }
}

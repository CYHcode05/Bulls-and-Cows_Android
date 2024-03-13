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

public class Hard extends Activity {

    int dep4, dep5, dep6, dep7;
    int count1;
    EditText edit4, edit5, edit6, edit7;
    TextView tvResult1, tvCount1;
    String num4, num5, num6, num7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hard);

        tvCount1 = findViewById(R.id.tvCount1);
        tvResult1 = findViewById(R.id.tvResult1);

        count1 = 0;

        if (count1 == 0) {
            tvResult1.setText("");

            tvResult1.setText("게임이 시작되었습니다.\n");

            dep4 = (int) (Math.random() * 9);
            dep5 = (int) (Math.random() * 9);
            dep6 = (int) (Math.random() * 9);
            dep7 = (int) (Math.random() * 9);

            while (dep5 == dep4) {
                dep5 = (int) (Math.random() * 9);
            }

            while (dep6 == dep4 || dep6 == dep5) {
                dep6 = (int) (Math.random() * 9);
            }

            while (dep7 == dep4 || dep7 == dep5) {
                while (dep7 == dep6) {
                    dep7 = (int) (Math.random() * 9);
                }
            }
        }
        Button btnCheck = (Button) findViewById(R.id.btnCheck1);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit4 = findViewById(R.id.edit4);
                edit5 = findViewById(R.id.edit5);
                edit6 = findViewById(R.id.edit6);
                edit7 = findViewById(R.id.edit7);

                num4 = edit4.getText().toString();
                num5 = edit5.getText().toString();
                num6 = edit6.getText().toString();
                num7 = edit7.getText().toString();

                int Num4 = Integer.parseInt(num4);
                int Num5 = Integer.parseInt(num5);
                int Num6 = Integer.parseInt(num6);
                int Num7 = Integer.parseInt(num7);

                int strike1 = 0;
                int ball1 = 0;

                if (dep4 == Num4) {
                    strike1++;
                } else if (dep4 == Num5 || dep4 == Num6) {
                    ball1++;
                } else if(dep4 == Num7)
                {
                    ball1++;
                }

                if (dep5 == Num5) {
                    strike1++;
                } else if (dep5 == Num4 || dep5 == Num6) {
                    ball1++;
                } else if (dep5 == Num7)
                {
                    ball1++;
                }

                if (dep6 == Num6) {
                    strike1++;
                } else if (dep6 == Num4 || dep6 == Num5) {
                    ball1++;
                } else if(dep6 == Num7)
                {
                    ball1++;
                }

                if (dep7 == Num7) {
                    strike1++;
                } else if (dep7 == Num4 || dep7 == Num5) {
                    ball1++;
                } else if(dep7 == Num6) {
                    ball1++;
                }

                count1++;
                tvCount1.setText(count1 + "번째");

                String resultstr1 = count1 + " : ";
                if (strike1 == 0 && ball1 == 0) {
                    resultstr1 += "아웃 " + "1번째 :" + "<" + Num4 + ">" + "2번째:" + "<" + Num5 + ">" + "3번째:" + "<" + Num6 + ">" + "4번째:" + "<" + Num7 + ">" + "\n";
                } else if (strike1 == 4) {
                    Intent intent = new Intent(getApplication(), Win1.class);
                    startActivity(intent);
                } else {
                    resultstr1 += strike1 + "S, " + ball1 + "B ";
                    resultstr1 += "1번째 :" + "<" + Num4 + ">" + "2번째:" + "<" + Num5 + ">" + "3번째:" + "<" + Num6 + ">" + "4번째:" + "<" + Num7 + ">" + "\n";
                }

                if (tvResult1.getText().toString() == null || tvResult1.getText().toString() == "") {
                    tvResult1.setText(resultstr1);
                } else {
                    tvResult1.append(resultstr1);
                }

                if (count1 == 9) {
                    if (strike1 == 4) {
                        Intent intent = new Intent(getApplication(), Win1.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getApplication(), Restart1.class);
                        startActivity(intent);
                    }
                }
                edit4.setText(null);
                edit5.setText(null);
                edit6.setText(null);
                edit7.setText(null);
            }
        });
    }
}

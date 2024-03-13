package com.cookandroid.termproject1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button btneasy = (Button) findViewById(R.id.btneasy);
        Button btnhard = (Button) findViewById(R.id.btnhard);

        btneasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),EasyActivity.class);
                startActivity(intent);
            }
        });

        btnhard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),Hard.class);
                startActivity(intent);
            }
        });
    }

}

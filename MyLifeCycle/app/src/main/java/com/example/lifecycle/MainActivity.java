package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate 호출", Toast.LENGTH_LONG).show();
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart 호출", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop 호출", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy 호출", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause 호출", Toast.LENGTH_LONG).show();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();
        editor.putString("name", "소녀시대");
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume 호출", Toast.LENGTH_LONG).show();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);

        if(pref != null){
            String name = pref.getString("name", "");
            Toast.makeText(this, "복구된 이름 : " + name, Toast.LENGTH_SHORT).show();
        }
    }
}
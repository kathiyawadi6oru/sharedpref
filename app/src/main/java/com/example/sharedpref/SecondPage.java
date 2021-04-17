package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondPage extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn = (Button)findViewById(R.id.btnsMovetoBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondPage.this,MainActivity.class);
                SharedPreferences sharedPreferences = getSharedPreferences("my123Database", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove("username");
                 //edit.putString("username","");
                edit.remove("password");
               // edit.putString("password","");

                edit.commit();
                startActivity(intent);
            }
        });
    }
}
package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initControl();
        //displayALL();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username",edUsername.getText().toString());
                editor.putString("password",edPassword.getText().toString());
                editor.commit();
               /* Intent intent = new Intent(MainActivity.this,SecondPage.class);
                startActivity(intent);*/
            }
        });
        displayALL();
    }

    private void initControl() {
        edUsername = (EditText) findViewById(R.id.edUserName);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        tvUserList = (TextView) findViewById(R.id.tvUserList);
        cbRemember = (CheckBox) findViewById(R.id.cbRememberMe);

        sharedPreferences = getSharedPreferences("my123Database", Context.MODE_PRIVATE);
    }

    private void displayALL() {
        if (sharedPreferences.contains("username")) {

            if(sharedPreferences.getString("username","").toString().equals("")&&sharedPreferences.getString("password","").toString().equals("")){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "UserName is already registred", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,SecondPage.class);
                startActivity(intent);
            }

        }
        else
            Toast.makeText(this, "NO USER IS YET REGISTERED", Toast.LENGTH_LONG).show();
    }

    SharedPreferences sharedPreferences;
    EditText edUsername, edPassword;
    Button btnRegister;
    CheckBox cbRemember;
    TextView tvUserList;

    private void mySharedPReferensesImplementation(){
        SharedPreferences  sharedPreferences;
        sharedPreferences = getSharedPreferences("my123Database", 0);
        //For Read Mode
        sharedPreferences.contains("Provide Key Name | UserName");
        sharedPreferences.getBoolean("gender",true);
        sharedPreferences.getString("Username","not avalilble");
        sharedPreferences.getFloat("PI value",3.14f);
        sharedPreferences.getLong("mobilenu",1231231231l);
        Map<String,String> myMap = (Map<String, String>) sharedPreferences.getAll();
        myMap.get("gender").toString();
        //for write mode
        SharedPreferences.Editor myEditableSP = sharedPreferences.edit();
        myEditableSP.putString("Username","myNewUN");
        // if available this this then it will overwrite its value
        //myEditableSP.remove("Username");
        myEditableSP.putString("Username",""); // for black/null value - setting.
        myEditableSP.putString("password","");
        myEditableSP.commit();
        myEditableSP.clear();
    }


}
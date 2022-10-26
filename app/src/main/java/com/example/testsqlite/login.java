package com.example.testsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText username,password;
    Button btn3;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.name);
        password=findViewById(R.id.testpas);
        DB= new DBHelper(this);
        btn3=findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user= username.getText().toString();
                String testpas= password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(testpas))
                    Toast.makeText(login.this, "all fields Required", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass= DB.checkusernamepassword(user,testpas);
                    if (checkuserpass==true){
                        Toast.makeText(login.this, "Login Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(/*getApplicationContext()*/ login.this, HomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(login.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText username, password;
    private String correct_username = "admin";
    private String correct_password = "admin";
    private TextView createnewaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.inputEmail);
        password=findViewById(R.id.inputPassword);
        loginButton=findViewById(R.id.btnLogin);
        createnewaccount=findViewById(R.id.createAccount);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(username.getText().toString()) && TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(MainActivity.this, "ENTER USERNAME & PASSWORD", Toast.LENGTH_SHORT).show();
                } else if (username.getText().toString().equals(correct_username)){
                    if (password.getText().toString().equals(correct_password)){
                        Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, HomepageActivity.class));
                    }else {
                        Toast.makeText(MainActivity.this, "INVALID USERNAME/PASSWORD", Toast.LENGTH_SHORT).show();
                    }

                } else{
                    Toast.makeText(MainActivity.this, "INVALID USERNAME/PASSWORD", Toast.LENGTH_SHORT).show();
                }
            }
        });

        createnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "CREATE ACCOUNT", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }
}
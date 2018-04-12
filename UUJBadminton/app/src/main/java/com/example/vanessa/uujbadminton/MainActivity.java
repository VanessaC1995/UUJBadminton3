package com.example.vanessa.uujbadminton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1, e2, e3;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.tbUsername);
        e2=(EditText)findViewById(R.id.tbPassword);
        e3=(EditText)findViewById(R.id.tbConfirm);
        btn1=(Button)findViewById(R.id.btnRegister);
        btn2=(Button)findViewById(R.id.btnLogin);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Login.class );
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if(s1.equals("")|| s2.equals("")|| s3.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean checkUsername = db.checkUsername(s1);
                        if(checkUsername==true){
                            Boolean insert = db.insert(s1, s2);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(), "Registration Successful!", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Username already exists", Toast.LENGTH_SHORT).show();

                        }
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

    }
}

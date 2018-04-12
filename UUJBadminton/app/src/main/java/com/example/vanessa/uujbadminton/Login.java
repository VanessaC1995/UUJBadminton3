package com.example.vanessa.uujbadminton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1, e2;
    Button btn1;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.tbName);
        e2 = (EditText)findViewById(R.id.tbPass);
        btn1 = (Button)findViewById(R.id.btnLog);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = e1.getText().toString();
                String password = e2.getText().toString();

               /* Boolean Checkusernamepassword = db.usernamepassword(username, password);
                if(Checkusernamepassword==true)
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                else
                   Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_SHORT).show();*/

                Intent intent = new Intent(Login.this,MainMenu.class );
                startActivity(intent);
            }
        });

    }
}

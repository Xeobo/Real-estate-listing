package com.rt_rk.vzbiljic.pkiapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_login);


        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.username);
                EditText password = (EditText) findViewById(R.id.password);
                if("admin".equals(username.getText().toString()) && "admin".equals(password.getText().toString()) ) {
                    Toast.makeText(LoginActivity.this, "Welcome admin!", Toast.LENGTH_SHORT).show();
                }else if("user".equals(username.getText().toString()) && "user".equals(password.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Welcome user!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

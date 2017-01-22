package com.rt_rk.vzbiljic.pkiapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AbstractActivity implements View.OnFocusChangeListener {

    @Override
    protected void onCreateBase(Bundle savedInstanceState){

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        actionBar.setIcon(R.drawable.homeicon);
        setContentView(R.layout.activity_login);

        final Button button = (Button) findViewById(R.id.button);

        final EditText username = (EditText) findViewById(R.id.username);
        username.setOnFocusChangeListener(this);

        final EditText password = (EditText) findViewById(R.id.password);
        password.setOnFocusChangeListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.username);
                EditText password = (EditText) findViewById(R.id.password);
                if("admin".equals(username.getText().toString()) && "admin".equals(password.getText().toString()) ) {
                    Toast.makeText(LoginActivity.this, "Welcome admin!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                    startActivity(intent);
                }else if("user".equals(username.getText().toString()) && "user".equals(password.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Welcome user!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if(!hasFocus && (view.getId() == R.id.username || view.getId() == R.id.password)) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
//        }else if(hasFocus && (view.getId() == R.id.username || view.getId() == R.id.password)){
//            InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.showSoftInput(view,0);
//        }
    }
}

package com.rt_rk.vzbiljic.pkiapp.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.datasource.UserDataSource;

public class LoginActivity extends AbstractActivity implements View.OnFocusChangeListener {

    @Override
    protected void onCreateBase(Bundle savedInstanceState){

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        
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
                    Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(intent);
                }else if("user".equals(username.getText().toString()) && "user".equals(password.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Welcome user!", Toast.LENGTH_SHORT).show();
                    UserDataSource.getInstance().setCurrentUser(UserDataSource.getInstance().get(0));
                    Intent intent = new Intent(LoginActivity.this, UserActivity.class);
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
    }

    @Override
    public void onBackPressed() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Kraj?")
                .setMessage("Da li ste sigurni da želite da zatvorite aplikaciju?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                    }
                }).create();

        dialog.show();

        Button button = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setTextColor(Color.RED);
        button.setText("DA");

        button = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        button.setTextColor(Color.RED);
        button.setText("NE");

    }

}

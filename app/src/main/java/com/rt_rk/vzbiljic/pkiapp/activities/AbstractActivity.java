package com.rt_rk.vzbiljic.pkiapp.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.rt_rk.vzbiljic.pkiapp.R;

/**
 * Created by Xeobo on 1/21/2017.
 */

public abstract class AbstractActivity extends AppCompatActivity {
    private String TAG = "AbstractActivity";

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.red));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.red));
            Log.i(TAG, "navigation bar color changed");
        }
        
        onCreateBase(savedInstanceState);
    }

    protected abstract void onCreateBase(Bundle savedInstanceState);

}

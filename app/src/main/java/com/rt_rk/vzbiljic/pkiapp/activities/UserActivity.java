package com.rt_rk.vzbiljic.pkiapp.activities;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.fragments.PropertyListFragment;
import com.rt_rk.vzbiljic.pkiapp.fragments.SearchFragment;

/**
 * Created by Xeobo on 2/4/2017.
 */

public class UserActivity extends StartFragmentActivity  {


    protected void initializeMenuItems(Menu menu){

        menu.add(0,Menu.FIRST, Menu.NONE,"Listaj nekretnine").setIcon(R.drawable.ic_home_black_24dp);
        menu.add(0,Menu.FIRST + 1,Menu.NONE,"Pretrazi").setIcon(R.drawable.ic_search_black_24dp);
        menu.add(0,Menu.FIRST + 2,Menu.NONE,"Odjavi se").setIcon(R.drawable.ic_mood_bad_black_24dp);
    }

    protected  int getMainLayout(){
        return R.layout.content_start;
    }

    @Override
    protected Fragment getMainFragment() {
        PropertyListFragment pp = new PropertyListFragment();
        return pp;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == Menu.FIRST) {

            PropertyListFragment newFragment = new PropertyListFragment();

            atachFragment(newFragment);
        } else if (id == Menu.FIRST + 1) {
            // Create fragment and give it an argument specifying the article it should show
            SearchFragment newFragment = new SearchFragment();

            atachFragment(newFragment);

        } else if (id == Menu.FIRST + 2) {

            startActivity(new Intent(this,LoginActivity.class));

        } else {
            Toast.makeText(
                    UserActivity.this,
                    "BAAAD",
                    Toast.LENGTH_SHORT
            ).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

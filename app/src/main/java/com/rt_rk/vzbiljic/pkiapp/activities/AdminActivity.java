package com.rt_rk.vzbiljic.pkiapp.activities;

import android.os.Bundle;
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
import com.rt_rk.vzbiljic.pkiapp.fragments.UserListFragment;

public class AdminActivity extends StartFragmentActivity {

    @Override
    protected void initializeMenuItems(Menu menu) {
        menu.add(0,Menu.FIRST, Menu.NONE,"Listaj nekretnine").setIcon(R.drawable.ic_home_black_24dp);
        menu.add(0,Menu.FIRST + 1,Menu.NONE,"Pretrazi").setIcon(R.drawable.ic_search_black_24dp);
        menu.add(0,Menu.FIRST + 2,Menu.NONE,"Odjavi se").setIcon(R.drawable.ic_mood_bad_black_24dp);
    }

    @Override
    protected int getMainLayout() {
        return R.layout.content_start;
    }

    @Override
    protected Fragment getMainFragment() {
        return new UserListFragment();
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        // Handle navigation view item clicks here.
        int id = menuItem.getItemId();

        if (id == Menu.FIRST) {
            // Create fragment and give it an argument specifying the article it should show
            PropertyListFragment newFragment = new PropertyListFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        } else if (id == Menu.FIRST + 1) {
            // Create fragment and give it an argument specifying the article it should show
            SearchFragment newFragment = new SearchFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        } else if (id == Menu.FIRST + 2) {
            Toast.makeText(
                    AdminActivity.this,
                    "Menu.FIRST + 2",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            Toast.makeText(
                    AdminActivity.this,
                    "BAAAD",
                    Toast.LENGTH_SHORT
            ).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

package com.rt_rk.vzbiljic.pkiapp;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.rt_rk.vzbiljic.pkiapp.fragments.DetailsFragment;
import com.rt_rk.vzbiljic.pkiapp.fragments.PropertyListFragment;
import com.rt_rk.vzbiljic.pkiapp.fragments.SearchFragment;
import com.rt_rk.vzbiljic.pkiapp.utils.PropertyDataSource;

/**
 * Created by Xeobo on 2/4/2017.
 */

public class UserStartActivity extends StartActivity  implements SearchFragment.OnFragmentInteractionListener{


    protected void initializeMenuItems(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        // get menu from navigationView
        Menu menu = navigationView.getMenu();

        menu.add(0,Menu.FIRST, Menu.NONE,"Listaj nekretnine").setIcon(R.drawable.ic_home_black_24dp);
        menu.add(0,Menu.FIRST + 1,Menu.NONE,"Pretrazi").setIcon(R.drawable.ic_search_black_24dp);
        menu.add(0,Menu.FIRST + 2,Menu.NONE,"Odjavi se").setIcon(R.drawable.ic_mood_bad_black_24dp);

        // add NavigationItemSelectedListener to check the navigation clicks
        navigationView.setNavigationItemSelectedListener(this);
    }

    protected  int getMainLayout(){
        return R.layout.content_start;
    }

    protected void initMainLayout(Bundle savedInstanceState){
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
            Log.i("UserStartActivity","R.id.fragment_container found");
//            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)findViewById(R.id.app_bar_start);
//            coordinatorLayout.addView(getLayoutInflater().inflate(getMainLayout(), coordinatorLayout,false));

            // Create a new Fragment to be placed in the activity layout
            PropertyListFragment firstFragment = new PropertyListFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();



        }



    }


    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);


        Log.i("UserStartActivity","onAttachFragment");

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

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
                    UserStartActivity.this,
                    "Menu.FIRST + 2",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            Toast.makeText(
                    UserStartActivity.this,
                    "BAAAD",
                    Toast.LENGTH_SHORT
            ).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

package com.rt_rk.vzbiljic.pkiapp.activities;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.datasource.UserDataSource;
import com.rt_rk.vzbiljic.pkiapp.fragments.AbstractActivityFragment;
import com.rt_rk.vzbiljic.pkiapp.fragments.AbstractSearchUserFragment;
import com.rt_rk.vzbiljic.pkiapp.fragments.AgentActivityFragment;
import com.rt_rk.vzbiljic.pkiapp.fragments.AssignPropertyToAgent;
import com.rt_rk.vzbiljic.pkiapp.fragments.RemovePropertyFragment;
import com.rt_rk.vzbiljic.pkiapp.fragments.SearchAgentFragment;
import com.rt_rk.vzbiljic.pkiapp.fragments.SearchUserFragment;
import com.rt_rk.vzbiljic.pkiapp.fragments.UserActivityFragment;
import com.rt_rk.vzbiljic.pkiapp.fragments.UserListFragment;

public class AdminActivity extends StartFragmentActivity {



    @Override
    protected void initializeMenuItems(Menu menu) {
        menu.add(0,Menu.FIRST, Menu.NONE,"Listaj agente").setIcon(R.drawable.ic_face_black_24dp);
        menu.add(0,Menu.FIRST + 1, Menu.NONE,"Dodavanje nekretnine").setIcon(R.drawable.ic_add_black_24dp);
        menu.add(0,Menu.FIRST + 2,Menu.NONE,"Dodeli nekretninu agentu").setIcon(R.drawable.ic_input_black_24dp);
        menu.add(0,Menu.FIRST + 3, Menu.NONE,"Izdate i prodate nekretnine").setIcon(R.drawable.ic_home_black_24dp);
        menu.add(0,Menu.FIRST + 4, Menu.NONE,"Obišao korisnik").setIcon(R.drawable.ic_transfer_within_a_station_black_24dp);
        menu.add(0,Menu.FIRST + 5, Menu.NONE,"Prikazao agent").setIcon(R.drawable.ic_accessibility_black_24dp);
        menu.add(0,Menu.FIRST + 6,Menu.NONE,"Odjavi se").setIcon(R.drawable.ic_mood_bad_black_24dp);
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
        Fragment newFragment;

        switch (id){
            case Menu.FIRST://Agents
                atachFragment(new UserListFragment());
                break;
            case Menu.FIRST + 1://Add property

                break;
            case Menu.FIRST + 2://Add to agent
                 newFragment = new AssignPropertyToAgent();

                atachFragment(newFragment);
                break;
            case Menu.FIRST + 3://remove sold property
                atachFragment(new RemovePropertyFragment());
                break;
            case Menu.FIRST + 4:// seen by user
                newFragment = new SearchUserFragment();

                atachFragment(newFragment);
                break;
            case Menu.FIRST + 5://taken by agent
                newFragment = new SearchAgentFragment();

                atachFragment(newFragment);

                break;
            case Menu.FIRST + 6://log out

                break;
            default:
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

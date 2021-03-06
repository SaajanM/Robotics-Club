package com.cusd80.cchs.roboticsclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Collection;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String EMAIL = "com.cusd80.cchs.roboticsclub.email";
    public static final String USERNAME = "com.cusd80.cchs.roboticsclub.username";
    private static final String ACCESS_LEVEL = "com.cusd80.cchs.roboticsclub.access_level";

    private NavigationView mNavView;
    private View mHeaderView;
    private TextView mEmailView;
    private TextView mUsernameView;
    private MenuItem mAdminCollection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavView=(NavigationView) findViewById(R.id.nav_view);
        mHeaderView=mNavView.getHeaderView(0);


        mEmailView=(TextView) mHeaderView.findViewById(R.id.emailView);
        //mEmailView.setHeight(mEmailView.getHeight()+100);
        mUsernameView=(TextView) mHeaderView.findViewById(R.id.usernameView);
        mAdminCollection=(MenuItem) mHeaderView.findViewById(R.id.admin_collect);
        mAdminCollection.setVisible(accessLevel());

        Intent intent = getIntent();
        String uEmail =intent.getStringExtra(EMAIL);
        String uUsername =intent.getStringExtra(USERNAME);

        mEmailView.setText(uEmail);
        mUsernameView.setText(uUsername);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_points) {
            onBackPressed();
        } else if (id == R.id.nav_idea) {

        } else if (id == R.id.nav_acct) {

        } else if (id == R.id.nav_admin) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

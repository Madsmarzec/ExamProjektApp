package com.example.madsm.vemmelevboldklub;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.app.FragmentManager;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

      /*  fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home Fragment...");
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_frontPage:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home Fragment");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_fixtures:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new FixtureFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Fixture Fragment");
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;
                }

                return false;
            }
        });
        */
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_fixture) {
            Intent i = new Intent(this, FixtureActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_leagueTable) {
            Intent i = new Intent(this, LeagueTableActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_trainingSession){
            Intent i = new Intent(this, TrainingActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_statistics){
            Intent i = new Intent(this, StatisticActivity.class);
            startActivity(i);
        }
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

package com.blucode.mhmd.session7.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.blucode.mhmd.session7.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_content);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setTitleTextColor(getColor(R.color.white));
        }
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_home);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch(id) {
                    case R.id.nav_info:
                        navigationView.setCheckedItem(R.id.nav_info);
                        transaction.replace(R.id.main_content, new InfoFragment());
                        setTitle("Info");
                        transaction.commit();
                        bottomNavigationView.setSelectedItemId(R.id.icon_bottomnav_Info);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_home:
                        navigationView.setCheckedItem(R.id.nav_home);
                        transaction.replace(R.id.main_content, new HomeFragment());
                        setTitle("Home");
                        transaction.commit();
                        bottomNavigationView.setSelectedItemId(R.id.icon_bottomnav_home);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_share:
                        navigationView.setCheckedItem(R.id.nav_share);
                        Intent intent = new Intent(MainActivity.this, ShareMessageActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_setting:
                        navigationView.setCheckedItem(R.id.nav_home);
                        transaction.replace(R.id.main_content, new SettingFragment());
                        setTitle("Setting");
                        transaction.commit();
                        bottomNavigationView.setSelectedItemId(R.id.icon_bottomnav_Setting);
                        drawerLayout.closeDrawers();
                        return true;
                    default:
                }
                return false;

            }
        });
        bottomNavigationView = findViewById(R.id.bottomNavigation_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content, new HomeFragment());
        setTitle("Home");
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()) {
            case R.id.icon_bottomnav_home:
                setTitle("Home");
                transaction.replace(R.id.main_content, new HomeFragment());
                transaction.commit();
                return true;

            case R.id.icon_bottomnav_Info:
                setTitle("Info");
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content, new InfoFragment());
                transaction.commit();
                return true;

            case R.id.icon_bottomnav_Setting:
                setTitle("Setting");
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content, new SettingFragment());
                transaction.commit();
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        switch (item.getItemId()) {
            case R.id.menu_app_bar_capture_image_camera:

                return true;
            case R.id.menu_app_bar_capture_image_gallery:

                return true;

            case R.id.menu_app_bar_search:

                return true;
        }
        return false;
    }
}

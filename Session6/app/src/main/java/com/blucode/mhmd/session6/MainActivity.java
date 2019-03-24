package com.blucode.mhmd.session6;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_content);
        bottomNavigationView = findViewById(R.id.bottomNavigation_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemReselectedListener(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content, new HomeFragment());
        transaction.commit();
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()) {
            case R.id.icon_bottomnav_home:
                transaction.replace(R.id.main_content, new HomeFragment());
                transaction.commit();
                return true;
            case R.id.icon_bottomnav_Info:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content, new InfoFragment());
                transaction.commit();
                return true;

            case R.id.icon_bottomnav_Setting:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content, new SettingFragment());
                transaction.commit();
                return true;
        }
        return false;
    }
}

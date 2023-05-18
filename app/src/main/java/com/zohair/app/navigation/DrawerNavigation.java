package com.zohair.app.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.zohair.app.navigation.NavBottom.fragments.AccountFragment;
import com.zohair.app.navigation.NavBottom.fragments.HomeFragment;
import com.zohair.app.navigation.NavBottom.fragments.SettingsFragment;

import org.jetbrains.annotations.NotNull;

public class DrawerNavigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FrameLayout frameLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbarLayout);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);



        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment());
            navigationView.setCheckedItem(R.id.home);
        }
    }

    HomeFragment homeFragment = new HomeFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    AccountFragment accountFragment = new AccountFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,homeFragment).commit();
                return true;
            case R.id.setting:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,settingsFragment).commit();
                return true;
            case R.id.person:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,accountFragment).commit();
                return true;
            case R.id.logout:
                Toast.makeText(this,"Log Out",Toast.LENGTH_LONG).show();
                break;

        }

        return false;
    }
}
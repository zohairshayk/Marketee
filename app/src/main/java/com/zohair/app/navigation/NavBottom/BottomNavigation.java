package com.zohair.app.navigation.NavBottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zohair.app.navigation.NavBottom.fragments.AccountFragment;
import com.zohair.app.navigation.NavBottom.fragments.home.HomeFragment;
import com.zohair.app.navigation.NavBottom.fragments.SettingsFragment;
import com.zohair.app.navigation.R;

import org.jetbrains.annotations.NotNull;

public class BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);


        bottomNavigationView= findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

}

    HomeFragment homeFragment = new HomeFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    AccountFragment accountFragment= new AccountFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment,homeFragment).commit();
                return true;
            case R.id.setting:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment,settingsFragment).commit();
                return true;
            case R.id.person:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment,accountFragment).commit();
                return true;
            case R.id.logout:
                Toast.makeText(this,"Log Out",Toast.LENGTH_LONG).show();
                break;

        }

        return false;
    }
}
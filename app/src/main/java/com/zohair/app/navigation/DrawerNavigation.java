package com.zohair.app.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.zohair.app.navigation.NavBottom.fragments.AccountFragment;
import com.zohair.app.navigation.NavBottom.fragments.home.HomeFragment;
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


        openHome();

        navigationView.setNavigationItemSelectedListener(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(Gravity.LEFT);

                ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(DrawerNavigation.this,drawerLayout,R.string.open_drawer,R.string.close_drawer);
                drawerLayout.addDrawerListener(toogle);
                toogle.syncState();
                if(savedInstanceState==null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment());
                    navigationView.setCheckedItem(R.id.home);
                }
            }
        });





    }

    private void openHome() {
        switchFragment(new HomeFragment(),"home fragment");
    }

    /* switch fragment */
    public void switchFragmentWithBackStack(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment, tag)
                .addToBackStack(null).commit();
        // fragmentManager.beginTransaction().remove(fragment).commit();
    }

    /* switch fragment */
    public void switchFragment(Fragment fragment, String tag) {


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_layout,fragment,tag);
        transaction.addToBackStack(null);
        transaction.commit();


//Percentage can be calculated for API 16+

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
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            case R.id.setting:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,settingsFragment).commit();
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            case R.id.person:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout,accountFragment).commit();
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            case R.id.logout:
                Toast.makeText(this,"Log Out",Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawer(Gravity.LEFT);
                break;

        }

        return false;
    }


}
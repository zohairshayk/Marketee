package com.zohair.app.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zohair.app.navigation.NavBottom.BottomNavigation;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Button drawer_nav,bottom_nav;

        drawer_nav =(Button) findViewById(R.id.drawerLayout);
        bottom_nav = (Button)findViewById(R.id.bottomNav);

        drawer_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SplashScreen.this,DrawerNavigation.class);
                startActivity(intent);
            }
        });

        bottom_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SplashScreen.this, BottomNavigation.class);
                startActivity(intent);
            }
        });
    }


}
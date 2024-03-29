package com.zohair.app.marketee;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zohair.app.marketee.NavBottom.BottomNavigation;

public class SplashScreen extends AppCompatActivity {

    Animation slide_in_right;
    TextView txt;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        txt = findViewById(R.id.textHeading);
        slide_in_right = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);

        MyAnimationListener listener = new MyAnimationListener();
        listener.setText(txt);

        txt.startAnimation(slide_in_right);
        slide_in_right.setAnimationListener(listener);


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

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        closeApp("Do You want to exit?");
    }

    private void closeApp(String msg) {
//        Dialog dialog = new Dialog(getBaseContext());
//        dialog.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.setContentView(R.layout.custom_dialog);
//        dialog.setCancelable(false);
//        dialog.setCanceledOnTouchOutside(false);
//
//
//        TextView txtMsg = findViewById(R.id.custom_dialog_message);
//        txtMsg.setText(msg);
//
//        Button ok = findViewById(R.id.ok_button);
//        ok.setText("Yes");
//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//        Button cancel = findViewById(R.id.no_button);
//        cancel.setText("Cancel");
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        } );
//
//        dialog.show();
        Dialog alertDialog = new Dialog(SplashScreen.this);
        alertDialog.setContentView(R.layout.custom_alert_dialog);

        TextView txtMsg = alertDialog.findViewById(R.id.custom_dialog_message);
        txtMsg.setText(msg);


        Button ok = (Button) alertDialog.findViewById(R.id.ok_button);
        Button cancel = (Button) alertDialog.findViewById(R.id.no_button);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();

    }

    public class MyAnimationListener implements Animation.AnimationListener {
        TextView text;
        ImageView img;
        public void setImage(Image view) {
            this.img = img;
        }
        public void setText(TextView view) {
            this.text = text;
        }
        public void onAnimationEnd(Animation animation) {
            // Do whatever you want
            Intent intent= new Intent(SplashScreen.this, BottomNavigation.class);
            startActivity(intent);
        }
        public void onAnimationRepeat(Animation animation) {
        }
        public void onAnimationStart(Animation animation) {
        }
    }

}


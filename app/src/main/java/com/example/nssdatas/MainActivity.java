package com.example.nssdatas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ThankFragment thankFragment=new ThankFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.parent_container,thankFragment).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_think:
                    doThink();
                    return true;
                case R.id.navigation_thank:
                    doThank();
                    return true;
                case R.id.navigation_blood:
                    doBlood();
                    return true;
            }
            return false;
        }
    };

    private void doThank() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.parent_container, new ThankFragment());
        ft.commit();

    }

    private void doThink() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.parent_container, new ThinkFragment());
        ft.commit();
    }

    private void doBlood() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.parent_container, new BloodRequestFragment());
        ft.commit();
    }
}

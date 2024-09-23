package com.example.uxraiso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    TextView welcomelbl;
    TabLayout tablayout;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcomelbl = findViewById(R.id.welcomelbl);
        Intent intent = getIntent();
        welcomelbl.setText("Welcome to Raiso, " + intent.getStringExtra("username"));

        tablayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewPager2);

        tablayout.addTab(tablayout.newTab().setText("Home"));
        tablayout.addTab(tablayout.newTab().setText("Items"));
        tablayout.addTab(tablayout.newTab().setText("All"));
        tablayout.addTab(tablayout.newTab().setText("Details"));
        tablayout.addTab(tablayout.newTab().setText("About"));

        FragmentAdaptor adapter = new FragmentAdaptor(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tablayout.selectTab(tablayout.getTabAt(position));
            }
        });
    }
}
package com.example.blogging;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.blogging.Adapters.LoginRegisterAdapter;
import com.example.blogging.Fragments.LoginFrag;
import com.example.blogging.Fragments.RegisterFrag;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.vp_viewpager);
        tabLayout = findViewById(R.id.tb_tabyout);

        LoginRegisterAdapter adapter= new LoginRegisterAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFrag(),"Login");
        adapter.addFragment(new RegisterFrag(),"Register");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

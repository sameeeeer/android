package com.example.blogging.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class LoginRegisterAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragmentname = new ArrayList<>();

    public LoginRegisterAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
          return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();

    }
    public CharSequence getPageTitle(int position){
        return fragmentname.get(position);
    }
    public void addFragment(Fragment fragment, String title){
        fragments.add(fragment);
        fragmentname.add(title);
    }
}

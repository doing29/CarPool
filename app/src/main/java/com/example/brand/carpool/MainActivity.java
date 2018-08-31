package com.example.brand.carpool;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.brand.carpool.fragment.LoginFragment;
import com.example.brand.carpool.fragment.MapFragment;
import com.example.brand.carpool.fragment.UserFragment;
import com.example.brand.carpool.utils.L;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    //Title
    private List<String> mTitle;
    //Flagment
    private List<Fragment> mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // hide shade
        getSupportActionBar().setElevation(0);
        initData();
        initView();

        L.d("d is called");
        L.i("i called");
        L.e("e called");
        L.w("w called");
    }

    private void initData() {
        mTitle = new ArrayList<>();
        mTitle.add("login");
        mTitle.add("map");
        mTitle.add("Personal detail ");
        mFragment = new ArrayList<>();
        //mFragment.add();
        mFragment.add(new LoginFragment());
        mFragment.add(new MapFragment());
        mFragment.add(new UserFragment());
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        // pre load
        mViewPager.setOffscreenPageLimit(mFragment.size());
        //config
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //select item
            @Override
            public Fragment getItem(int position) {
                return mFragment.get( position);
            }

            //return item size
            public int getCount() {
                return mFragment.size();
            }
            //set title

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
            //bind activity

        });
        mTabLayout.setupWithViewPager(mViewPager);
    }
}

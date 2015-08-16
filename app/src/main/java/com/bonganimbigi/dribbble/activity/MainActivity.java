package com.bonganimbigi.dribbble.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bonganimbigi.dribbble.R;
import com.bonganimbigi.dribbble.adapter.ShotPagerAdapter;
import com.bonganimbigi.dribbble.service.ConnectionService;

import javax.inject.Inject;

import butterknife.InjectView;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.tabs)
    TabLayout tabLayout;

    @InjectView(R.id.layout_no_internet)
    LinearLayout noInternet;

    @InjectView(R.id.image_refresh)
    ImageView imageRefresh;

    @Inject
    ConnectionService connectionService;

    @InjectView(R.id.pager)
    ViewPager viewPager;

    @InjectView(R.id.container)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        setListeners();
        checkInternet();
        overridePendingTransition(R.anim.slide_out_down, R.anim.slide_in_up);
    }

    private void checkInternet() {
        if (connectionService.hasConnection()) {
            initViewPager();
        } else {
            showEmptyView(true);
        }
    }

    private void initViewPager() {
        ShotPagerAdapter shotPagerAdapter = new ShotPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(shotPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setListeners() {
        toolbar.setOnMenuItemClickListener(this::onOptionsItemSelected);
        imageRefresh.setOnClickListener(v -> {
            showEmptyView(false);
            checkInternet();
        });
    }

    private void showEmptyView(boolean show) {
        if (show) {
            noInternet.setVisibility(View.VISIBLE);
            coordinatorLayout.setVisibility(View.GONE);
        } else {
            noInternet.setVisibility(View.GONE);
            coordinatorLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void injectMembers() {
        dribbleComponent().inject(this);
    }
}

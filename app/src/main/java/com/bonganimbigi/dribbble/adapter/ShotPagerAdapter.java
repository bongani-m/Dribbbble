package com.bonganimbigi.dribbble.adapter;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bonganimbigi.dribbble.application.Application;
import com.bonganimbigi.dribbble.fragment.ListShotsFragment;
import com.bonganimbigi.dribbble.util.PageType;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ShotPagerAdapter extends FragmentPagerAdapter {

    @Inject
    Resources resources;

    private List<ListShotsFragment> listShotsFragment = new ArrayList<>();

    public ShotPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        Application.getDribbbleComponent().inject(this);
        listShotsFragment.add(ListShotsFragment.newInstance(PageType.POPULAR));
        listShotsFragment.add(ListShotsFragment.newInstance(PageType.DEBUT));
        listShotsFragment.add(ListShotsFragment.newInstance(PageType.RECENT));
    }

    @Override
    public Fragment getItem(int position) {
        return listShotsFragment.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return resources.getString(listShotsFragment.get(position).getPageTitle());
    }
}

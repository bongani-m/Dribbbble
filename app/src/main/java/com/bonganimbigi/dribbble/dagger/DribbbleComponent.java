package com.bonganimbigi.dribbble.dagger;

import com.bonganimbigi.dribbble.activity.MainActivity;
import com.bonganimbigi.dribbble.activity.ShotActivity;
import com.bonganimbigi.dribbble.adapter.ShotPagerAdapter;
import com.bonganimbigi.dribbble.fragment.ListShotsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DribbbleModule.class)
public interface DribbbleComponent {

    void inject(MainActivity mainActivity);
    void inject(ShotActivity shotActivity);
    void inject(ListShotsFragment listShotsFragment);
    void inject(ShotPagerAdapter shotPagerAdapter);

}

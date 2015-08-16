package com.bonganimbigi.dribbble.application;

import com.bonganimbigi.dribbble.dagger.DaggerDribbbleComponent;
import com.bonganimbigi.dribbble.dagger.DribbbleComponent;
import com.bonganimbigi.dribbble.dagger.DribbbleModule;

public class Application extends android.app.Application {


    private static DribbbleComponent dribbbleComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        dribbbleComponent = DaggerDribbbleComponent.
                builder().
                dribbbleModule(new DribbbleModule(this)).
                build();
    }

    public static DribbbleComponent getDribbbleComponent(){
        return dribbbleComponent;
    }
}

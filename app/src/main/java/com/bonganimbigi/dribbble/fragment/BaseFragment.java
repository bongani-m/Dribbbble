package com.bonganimbigi.dribbble.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.bonganimbigi.dribbble.application.Application;
import com.bonganimbigi.dribbble.dagger.DribbbleComponent;

import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseFragment extends Fragment {

    protected CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        injectMembers();
        setOnClickListeners();
    }

    @Override
    public void onDestroyView() {
        unsubscribeSubscriptions();
        super.onDestroyView();
    }

    protected void unsubscribeSubscriptions(){
        compositeSubscription.unsubscribe();
        compositeSubscription = new CompositeSubscription();
    }

    protected DribbbleComponent dribbleComponent() {
        return Application.getDribbbleComponent();
    }

    protected void log(Throwable e){
        Log.e(getTag(), "", e);
    }

    protected void setOnClickListeners(){}

    protected abstract void injectMembers();

}

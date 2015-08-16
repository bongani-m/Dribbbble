package com.bonganimbigi.dribbble.dagger;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.LayoutInflater;

import com.bonganimbigi.dribbble.network.DribbbleNetwork;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module
public class DribbbleModule {

    private final Context context;

    public DribbbleModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    SharedPreferences providePreferenceManager(Context context) {
        return context.getSharedPreferences("Dribble", 0);
    }

    @Provides
    ConnectivityManager provideConnectivityManager() {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter(){
        return new RestAdapter.Builder().setEndpoint("http://api.dribbble.com/").build();
    }

    @Provides
    DribbbleNetwork provideMovieNetwork(RestAdapter restAdapter){
        return restAdapter.create(DribbbleNetwork.class);
    }

    @Provides
    ContentResolver provideContentResolver() {
        return context.getContentResolver();
    }

    @Provides
    Resources provideResources(Context context) {
        return context.getResources();
    }

    @Provides
    LayoutInflater provideLayoutInflater(Context context) {
        return LayoutInflater.from(context);
    }

}

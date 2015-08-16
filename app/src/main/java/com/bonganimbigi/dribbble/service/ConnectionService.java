package com.bonganimbigi.dribbble.service;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

public class ConnectionService {

    @Inject
    ConnectivityManager connectivityManager;

    @Inject
    public ConnectionService() {}

    public boolean hasConnection() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

}

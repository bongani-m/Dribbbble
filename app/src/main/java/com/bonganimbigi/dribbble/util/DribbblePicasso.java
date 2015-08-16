package com.bonganimbigi.dribbble.util;

import android.content.Context;

import com.bonganimbigi.dribbble.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class DribbblePicasso {

    static public RequestCreator with(Context context, String url) {
        return Picasso.with(context).load(url).placeholder(R.drawable.dribbble_loading).error(R.drawable.internet_error);
    }

}

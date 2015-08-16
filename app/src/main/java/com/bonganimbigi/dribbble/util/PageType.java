package com.bonganimbigi.dribbble.util;

import com.bonganimbigi.dribbble.R;

public enum PageType {

    POPULAR(R.string.popular),
    DEBUT(R.string.debuts),
    RECENT(R.string.recent);

    private int resource;

    PageType(int resource) {
        this.resource = resource;
    }

    public int getResource() {
        return resource;
    }
}

package com.bonganimbigi.dribbble.util;

import android.graphics.Color;

public class ColorUtil {

    public static int getDarkerColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.9F;
        return Color.HSVToColor(hsv);
    }

}

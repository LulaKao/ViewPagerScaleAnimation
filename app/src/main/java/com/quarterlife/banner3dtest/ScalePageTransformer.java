package com.quarterlife.banner3dtest;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/**
 * 設定中間放大兩邊縮小
 */
public class ScalePageTransformer implements ViewPager.PageTransformer{
    public static final float MAX_SCALE = 1.0f;
    public static final float MIN_SCALE = 0.9f;
    private boolean isFill;

    public ScalePageTransformer(boolean isFill) {
        this.isFill = isFill;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }
        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;

        float scaleValue = MIN_SCALE + tempScale * slope;
        if (isFill) {
            page.setScaleX(scaleValue);
        }
        page.setScaleY(scaleValue);
    }
}
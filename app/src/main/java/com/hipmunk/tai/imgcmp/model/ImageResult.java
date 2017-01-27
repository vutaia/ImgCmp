package com.hipmunk.tai.imgcmp.model;

import android.graphics.Bitmap;

public class ImageResult {

    private final Bitmap mBitmap;
    private final float mDelta;

    public ImageResult(Bitmap bitmap, float delta) {
        mBitmap = bitmap;
        mDelta = delta;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public float getDelta() {
        return mDelta;
    }
}

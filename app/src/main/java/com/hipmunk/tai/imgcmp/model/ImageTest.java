package com.hipmunk.tai.imgcmp.model;

/**
 * Created by tai on 1/24/17.
 */

public class ImageTest {

    private int mImageOneRawId, mImageTwoRawId;
    private float mPassThreshold;

    public ImageTest(int imageOneRawId, int imageTwoRawId, float passPercentageCriteria) {
        mImageOneRawId = imageOneRawId;
        mImageTwoRawId = imageTwoRawId;
        mPassThreshold = passPercentageCriteria;
    }

    public int getImageOneRawId() {
        return mImageOneRawId;
    }

    public int getImageTwoRawId() {
        return mImageTwoRawId;
    }

    public float getPassThreshold() {
        return mPassThreshold;
    }
}

package com.hipmunk.tai.imgcmp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by tai on 1/24/17.
 */

public class BitmapCompareAsync extends AsyncTask<Void, Void, Bitmap> {

    private Bitmap mOne, mTwo;
    private ImageView mImageView = null;
    private View mLoadingView = null;

    public BitmapCompareAsync(Bitmap _one, Bitmap _two, ImageView imageContainer, View loadingView) {
        mOne = _one;
        mTwo = _two;
        mImageView = imageContainer;

        mLoadingView = loadingView;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        Bitmap deltaBitmap = ImageComparator.compareBitmap(mOne, mTwo, 90f);
        return deltaBitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        if (mLoadingView!=null) {
            mLoadingView.setVisibility(View.GONE);
        }

        if (mImageView==null || result==null) {
            return;
        }

        mImageView.setImageBitmap(result);
    }
}

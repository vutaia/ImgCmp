package com.hipmunk.tai.imgcmp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hipmunk.tai.imgcmp.model.ImageResult;

/**
 * Created by tai on 1/24/17.
 */

public class BitmapCompareAsync extends AsyncTask<Void, Void, ImageResult> {

    private Bitmap mOne, mTwo;
    private ImageView mImageView = null;
    private View mLoadingView = null;
    private TextView mDeltaTextView = null;

    public BitmapCompareAsync(Bitmap _one, Bitmap _two, ImageView imageContainer, View loadingView, TextView deltaTextView) {
        mOne = _one;
        mTwo = _two;
        mImageView = imageContainer;

        mLoadingView = loadingView;
        mDeltaTextView = deltaTextView;
    }

    @Override
    protected ImageResult doInBackground(Void... params) {
        return ImageComparator.compareBitmap(mOne, mTwo, 90f);
    }

    @Override
    protected void onPostExecute(ImageResult result) {
        super.onPostExecute(result);
        if (mLoadingView!=null) {
            mLoadingView.setVisibility(View.GONE);
        }

        if (mImageView==null || result==null) {
            return;
        }

        mImageView.setImageBitmap(result.getBitmap());
        mDeltaTextView.setText(result.getDelta()*100+"%");
    }
}

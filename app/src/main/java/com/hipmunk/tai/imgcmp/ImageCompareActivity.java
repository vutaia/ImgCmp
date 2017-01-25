package com.hipmunk.tai.imgcmp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hipmunk.tai.imgcmp.helper.RawBitmapLoader;

public class ImageCompareActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int position = getIntent().getIntExtra("position", 0);

        setContentView(R.layout.activity_image_compare);

        ImageView imageViewBase = (ImageView) findViewById(R.id.imageview_base_image),
                imageViewCompare = (ImageView) findViewById(R.id.imageview_compare_image),
                imageViewDelta = (ImageView) findViewById(R.id.imageview_delta_image);

        Bitmap imgBase = RawBitmapLoader.loadRawImage(this, Tests.TESTS[position].getImageOneRawId()),
                imgCompare = RawBitmapLoader.loadRawImage(this, Tests.TESTS[position].getImageTwoRawId());

        imageViewBase.setImageBitmap(imgBase);
        imageViewCompare.setImageBitmap(imgCompare);

        View loadingView = findViewById(R.id.loadingView);
        new BitmapCompareAsync(imgBase, imgCompare, imageViewDelta, loadingView).execute();
    }
}

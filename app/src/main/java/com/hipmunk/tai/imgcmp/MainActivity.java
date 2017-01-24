package com.hipmunk.tai.imgcmp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageViewBase = (ImageView) findViewById(R.id.imageview_base_image),
                imageViewCompare = (ImageView) findViewById(R.id.imageview_compare_image),
                imageViewDelta = (ImageView) findViewById(R.id.imageview_delta_image);

        Bitmap imgBase = loadRawImage(R.raw.a_base),
                imgCompare = loadRawImage(R.raw.a_compare);

        imageViewBase.setImageBitmap(imgBase);
        imageViewCompare.setImageBitmap(imgCompare);

        View loadingView = findViewById(R.id.loadingView);
        new BitmapCompareAsync(imgBase, imgCompare, imageViewDelta, loadingView).execute();
//        Bitmap imgDelta = ImageComparator.compareBitmap(imgBase, imgCompare, 100);
//        imageViewDelta.setImageBitmap(imgDelta);
    }

    private Bitmap loadRawImage(int id) {
        Bitmap img = null;
        try {
            InputStream ip = getResources().openRawResource(id);
            img = BitmapFactory.decodeStream(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }
}

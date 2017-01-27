package com.hipmunk.tai.imgcmp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hipmunk.tai.imgcmp.helper.RawBitmapLoader;

public class ImageCompareActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int position = getIntent().getIntExtra("position", 0);

        setContentView(R.layout.activity_image_compare);

        final LayoutInflater layoutInflater = LayoutInflater.from(this);

        final Bitmap imageA = RawBitmapLoader.loadRawImage(this, Tests.TESTS[position].getImageOneRawId()),
                imageB = RawBitmapLoader.loadRawImage(this, Tests.TESTS[position].getImageTwoRawId());

        final TextView textviewDelta = (TextView) findViewById(R.id.textview_delta);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_images);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                final View arg1View = (View) object;
                return view.getTag() != null && arg1View != null && view.getTag().equals(arg1View.getTag());
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                View view = layoutInflater.inflate(R.layout.component_image_viewer, container, false);
                ImageView imageView = (ImageView) view.findViewById(R.id.image);

                view.setTag(position);
                container.addView(view, 0);

                if (position==2) {
                    View loadingView = findViewById(R.id.loading_view);
                    loadingView.setVisibility(View.VISIBLE);
                    new BitmapCompareAsync(imageA, imageB, imageView, loadingView, textviewDelta).execute();
                } else {
                    if (position==0)
                        imageView.setImageBitmap(imageA);
                    else
                        imageView.setImageBitmap(imageB);
                }
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeViewAt(position);
            }
        });

        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(viewPager.getAdapter().getCount());
    }
}

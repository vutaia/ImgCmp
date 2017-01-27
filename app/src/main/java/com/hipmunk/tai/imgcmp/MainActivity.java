package com.hipmunk.tai.imgcmp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.hipmunk.tai.imgcmp.model.ImageTest;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView testListView = (ListView) findViewById(R.id.listview_tests);
        testListView.setAdapter(new TestListViewAdapter(this));
        testListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, ImageCompareActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    class TestListViewAdapter extends ArrayAdapter<ImageTest> {

        public TestListViewAdapter(Context context) {
            super(context, -1);
        }

        @Override
        public int getCount() {
            return Tests.TESTS.length;
        }

        @Nullable
        @Override
        public ImageTest getItem(int position) {
            return Tests.TESTS[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null) {
                LayoutInflater li = LayoutInflater.from(parent.getContext());
                convertView = li.inflate(R.layout.component_image_test, null);
            }
            ImageView iv1 = (ImageView) convertView.findViewById(R.id.image1);
            ImageView iv2 = (ImageView) convertView.findViewById(R.id.image2);

            Glide.with(MainActivity.this).load(getItem(position).getImageOneRawId()).into(iv1);
            Glide.with(MainActivity.this).load(getItem(position).getImageTwoRawId()).into(iv2);

            return convertView;
        }
    }

}

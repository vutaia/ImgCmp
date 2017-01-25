package com.hipmunk.tai.imgcmp.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

/**
 * Created by tai on 1/24/17.
 */

public class RawBitmapLoader {

    public static Bitmap loadRawImage(Context context, int id) {
        if (context==null) {
            return null;
        }

        Bitmap img = null;
        try {
            InputStream ip = context.getResources().openRawResource(id);
            img = BitmapFactory.decodeStream(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }
}

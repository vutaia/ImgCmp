package com.hipmunk.tai.imgcmp;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by tai on 1/24/17.
 */

public class ImageComparator {

    public static Bitmap compareBitmap(Bitmap _one, Bitmap _two, int _threshold) {
        int maxHeight = Math.max(_one.getHeight(), _two.getHeight());
        int maxWidth = Math.max(_one.getWidth(), _two.getWidth());
        double sameCount = 0;

        Bitmap deltaBitmap = Bitmap.createBitmap(maxWidth, maxHeight, Bitmap.Config.ARGB_8888);

        for (int x=0; x<maxWidth; x++) {
            for (int y=0; y<maxHeight; y++) {
                int pixel_one = _one.getPixel(x, y);
                int pixel_two = _two.getPixel(x, y);

                if (pixel_one==pixel_two) {
                    deltaBitmap.setPixel(x, y, pixel_one);
                    sameCount++;
                } else {
                    deltaBitmap.setPixel(x, y, Color.rgb(255, 30, 30));
                }
            }
        }

        System.out.println("maxHeight: "+maxHeight);
        System.out.println("maxWidth: "+maxWidth);
        System.out.println("% delta: "+(sameCount/(maxWidth*maxHeight)*100));

        return deltaBitmap;
    }
}

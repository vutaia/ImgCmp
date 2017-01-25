package com.hipmunk.tai.imgcmp;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by tai on 1/24/17.
 */

public class ImageComparator {

    public static Bitmap compareBitmap(Bitmap _one, Bitmap _two, float _threshold) {
        int height1 = _one.getHeight(), height2 = _two.getHeight();
        int width1 = _one.getWidth(), width2 = _two.getWidth();
        int maxHeight = Math.max(height1, height2);
        int maxWidth = Math.max(width1, width2);
        double sameCount = 0;

        Bitmap deltaBitmap = Bitmap.createBitmap(maxWidth, maxHeight, Bitmap.Config.ARGB_8888);

        for (int x=0; x<maxWidth; x++) {
            for (int y=0; y<maxHeight; y++) {

                int pixel_one = 0;
                int pixel_two = 0;

                try {
                    pixel_one = _one.getPixel(x, y);
                } catch (Exception e) { }

                try {
                    pixel_two = _two.getPixel(x, y);
                } catch (Exception e) { }

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
        System.out.println("% delta: "+(sameCount/(maxWidth*maxHeight)));

        return deltaBitmap;
    }
}

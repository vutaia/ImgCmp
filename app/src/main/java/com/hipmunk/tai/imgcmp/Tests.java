package com.hipmunk.tai.imgcmp;

import com.hipmunk.tai.imgcmp.model.ImageTest;

import static com.hipmunk.tai.imgcmp.R.raw.a_base;
import static com.hipmunk.tai.imgcmp.R.raw.a_compare;
import static com.hipmunk.tai.imgcmp.R.raw.b_base;
import static com.hipmunk.tai.imgcmp.R.raw.b_compare;

/**
 * Created by tai on 1/24/17.
 */

public class Tests {

    public static ImageTest[] TESTS = {
            new ImageTest(a_base, a_compare, .90f),
            new ImageTest(b_base, b_compare, .90f),
            new ImageTest(a_base, b_compare, .90f),
            new ImageTest(b_base, a_compare, .90f),
    };
}

package com.hipmunk.tai.imgcmp;

import com.hipmunk.tai.imgcmp.model.ImageTest;

import static com.hipmunk.tai.imgcmp.R.raw.a_base;
import static com.hipmunk.tai.imgcmp.R.raw.a_compare;
import static com.hipmunk.tai.imgcmp.R.raw.b_base;
import static com.hipmunk.tai.imgcmp.R.raw.b_compare;
import static com.hipmunk.tai.imgcmp.R.raw.c_base;
import static com.hipmunk.tai.imgcmp.R.raw.c_compare;

public class Tests {

    public static ImageTest[] TESTS = {
            new ImageTest(a_base, a_compare, .90f),
            new ImageTest(c_base, c_compare, .90f),
            new ImageTest(b_base, b_compare, .90f),
    };
}

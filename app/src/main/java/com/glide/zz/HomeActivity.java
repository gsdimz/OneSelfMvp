package com.glide.zz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity {
    private ImageView mIvGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mIvGlide = (ImageView) findViewById(R.id.miv_for_glide);

        Glide.with(this).load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png").into(mIvGlide);

    }
}

package com.zx.glide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.zx.glide.mvp.main.MainModel;
import com.zx.glide.mvp.main.MainPresenter;
import com.zx.glide.mvp.main.MainView;
import com.zx.glide.mvp.other.MvpActivity;

import butterknife.ButterKnife;

public class HomeActivity extends MvpActivity<MainPresenter> implements MainView {
    private ImageView mIvGlide;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initToolBarAsHome("MVP");
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void getDataSuccess(MainModel model) {

    }

    @Override
    public void getDataFail(String msg) {

    }
}

package com.zx.glide.mvp.other;

import android.os.Bundle;

import com.zx.glide.ui.BaseActivity;

/**
 * Created by zx on 17-7-12.
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

    public void showLoading() {
        showProgressDialog();
    }

    public void hideLoading() {
        dismissProgressDialog();
    }
}

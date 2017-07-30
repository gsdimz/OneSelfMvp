package com.zx.glide;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zx.glide.mvp.main.MainModel;
import com.zx.glide.mvp.main.MainPresenter;
import com.zx.glide.mvp.main.MainView;
import com.zx.glide.mvp.other.MvpActivity;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeActivity extends MvpActivity<MainPresenter> implements MainView {
    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.mimage)
    ImageView mImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
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
        dataSuccess(model);
    }

    @Override
    public void getDataFail(String msg) {
        toastShow("网络不给力");
    }

    @OnClick({R.id.button0, R.id.button1, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                Glide.with(mActivity).asBitmap().load("https://www.baidu.com/img/bdlogo.png")
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                mImageView.setImageBitmap(resource);
                            }
                        });
                break;
            case R.id.button1:
                break;
            case R.id.button2:
                //请求接口
                mvpPresenter.loadDataByRetrofitRxjava("101310222");
                break;
        }
    }

    private void dataSuccess(MainModel model) {
        MainModel.WeatherinfoBean weatherinfo = model.getWeatherinfo();
        String showData = getResources().getString(R.string.city) + weatherinfo.getCity()
                + getResources().getString(R.string.wd) + weatherinfo.getWD()
                + getResources().getString(R.string.ws) + weatherinfo.getWS()
                + getResources().getString(R.string.time) + weatherinfo.getTime();
        text.setText(showData);
    }
}

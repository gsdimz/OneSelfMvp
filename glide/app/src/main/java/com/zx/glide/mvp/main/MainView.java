package com.zx.glide.mvp.main;

/**
 * Created by zx on 17-7-12.
 * 添加处理业务的方法.
 */

public interface MainView extends BaseView {

    void getDataSuccess(MainModel model);

    void getDataFail(String msg);

}

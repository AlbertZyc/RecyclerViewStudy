package com.study.zyc.recyclestudy.model;

import android.widget.TextView;

import com.study.zyc.recyclestudy.bean.DataBean;

public class IMainModelImpl implements IMainModel {
    TextView textView;
    @Override
    public void setT(String text) {
        new DataBean(text);
    }

    @Override
    public DataBean getT(String text) {
        return null;
    }
}

package com.study.zyc.recyclestudy.pesenter;

import com.study.zyc.recyclestudy.model.IMainModelImpl;
import com.study.zyc.recyclestudy.view.IUpdataViews;

public class IPresenterImpl implements IPresenter{
    private IUpdataViews views;
    private IMainModelImpl model;

    public IPresenterImpl(IUpdataViews views) {
        this.views = views;
        model = new IMainModelImpl() ;
    }


    @Override
    public void setT(String text) {
        model.setT(text);
    }
}

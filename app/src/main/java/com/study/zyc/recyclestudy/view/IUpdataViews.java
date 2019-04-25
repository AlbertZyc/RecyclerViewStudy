package com.study.zyc.recyclestudy.view;

import java.util.Map;

public interface IUpdataViews {
    void upDataRecyclerView(Map<String,Object> datas);
    void onClickThis();
    void onLongClik();
    void onUpRefresh();
    void onBottomRefresh();
    void onAddData();
    void setT();
}

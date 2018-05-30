package com.framgia.nguyenson.lesson8.screen.main;


import com.framgia.nguyenson.lesson8.data.model.Repos;
import com.framgia.nguyenson.lesson8.source.remote.LoadJson;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainContract.Presenter, LoadJson.CallBack {

    private MainContract.View mView;
    private LoadJson mLoadJson;
    private List<Repos> mReposList;

    public MainPresenter() {
        mLoadJson = new LoadJson();
        mLoadJson.onListener(this);
    }

    @Override
    public void setView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void callBack(List<Repos> list) {
        mReposList = list;
        mView.showList(list);
    }

    @Override
    public void callBackError(String message) {
        mView.showError(message);
    }

    @Override
    public void load(String url) {
        mLoadJson.execute(url);
    }

    @Override
    public void search(String s) {
        ArrayList<Repos> list = new ArrayList<>();
        if (mReposList == null) return;
        if (s.isEmpty()) {
            mView.showList(mReposList);
        } else {
            for (Repos i : mReposList) {
                if (String.valueOf(i.getId()).contains(s)) {
                    list.add(i);
                }
            }
            mView.showList(list);
        }
    }
}

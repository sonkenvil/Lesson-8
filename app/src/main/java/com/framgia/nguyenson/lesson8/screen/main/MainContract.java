package com.framgia.nguyenson.lesson8.screen.main;

import com.framgia.nguyenson.lesson8.BasePresenter;
import com.framgia.nguyenson.lesson8.BaseView;
import com.framgia.nguyenson.lesson8.data.model.Repos;

import java.util.List;

public interface MainContract {
    interface View extends BaseView {

        void showList(List<Repos> list);

        void showError(String message);
    }

    interface Presenter extends BasePresenter<View> {
        void search(String s);

        void load(String url);
    }
}

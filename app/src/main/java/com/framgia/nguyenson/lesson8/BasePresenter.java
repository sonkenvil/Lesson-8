package com.framgia.nguyenson.lesson8;

public interface BasePresenter<T> {
    void setView(T view);

    void start();

    void stop();
}

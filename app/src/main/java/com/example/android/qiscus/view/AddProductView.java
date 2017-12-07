package com.example.android.qiscus.view;

/**
 * Created by Ifan on 12/7/2017.
 */

public interface AddProductView {

    void onCompleteInput(String name, String price, String desc);

    void onSubmit();

    void onSuccess();

    void onError();

    void showProgress();

    void hideProgress();

    void backToLastPage();
}

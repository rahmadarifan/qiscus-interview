package com.example.android.qiscus.view;

import com.example.android.qiscus.model.Products;

import java.util.List;

/**
 * Created by Ifan on 12/7/2017.
 */

public interface ListProducts {

    void setItem(List<Products.Main> list);

    void showConnectionError();

    void showProgressBar();

    void hideProgressBar();
}

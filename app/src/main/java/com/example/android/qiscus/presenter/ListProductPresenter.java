package com.example.android.qiscus.presenter;

import com.example.android.qiscus.model.Products;

import java.util.List;

/**
 * Created by Ifan on 12/7/2017.
 */

public interface ListProductPresenter {

    void onStart();

    void onDestroy();

    void loadListProducts();

    interface Callback{
        void onSuccess(List<Products.Main> mains);
    }
}

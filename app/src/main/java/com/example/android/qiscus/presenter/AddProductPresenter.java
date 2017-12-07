package com.example.android.qiscus.presenter;

import com.example.android.qiscus.model.Products;

import java.util.List;

/**
 * Created by Ifan on 12/7/2017.
 */

public interface AddProductPresenter {

    void onDestroy();

    void addProduct(String name, String price, String desc);

}

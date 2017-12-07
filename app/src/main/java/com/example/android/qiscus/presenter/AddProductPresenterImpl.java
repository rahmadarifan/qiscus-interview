package com.example.android.qiscus.presenter;

import com.example.android.qiscus.model.Products;
import com.example.android.qiscus.network.APIServices;
import com.example.android.qiscus.view.AddProductView;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Ifan on 12/7/2017.
 */

public class AddProductPresenterImpl implements AddProductPresenter {
    AddProductView addProductView;
    APIServices apiServices;

    @Override
    public void onDestroy() {
        addProductView = null;
    }

    @Override
    public void addProduct(String name, String price, String desc) {
        apiServices.setProduct(name, price, desc).enqueue(new retrofit2.Callback<Products.Main>() {
            @Override
            public void onResponse(Call<Products.Main> call, Response<Products.Main> response) {
                addProductView.hideProgress();
                if (response.isSuccessful()) {
                    addProductView.onSuccess();
                } else {
                    addProductView.onError();
                }
            }

            @Override
            public void onFailure(Call<Products.Main> call, Throwable t) {
                addProductView.hideProgress();
                addProductView.onError();
            }
        });
    }


    public AddProductPresenterImpl(AddProductView addProductView, APIServices apiServices) {
        this.addProductView = addProductView;
        this.apiServices = apiServices;
    }
}

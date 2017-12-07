package com.example.android.qiscus.presenter;

import com.example.android.qiscus.model.Products;
import com.example.android.qiscus.network.APIServices;
import com.example.android.qiscus.view.ListProducts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Ifan on 12/7/2017.
 */

public class ListProductsPresenterImpl implements ListProductPresenter, ListProductPresenter.Callback {

    ListProducts listProductsView;
    List<Products.Main> mains;
    APIServices apiServices;

    @Override
    public void onSuccess(List<Products.Main> mains) {
        listProductsView.setItem(mains);
    }

    @Override
    public void onStart() {
        if (listProductsView != null) {
            listProductsView.showProgressBar();
            loadListProducts();
        }
    }

    @Override
    public void onDestroy() {
        listProductsView = null;
    }

    @Override
    public void loadListProducts() {
        apiServices.getProduct().enqueue(new retrofit2.Callback<List<Products.Main>>() {
            @Override
            public void onResponse(Call<List<Products.Main>> call, Response<List<Products.Main>> response) {
                listProductsView.hideProgressBar();
                if (response.isSuccessful()) {
                    List<Products.Main> mains = response.body();
                    if (!mains.isEmpty()) {
                        onSuccess(mains);
                    } else {
                        listProductsView.showConnectionError();
                    }
                } else {
                    listProductsView.showConnectionError();
                }
            }

            @Override
            public void onFailure(Call<List<Products.Main>> call, Throwable t) {
                listProductsView.hideProgressBar();
                listProductsView.showConnectionError();
            }
        });
    }

    public ListProductsPresenterImpl(ListProducts listProductsView, APIServices apiServices) {
        this.apiServices = apiServices;
        this.listProductsView = listProductsView;
    }
}

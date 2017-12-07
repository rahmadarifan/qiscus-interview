package com.example.android.qiscus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.qiscus.adapter.ListProductsAdapter;
import com.example.android.qiscus.model.Products;
import com.example.android.qiscus.network.APIClient;
import com.example.android.qiscus.network.APIServices;
import com.example.android.qiscus.presenter.ListProductPresenter;
import com.example.android.qiscus.presenter.ListProductsPresenterImpl;
import com.example.android.qiscus.view.ListProducts;

import java.util.List;

public class ListProductFragment extends Fragment implements ListProducts {

    private RecyclerView recyclerView;
    private View progressBar;
    private ListProductsAdapter listProductsAdapter;
    private ListProductPresenter listProductPresenter;

    public ListProductFragment() {

    }

    public static ListProductFragment newInstance() {
        ListProductFragment fragment = new ListProductFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_product, container, false);
        setHasOptionsMenu(true);
        recyclerView = view.findViewById(R.id.recycler_view);
        progressBar = view.findViewById(R.id.progress_bar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        listProductPresenter = new ListProductsPresenterImpl(this, APIClient.getClient(getContext()).create(APIServices.class));
        listProductPresenter.onStart();
        return view;
    }

    @Override
    public void setItem(List<Products.Main> list) {
        listProductsAdapter = new ListProductsAdapter(list, getContext());
        recyclerView.setAdapter(listProductsAdapter);
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(getContext(), "Connection Error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_product:
                getFragmentManager().beginTransaction().replace(R.id.frame_layout, AddProductFragment.newInstance()).addToBackStack(AddProductFragment.class.getSimpleName()).commit();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        listProductPresenter.onDestroy();
        super.onDestroy();
    }
}

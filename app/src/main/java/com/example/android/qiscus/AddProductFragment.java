package com.example.android.qiscus;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.qiscus.network.APIClient;
import com.example.android.qiscus.network.APIServices;
import com.example.android.qiscus.presenter.AddProductPresenter;
import com.example.android.qiscus.presenter.AddProductPresenterImpl;
import com.example.android.qiscus.view.AddProductView;

public class AddProductFragment extends Fragment implements AddProductView {
    EditText etName, etPrice, etDesc;
    Button btnSubmit;
    AddProductPresenter addProductPresenter;

    private ProgressDialog progressDialog;

    public AddProductFragment() {
        // Required empty public constructor
    }

    public static AddProductFragment newInstance() {
        return new AddProductFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);
        addProductPresenter = new AddProductPresenterImpl(this, APIClient.getClient(getContext()).create(APIServices.class));
        etName = view.findViewById(R.id.et_product_name);
        etPrice = view.findViewById(R.id.et_product_price);
        etDesc = view.findViewById(R.id.et_product_desc);
        btnSubmit = view.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmit();
            }
        });

        return view;
    }

    @Override
    public void onCompleteInput(String name, String price, String desc) {
        showProgress();
        addProductPresenter.addProduct(name, price, desc);
    }

    @Override
    public void onSubmit() {
        String name = etName.getText().toString();
        String price = etPrice.getText().toString();
        String desc = etDesc.getText().toString();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(price) && !TextUtils.isEmpty(desc)) {
            onCompleteInput(name, price, desc);
        } else {
            Toast.makeText(getContext(), "Data cannot be empty!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSuccess() {
        Toast.makeText(getContext(), "Add Product Success!", Toast.LENGTH_SHORT).show();
        backToLastPage();
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), "Add product Error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void backToLastPage() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void showProgress() {
        progressDialog = ProgressDialog.show(getContext(), "", "Loading", true);
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}

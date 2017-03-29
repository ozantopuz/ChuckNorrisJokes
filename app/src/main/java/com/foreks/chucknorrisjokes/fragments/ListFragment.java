package com.foreks.chucknorrisjokes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foreks.chucknorrisjokes.R;
import java.lang.String;

import com.foreks.chucknorrisjokes.adapters.ListAdapter;
import com.foreks.chucknorrisjokes.models.CategoriesResponse;
import com.foreks.chucknorrisjokes.services.APIClient;
import com.foreks.chucknorrisjokes.services.APIService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ozan on 29/03/17.
 */

public class ListFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();
    private APIService apiService;
    private ArrayList<CategoriesResponse> mCategories;

    @BindView(R.id.fragment_list_recycler_view)
    RecyclerView mRecyclerView;
    private Unbinder mUnbinder;


    public static ListFragment newInstance(Context context) {
        return (ListFragment) ListFragment.instantiate(context, ListFragment.class.getName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        apiService = APIClient.getClient().create(APIService.class);
        mCategories = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<List<String>> call = apiService.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {

                if(response.isSuccessful()){
                    for(int x = 0; x < response.body().size(); x++) {
                        CategoriesResponse mCategoriesResponse = new CategoriesResponse(response.body().get(x));
                        mCategories.add(mCategoriesResponse);
                    }
                    mRecyclerView.setAdapter(new ListAdapter(mCategories, getActivity().getApplicationContext()));
                }
            }
            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.e(TAG," Response Failure "+String.valueOf(t.getMessage()));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}

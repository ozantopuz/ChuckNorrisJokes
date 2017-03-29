package com.foreks.chucknorrisjokes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.foreks.chucknorrisjokes.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ozan on 29/03/17.
 */

public class DetailFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    @BindView(R.id.fragment_detail_image_view)
    ImageView mImageView;
    @BindView(R.id.fragment_detail_text_view)
    TextView mTextView;
    private Unbinder mUnbinder;

    public static DetailFragment newInstance(Context context) {
        return (DetailFragment) DetailFragment.instantiate(context, DetailFragment.class.getName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}

package com.foreks.chucknorrisjokes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.foreks.chucknorrisjokes.R;
import com.foreks.chucknorrisjokes.models.RandomJokeResponse;
import com.foreks.chucknorrisjokes.services.APIClient;
import com.foreks.chucknorrisjokes.services.APIService;
import com.foreks.chucknorrisjokes.utils.StringUtils;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ozan on 29/03/17.
 */

public class DetailFragment extends Fragment {

    private static final String ARGS_CATEGORY = "category";
    private final String TAG = this.getClass().getSimpleName();
    String getArgsCategory;
    private APIService apiService;
    StringUtils stringUtils;

    @BindView(R.id.fragment_detail_image_view)
    ImageView mImageView;
    @BindView(R.id.fragment_detail_text_view)
    TextView mTextView;
    @BindView(R.id.fragment_detail_text_view_words)
    TextView mWordsTextView;
    @BindView(R.id.fragment_detail_text_view_letters)
    TextView mLettersTextView;
    private Unbinder mUnbinder;

    public static DetailFragment newInstance(Context context, String category) {
        Bundle args = new Bundle();
        args.putString(ARGS_CATEGORY, category);
        return (DetailFragment) instantiate(context, DetailFragment.class.getName(), args);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        apiService = APIClient.getClient().create(APIService.class);
        stringUtils = new StringUtils();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        getArgsCategory = args.getString(ARGS_CATEGORY);

        Call<RandomJokeResponse> call = apiService.fetchRandomJoke(getArgsCategory);
        call.enqueue(new Callback<RandomJokeResponse>() {
            @Override
            public void onResponse(Call<RandomJokeResponse> call, Response<RandomJokeResponse> response) {

                if (response.isSuccessful()) {
                    String value = response.body().getValue();

                    String[] wordArray = stringUtils.splitSentenceIntoWords(value);
                    String evaluatedSentence = stringUtils.createStringWithOccurenceNumbers(wordArray);

                    String[] charArray = stringUtils.toCharacterArray(value);
                    String evaluatedSentenceFromChars = stringUtils.createStringWithOccurenceNumbers(charArray);

                    mTextView.setText(value);
                    mWordsTextView.setText(evaluatedSentence);
                    mLettersTextView.setText(evaluatedSentenceFromChars);

                    Picasso.with(getActivity())
                            .load(response.body().getIconUrl())
                            .fit()
                            .centerInside()
                            .into(mImageView);
                }
            }

            @Override
            public void onFailure(Call<RandomJokeResponse> call, Throwable t) {
                Log.e(TAG, " Response Failure " + String.valueOf(t.getMessage()));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}

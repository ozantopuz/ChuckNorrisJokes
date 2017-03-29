package com.foreks.chucknorrisjokes.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foreks.chucknorrisjokes.R;
import com.foreks.chucknorrisjokes.models.CategoriesResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ozan on 29/03/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<CategoriesResponse> mCategories;
    private Context context;

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_list_text_view)
        TextView mTextView;

        @BindView(R.id.item_list_card_view)
        CardView cardView;

        public ListViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public ListAdapter(List<CategoriesResponse> mCategories, Context context) {
        this.mCategories = mCategories;
        this.context = context;
    }

    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ListViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        holder.mTextView.setText(mCategories.get(position).getCategories());
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }
}

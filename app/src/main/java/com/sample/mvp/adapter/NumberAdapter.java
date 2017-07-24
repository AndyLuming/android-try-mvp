package com.sample.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.mvp.R;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by AndyL on 2017/7/24.
 */

public class NumberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> numbers = new ArrayList<>();

    public NumberAdapter() {}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NumberViewHolder(parent.getContext(), parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NumberViewHolder) holder).textView.setText(numbers.get(position));
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public void setNumbers(List<String> numbers){
        checkNotNull(numbers);
        this.numbers = numbers;
    }

    public void appendNumber(String number){
        checkNotNull(number);
        this.numbers.add(number);
    }

    private class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        NumberViewHolder(Context context, ViewGroup parent) {
            super(LayoutInflater.from(context).inflate(R.layout.viewholder_number, parent, false));
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}

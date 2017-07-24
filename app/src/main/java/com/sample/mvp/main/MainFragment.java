package com.sample.mvp.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.mvp.R;
import com.sample.mvp.adapter.NumberAdapter;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by AndyL on 2017/7/24.
 */

public class MainFragment extends Fragment implements MainContract.View{

    public  static  final String TAG = "MainFragment";

    private Context context;

    private MainContract.presenter presenter;

    private RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;

    private NumberAdapter adapter;

    public MainFragment(){}

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new NumberAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        FloatingActionButton button = (FloatingActionButton) rootView.findViewById(R.id.floatingButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.generateNewNumber();
            }
        });

        presenter.loadNumber();

        Log.i(TAG, "createView");

        return rootView;
    }

    @Override
    public void setPresenter(MainContract.presenter presenter) {
        checkNotNull(presenter);
        this.presenter = presenter;
    }

    @Override
    public void showNumber(List<String> numbers) {
        checkNotNull(numbers);
        Log.i(TAG, "showNumber");
        adapter.setNumbers(numbers);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void appendNewNumber(String number) {
        checkNotNull(number);
        Log.i(TAG, "appendNewNumber");
        int insertPosition = adapter.getItemCount();
        adapter.appendNumber(number);
        adapter.notifyItemInserted(insertPosition);
    }

    @Override
    public void smoothScrollToBottom() {
        recyclerView.smoothScrollToPosition(linearLayoutManager.getItemCount() - 1);
    }

    @Override
    public int getNumberCount() {
        checkNotNull(adapter);
        return adapter.getItemCount();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
}

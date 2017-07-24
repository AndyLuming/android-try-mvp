package com.sample.mvp.main;

import android.util.Log;

import com.sample.mvp.data.NumberRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by AndyL on 2017/7/24.
 */

public class MainPresenter implements MainContract.presenter {

    private static final String TAG = "mainPresenter";

    private final MainContract.View mainView;

    private final NumberRepository numberRepository;

    public MainPresenter(MainContract.View mainView, NumberRepository numberRepository) {
        this.mainView = checkNotNull(mainView);
        this.numberRepository = checkNotNull(numberRepository);
        this.mainView.setPresenter(this);
    }

    @Override
    public void start() {
        Log.i(TAG, "start");
    }

    @Override
    public void destroy() {
        Log.i(TAG, "destroy");
    }

    @Override
    public void loadNumber() {
        Log.i(TAG, "loadNumber");
        mainView.showNumber(numberRepository.fetchNumbers());
    }

    @Override
    public void generateNewNumber() {
        Log.i(TAG, "generateNewNumber");
        String newNumber = String.valueOf(mainView.getNumberCount());
        numberRepository.saveNewNumber(newNumber);
        mainView.appendNewNumber(newNumber);
        mainView.smoothScrollToBottom();
    }
}

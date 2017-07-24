package com.sample.mvp.main;

import com.sample.mvp.base.BasePresenter;
import com.sample.mvp.base.BaseView;

import java.util.List;

/**
 * Created by AndyL on 2017/7/24.
 */

public interface MainContract {

    interface View extends BaseView<presenter> {

        void showNumber(List<String> numbers);

        void appendNewNumber(String number);

        void smoothScrollToBottom();

        int  getNumberCount();
    }

    interface presenter extends BasePresenter {

        void loadNumber();

        void generateNewNumber();

    }

}

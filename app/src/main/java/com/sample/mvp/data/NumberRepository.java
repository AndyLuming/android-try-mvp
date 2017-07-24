package com.sample.mvp.data;

import java.util.List;

/**
 * Created by AndyL on 2017/7/24.
 */

public interface NumberRepository {

    List<String> fetchNumbers();

    void saveNewNumber(String number);

}

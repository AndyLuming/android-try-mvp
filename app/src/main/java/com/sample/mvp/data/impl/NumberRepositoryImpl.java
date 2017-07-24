package com.sample.mvp.data.impl;

import android.util.Log;

import com.sample.mvp.data.NumberRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by AndyL on 2017/7/24.
 */

public class NumberRepositoryImpl implements NumberRepository {

    private final static String       TAG = "NumberRepositoryImpl";

    private final static LinkedHashMap<String, String> numbers;

    static {
        numbers = new LinkedHashMap<>();
        numbers.put(UUID.randomUUID().toString(), "0");
        numbers.put(UUID.randomUUID().toString(), "1");
        numbers.put(UUID.randomUUID().toString(), "2");
    }

    @Override
    public List<String> fetchNumbers() {
        Log.i(TAG, "fetchNumbers");
        List<String> nums = new ArrayList<>();
        nums.addAll(numbers.values());
        return nums;
    }

    @Override
    public void saveNewNumber(String number) {
        Log.i(TAG, "saveNewNumber");
        checkNotNull(number);
        numbers.put(UUID.randomUUID().toString(), number);
    }


}

package com.sample.mvp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sample.mvp.R;
import com.sample.mvp.data.impl.NumberRepositoryImpl;
import com.sample.mvp.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment fragment = MainFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                fragment, R.id.frameContainer);
        MainPresenter presenter = new MainPresenter(fragment,
                new NumberRepositoryImpl());
    }
}

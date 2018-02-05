package com.napsis.cryptowatcher.app.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.kogimobile.android.baselibrary.app.base.BaseActivity;
import com.kogimobile.android.baselibrary.app.base.BaseActivityInnerNavigation;
import com.napsis.cryptowatcher.R;
import com.napsis.cryptowatcher.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivityInnerNavigation {

    private ActivityMainBinding binding;
    private ViewModelActivityMain viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewModel = ViewModelProviders.of(this).get(ViewModelActivityMain.class);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected NavigationControllerActivityMain getNavigationController() {
        return (NavigationControllerActivityMain) super.getNavigationController();
    }

    @Override
    protected void initVars() {
        setNavigationController(new NavigationControllerActivityMain(this));
    }

    @Override
    protected void initViews() {
        initToolbar();
        navigateToFirstFragment();
    }

    @Override
    protected void initListeners() {

    }


    private void navigateToFirstFragment() {
        getNavigationController().navigateToSection1();
    }

    private void initToolbar() {
        setSupportActionBar(binding.includeToolbar.toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));
    }
}

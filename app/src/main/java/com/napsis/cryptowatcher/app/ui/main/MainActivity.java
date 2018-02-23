package com.napsis.cryptowatcher.app.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.kogimobile.android.baselibrary.app.base.BaseActivityInnerNavigation;
import com.napsis.cryptowatcher.R;
import com.napsis.cryptowatcher.app.ui.detail.FrgAlarmDetail;
import com.napsis.cryptowatcher.app.ui.main.viewmodel.ViewModelActivityMain;
import com.napsis.cryptowatcher.app.ui.settings.FrgSettins;
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
        if (isFragmentAdded(FrgMain.class.getSimpleName())) return;
        getNavigationController().navigateToSection1();
    }


    public void navigateToSecondFragment() {
        if (isFragmentAdded(FrgSettins.class.getSimpleName())) return;
        enableHomeBackArrowIndicator();
        getNavigationController().navigateToSection2();
    }

    public void navigateToThirdFragment() {
        if (isFragmentAdded(FrgAlarmDetail.class.getSimpleName())) return;
        getNavigationController().navigateToSection3();
    }


    private void initToolbar() {
        setSupportActionBar(binding.includeToolbar.toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));
    }

    public boolean isFragmentAdded(String fragmentTag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        return fragmentManager.findFragmentByTag(fragmentTag) != null;
    }

    @Override
    public void onBackPressed() {
        if (getTitleStack().size() == 2) {
            setHomeAsUpIndicator(-1);
        }
        super.onBackPressed();
    }


}

package com.napsis.cryptowatcher.app.ui.settings;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kogimobile.android.baselibrary.app.base.BaseFragment;
import com.napsis.cryptowatcher.R;
import com.napsis.cryptowatcher.app.ui.settings.viewmodel.ViewModelSettings;
import com.napsis.cryptowatcher.databinding.FrgSettingsBinding;

/**
 * @author Daniela Perez danielaperez@kogimobile.com on 2/5/18.
 */

public class FrgSettins extends BaseFragment {

    private FrgSettingsBinding binding;
    private ViewModelSettings viewModel;

    public static BaseFragment newInstance() {
        return new FrgSettins();
    }

    @Override
    protected void initVars() {
setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = ViewModelProviders.of(this).get(ViewModelSettings.class);
        initViewModels();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.frg_settings, container, false);
        return this.binding.getRoot();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initListeners() {

    }

    private void initViewModels() {
        viewModel =
                ViewModelProviders.of(this).get(ViewModelSettings.class);


    }
}

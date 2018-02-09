package com.napsis.cryptowatcher.app.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.kogimobile.android.baselibrary.app.base.BaseFragment;
import com.kogimobile.android.baselibrary.app.busevents.snackbar.EventSnackbarMessage;
import com.napsis.cryptowatcher.R;
import com.napsis.cryptowatcher.data.models.Currency;
import com.napsis.cryptowatcher.data.models.CurrencyCombo;
import com.napsis.cryptowatcher.data.models.UiStateModel;
import com.napsis.cryptowatcher.databinding.FrgMainBinding;


/**
 * @author Daniela Perez danielaperez@kogimobile.com on 2/5/18.
 */

public class FrgMain extends BaseFragment {

    private FrgMainBinding binding;
    private ViewModelFrgMain viewModel;

    public static FrgMain newInstance() {
        return new FrgMain();
    }

    @Override
    protected void initVars() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = ViewModelProviders.of(this).get(ViewModelFrgMain.class);
        initViewModels();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.frg_main, container, false);
        return this.binding.getRoot();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initListeners() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.currency_usd:
                viewModel.searchCurrenciesFromMenu(Currency.CurrencyType.USD);
                break;
            case R.id.currency_eur:
                viewModel.searchCurrenciesFromMenu(Currency.CurrencyType.EUR);
                break;
            case R.id.currency_gpb:
                viewModel.searchCurrenciesFromMenu(Currency.CurrencyType.GBP);
                break;
            case R.id.settings:
                ((MainActivity) getActivity()).navigateToSecondFragment();
                break;
        }
        return true;
    }

    private void initViewModels() {
        viewModel =
                ViewModelProviders.of(this).get(ViewModelFrgMain.class);

        subscribeToArtistsViewModel();
        viewModel.searchCurrencies(Currency.CurrencyType.USD);

    }

    private void subscribeToArtistsViewModel() {
        viewModel.getCurrencies()
                .observe(this, new Observer<UiStateModel<CurrencyCombo>>() {
                    @Override
                    public void onChanged(@Nullable UiStateModel<CurrencyCombo> currenciesUiStateModel) {
                        onCurrenciesViewModelChanged(currenciesUiStateModel);
                    }
                });
    }

    private void onCurrenciesViewModelChanged(UiStateModel<CurrencyCombo> currenciesUiStateModel) {
        if (currenciesUiStateModel == null) return;

        if (currenciesUiStateModel.isInProgress()) {
            showLoading();
        }

        if (currenciesUiStateModel.isSuccess()) {
            hideLoading();
            setCurrenciesData(currenciesUiStateModel.getData());
        }

        if (currenciesUiStateModel.isError()) {
            hideLoading();
            EventSnackbarMessage.getBuilder().withMessage(currenciesUiStateModel.getErrorMessage()).build();
        }
    }

    private void setCurrenciesData(CurrencyCombo data) {
        binding.btcBuy.setText(String.format(getString(R.string.value_currency), data.getBtcBuy().getAmount(), data.getBtcBuy().getCurrency()));
        binding.btcSell.setText(String.format(getString(R.string.value_currency), data.getBtcSell().getAmount(), data.getBtcSell().getCurrency()));
        binding.bchBuy.setText(String.format(getString(R.string.value_currency), data.getBchBuy().getAmount(), data.getBchBuy().getCurrency()));
        binding.bchSell.setText(String.format(getString(R.string.value_currency), data.getBchSell().getAmount(), data.getBchSell().getCurrency()));
        binding.ethBuy.setText(String.format(getString(R.string.value_currency), data.getEthBuy().getAmount(), data.getEthBuy().getCurrency()));
        binding.ethSell.setText(String.format(getString(R.string.value_currency), data.getEthSell().getAmount(), data.getEthSell().getCurrency()));
        binding.ltcBuy.setText(String.format(getString(R.string.value_currency), data.getLtcBuy().getAmount(), data.getLtcBuy().getCurrency()));
        binding.ltcSell.setText(String.format(getString(R.string.value_currency), data.getLtcSell().getAmount(), data.getLtcSell().getCurrency()));
    }

    private void showLoading() {
        binding.progress.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        binding.progress.setVisibility(View.GONE);
    }

}

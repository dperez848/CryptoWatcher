package com.napsis.cryptowatcher.data.repository.currency;

import com.napsis.cryptowatcher.R;
import com.napsis.cryptowatcher.app.App;
import com.napsis.cryptowatcher.data.managers.remote.RestClient;
import com.napsis.cryptowatcher.data.managers.remote.RestManagerPublicService;
import com.napsis.cryptowatcher.data.models.Currency;
import com.napsis.cryptowatcher.data.models.CurrencyCombo;

import io.reactivex.Single;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function8;

/**
 * @author Daniela Perez danielaperez@kogimobile.com on 2/5/18.
 */

public class RestCurrencySource implements RepositoryCurrencyDataSource {


    private static RestCurrencySource instance;

    public static RestCurrencySource newInstance() {
        if (instance == null) {
            instance = new RestCurrencySource();
        }
        return instance;
    }


    private RestManagerPublicService getService() {
        return (RestManagerPublicService) RestClient.getInstance().getRestClientManager()
                .getService(RestManagerPublicService.class);
    }

    @Override
    public Single<CurrencyCombo> getAll(int type) {
        return Single.zip(getService().getCurrencyBuy(getBtcPair(type)),
                getService().getCurrencyBuy(getEthPair(type)),
                getService().getCurrencyBuy(getBchPair(type)),
                getService().getCurrencyBuy(getLtcPair(type)),
                getService().getCurrencySell(getBtcPair(type)),
                getService().getCurrencySell(getEthPair(type)),
                getService().getCurrencySell(getBchPair(type)),
                getService().getCurrencySell(getLtcPair(type)),
                new Function8<Currency, Currency, Currency, Currency, Currency, Currency, Currency, Currency, CurrencyCombo>() {
                    @Override
                    public CurrencyCombo apply(Currency btcBuy, Currency ethBuy, Currency bchBuy,
                                               Currency ltcBuy, Currency btcSell, Currency ethSell,
                                               Currency bchSell, Currency ltcSell) throws Exception {
                        return new CurrencyCombo(btcSell, ethSell, bchSell, ltcSell, btcBuy, ethBuy, bchBuy, ltcBuy);
                    }
                });
    }

    private String getBtcPair(int type) {
        switch (type) {
            case 0: {
                return App.getGlobalContext().getString(R.string.pair_btc_usd);
            }
            case 1: {
                return App.getGlobalContext().getString(R.string.pair_btc_eur);
            }
            default: {
                return App.getGlobalContext().getString(R.string.pair_btc_gbp);
            }

        }
    }

    private String getEthPair(int type) {
        switch (type) {
            case 0:
                return App.getGlobalContext().getString(R.string.pair_eth_usd);
            case 1:
                return App.getGlobalContext().getString(R.string.pair_eth_eur);
            default:
                return App.getGlobalContext().getString(R.string.pair_eth_gbp);
        }
    }

    private String getBchPair(int type) {
        switch (type) {
            case 0:
                return App.getGlobalContext().getString(R.string.pair_bch_usd);
            case 1:
                return App.getGlobalContext().getString(R.string.pair_bch_eur);
            default:
                return App.getGlobalContext().getString(R.string.pair_bch_gbp);
        }
    }

    private String getLtcPair(int type) {
        switch (type) {
            case 0:
                return App.getGlobalContext().getString(R.string.pair_ltc_usd);
            case 1:
                return App.getGlobalContext().getString(R.string.pair_ltc_eur);
            default:
                return App.getGlobalContext().getString(R.string.pair_ltc_gbp);
        }
    }
}

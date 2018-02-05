package com.napsis.cryptowatcher.data.repository.currency;

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
    public Single<CurrencyCombo> getAll() {
        return Single.zip(getService().getCurrencyBuy("BTC-USD"),
                getService().getCurrencyBuy("ETH-USD"),
                getService().getCurrencyBuy("BCH-USD"),
                getService().getCurrencyBuy("LTC-USD"),
                getService().getCurrencySell("BTC-USD"),
                getService().getCurrencySell("ETH-USD"),
                getService().getCurrencySell("BCH-USD"),
                getService().getCurrencySell("LTC-USD"),
                new Function8<Currency, Currency, Currency, Currency, Currency, Currency, Currency, Currency, CurrencyCombo>() {
                    @Override
                    public CurrencyCombo apply(Currency btcBuy, Currency ethBuy, Currency bchBuy,
                                               Currency ltcBuy, Currency btcSell, Currency ethSell,
                                               Currency bchSell, Currency ltcSell) throws Exception {
                        return new CurrencyCombo(btcSell, ethSell, bchSell, ltcSell, btcBuy, ethBuy, bchBuy, ltcBuy);
                    }
                });
    }
}

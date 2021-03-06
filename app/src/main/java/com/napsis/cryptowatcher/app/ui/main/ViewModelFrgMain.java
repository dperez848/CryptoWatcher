package com.napsis.cryptowatcher.app.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.napsis.cryptowatcher.data.models.CurrencyCombo;
import com.napsis.cryptowatcher.data.models.UiStateModel;
import com.napsis.cryptowatcher.data.repository.RepositoryInjection;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * @author Daniela Perez danielaperez@kogimobile.com on 2/5/18.
 */

public class ViewModelFrgMain extends BaseViewModel {

    private MutableLiveData<UiStateModel<CurrencyCombo>> currencyComboLiveData;
    private long TIME_FOR_INTERVAL = 10;

    private String name;

    public ViewModelFrgMain() {
        currencyComboLiveData = new MutableLiveData<>();
    }

    public LiveData<UiStateModel<CurrencyCombo>> getCurrencies() {
        return currencyComboLiveData;
    }

    public void searchCurrencies() {
        if (name == null) {
            Timber.d("name is null");
            Disposable disposable =
                    Flowable.interval(TIME_FOR_INTERVAL, TimeUnit.SECONDS, Schedulers.io())
                            .startWith(Long.valueOf(10))
                            .flatMapSingle(new Function<Long, SingleSource<CurrencyCombo>>() {
                                @Override
                                public SingleSource<CurrencyCombo> apply(Long aLong) throws Exception {
                                    return RepositoryInjection.getRepositoryCurrency().getAll();
                                }
                            })
                            .doOnSubscribe(new Consumer<Subscription>() {
                                @Override
                                public void accept(Subscription subscription) throws Exception {
                                    currencyComboLiveData.postValue(UiStateModel.<CurrencyCombo>loading());

                                }
                            })
                            .subscribe(new Consumer<CurrencyCombo>() {
                                @Override
                                public void accept(CurrencyCombo currencyCombo) throws Exception {
                                    name = "currencyCombo";
                                    currencyComboLiveData.postValue(UiStateModel.success(currencyCombo));

                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                    currencyComboLiveData.postValue(UiStateModel.<CurrencyCombo>failure("An error occurred."));

                                }
                            });

            getCompositeDisposable().add(disposable);
        } else {
            Timber.d("name is NOT null");

        }
    }
}

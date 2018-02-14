package com.napsis.cryptowatcher.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.kogimobile.android.baselibrary.utils.StringUtils;
import com.napsis.cryptowatcher.app.App;
import com.napsis.cryptowatcher.data.models.Currency;

public class PreferenceUtils {


    private static final String PREF_USER_TOKEN = "PREF_USER_TOKEN";
    private static final String PREF_CURRENCY = "PREF_CURRENCY";

    public static void clearPreferences() {
        getPreferences(App.getGlobalContext()).edit().clear().apply();
    }

    PreferenceUtils() {
        throw new IllegalStateException("Utility class, please don't instantiate");
    }

    protected static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    protected static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }

    public static void setCurrencyPreference(int type){
        getEditor(App.getGlobalContext()).putInt(PREF_CURRENCY, type).apply();
    }

    public static int getCurrencyPreference(){
        return getPreferences(App.getGlobalContext()).getInt(PREF_CURRENCY, 0);
    }


}

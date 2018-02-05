package com.napsis.cryptowatcher.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.kogimobile.android.baselibrary.utils.StringUtils;
import com.napsis.cryptowatcher.app.App;

public class PreferenceUtils {


    private static final String PREF_USER_TOKEN = "PREF_USER_TOKEN";
    private static final String PREF_DEVICE_TOKEN = "PREF_DEVICE_TOKEN";

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


}

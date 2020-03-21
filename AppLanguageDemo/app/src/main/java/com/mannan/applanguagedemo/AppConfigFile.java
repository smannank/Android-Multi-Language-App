package com.mannan.applanguagedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppConfigFile {

    private SharedPreferences prefs;
    String sSysLanguage;

    public AppConfigFile(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }


    public String getsSysLanguage() {
        String sSysLanguage = prefs.getString("sSysLanguage", null);
        return sSysLanguage;
    }

    public void setsSysLanguage(String sSysLanguage) {
        prefs.edit().putString("sSysLanguage", sSysLanguage).commit();

    }
}

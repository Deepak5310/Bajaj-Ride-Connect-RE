package com.mappls.sdk.maps;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes4.dex */
class PreferenceHelper {
    private static final String KEY_LAST_SELECTED_STYLE = "com.mappls.sdk.maps.key_last_selected_style";
    private static final String KEY_MAPPLS_STYLE_LIST = "com.mappls.sdk.maps.key_mappls_style_list";
    private static final String PREF_MAPPLS_STYLE = "com.mappls.sdk.maps_mappls_style";
    private static PreferenceHelper mInstance;
    private final Context mContext;

    PreferenceHelper(Context context) {
        this.mContext = context;
    }

    void setMapplsStyle(GetStylesResponse getStylesResponse) {
        if (getStylesResponse == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mContext.getSharedPreferences(PREF_MAPPLS_STYLE, 0).edit();
        editorEdit.putString(KEY_MAPPLS_STYLE_LIST, new Gson().toJson(getStylesResponse));
        editorEdit.apply();
    }

    GetStylesResponse getMapplsStyle() {
        String string = this.mContext.getSharedPreferences(PREF_MAPPLS_STYLE, 0).getString(KEY_MAPPLS_STYLE_LIST, null);
        if (string == null) {
            return null;
        }
        return (GetStylesResponse) new Gson().fromJson(string, GetStylesResponse.class);
    }

    void setLastSelectedStyle(String str) {
        if (str == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mContext.getSharedPreferences(PREF_MAPPLS_STYLE, 0).edit();
        editorEdit.putString(KEY_LAST_SELECTED_STYLE, str);
        editorEdit.apply();
    }

    String getLastSelectedStyle() {
        return this.mContext.getSharedPreferences(PREF_MAPPLS_STYLE, 0).getString(KEY_LAST_SELECTED_STYLE, null);
    }
}

package com.mappls.sdk.plugins.places.autocomplete.data.converter;

import com.google.gson.Gson;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static ELocation a(String str) {
        if (str == null) {
            return null;
        }
        return (ELocation) new Gson().fromJson(str, ELocation.class);
    }

    public static String a(ELocation eLocation) {
        return new Gson().toJson(eLocation);
    }
}

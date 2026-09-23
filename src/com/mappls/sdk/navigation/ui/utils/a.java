package com.mappls.sdk.navigation.ui.utils;

import android.content.Context;
import android.util.Pair;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static Pair a(Context context, int i, boolean z) {
        String str;
        if (z) {
            str = "mappls_maneuver_dark_icon_" + i;
        } else {
            str = "mappls_maneuver_icon_" + i;
        }
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        if (identifier == 0) {
            return null;
        }
        return new Pair(Integer.valueOf(identifier), Integer.valueOf(i));
    }
}

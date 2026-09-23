package com.google.android.libraries.navigation.internal.iv;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m {
    public final SharedPreferences a;
    public final SharedPreferences b;
    public final SharedPreferences.Editor c;

    public m(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        this.a = sharedPreferences;
        this.b = sharedPreferences2;
        this.c = sharedPreferences2.edit();
    }
}

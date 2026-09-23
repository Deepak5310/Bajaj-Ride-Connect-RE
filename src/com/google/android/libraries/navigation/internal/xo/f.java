package com.google.android.libraries.navigation.internal.xo;

import android.net.Uri;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private final SimpleArrayMap a;

    public f(SimpleArrayMap simpleArrayMap) {
        this.a = simpleArrayMap;
    }

    public final String a(Uri uri, String str, String str2) {
        SimpleArrayMap simpleArrayMap = uri != null ? (SimpleArrayMap) this.a.get(uri.toString()) : null;
        if (simpleArrayMap == null) {
            return null;
        }
        if (str != null) {
            str2 = str.concat(str2);
        }
        return (String) simpleArrayMap.get(str2);
    }
}

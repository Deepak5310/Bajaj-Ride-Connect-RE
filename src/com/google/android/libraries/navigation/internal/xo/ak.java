package com.google.android.libraries.navigation.internal.xo;

import android.content.SharedPreferences;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak implements i {
    public static final Map a = new ArrayMap();
    private final SharedPreferences b;
    private final SharedPreferences.OnSharedPreferenceChangeListener c;

    static synchronized void b() {
        Map map = a;
        Iterator it2 = map.values().iterator();
        if (it2.hasNext()) {
            ak akVar = (ak) it2.next();
            SharedPreferences sharedPreferences = akVar.b;
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = akVar.c;
            throw null;
        }
        map.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.xo.i
    public final Object a(String str) {
        throw null;
    }
}

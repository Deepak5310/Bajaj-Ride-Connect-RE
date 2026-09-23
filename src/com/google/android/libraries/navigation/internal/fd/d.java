package com.google.android.libraries.navigation.internal.fd;

import android.content.Context;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static final Map a = new EnumMap(c.class);

    public static synchronized void a(Context context) {
        Iterator it2 = a.values().iterator();
        while (it2.hasNext()) {
            ((e) it2.next()).a(context);
        }
    }
}

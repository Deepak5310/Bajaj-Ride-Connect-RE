package com.google.android.libraries.navigation.internal.nm;

import android.content.ContentResolver;
import android.content.Context;
import com.google.android.libraries.navigation.internal.lc.h;
import com.google.android.libraries.navigation.internal.mh.c;
import com.google.android.libraries.navigation.internal.mh.j;
import com.google.android.libraries.navigation.internal.mh.k;
import com.google.android.libraries.navigation.internal.mh.l;
import com.google.android.libraries.navigation.internal.mh.m;
import com.google.android.libraries.navigation.internal.yz.ma;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final Context a;
    private final ContentResolver b;
    private final h c;

    public a(Context context, h hVar) {
        this.a = context;
        this.c = hVar;
        this.b = context.getContentResolver();
    }

    private final boolean c() {
        return this.c.f(this.a, h.b) == 0;
    }

    public final Map a(String... strArr) {
        if (!c()) {
            return ma.b;
        }
        ContentResolver contentResolver = this.b;
        try {
            j jVar = ((m) c.a).e;
            return j.a(contentResolver, strArr, new k() { // from class: com.google.android.libraries.navigation.internal.mh.h
                @Override // com.google.android.libraries.navigation.internal.mh.k
                public final Map a(int i) {
                    return new TreeMap();
                }
            });
        } catch (l unused) {
            return new TreeMap();
        }
    }

    public final int b() {
        if (c()) {
            return c.a(this.b);
        }
        return -1;
    }
}

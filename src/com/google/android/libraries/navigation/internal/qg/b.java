package com.google.android.libraries.navigation.internal.qg;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    final com.google.android.libraries.navigation.internal.qi.e a;
    final List b;
    final String c;
    private final boolean d;

    public b(boolean z, com.google.android.libraries.navigation.internal.qi.e eVar, List list, String str) {
        this.d = z;
        this.a = eVar;
        this.b = list;
        this.c = str;
    }

    public final boolean a() {
        return (!this.d || this.a == null || this.b == null) ? false : true;
    }
}

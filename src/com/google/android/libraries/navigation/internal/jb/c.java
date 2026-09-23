package com.google.android.libraries.navigation.internal.jb;

import com.google.android.libraries.navigation.internal.afl.ab;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    static final Long a = 101L;
    static final Long b = 999999999L;
    private final an c;
    private final String d;
    private final com.google.android.libraries.navigation.internal.jc.b e;
    private final Long f;
    private final int g;

    public c(int i, an anVar, String str, com.google.android.libraries.navigation.internal.jc.b bVar, Long l) {
        this.g = i;
        this.c = anVar;
        this.d = str;
        this.e = bVar;
        this.f = l;
    }

    public final com.google.android.libraries.navigation.internal.jc.b a() {
        return this.e;
    }

    public final an b() {
        return this.c;
    }

    public final Long c() {
        return this.f;
    }

    public final String d() {
        int i;
        return (this.g == ab.k || (i = this.g) == ab.l || i == ab.f || i == ab.d) ? this.e.toString() : this.d;
    }

    public final int e() {
        return this.g;
    }
}

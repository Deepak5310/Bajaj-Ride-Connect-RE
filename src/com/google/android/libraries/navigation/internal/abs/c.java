package com.google.android.libraries.navigation.internal.abs;

import java.util.Arrays;
import java.util.Stack;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final String a = "c";
    public final b b;
    public final e c;
    final int[] d;
    final Stack e;
    public final com.google.android.libraries.navigation.internal.abw.i f;
    public boolean g;

    public c(int i) {
        e eVar = e.a;
        b bVar = b.a;
        com.google.android.libraries.navigation.internal.abf.s.a(true, String.format("illegal cacheSize: %s", 16));
        com.google.android.libraries.navigation.internal.abf.s.k(eVar, "glUtils2");
        this.c = eVar;
        this.b = bVar;
        int[] iArr = new int[16];
        this.d = iArr;
        Arrays.fill(iArr, 0);
        this.e = new Stack();
        this.f = new com.google.android.libraries.navigation.internal.abw.i(16, this);
        this.g = false;
    }

    public final Integer a(Object obj) {
        com.google.android.libraries.navigation.internal.abf.s.k(obj, "key");
        return (Integer) this.f.get(obj);
    }

    public final /* bridge */ /* synthetic */ void b(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() != 0) {
            this.e.add(num);
        }
    }

    public final String toString() {
        return String.format("pool|unused|active: %s => %s => %s", Arrays.toString(this.d), this.e, this.f);
    }
}

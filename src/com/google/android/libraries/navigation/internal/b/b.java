package com.google.android.libraries.navigation.internal.b;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public byte[] a;
    public String b;
    public long c;
    public long d;
    public long e;
    public long f;
    public Map g = Collections.emptyMap();
    public List h;

    public static /* synthetic */ String b(int i, String str) {
        return str + i;
    }

    public static /* synthetic */ String e(Object obj, String str, String str2) {
        return str + String.valueOf(obj) + str2;
    }

    public static /* synthetic */ String g(String str, String str2, String str3) {
        return str2 + str + str3;
    }

    public static /* synthetic */ String h(float f, String str) {
        return str + f;
    }

    public static /* synthetic */ String j(int i, String str, String str2) {
        return str + i + str2;
    }

    public static /* synthetic */ String k(int i, int i2, String str, String str2, String str3) {
        return str + i2 + str2 + i + str3;
    }

    public static /* synthetic */ String l(int i, int i2, String str, String str2) {
        return str + i2 + str2 + i;
    }

    public static /* synthetic */ String m(int i, int i2, int i3, String str, String str2, String str3) {
        return str + i3 + str2 + i2 + str3 + i;
    }

    public static /* synthetic */ String n(Object obj, String str, String str2) {
        return str + obj.toString() + str2;
    }

    final boolean a(long j) {
        return this.e < j;
    }
}

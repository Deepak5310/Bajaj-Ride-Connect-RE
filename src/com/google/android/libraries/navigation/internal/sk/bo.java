package com.google.android.libraries.navigation.internal.sk;

import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bo {
    public final String a;
    public final long b;
    public long c;
    public long d;
    private final String e;
    private final String f;

    public bo(String str, String str2, long j, long j2, long j3, String str3) {
        this.a = str;
        this.e = str2;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.f = str3;
    }

    public final bp a() {
        return new bp(this.a, this.e);
    }

    public final File b() {
        String strValueOf = String.valueOf(Long.toHexString(this.b));
        return new File(this.f, String.valueOf(this.a).concat(strValueOf));
    }

    public final String toString() {
        return this.a + ":" + this.e + ":" + Long.toHexString(this.b) + ":" + Long.toHexString(this.c) + ":" + Long.toHexString(this.d);
    }
}

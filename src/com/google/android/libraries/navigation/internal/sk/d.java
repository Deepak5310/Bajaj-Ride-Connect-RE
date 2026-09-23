package com.google.android.libraries.navigation.internal.sk;

import com.google.android.libraries.navigation.internal.ace.hm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final com.google.android.libraries.navigation.internal.agl.a a;
    public final com.google.android.libraries.navigation.internal.agl.a b;
    public final com.google.android.libraries.navigation.internal.agl.a c;
    public final com.google.android.libraries.navigation.internal.agl.a d;
    public final boolean e;
    private final com.google.android.libraries.navigation.internal.agl.a f;

    public d(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, hm hmVar) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.f = aVar4;
        this.d = aVar5;
        this.e = !hmVar.k;
    }

    public final com.google.android.libraries.navigation.internal.agl.a a() {
        return this.e ? this.b : this.f;
    }
}

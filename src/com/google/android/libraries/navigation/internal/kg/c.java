package com.google.android.libraries.navigation.internal.kg;

import com.google.android.libraries.navigation.internal.kk.m;
import com.google.android.libraries.navigation.internal.kk.n;
import com.google.android.libraries.navigation.internal.km.p;
import com.google.android.libraries.navigation.internal.yz.mp;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public final com.google.android.libraries.navigation.internal.mj.a a;
    public volatile int c;
    public long d;
    public long f;
    public int g;
    public int h;
    public final m i;
    public final m j;
    public int l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f464n;
    public int o;
    public final int p;
    public final int[] b = new int[100];
    public long e = -1;
    public final Set k = mp.i();

    public c(int i, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.kl.b bVar) {
        this.a = aVar;
        this.p = i;
        this.i = ((n) bVar.a(p.a)).a();
        this.j = ((n) bVar.a(p.b)).a();
        Thread.currentThread().getName();
    }

    public final void a(a aVar) {
        this.k.add(aVar);
    }
}

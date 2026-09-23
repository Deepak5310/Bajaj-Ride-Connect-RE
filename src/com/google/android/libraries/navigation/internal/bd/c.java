package com.google.android.libraries.navigation.internal.bd;

import android.app.Application;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.hn.r;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.nt.p;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c {
    public static final j a = j.e("com.google.android.libraries.navigation.internal.bd.c");
    public final Application b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public final com.google.android.libraries.navigation.internal.kl.b d;
    public final com.google.android.libraries.navigation.internal.mj.a e;
    public final com.google.android.libraries.navigation.internal.bn.d f;
    public final com.google.android.libraries.navigation.internal.ia.e g;
    public final af h;
    public final Executor i;
    public final bn j;
    public final com.google.android.libraries.navigation.internal.afo.a k;
    public final long l;
    private final com.google.android.libraries.navigation.internal.cw.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.afo.a f343n;
    private final r o;
    private final p p;

    public c(Application application, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.bn.d dVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.cw.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4, af afVar, r rVar, Executor executor, bn bnVar, com.google.android.libraries.navigation.internal.afo.a aVar5) {
        a aVar6 = new a();
        aVar6.b = (byte) (aVar6.b | 8);
        aVar6.c(f.INITIALIZING);
        aVar6.b(false);
        aVar6.a = false;
        aVar6.b = (byte) (aVar6.b | 2);
        aVar6.d(false);
        this.p = new p(aVar6.a());
        this.l = 0L;
        this.b = application;
        this.c = aVar;
        this.d = bVar;
        this.e = aVar2;
        this.f = dVar;
        this.g = eVar;
        this.m = aVar3;
        this.f343n = aVar4;
        this.h = afVar;
        this.o = rVar;
        this.i = executor;
        this.j = bnVar;
        this.k = aVar5;
    }
}

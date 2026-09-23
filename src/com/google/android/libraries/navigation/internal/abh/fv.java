package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fv {
    public static final com.google.android.libraries.navigation.internal.mj.a a = new com.google.android.libraries.navigation.internal.mk.b();
    public final Context b;
    public final com.google.android.libraries.navigation.internal.yx.br c;
    public final gu d;
    public final ExecutorService e;
    public final com.google.android.libraries.navigation.internal.mj.a f;
    public final id g;
    public long h;
    public long i;
    public final com.google.android.libraries.navigation.internal.wd.g j;
    public long k;
    int o = 1;
    boolean l = false;
    boolean m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f121n = false;

    public fv(com.google.android.libraries.navigation.internal.yx.br brVar, gu guVar, ExecutorService executorService, com.google.android.libraries.navigation.internal.mj.a aVar, id idVar, Context context, com.google.android.libraries.navigation.internal.wd.g gVar) {
        this.c = brVar;
        this.d = guVar;
        this.e = executorService;
        this.f = aVar;
        this.g = idVar;
        this.b = context;
        this.j = gVar;
    }

    public final void a() {
        if (this.l && this.m && this.f121n) {
            this.o = 1;
            this.l = false;
            this.m = false;
            this.f121n = false;
        }
    }
}

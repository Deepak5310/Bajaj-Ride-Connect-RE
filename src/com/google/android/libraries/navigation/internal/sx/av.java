package com.google.android.libraries.navigation.internal.sx;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av {
    public static final long a = TimeUnit.SECONDS.toMillis(3);
    public static final long b = TimeUnit.SECONDS.toMillis(6);
    public final at c;
    public final Context d;
    public final Executor e = com.google.android.libraries.navigation.internal.aac.ac.INSTANCE;
    public final ae f;
    private final com.google.android.libraries.navigation.internal.fz.d g;

    public av(at atVar, ae aeVar, Application application, com.google.android.libraries.navigation.internal.fz.d dVar) {
        this.c = atVar;
        this.f = aeVar;
        this.d = application;
        this.g = dVar;
    }

    public final boolean a() {
        return this.g.b().a.aY;
    }
}

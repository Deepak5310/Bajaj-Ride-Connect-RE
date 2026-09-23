package com.google.android.libraries.navigation.internal.qq;

import com.google.android.libraries.geo.mapcore.renderer.ez;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class f {
    public abstract com.google.android.libraries.geo.mapcore.internal.model.aq a();

    public abstract e b();

    public abstract ez c();

    public abstract com.google.android.libraries.navigation.internal.rq.a d();

    public abstract boolean e();

    public final f f(boolean z) {
        return b() != null ? b().a(z) : new b(c(), d(), a(), z, null);
    }

    public final boolean g(f fVar) {
        b bVar = (b) fVar;
        return a().equals(bVar.c) && c().equals(bVar.a) && d().equals(bVar.b) && b() == bVar.e;
    }

    public final String toString() {
        return b() != null ? b().name() : "CUSTOM_DRAW_MODE";
    }
}

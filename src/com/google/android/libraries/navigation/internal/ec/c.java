package com.google.android.libraries.navigation.internal.ec;

import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.r;
import com.google.android.libraries.navigation.internal.nt.m;
import com.google.android.libraries.navigation.internal.nt.t;
import com.google.android.libraries.navigation.internal.zb.an;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c implements com.google.android.libraries.navigation.internal.ed.b {
    public final com.google.android.libraries.navigation.internal.iv.f b;
    public final com.google.android.libraries.navigation.internal.ia.e c;
    public final h d;
    public final Executor e;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final j f420n = j.e("com.google.android.libraries.navigation.internal.ec.c");
    public static final r a = ab.M;
    public boolean f = false;
    public boolean g = false;
    private volatile boolean o = false;
    public volatile boolean h = true;
    public volatile com.google.android.libraries.navigation.internal.ed.a i = com.google.android.libraries.navigation.internal.ed.a.AUTO;
    public int k = 0;
    public final t l = new a(this);
    public final b m = new b(this);
    public final g j = new g(null);

    public c(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.ia.e eVar, Executor executor, h hVar) {
        this.b = fVar;
        this.c = eVar;
        this.e = executor;
        this.d = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ed.b
    public final m a() {
        return this.j.a();
    }

    public final void b() {
        Boolean boolValueOf = Boolean.valueOf(c());
        g gVar = this.j;
        gVar.a.c(boolValueOf);
        gVar.b.setValue(boolValueOf);
    }

    @Override // com.google.android.libraries.navigation.internal.ed.b
    public final boolean c() {
        if (this.k == 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) j.b.h(an.MEDIUM)).F(435)).p("Invalid call, onCreate needs to be called before using this method!");
            return false;
        }
        if (this.h) {
            if (this.k == 0) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) j.b.h(an.MEDIUM)).F(436)).p("Invalid call, onCreate needs to be called before using this method!");
            } else {
                int iOrdinal = this.i.ordinal();
                if (iOrdinal != 1 && (iOrdinal == 2 || this.g || this.f)) {
                    return true;
                }
            }
        }
        return false;
    }
}

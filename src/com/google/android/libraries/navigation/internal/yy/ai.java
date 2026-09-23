package com.google.android.libraries.navigation.internal.yy;

import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.aac.ck;
import com.google.android.libraries.navigation.internal.yx.bm;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ai implements ax {
    volatile ax a;
    final ca b;
    final bm c;

    public ai() {
        this(bi.b);
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final int a() {
        return this.a.a();
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final ax b(ReferenceQueue referenceQueue, Object obj, bj bjVar) {
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final bj c() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final Object d() throws ExecutionException {
        return ck.a(this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final void e(Object obj) {
        if (obj != null) {
            j(obj);
        } else {
            this.a = bi.b;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final boolean f() {
        return this.a.f();
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final boolean g() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.ax
    public final Object get() {
        return this.a.get();
    }

    public final long h() {
        return this.c.a(TimeUnit.NANOSECONDS);
    }

    public final com.google.android.libraries.navigation.internal.aac.bj i(Object obj, j jVar) {
        try {
            this.c.d();
            if (this.a.get() == null) {
                Object objA = jVar.a(obj);
                return j(objA) ? this.b : com.google.android.libraries.navigation.internal.aac.az.h(objA);
            }
            com.google.android.libraries.navigation.internal.yx.ar.q(obj);
            return com.google.android.libraries.navigation.internal.aac.j.h(com.google.android.libraries.navigation.internal.aac.az.h(jVar.a(obj)), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.yy.ah
                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj2) {
                    this.a.j(obj2);
                    return obj2;
                }
            }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
        } catch (Throwable th) {
            com.google.android.libraries.navigation.internal.aac.bj bjVarG = k(th) ? this.b : com.google.android.libraries.navigation.internal.aac.az.g(th);
            if (th instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            return bjVarG;
        }
    }

    public final boolean j(Object obj) {
        return this.b.d(obj);
    }

    public final boolean k(Throwable th) {
        return this.b.ap(th);
    }

    public ai(ax axVar) {
        this.b = new ca();
        this.c = new bm();
        this.a = axVar;
    }
}

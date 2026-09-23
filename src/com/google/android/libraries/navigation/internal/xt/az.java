package com.google.android.libraries.navigation.internal.xt;

import android.content.Context;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az implements com.google.android.libraries.navigation.internal.yx.br {
    public static final /* synthetic */ int a = 0;
    private static volatile com.google.android.libraries.navigation.internal.xq.a b = new com.google.android.libraries.navigation.internal.xq.a(new com.google.android.libraries.navigation.internal.xr.a() { // from class: com.google.android.libraries.navigation.internal.xt.ay
        @Override // com.google.android.libraries.navigation.internal.xr.a
        public final void a() {
            int i = az.a;
        }
    });
    private final String c;
    private final String d;
    private final Object e;
    private final o f;
    private ak g;
    private volatile int h;
    private volatile Object i;
    private SimpleArrayMap j;
    private SimpleArrayMap k;
    private SimpleArrayMap l;
    private final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f654n;
    private volatile boolean o;

    public az(String str, String str2, Object obj, o oVar) {
        this.h = -1;
        this.c = "com.google.android.gms.maps";
        this.d = str2;
        this.e = obj;
        this.f = oVar;
        this.m = true;
        this.o = false;
        this.f654n = true;
    }

    public az(String str, String str2, Object obj, o oVar, boolean z) {
        this.h = -1;
        this.c = str;
        this.d = str2;
        this.e = obj;
        this.f = oVar;
        this.m = true;
        this.o = false;
        this.f654n = false;
    }

    private final Object b(com.google.android.libraries.navigation.internal.xo.y yVar) {
        com.google.android.libraries.navigation.internal.xo.y.f();
        Object objA = this.f.a(yVar, this.c, this.d, this.f654n);
        return objA != null ? objA : this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final Object a() {
        Context context = com.google.android.libraries.navigation.internal.xo.y.a;
        boolean z = true;
        com.google.android.libraries.navigation.internal.xo.aa.b = true;
        if (com.google.android.libraries.navigation.internal.xo.aa.c == null) {
            com.google.android.libraries.navigation.internal.xo.aa.c = new com.google.android.libraries.navigation.internal.xo.z();
        }
        Context context2 = com.google.android.libraries.navigation.internal.xo.y.a;
        if (context2 == null) {
            com.google.android.libraries.navigation.internal.xo.aa.a();
            throw new IllegalStateException("Must call PhenotypeContext.setContext() first");
        }
        com.google.android.libraries.navigation.internal.xo.y yVarA = com.google.android.libraries.navigation.internal.xo.y.a(context2);
        if ("".equals("")) {
            int i = this.h;
            if (i == -1 || i < this.g.a()) {
                synchronized (this) {
                    int i2 = this.h;
                    if (i2 == -1) {
                        this.g = this.f.b(yVarA, this.c);
                    }
                    int iA = this.g.a();
                    if (i2 < iA) {
                        Object objB = b(yVarA);
                        this.i = objB;
                        this.h = iA;
                        return objB;
                    }
                }
            }
            return this.i;
        }
        synchronized (this) {
            if (this.k == null) {
                com.google.android.libraries.navigation.internal.yx.ar.k(this.j == null);
                com.google.android.libraries.navigation.internal.yx.ar.k(this.l == null);
                this.k = new SimpleArrayMap();
                this.j = new SimpleArrayMap();
                this.l = new SimpleArrayMap();
            }
            ak akVar = (ak) this.k.get("");
            if (akVar != null && akVar.a() <= ((Integer) this.l.getOrDefault("", -1)).intValue()) {
                Object obj = this.j.get("");
                com.google.android.libraries.navigation.internal.yx.ar.r(obj, "Cached flag value should not be null if its version is up to date.");
                return obj;
            }
            ak akVarB = this.f.b(yVarA, this.c);
            ak akVar2 = (ak) this.k.put("", akVarB);
            if (akVar2 != null && akVar2 != akVarB) {
                z = false;
            }
            com.google.android.libraries.navigation.internal.yx.ar.l(z, "PackageVersionCache object should not change in the life of the process.");
            this.l.put("", Integer.valueOf(akVarB.a()));
            Object objB2 = b(yVarA);
            com.google.android.libraries.navigation.internal.yx.ar.s(objB2, "Expected user-scoped %s to not be null.", this.d);
            this.j.put("", objB2);
            return objB2;
        }
    }
}

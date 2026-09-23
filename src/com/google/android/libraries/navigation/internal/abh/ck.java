package com.google.android.libraries.navigation.internal.abh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ck extends com.google.android.libraries.navigation.internal.ly.aw {
    private final fv a;
    private final com.google.android.libraries.navigation.internal.wd.f b;
    private final el c;
    private final com.google.android.libraries.navigation.internal.wd.f d;
    private final com.google.android.libraries.navigation.internal.wd.g e;
    private final ed f;
    private final com.google.android.libraries.navigation.internal.wd.f g;

    public ck(fv fvVar, com.google.android.libraries.navigation.internal.wd.f fVar, el elVar, m mVar, com.google.android.libraries.navigation.internal.wd.f fVar2, com.google.android.libraries.navigation.internal.wd.f fVar3, ed edVar) {
        this.a = fvVar;
        this.b = fVar;
        this.c = elVar;
        this.d = fVar2;
        this.g = fVar3;
        this.e = mVar.l;
        com.google.android.libraries.navigation.internal.afu.d.s();
        this.f = edVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.ax
    public final void a() {
        com.google.android.libraries.navigation.internal.wd.f fVar;
        try {
            final fv fvVar = this.a;
            if (fvVar.c.a() != null) {
                final long epochMilli = fvVar.f.f().toEpochMilli();
                final long j = epochMilli - fvVar.h;
                fvVar.e.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.fs
                    @Override // java.lang.Runnable
                    public final void run() {
                        fv fvVar2 = fvVar;
                        com.google.android.libraries.navigation.internal.ny.e eVar = (com.google.android.libraries.navigation.internal.ny.e) fvVar2.c.a();
                        com.google.android.libraries.navigation.internal.zt.q qVarA = bx.a(fvVar2.d, fvVar2.b.getPackageName());
                        com.google.android.libraries.navigation.internal.ky.an anVar = eVar.b;
                        com.google.android.libraries.navigation.internal.ky.ah ahVarA = com.google.android.libraries.navigation.internal.ky.ah.a(qVarA);
                        com.google.android.libraries.navigation.internal.ky.ao aoVar = anVar.a;
                        aoVar.a(aoVar.g.a(j), 1L, ahVarA);
                        if (com.google.android.libraries.navigation.internal.afu.ae.c()) {
                            long j2 = epochMilli - fvVar2.k;
                            synchronized (fvVar2.j) {
                                if (fvVar2.o != 1) {
                                    if (!fvVar2.f121n) {
                                        int i = fvVar2.o;
                                        int i2 = i - 1;
                                        if (i == 0) {
                                            throw null;
                                        }
                                        if (i2 == 1) {
                                            fvVar2.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_COLD_START_WITH_CACHES_TO_MAP_LOAD, (int) j2);
                                        } else if (i2 == 2) {
                                            fvVar2.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_COLD_START_WITHOUT_CACHES_TO_MAP_LOAD, (int) j2);
                                        } else if (i2 == 3) {
                                            fvVar2.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_WARM_START_TO_MAP_LOAD, (int) j2);
                                        } else if (i2 == 4) {
                                            fvVar2.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_HOT_START_TO_MAP_LOAD, (int) j2);
                                        }
                                        fvVar2.f121n = true;
                                    }
                                    fvVar2.a();
                                }
                            }
                        }
                    }
                });
            }
            el elVar = this.c;
            elVar.c = true;
            elVar.d();
            if (com.google.android.libraries.navigation.internal.afu.d.f() && (fVar = this.g) != null) {
                fVar.b(0);
            }
            if (com.google.android.libraries.navigation.internal.afu.d.a.a().d() && this.f.O()) {
                this.d.b(0);
                this.e.c(com.google.android.libraries.navigation.internal.abx.b.MAP_READY);
            } else {
                this.b.b(0);
                this.e.c(com.google.android.libraries.navigation.internal.abx.b.STYLED_MAP_READY);
            }
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (!(th instanceof Error)) {
                throw new RuntimeException(th);
            }
            throw ((Error) th);
        }
    }
}

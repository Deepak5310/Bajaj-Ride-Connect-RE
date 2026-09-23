package com.google.android.libraries.navigation.internal.abm;

import com.google.android.libraries.navigation.internal.abh.fv;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.abm.do, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class Cdo {
    private final fv a;

    public Cdo(fv fvVar) {
        this.a = fvVar;
    }

    public final void a() {
        final fv fvVar = this.a;
        if (fvVar.c.a() != null) {
            final long epochMilli = fvVar.f.f().toEpochMilli();
            final long j = epochMilli - fvVar.i;
            fvVar.e.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.fq
                @Override // java.lang.Runnable
                public final void run() {
                    fv fvVar2 = fvVar;
                    com.google.android.libraries.navigation.internal.ny.e eVar = (com.google.android.libraries.navigation.internal.ny.e) fvVar2.c.a();
                    com.google.android.libraries.navigation.internal.zt.q qVarA = bx.a(fvVar2.d, fvVar2.b.getPackageName());
                    com.google.android.libraries.navigation.internal.ky.an anVar = eVar.c;
                    com.google.android.libraries.navigation.internal.ky.ah ahVarA = com.google.android.libraries.navigation.internal.ky.ah.a(qVarA);
                    com.google.android.libraries.navigation.internal.ky.ao aoVar = anVar.a;
                    aoVar.a(aoVar.g.a(j), 1L, ahVarA);
                    if (com.google.android.libraries.navigation.internal.afu.ae.c()) {
                        long j2 = epochMilli - fvVar2.k;
                        synchronized (fvVar2.j) {
                            if (fvVar2.o != 1) {
                                if (!fvVar2.m) {
                                    int i = fvVar2.o;
                                    int i2 = i - 1;
                                    if (i == 0) {
                                        throw null;
                                    }
                                    if (i2 == 1) {
                                        fvVar2.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_COLD_START_WITH_CACHES_TO_FULL_DISPLAY, (int) j2);
                                    } else if (i2 == 2) {
                                        fvVar2.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_COLD_START_WITHOUT_CACHES_TO_FULL_DISPLAY, (int) j2);
                                    } else if (i2 == 3) {
                                        fvVar2.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_WARM_START_TO_FULL_DISPLAY, (int) j2);
                                    } else if (i2 == 4) {
                                        fvVar2.j.f(com.google.android.libraries.navigation.internal.abx.b.MAP_HOT_START_TO_FULL_DISPLAY, (int) j2);
                                    }
                                    fvVar2.m = true;
                                }
                                fvVar2.a();
                            }
                        }
                    }
                }
            });
        }
    }

    public final void b() {
        fv fvVar = this.a;
        if (fvVar.c.a() != null) {
            fvVar.i = fvVar.f.f().toEpochMilli();
        }
    }
}

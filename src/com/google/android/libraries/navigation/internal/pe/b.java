package com.google.android.libraries.navigation.internal.pe;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.jo;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.f;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.nw.e;
import com.google.android.libraries.navigation.internal.ob.i;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.pb.p;
import com.google.android.libraries.navigation.internal.pd.d;
import com.google.android.libraries.navigation.internal.pd.k;
import com.google.android.libraries.navigation.internal.zp.n;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements i {
    private static final long b = TimeUnit.HOURS.toSeconds(1);
    public final af a;
    private final com.google.android.libraries.navigation.internal.mj.a c;
    private final com.google.android.libraries.navigation.internal.fu.a d;
    private final com.google.android.libraries.navigation.internal.i.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;
    private final Executor g;
    private final c h;

    public b(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fu.a aVar2, com.google.android.libraries.navigation.internal.i.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, f fVar, af afVar, Executor executor) {
        this.d = aVar2;
        this.e = aVar3;
        this.c = aVar;
        this.f = aVar4;
        this.a = afVar;
        this.g = executor;
        this.h = new c(fVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ob.i
    public final void a() {
        c cVar = this.h;
        cVar.a();
        if (cVar.b()) {
            cVar.h.c().edit().remove(c.a.toString()).remove(c.b.toString()).remove(c.c.toString()).remove(c.d.toString()).remove(c.e.toString()).remove(c.f.toString()).remove(c.g.toString()).apply();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ob.i
    public final void b(d dVar, boolean z) {
        k kVar = new k(dVar, z, this.c.f().toEpochMilli());
        c cVar = this.h;
        cVar.a();
        d dVar2 = kVar.a;
        cVar.h.c().edit().putFloat(c.a.toString(), (float) dVar2.i.a).putFloat(c.b.toString(), (float) dVar2.i.b).putFloat(c.c.toString(), dVar2.k).putFloat(c.d.toString(), dVar2.l).putFloat(c.e.toString(), dVar2.m).putBoolean(c.f.toString(), kVar.b).putLong(c.g.toString(), kVar.c).apply();
    }

    @Override // com.google.android.libraries.navigation.internal.ob.i
    public final int c(com.google.android.libraries.navigation.internal.pd.a aVar) {
        k kVar;
        int i;
        c cVar = this.h;
        synchronized (cVar) {
            if (!cVar.i) {
                cVar.h.A(new ab[]{c.a, c.b, c.c, c.d, c.e, c.f, c.g});
                cVar.i = true;
            }
        }
        try {
            if (cVar.b()) {
                Map<String, ?> all = cVar.h.c().getAll();
                d dVar = d.a;
                com.google.android.libraries.navigation.internal.pd.a aVar2 = new com.google.android.libraries.navigation.internal.pd.a();
                aVar2.d(new r(((Float) c.c(c.a, Float.class, all)).floatValue(), ((Float) c.c(c.b, Float.class, all)).floatValue()));
                aVar2.c = ((Float) c.c(c.c, Float.class, all)).floatValue();
                aVar2.d = ((Float) c.c(c.d, Float.class, all)).floatValue();
                aVar2.e = ((Float) c.c(c.e, Float.class, all)).floatValue();
                kVar = new k(aVar2.a(), ((Boolean) c.c(c.f, Boolean.class, all)).booleanValue(), ((Long) c.c(c.g, Long.class, all)).longValue());
            } else {
                kVar = null;
            }
        } catch (ClassCastException | IllegalArgumentException unused) {
        }
        if (kVar == null) {
            if (this.a != null) {
                this.g.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.pe.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b bVar = this.a;
                        com.google.android.libraries.navigation.internal.nw.d dVarB = e.b("PreferencesMapCameraStorage.logUe3DefaultCameraPosition");
                        try {
                            af afVar = bVar.a;
                            com.google.android.libraries.navigation.internal.kd.d dVar2 = new com.google.android.libraries.navigation.internal.kd.d();
                            dVar2.b(n.B);
                            afVar.n(dVar2.a());
                            if (dVarB != null) {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            if (dVarB != null) {
                                try {
                                    Trace.endSection();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                });
            }
            com.google.android.libraries.navigation.internal.fu.a aVar3 = this.d;
            aVar.b(p.a(aVar3 != null ? aVar3.b() : null));
            return 1;
        }
        aVar.b(kVar.a);
        com.google.android.libraries.navigation.internal.i.a aVar4 = this.e;
        com.google.android.libraries.navigation.internal.agl.a aVar5 = this.f;
        jo joVar = aVar5 != null ? (jo) aVar5.a() : null;
        long epochMilli = this.c.f().toEpochMilli();
        long j = kVar.c;
        if (aVar4 != null && aVar4.a()) {
            long j2 = b;
            if (joVar != null && (joVar.b & 8) != 0 && (i = joVar.c) >= 0) {
                j2 = i;
            }
            if (TimeUnit.MILLISECONDS.toSeconds(epochMilli - j) >= j2) {
                return 2;
            }
        }
        return kVar.b ? 2 : 3;
    }
}

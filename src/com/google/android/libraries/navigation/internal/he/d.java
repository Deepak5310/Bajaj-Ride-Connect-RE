package com.google.android.libraries.navigation.internal.he;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.afl.he;
import com.google.android.libraries.navigation.internal.afl.hg;
import com.google.android.libraries.navigation.internal.hm.o;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public com.google.android.libraries.navigation.internal.agl.a a;
    public List b;
    public ev c = null;
    private final Application d;
    private final c e;

    public d(Application application, final com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.ia.e eVar) {
        c cVar = new c(this);
        this.e = cVar;
        this.d = application;
        Objects.requireNonNull(dVar);
        this.a = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.he.a
            @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
            public final Object a() {
                return dVar.M();
            }
        };
        fz fzVar = new fz();
        fzVar.b(o.class, new e(o.class, cVar, ap.DANGEROUS_PUBLISHER_THREAD));
        eVar.c(cVar, fzVar.a());
    }

    final synchronized List a() {
        if (this.b == null) {
            hg hgVar = (hg) this.a.a();
            int i = ev.d;
            eq eqVar = new eq();
            for (he heVar : hgVar.b) {
                int i2 = heVar.b;
                b bVar = null;
                if ((i2 & 1) != 0) {
                    int i3 = heVar.c;
                    if ((i2 & 2) != 0) {
                        com.google.android.libraries.navigation.internal.adu.f fVar = heVar.d;
                        if (fVar == null) {
                            fVar = com.google.android.libraries.navigation.internal.adu.f.a;
                        }
                        Intent intent = new Intent();
                        if ((fVar.b & 1) != 0) {
                            intent.setAction(fVar.c);
                        }
                        if ((fVar.b & 2) != 0) {
                            intent.setData(Uri.parse(fVar.d));
                        }
                        if ((fVar.b & 4) != 0) {
                            intent.setComponent(ComponentName.unflattenFromString(fVar.e));
                        }
                        if ((fVar.b & 8) != 0) {
                            intent.setFlags(fVar.f);
                        }
                        if (fVar.g.size() > 0) {
                            for (com.google.android.libraries.navigation.internal.adu.e eVar : fVar.g) {
                                int i4 = eVar.b;
                                if (i4 == 2) {
                                    intent.putExtra(eVar.d, (String) eVar.c);
                                } else if (i4 == 3) {
                                    intent.putExtra(eVar.d, ((x) eVar.c).B());
                                } else if (i4 == 4) {
                                    intent.putExtra(eVar.d, ((Integer) eVar.c).intValue());
                                } else if (i4 == 5) {
                                    intent.putExtra(eVar.d, i4 == 5 ? ((Boolean) eVar.c).booleanValue() : false);
                                }
                            }
                        }
                        bVar = new b(i3, intent);
                    }
                }
                if (bVar != null) {
                    eqVar.h(bVar);
                }
            }
            this.b = eqVar.g();
        }
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized List b() {
        List<ResolveInfo> listQueryIntentActivities;
        if (this.c == null) {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("getSupportedCapabilityIds");
            try {
                List listA = a();
                Application application = this.d;
                int i = ev.d;
                eq eqVar = new eq();
                no it2 = ((ev) listA).iterator();
                while (it2.hasNext()) {
                    b bVar = (b) it2.next();
                    Intent intent = bVar.b;
                    PackageManager packageManager = application.getPackageManager();
                    if (packageManager != null && (listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0)) != null && !listQueryIntentActivities.isEmpty()) {
                        eqVar.h(Integer.valueOf(bVar.a));
                    }
                }
                this.c = eqVar.g();
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
        return this.c;
    }
}

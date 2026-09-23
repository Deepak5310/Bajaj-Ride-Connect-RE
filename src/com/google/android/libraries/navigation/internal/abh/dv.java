package com.google.android.libraries.navigation.internal.abh;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dv implements com.google.android.libraries.navigation.internal.abg.g, ge {
    public final List d;
    public final be e;
    public final com.google.android.libraries.navigation.internal.afm.d f;
    public String g;
    public String h;
    private String j;
    private final Executor i = com.google.android.libraries.navigation.internal.abf.ah.a();
    public volatile boolean a = true;
    public volatile boolean b = false;
    public volatile boolean c = false;

    public dv(be beVar, com.google.android.libraries.navigation.internal.afm.d dVar) {
        this.e = beVar;
        new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.f = dVar;
    }

    private final void e() {
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            d((ed) it2.next());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abg.g
    public final synchronized void a() {
        if (this.a) {
            this.a = false;
            com.google.android.libraries.navigation.internal.afu.v.c();
            e();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abg.g
    public final synchronized void b() {
        if (this.a) {
            return;
        }
        this.a = true;
        com.google.android.libraries.navigation.internal.afu.v.c();
        e();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ge
    public final synchronized void c(boolean z, boolean z2, String str, String str2) {
        this.b = z;
        this.c = z2;
        this.h = str;
        this.j = str2;
        com.google.android.libraries.navigation.internal.afu.v.c();
        e();
    }

    public final void d(final ed edVar) {
        String str;
        if (!this.b && !this.c && this.a) {
            Executor executor = this.i;
            Objects.requireNonNull(edVar);
            executor.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.dt
                @Override // java.lang.Runnable
                public final void run() {
                    edVar.l();
                }
            });
            return;
        }
        this.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.du
            @Override // java.lang.Runnable
            public final void run() {
                String strN;
                dv dvVar = this.a;
                if (!dvVar.a || (strN = dvVar.h) == null) {
                    if (dvVar.b) {
                        strN = dvVar.e.n(com.google.android.gms.maps.am.o);
                    } else if (dvVar.c) {
                        strN = dvVar.e.n(com.google.android.gms.maps.am.p);
                    } else {
                        if (dvVar.g == null) {
                            dvVar.g = dvVar.e.n(com.google.android.gms.maps.am.l);
                        }
                        strN = dvVar.g;
                    }
                }
                edVar.k(strN);
            }
        });
        if (!this.a || (str = this.j) == null) {
            if (this.b) {
                str = "The number of requests has exceeded the usage limits for the Google Maps SDK.";
            } else {
                str = this.c ? "The Google Maps SDK has been disabled for this application. This might be because of an incorrectly configured project, or an invalid API key. See the Google API console: https://console.developers.google.com, and information about Obtaining an API key: https://developers.google.com/maps/documentation/android-sdk/signup." : null;
            }
        }
        if (str != null) {
            com.google.android.libraries.navigation.internal.abf.p.c(str);
        }
    }
}

package com.google.android.libraries.navigation.internal.qu;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bb implements com.google.android.libraries.navigation.internal.qz.g {
    final String a;
    final be b;
    final bd c;
    final com.google.android.libraries.navigation.internal.qz.m d;
    final /* synthetic */ bg e;

    public bb(bg bgVar, String str, be beVar, bd bdVar, com.google.android.libraries.navigation.internal.qz.m mVar) {
        this.e = bgVar;
        this.a = str;
        this.b = beVar;
        this.c = bdVar;
        this.d = mVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qz.g
    public final void a(final com.google.android.libraries.navigation.internal.qz.k kVar) {
        final String str;
        int i;
        if (kVar.p()) {
            this.e.i.e.incrementAndGet();
            this.e.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.az
                @Override // java.lang.Runnable
                public final void run() {
                    bb bbVar = this.a;
                    com.google.android.libraries.navigation.internal.qz.k kVar2 = kVar;
                    com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GlobalStyleTables.handleResource");
                    try {
                        byte[] bArr = kVar2.c;
                        if (bArr != null) {
                            bbVar.b.a(bArr);
                        }
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
            return;
        }
        this.e.i.f.incrementAndGet();
        int iA = kVar.a();
        boolean zQ = false;
        if (iA == 0) {
            str = "Resource unavailable";
            i = com.google.android.libraries.navigation.internal.km.n.f;
        } else if (iA == 1) {
            zQ = this.e.q(this.a, this.d, this);
            str = "Resource server error";
            i = com.google.android.libraries.navigation.internal.km.n.g;
        } else if (iA != 2) {
            str = "Resource fetching error";
            i = com.google.android.libraries.navigation.internal.km.n.i;
        } else {
            zQ = this.e.q(this.a, this.d, this);
            str = "Resource failed";
            i = com.google.android.libraries.navigation.internal.km.n.h;
        }
        if (!zQ) {
            synchronized (this.e.g) {
                this.e.g.remove(this.a);
            }
            this.e.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.ba
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c.a(str);
                }
            });
        }
        com.google.android.libraries.navigation.internal.kk.k kVar2 = (com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.e.a.a()).a(com.google.android.libraries.navigation.internal.km.p.o);
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        kVar2.a(i2);
    }
}

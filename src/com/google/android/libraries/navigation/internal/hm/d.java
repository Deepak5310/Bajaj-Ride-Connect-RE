package com.google.android.libraries.navigation.internal.hm;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.ck;
import com.google.android.libraries.navigation.internal.afl.ha;
import com.google.android.libraries.navigation.internal.afl.hb;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends b {
    private final com.google.android.libraries.navigation.internal.afo.a c;
    private final com.google.android.libraries.navigation.internal.afo.a d;
    private volatile com.google.android.libraries.navigation.internal.fz.d e;
    private final fy f;
    private final com.google.android.libraries.navigation.internal.mj.a g;
    private final CountDownLatch b = new CountDownLatch(1);
    public com.google.android.libraries.navigation.internal.yx.an a = com.google.android.libraries.navigation.internal.yx.a.a;

    public d(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.mj.a aVar3, Set set) {
        this.c = aVar;
        this.d = aVar2;
        this.g = aVar3;
        this.f = fy.o(set);
    }

    private final com.google.android.libraries.navigation.internal.fz.d ai(final ha haVar) {
        AutoCloseable autoCloseableB;
        if (this.e != null) {
            return this.e;
        }
        br brVar = new br() { // from class: com.google.android.libraries.navigation.internal.hm.c
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                ha haVar2 = haVar;
                return com.google.android.libraries.navigation.internal.xn.a.a(com.google.android.libraries.navigation.internal.xn.a.d("ClientParametersBlockingReference.getDelegate: "), haVar2 == null ? com.google.android.libraries.navigation.internal.xn.a.d("NO_GROUP") : com.google.android.libraries.navigation.internal.xn.a.e(haVar2));
            }
        };
        if (com.google.android.libraries.navigation.internal.yr.aw.d(com.google.android.libraries.navigation.internal.yr.ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS)) {
            autoCloseableB = com.google.android.libraries.navigation.internal.yt.d.e(((com.google.android.libraries.navigation.internal.xn.a) brVar.a()).a);
        } else {
            autoCloseableB = Trace.isEnabled() ? com.google.android.libraries.navigation.internal.yt.f.b(((com.google.android.libraries.navigation.internal.xn.a) brVar.a()).a) : com.google.android.libraries.navigation.internal.yt.d.a;
        }
        try {
            boolean zI = com.google.android.libraries.navigation.internal.hx.ap.i(com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD);
            brVar.a();
            if (zI) {
                long jA = this.g.a();
                ck.b(this.b);
                this.a = com.google.android.libraries.navigation.internal.yx.an.j(Long.valueOf(this.g.a() - jA));
            } else {
                ck.b(this.b);
            }
            autoCloseableB.close();
            return this.e;
        } catch (Throwable th) {
            try {
                autoCloseableB.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fz.d
    public final hb L(ha haVar) {
        return ai(haVar).L(haVar);
    }

    @Override // com.google.android.libraries.navigation.internal.fz.d
    public final Map X() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final long Y() {
        return Z().Y();
    }

    public final com.google.android.libraries.navigation.internal.fz.d Z() {
        return ai(null);
    }

    @Override // com.google.android.libraries.navigation.internal.fz.d
    public final com.google.android.libraries.navigation.internal.fz.c a(com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        return Z().a(aaVar);
    }

    public final synchronized e aa() {
        com.google.android.libraries.navigation.internal.fz.d eVar;
        if (this.e == null) {
            ck.b(this.b);
        }
        if (this.e instanceof e) {
            eVar = this.e;
        } else {
            synchronized (this) {
                eVar = new e(Z().ac(), ab(), Y(), Z().af(), new ArrayList(Z().X().values()), this.c, this.f);
                ae(eVar);
            }
        }
        return (e) eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final com.google.android.libraries.navigation.internal.ael.x ab() {
        return Z().ab();
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final String ac() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final List ad() {
        throw null;
    }

    final synchronized void ae(com.google.android.libraries.navigation.internal.fz.d dVar) {
        this.e = dVar;
        this.b.countDown();
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final int af() {
        if (this.e != null) {
            return Z().af();
        }
        return 1;
    }

    public final synchronized boolean ag(String str, com.google.android.libraries.navigation.internal.ael.x xVar, long j, int i, List list) {
        if (this.e == null) {
            ae(new e(str, xVar, j, i, list, this.c, this.f));
            return true;
        }
        return aa().ai(str, xVar, j, i, list);
    }

    @Override // com.google.android.libraries.navigation.internal.hn.e
    public final com.google.android.libraries.navigation.internal.hp.g ah() {
        return ((e) Z()).a;
    }

    @Override // com.google.android.libraries.navigation.internal.fz.d
    public final com.google.android.libraries.navigation.internal.hn.p b() {
        return Z().b();
    }
}

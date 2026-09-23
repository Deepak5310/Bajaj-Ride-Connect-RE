package com.google.android.libraries.navigation.internal.xh;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.aer.i;
import com.google.android.libraries.navigation.internal.gg.o;
import com.google.android.libraries.navigation.internal.gg.p;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.f;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements c {
    private static final j c = j.e("com.google.android.libraries.navigation.internal.xh.e");
    public final f a;
    public ca b;
    private final Executor d;
    private final com.google.android.libraries.navigation.internal.gg.e e = new d(this);
    private final com.google.android.libraries.navigation.internal.afs.b f;

    public e(com.google.android.libraries.navigation.internal.afs.b bVar, Executor executor, f fVar) {
        this.f = bVar;
        this.d = executor;
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xh.c
    public final b a() {
        b aVar;
        synchronized (this) {
            ca caVar = this.b;
            aVar = null;
            b bVar = (caVar == null || !caVar.isDone()) ? null : (b) com.google.android.libraries.navigation.internal.ww.a.a(this.b, null);
            if (bVar == null) {
                f fVar = this.a;
                if (fVar.w(ab.bf) && fVar.w(ab.be) && fVar.w(ab.bg)) {
                    aVar = new a(fVar.y(ab.bf, false), fVar.y(ab.be, false), fVar.b(ab.bg, 0L));
                }
            } else {
                aVar = bVar;
            }
        }
        return aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xh.c
    public final bj b() {
        bj bjVarI;
        synchronized (this) {
            if (this.b == null) {
                this.b = new ca();
                this.f.a(i.a, this.e, this.d);
            }
            bjVarI = az.i(this.b);
        }
        return bjVarI;
    }

    public final void c(o oVar) {
        synchronized (this) {
            this.b.ap(new p(oVar));
            this.b = null;
        }
    }
}

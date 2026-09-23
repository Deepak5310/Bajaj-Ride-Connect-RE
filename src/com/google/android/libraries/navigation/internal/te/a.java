package com.google.android.libraries.navigation.internal.te;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.fz.d;
import com.google.android.libraries.navigation.internal.nt.m;
import com.google.android.libraries.navigation.internal.nt.p;
import com.google.android.libraries.navigation.internal.si.e;
import com.google.android.libraries.navigation.internal.sp.c;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.sp.b {
    private final d a;
    private final AtomicReference c = new AtomicReference();
    private final p b = new p(false);

    public a(d dVar) {
        this.a = dVar;
    }

    private final boolean e(e eVar) {
        if (eVar == e.GUIDED_NAV) {
            return true;
        }
        return eVar != null && this.a.b().r();
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(c cVar) {
        this.c.set(cVar.a);
        this.b.c(Boolean.valueOf(e((e) this.c.get())));
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        this.c.set(null);
        this.b.c(Boolean.valueOf(e((e) this.c.get())));
    }

    public final m c() {
        return this.b.a;
    }

    public final bj d() {
        return (this.a.b().q() || this.a.b().s()) ? az.h(Boolean.valueOf(e((e) this.c.get()))) : az.h(false);
    }
}

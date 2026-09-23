package com.google.android.libraries.navigation.internal.ox;

import com.google.android.libraries.navigation.internal.adi.af;
import com.google.android.libraries.navigation.internal.om.p;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private af a = null;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.afo.a c;
    private final br d;

    public f(final com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2) {
        this.c = aVar2;
        this.b = aVar;
        this.d = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.ox.e
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.d) ((p) aVar.a()).b()).h);
            }
        });
    }

    public final af a() {
        synchronized (this) {
            if (!((Boolean) this.d.a()).booleanValue()) {
                return ((p) this.b.a()).f();
            }
            af afVarA = this.a;
            if (afVarA == null) {
                afVarA = ((com.google.android.libraries.navigation.internal.oo.d) this.c.a()).a();
            }
            return afVarA;
        }
    }

    public final void b(af afVar) {
        synchronized (this) {
            this.a = afVar;
        }
    }
}

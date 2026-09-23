package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.adr.jg;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cd implements com.google.android.libraries.navigation.internal.sp.b {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sv.cd");
    public cb a;
    private final Executor c;
    private final ca d = new ca(this);
    private cc e;
    private long f;
    private final com.google.android.libraries.navigation.internal.sj.a g;

    public cd(com.google.android.libraries.navigation.internal.sj.a aVar, Executor executor) {
        this.g = aVar;
        this.c = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        this.g.c(this.d, this.c);
        e();
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        this.g.d(this.d);
        e();
    }

    public final com.google.android.libraries.navigation.internal.ael.x d() {
        cc ccVar = this.e;
        if (ccVar != null) {
            this.f = ccVar.b;
            this.e = null;
        }
        cb cbVar = this.a;
        if (cbVar == null) {
            return null;
        }
        return cbVar.a;
    }

    public final void e() {
        this.a = null;
        this.e = null;
        this.f = -1L;
    }

    public final void f(com.google.android.libraries.navigation.internal.ael.x xVar, long j) {
        e();
        this.a = new cb(xVar, j);
    }

    public final jg c(jg jgVar, long j) {
        if ((jgVar.b & 8) == 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1677)).p("Found traffic report without history token");
            return null;
        }
        cb cbVar = this.a;
        if ((cbVar != null && j <= cbVar.b) || j <= this.f) {
            return null;
        }
        cc ccVar = this.e;
        if (ccVar != null && j < ccVar.b) {
            return null;
        }
        if (ccVar != null && j == ccVar.b && jgVar == ccVar.a) {
            return null;
        }
        if (jgVar.h) {
            f(jgVar.g, j);
            return null;
        }
        this.e = new cc(jgVar, j);
        return jgVar;
    }
}

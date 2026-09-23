package com.google.android.libraries.navigation.internal.qq;

import com.google.android.libraries.geo.mapcore.internal.model.br;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.renderer.ea;
import com.google.android.libraries.geo.mapcore.renderer.ej;
import com.google.android.libraries.geo.mapcore.renderer.fg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class an extends h {
    private static final fg a = new fg(0, 0, 0);
    private final aq b;
    private final com.google.android.libraries.navigation.internal.rm.c c;
    private final fg e;

    public an(com.google.android.libraries.geo.mapcore.renderer.af afVar, cd cdVar, aq aqVar, com.google.android.libraries.geo.mapcore.renderer.ae aeVar, boolean z) {
        super(afVar, aeVar, cdVar.a);
        this.c = new com.google.android.libraries.navigation.internal.rm.c();
        this.b = aqVar;
        this.e = a;
        if (z) {
            x(ej.a(cdVar.b, cdVar.c, cdVar.a), 248);
        }
    }

    public static fg k(br brVar, com.google.android.libraries.geo.mapcore.internal.model.ai aiVar) {
        return new fg(aiVar.H, brVar.b(), brVar.c());
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al
    protected final float[] D(com.google.android.libraries.geo.mapcore.renderer.u uVar) {
        com.google.android.libraries.navigation.internal.rm.c cVar = this.c.b ? this.b.d : this.q;
        if (this.p || uVar.x() != this.r) {
            if (this.c.b) {
                this.o.d(this.b.a(uVar));
                aq aqVar = this.b;
                if (uVar.x() != aqVar.b) {
                    aqVar.a(uVar);
                    com.google.android.libraries.navigation.internal.rq.f.c(aqVar.d.a, uVar.G(), aqVar.c.a);
                    aqVar.d.a();
                    aqVar.b = uVar.x();
                }
                cVar = aqVar.d;
            } else {
                com.google.android.libraries.navigation.internal.rm.c cVarA = this.b.a(uVar);
                com.google.android.libraries.navigation.internal.rm.c cVar2 = this.o;
                com.google.android.libraries.navigation.internal.rm.c cVar3 = this.c;
                if (cVarA.b) {
                    cVar2.d(cVar3);
                } else if (cVar3.b) {
                    cVar2.d(cVarA);
                } else {
                    com.google.android.libraries.navigation.internal.rq.f.c(cVar2.a, cVarA.a, cVar3.a);
                    cVar2.b = false;
                }
                com.google.android.libraries.navigation.internal.rq.f.c(this.q.a, uVar.G(), this.o.a);
                this.q.a();
                cVar = this.q;
            }
            this.p = false;
            this.r = uVar.x();
        }
        return cVar.a;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final fg F() {
        return this.e;
    }

    public final void f(float f) {
        com.google.android.libraries.navigation.internal.rm.c cVar = new com.google.android.libraries.navigation.internal.rm.c();
        cVar.e();
        cVar.g(0.0f, 0.0f, f);
        if (this.s) {
            ea eaVar = ea.INVALID;
        }
        this.c.d(cVar);
        this.p = true;
    }

    public an(com.google.android.libraries.geo.mapcore.renderer.af afVar, cd cdVar, aq aqVar, fg fgVar, boolean z) {
        super(afVar, cdVar.a);
        this.c = new com.google.android.libraries.navigation.internal.rm.c();
        this.b = aqVar;
        this.e = fgVar == null ? a : fgVar;
        if (fgVar == null && (afVar instanceof com.google.android.libraries.geo.mapcore.renderer.cd)) {
            throw new IllegalArgumentException("GmmTileEntity in BaseTileDrawOrder does not specify sort values.");
        }
        if (z) {
            x(ej.a(cdVar.b, cdVar.c, cdVar.a), 248);
        }
    }
}

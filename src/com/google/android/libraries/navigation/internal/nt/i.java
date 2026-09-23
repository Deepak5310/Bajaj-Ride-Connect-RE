package com.google.android.libraries.navigation.internal.nt;

import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends o {
    private final ev b;
    private final Executor d;
    private boolean e;

    public i(br brVar, Executor executor, m... mVarArr) {
        super(brVar);
        this.e = false;
        eq eqVarJ = ev.j(2);
        for (int i = 0; i < 2; i++) {
            eqVarJ.h(new h(mVarArr[i]));
        }
        this.b = eqVarJ.g();
        this.d = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.nt.o, com.google.android.libraries.navigation.internal.nt.s
    protected final void u() {
        synchronized (this) {
            if (this.e) {
                return;
            }
            this.e = true;
            ev evVar = this.b;
            for (int i = 0; i < ((lv) evVar).c; i++) {
                h hVar = (h) evVar.get(i);
                t tVar = new t() { // from class: com.google.android.libraries.navigation.internal.nt.g
                    @Override // com.google.android.libraries.navigation.internal.nt.t
                    public final void a(m mVar) {
                        i iVar = this.a;
                        if (iVar.i()) {
                            iVar.j();
                        }
                    }
                };
                Executor executor = this.d;
                synchronized (hVar) {
                    if (hVar.b != null) {
                        throw new IllegalStateException("Cannot start already started combining observable.");
                    }
                    hVar.b = tVar;
                }
                hVar.a.f(tVar, executor);
            }
        }
    }
}

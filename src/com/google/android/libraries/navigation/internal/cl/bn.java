package com.google.android.libraries.navigation.internal.cl;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bn {
    final /* synthetic */ bo a;
    private final ga b;
    private final AtomicReference c = new AtomicReference();

    public bn(bo boVar, ga gaVar) {
        this.a = boVar;
        this.b = gaVar;
    }

    final com.google.android.libraries.navigation.internal.ol.aq a() {
        AtomicReference atomicReference;
        br brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.cl.bm
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                bn bnVar = this.a;
                return (com.google.android.libraries.navigation.internal.ol.aq) bnVar.c(bnVar.a.c);
            }
        });
        do {
            atomicReference = this.c;
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, brVarA)) {
                break;
            }
        } while (atomicReference.get() == null);
        br brVar = (br) this.c.get();
        com.google.android.libraries.navigation.internal.yx.ar.q(brVar);
        return (com.google.android.libraries.navigation.internal.ol.aq) brVar.a();
    }

    final com.google.android.libraries.navigation.internal.oo.f b() {
        return (com.google.android.libraries.navigation.internal.oo.f) c(com.google.android.libraries.navigation.internal.oj.l.a);
    }

    public final Object c(com.google.android.libraries.navigation.internal.oj.l lVar) {
        return lVar.c(this.b);
    }

    final void d() {
        br brVar = (br) this.c.getAndSet(null);
        if (brVar != null) {
            bo boVar = this.a;
            boVar.b.j((com.google.android.libraries.navigation.internal.ol.aq) brVar.a());
        }
    }
}

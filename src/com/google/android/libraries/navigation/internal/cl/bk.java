package com.google.android.libraries.navigation.internal.cl;

import android.graphics.Bitmap;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bk {
    final /* synthetic */ bo a;
    private final Bitmap b;
    private final AtomicReference c = new AtomicReference();

    public bk(bo boVar, Bitmap bitmap) {
        this.a = boVar;
        this.b = bitmap;
    }

    final com.google.android.libraries.navigation.internal.ol.aq a() {
        AtomicReference atomicReference;
        br brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.cl.bj
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                bk bkVar = this.a;
                return (com.google.android.libraries.navigation.internal.ol.aq) bkVar.c(bkVar.a.c);
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
        return lVar.f(this.b);
    }

    final void d() {
        br brVar = (br) this.c.getAndSet(null);
        if (brVar != null) {
            bo boVar = this.a;
            boVar.b.j((com.google.android.libraries.navigation.internal.ol.aq) brVar.a());
        }
    }
}

package com.google.android.libraries.navigation.internal.yq;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.s;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f extends com.google.android.libraries.navigation.internal.aac.d {
    private h a;
    private final int b;

    public f(h hVar, int i) {
        this.a = hVar;
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    public final boolean aA(bj bjVar) {
        return super.aA(bjVar);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final String ao() {
        s sVar;
        h hVar = this.a;
        if (hVar == null || (sVar = hVar.a.a) == null) {
            return null;
        }
        String strN = com.google.android.libraries.navigation.internal.b.b.n(sVar, "callable=[", "]");
        g gVar = (g) this.a.c.get();
        if (gVar == null) {
            return strN;
        }
        return strN + ", trial=[" + gVar.toString() + "]";
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final void b() {
        long j;
        int i;
        int iA;
        boolean z;
        h hVar = this.a;
        this.a = null;
        if (hVar == null) {
            return;
        }
        do {
            j = hVar.b.get();
            i = (int) j;
            iA = h.a(j);
            if (i == Integer.MIN_VALUE) {
                throw new AssertionError("Refcount is: " + j);
            }
            z = i == -2147483647;
            if (z) {
                iA++;
            }
        } while (!hVar.b.compareAndSet(j, h.b(iA, i - 1)));
        if (z) {
            while (true) {
                g gVar = (g) hVar.c.get();
                if (gVar != null) {
                    if (gVar.a <= this.b) {
                        gVar.cancel(true);
                        AtomicReference atomicReference = hVar.c;
                        while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, gVar, null)) {
                            if (atomicReference.get() != gVar) {
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
    }
}

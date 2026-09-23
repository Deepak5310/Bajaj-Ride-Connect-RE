package com.google.android.libraries.geo.navcore.service.base;

import com.google.android.libraries.navigation.internal.km.af;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements com.google.android.libraries.navigation.internal.sp.b {
    private final com.google.android.libraries.navigation.internal.afo.a a;
    private final com.google.android.libraries.navigation.internal.kk.k b;

    public o(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.kl.b bVar) {
        this.a = aVar;
        this.b = (com.google.android.libraries.navigation.internal.kk.k) bVar.a(af.A);
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        int i;
        com.google.android.libraries.navigation.internal.cw.c cVarA = ((com.google.android.libraries.navigation.internal.cw.a) this.a.a()).a();
        if (cVarA.b == com.google.android.libraries.navigation.internal.cw.b.a || cVarA.c == com.google.android.libraries.navigation.internal.cw.b.a || cVarA.a == com.google.android.libraries.navigation.internal.cw.b.a) {
            com.google.android.libraries.navigation.internal.kk.k kVar = this.b;
            int i2 = n.i;
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            }
            kVar.a(i3);
            return;
        }
        int i4 = cVarA.b;
        int i5 = com.google.android.libraries.navigation.internal.cw.b.b;
        int i6 = cVarA.c;
        int i7 = com.google.android.libraries.navigation.internal.cw.b.b;
        int i8 = cVarA.a;
        int i9 = com.google.android.libraries.navigation.internal.cw.b.b;
        if (i4 != i5) {
            if (i8 != i9) {
                i = i6 != i7 ? n.a : n.b;
            } else {
                i = i6 != i7 ? n.c : n.e;
            }
        } else if (i8 != i9) {
            i = i6 != i7 ? n.d : n.f;
        } else {
            i = i6 != i7 ? n.g : n.h;
        }
        com.google.android.libraries.navigation.internal.kk.k kVar2 = this.b;
        int i10 = i - 1;
        if (i == 0) {
            throw null;
        }
        kVar2.a(i10);
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
    }
}

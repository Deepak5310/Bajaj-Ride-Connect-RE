package com.google.android.libraries.navigation.internal.vw;

import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.xe.fg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public k(int i, Class cls, i iVar, ap apVar) {
        super(cls, iVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        if (this.f == 0) {
            ((i) this.c).a();
            return;
        }
        fg fgVar = ((i) this.c).a.w;
        if (fgVar != null) {
            fgVar.a();
        }
    }
}

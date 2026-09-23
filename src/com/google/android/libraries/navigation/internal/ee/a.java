package com.google.android.libraries.navigation.internal.ee;

import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends l {
    public ev a;

    @Override // com.google.android.libraries.navigation.internal.ee.l
    public final m a() {
        if (this.a != null) {
            return new b(this.a);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.ee.l
    public final void b(p... pVarArr) {
        this.a = ev.p(pVarArr);
    }
}

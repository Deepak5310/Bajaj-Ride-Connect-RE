package com.google.android.libraries.navigation.internal.mt;

import android.view.View;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.cr;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends b {
    private final cr c;
    private final bt d;

    public k(cr crVar, bt btVar) {
        ar.q(crVar);
        this.c = crVar;
        this.d = btVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mt.b
    protected final void a(View view) {
        this.c.b(view);
    }

    @Override // com.google.android.libraries.navigation.internal.mt.b
    protected final View c() {
        return this.c.c(this.d, null).a();
    }
}

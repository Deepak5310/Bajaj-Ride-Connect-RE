package com.google.android.libraries.navigation.internal.tq;

import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zr.cu;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final bg a;
    public final cu b;

    public a(bg bgVar) {
        this.a = bgVar;
        this.b = cu.OKAY;
    }

    public a(cu cuVar) {
        ar.k(cuVar != cu.OKAY);
        this.a = null;
        this.b = cuVar;
    }
}

package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.ex;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends bm {
    public ex a;
    public ex b;
    private com.google.android.libraries.navigation.internal.yx.an c = com.google.android.libraries.navigation.internal.yx.a.a;

    @Override // com.google.android.libraries.navigation.internal.ck.bm
    public final bn a() {
        return new f(this.c, this.a, this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bm
    public final void b(com.google.android.libraries.navigation.internal.yx.an anVar) {
        Objects.requireNonNull(anVar);
        this.c = anVar;
    }
}

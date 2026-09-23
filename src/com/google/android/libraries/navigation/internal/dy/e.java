package com.google.android.libraries.navigation.internal.dy;

import android.content.Context;
import com.google.android.libraries.navigation.internal.afr.g;
import com.google.android.libraries.navigation.internal.dx.i;
import com.google.android.libraries.navigation.internal.ht.r;
import com.google.android.libraries.navigation.internal.us.o;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements b.a {
    private final d a;

    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.dy.b.a
    public final b a(c cVar, boolean z, i iVar, Context context) {
        d dVar = this.a;
        o oVar = (o) ((g) dVar.a).a;
        ((r) dVar.b).a();
        return new b(cVar, false, iVar, context, oVar);
    }
}

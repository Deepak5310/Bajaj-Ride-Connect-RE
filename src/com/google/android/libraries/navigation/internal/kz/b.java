package com.google.android.libraries.navigation.internal.kz;

import android.content.Context;
import com.google.android.libraries.navigation.internal.ky.l;
import com.google.android.libraries.navigation.internal.ky.o;
import com.google.android.libraries.navigation.internal.ky.p;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    @Deprecated
    public b() {
        this.a = new com.google.android.libraries.navigation.internal.agl.a() { // from class: com.google.android.libraries.navigation.internal.kz.a
            @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
            public final Object a() {
                return com.google.android.libraries.navigation.internal.yx.a.a;
            }
        };
    }

    public b(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    private final void c(l lVar) {
        p pVar = (p) ((an) this.a.a()).f();
        if (pVar != null) {
            lVar.a(pVar);
        }
    }

    public final l a(Context context, String str) {
        List list = o.o;
        l lVar = new l(context, str);
        c(lVar);
        return lVar;
    }

    public final l b(Context context, String str) {
        l lVarE = o.e(context, str);
        c(lVarE);
        return lVarE;
    }
}

package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gu extends i {
    final /* synthetic */ Iterator a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.yx.as b;

    public gu(Iterator it2, com.google.android.libraries.navigation.internal.yx.as asVar) {
        this.a = it2;
        this.b = asVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.i
    protected final Object a() {
        while (this.a.hasNext()) {
            Iterator it2 = this.a;
            com.google.android.libraries.navigation.internal.yx.as asVar = this.b;
            Object next = it2.next();
            if (asVar.a(next)) {
                return next;
            }
        }
        b();
        return null;
    }
}

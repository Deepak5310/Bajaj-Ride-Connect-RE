package com.google.android.libraries.navigation.internal.lv;

import com.google.android.libraries.navigation.internal.le.ao;
import com.google.android.libraries.navigation.internal.le.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class af implements ap {
    final /* synthetic */ ag a;

    public af(ag agVar) {
        this.a = agVar;
    }

    @Override // com.google.android.libraries.navigation.internal.le.ap
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        ao aoVar;
        w wVar = this.a.a;
        synchronized (wVar) {
            wVar.b = false;
            aoVar = wVar.a.b;
        }
        if (aoVar != null) {
            wVar.c.i(aoVar, 2441);
        }
    }
}

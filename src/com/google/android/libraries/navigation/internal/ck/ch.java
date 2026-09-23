package com.google.android.libraries.navigation.internal.ck;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ch implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.aac.ca a;

    public ch(com.google.android.libraries.navigation.internal.aac.ca caVar) {
        this.a = caVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F('~')).p("A problem occurred while waiting for the MapStyles to become ready:");
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        List list = (List) obj;
        this.a.d(new ci((com.google.android.libraries.navigation.internal.ol.aq) list.get(0), (com.google.android.libraries.navigation.internal.ol.aq) list.get(1), (com.google.android.libraries.navigation.internal.ol.aq) list.get(2)));
    }
}

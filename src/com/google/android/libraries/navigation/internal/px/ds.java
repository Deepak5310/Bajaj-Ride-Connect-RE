package com.google.android.libraries.navigation.internal.px;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ds {
    private List a = new ArrayList();

    final synchronized void a() {
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            ((ai) it2.next()).D(128);
        }
        this.a = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.google.android.libraries.navigation.internal.px.ai, java.lang.Object] */
    final synchronized void b(ef efVar) {
        a();
        Iterator it2 = com.google.android.libraries.navigation.internal.yz.de.a(((v) efVar).b, com.google.android.libraries.navigation.internal.yz.de.d(((v) efVar).c).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.px.dr
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return ((eg) obj).a();
            }
        })).iterator();
        while (it2.hasNext()) {
            ?? C = ((eb) it2.next()).d().c();
            C.C(128);
            this.a.add(C);
        }
    }
}

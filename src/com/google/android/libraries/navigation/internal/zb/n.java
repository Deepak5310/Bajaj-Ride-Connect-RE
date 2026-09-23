package com.google.android.libraries.navigation.internal.zb;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n extends ac {
    public n(Class cls) {
        super("tags", cls, false);
    }

    @Override // com.google.android.libraries.navigation.internal.zb.ac
    public final /* bridge */ /* synthetic */ void b(Object obj, ab abVar) {
        com.google.android.libraries.navigation.internal.zg.h hVar = new com.google.android.libraries.navigation.internal.zg.h((com.google.android.libraries.navigation.internal.zg.i) ((com.google.android.libraries.navigation.internal.zg.l) obj).c.d);
        while (hVar.hasNext()) {
            Map.Entry entry = (Map.Entry) hVar.next();
            if (((Set) entry.getValue()).isEmpty()) {
                abVar.a((String) entry.getKey(), null);
            } else {
                Iterator it2 = ((Set) entry.getValue()).iterator();
                while (it2.hasNext()) {
                    abVar.a((String) entry.getKey(), it2.next());
                }
            }
        }
    }
}

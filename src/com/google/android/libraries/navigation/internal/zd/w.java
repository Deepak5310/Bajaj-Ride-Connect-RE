package com.google.android.libraries.navigation.internal.zd;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w implements s {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.zd.s
    public final /* synthetic */ void a(com.google.android.libraries.navigation.internal.zb.ac acVar, Iterator it2, Object obj) {
        com.google.android.libraries.navigation.internal.zj.b.b(acVar.b, "non repeating key");
        if (!acVar.c || ah.a() <= 20) {
            acVar.a(it2, obj);
        } else {
            while (it2.hasNext()) {
                obj.a(acVar.a, it2.next());
            }
        }
    }
}

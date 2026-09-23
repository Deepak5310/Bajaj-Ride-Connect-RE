package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cr {
    public final cq a;

    public cr(es esVar, Object obj, es esVar2, Object obj2) {
        this.a = new cq(esVar, obj, esVar2, obj2);
    }

    static int a(cq cqVar, Object obj, Object obj2) {
        return av.a(cqVar.a, 1, obj) + av.a(cqVar.c, 2, obj2);
    }

    static void b(ai aiVar, cq cqVar, Object obj, Object obj2) throws IOException {
        av.g(aiVar, cqVar.a, 1, obj);
        av.g(aiVar, cqVar.c, 2, obj2);
    }
}

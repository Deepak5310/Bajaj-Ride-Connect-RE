package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.jk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cb extends IllegalArgumentException {
    /* JADX WARN: Illegal instructions before constructor call */
    public cb(jk jkVar) {
        com.google.android.libraries.navigation.internal.adq.z zVar = jkVar.d;
        double d = (zVar == null ? com.google.android.libraries.navigation.internal.adq.z.a : zVar).c;
        com.google.android.libraries.navigation.internal.adq.z zVar2 = jkVar.d;
        super(d + "," + (zVar2 == null ? com.google.android.libraries.navigation.internal.adq.z.a : zVar2).d);
    }
}

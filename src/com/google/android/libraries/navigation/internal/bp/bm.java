package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.fv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bm {
    public static boolean a(fv fvVar) {
        int i = fvVar.b;
        if ((i & 2) == 0 || (i & 4) == 0) {
            return false;
        }
        com.google.android.libraries.navigation.internal.adr.ah ahVar = fvVar.d;
        if (ahVar == null) {
            ahVar = com.google.android.libraries.navigation.internal.adr.ah.a;
        }
        return ((ahVar.b & 2) == 0 || (fvVar.b & 1) == 0) ? false : true;
    }
}

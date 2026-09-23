package com.google.android.libraries.navigation.internal.eq;

import com.google.android.libraries.navigation.internal.aej.b;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends Exception {
    public a(com.google.android.libraries.navigation.internal.aei.a aVar) {
        ar.a(aVar != com.google.android.libraries.navigation.internal.aei.a.OK);
        com.google.android.libraries.navigation.internal.aej.a aVar2 = (com.google.android.libraries.navigation.internal.aej.a) b.a.q();
        int i = aVar.s;
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        b bVar = (b) aVar2.b;
        bVar.b |= 8;
        bVar.e = i;
    }

    public a(com.google.android.libraries.navigation.internal.aei.a aVar, String str) {
        super(str);
        ar.a(aVar != com.google.android.libraries.navigation.internal.aei.a.OK);
        com.google.android.libraries.navigation.internal.aej.a aVar2 = (com.google.android.libraries.navigation.internal.aej.a) b.a.q();
        int i = aVar.s;
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        b bVar = (b) aVar2.b;
        bVar.b |= 8;
        bVar.e = i;
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        b bVar2 = (b) aVar2.b;
        bVar2.b |= 4;
        bVar2.d = str;
    }

    public a(com.google.android.libraries.navigation.internal.aei.a aVar, Throwable th) {
        super(th);
        ar.a(aVar != com.google.android.libraries.navigation.internal.aei.a.OK);
        com.google.android.libraries.navigation.internal.aej.a aVar2 = (com.google.android.libraries.navigation.internal.aej.a) b.a.q();
        int i = aVar.s;
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        b bVar = (b) aVar2.b;
        bVar.b |= 8;
        bVar.e = i;
        String string = th.toString();
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        b bVar2 = (b) aVar2.b;
        string.getClass();
        bVar2.b |= 4;
        bVar2.d = string;
    }
}

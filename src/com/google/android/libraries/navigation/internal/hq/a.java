package com.google.android.libraries.navigation.internal.hq;

import com.google.android.libraries.navigation.internal.ace.bk;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class a implements Function {
    public static final com.google.android.libraries.navigation.internal.nk.d a(bk bkVar) {
        com.google.android.libraries.navigation.internal.nk.c cVar = (com.google.android.libraries.navigation.internal.nk.c) com.google.android.libraries.navigation.internal.nk.d.a.q();
        if ((bkVar.c & 4) != 0) {
            boolean z = bkVar.o;
            if (!cVar.b.H()) {
                cVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.d dVar = (com.google.android.libraries.navigation.internal.nk.d) cVar.b;
            dVar.b |= 1;
            dVar.c = z;
        }
        return (com.google.android.libraries.navigation.internal.nk.d) cVar.t();
    }

    @Override // java.util.function.Function
    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        throw null;
    }
}

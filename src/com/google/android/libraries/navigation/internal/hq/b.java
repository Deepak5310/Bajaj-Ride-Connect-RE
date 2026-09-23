package com.google.android.libraries.navigation.internal.hq;

import com.google.android.libraries.navigation.internal.afl.ci;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class b implements Function {
    public static final com.google.android.libraries.navigation.internal.nk.f a(ci ciVar) {
        com.google.android.libraries.navigation.internal.nk.e eVar = (com.google.android.libraries.navigation.internal.nk.e) com.google.android.libraries.navigation.internal.nk.f.a.q();
        if ((ciVar.b & 2) != 0) {
            int i = ciVar.c;
            if (!eVar.b.H()) {
                eVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.f fVar = (com.google.android.libraries.navigation.internal.nk.f) eVar.b;
            fVar.b |= 1;
            fVar.c = i;
        }
        if ((ciVar.b & 4) != 0) {
            int i2 = ciVar.d;
            if (!eVar.b.H()) {
                eVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.f fVar2 = (com.google.android.libraries.navigation.internal.nk.f) eVar.b;
            fVar2.b |= 2;
            fVar2.d = i2;
        }
        return (com.google.android.libraries.navigation.internal.nk.f) eVar.t();
    }

    @Override // java.util.function.Function
    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        throw null;
    }
}

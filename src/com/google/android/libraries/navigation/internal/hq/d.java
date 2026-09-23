package com.google.android.libraries.navigation.internal.hq;

import com.google.android.libraries.navigation.internal.acd.mj;
import com.google.android.libraries.navigation.internal.nk.r;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class d implements Function {
    public static final r a(mj mjVar) {
        com.google.android.libraries.navigation.internal.nk.q qVar = (com.google.android.libraries.navigation.internal.nk.q) r.a.q();
        if ((mjVar.b & 4096) != 0) {
            boolean z = mjVar.f;
            if (!qVar.b.H()) {
                qVar.v();
            }
            r rVar = (r) qVar.b;
            rVar.b |= 1;
            rVar.c = z;
        }
        if ((mjVar.b & 1024) != 0) {
            int i = mjVar.e;
            if (!qVar.b.H()) {
                qVar.v();
            }
            r rVar2 = (r) qVar.b;
            rVar2.b |= 2;
            rVar2.d = i;
        }
        if ((mjVar.b & 256) != 0) {
            String str = mjVar.c;
            if (!qVar.b.H()) {
                qVar.v();
            }
            r rVar3 = (r) qVar.b;
            str.getClass();
            rVar3.b |= 4;
            rVar3.e = str;
        }
        if ((mjVar.b & 512) != 0) {
            String str2 = mjVar.d;
            if (!qVar.b.H()) {
                qVar.v();
            }
            r rVar4 = (r) qVar.b;
            str2.getClass();
            rVar4.b |= 8;
            rVar4.f = str2;
        }
        if ((mjVar.b & 268435456) != 0) {
            boolean z2 = mjVar.h;
            if (!qVar.b.H()) {
                qVar.v();
            }
            r rVar5 = (r) qVar.b;
            rVar5.b |= 16;
            rVar5.g = z2;
        }
        return (r) qVar.t();
    }

    @Override // java.util.function.Function
    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        throw null;
    }
}

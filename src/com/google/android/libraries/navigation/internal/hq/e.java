package com.google.android.libraries.navigation.internal.hq;

import com.google.android.libraries.navigation.internal.ace.kx;
import com.google.android.libraries.navigation.internal.nk.u;
import com.google.android.libraries.navigation.internal.nk.v;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class e implements Function {
    public static final v a(kx kxVar) {
        u uVar = (u) v.a.q();
        if ((kxVar.c & 8) != 0) {
            boolean z = kxVar.g;
            if (!uVar.b.H()) {
                uVar.v();
            }
            v vVar = (v) uVar.b;
            vVar.b |= 1;
            vVar.c = z;
        }
        if ((kxVar.c & 2097152) != 0) {
            boolean z2 = kxVar.m;
            if (!uVar.b.H()) {
                uVar.v();
            }
            v vVar2 = (v) uVar.b;
            vVar2.b |= 2;
            vVar2.d = z2;
        }
        if ((kxVar.c & 128) != 0) {
            boolean z3 = kxVar.i;
            if (!uVar.b.H()) {
                uVar.v();
            }
            v vVar3 = (v) uVar.b;
            vVar3.b |= 4;
            vVar3.e = z3;
        }
        if ((kxVar.c & 16) != 0) {
            boolean z4 = kxVar.h;
            if (!uVar.b.H()) {
                uVar.v();
            }
            v vVar4 = (v) uVar.b;
            vVar4.b |= 8;
            vVar4.f = z4;
        }
        if ((kxVar.b & 4) != 0) {
            boolean z5 = kxVar.d;
            if (!uVar.b.H()) {
                uVar.v();
            }
            v vVar5 = (v) uVar.b;
            vVar5.b |= 16;
            vVar5.g = z5;
        }
        if ((kxVar.b & 8) != 0) {
            boolean z6 = kxVar.e;
            if (!uVar.b.H()) {
                uVar.v();
            }
            v vVar6 = (v) uVar.b;
            vVar6.b |= 32;
            vVar6.h = z6;
        }
        if ((kxVar.b & 16) != 0) {
            boolean z7 = kxVar.f;
            if (!uVar.b.H()) {
                uVar.v();
            }
            v vVar7 = (v) uVar.b;
            vVar7.b |= 64;
            vVar7.i = z7;
        }
        if ((kxVar.c & 8192) != 0) {
            boolean z8 = kxVar.j;
            if (!uVar.b.H()) {
                uVar.v();
            }
            v vVar8 = (v) uVar.b;
            vVar8.b |= 128;
            vVar8.j = z8;
        }
        if ((kxVar.c & 16384) != 0) {
            boolean z9 = kxVar.k;
            if (!uVar.b.H()) {
                uVar.v();
            }
            v vVar9 = (v) uVar.b;
            vVar9.b |= 256;
            vVar9.k = z9;
        }
        return (v) uVar.t();
    }

    @Override // java.util.function.Function
    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        throw null;
    }
}

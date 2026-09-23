package com.google.android.libraries.navigation.internal.ael;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dn {
    public final ArrayDeque a = new ArrayDeque();

    private static final int b(int i) {
        int iBinarySearch = Arrays.binarySearch(dq.a, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    public final void a(x xVar) {
        if (!xVar.h()) {
            if (!(xVar instanceof dq)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(xVar.getClass()))));
            }
            dq dqVar = (dq) xVar;
            int i = dq.h;
            a(dqVar.e);
            a(dqVar.f);
            return;
        }
        int iB = b(xVar.d());
        ArrayDeque arrayDeque = this.a;
        int iC = dq.c(iB + 1);
        if (arrayDeque.isEmpty() || ((x) this.a.peek()).d() >= iC) {
            this.a.push(xVar);
            return;
        }
        int iC2 = dq.c(iB);
        x dqVar2 = (x) this.a.pop();
        while (!this.a.isEmpty() && ((x) this.a.peek()).d() < iC2) {
            dqVar2 = new dq((x) this.a.pop(), dqVar2);
        }
        dq dqVar3 = new dq(dqVar2, xVar);
        while (!this.a.isEmpty()) {
            int iB2 = b(dqVar3.d) + 1;
            ArrayDeque arrayDeque2 = this.a;
            if (((x) arrayDeque2.peek()).d() >= dq.c(iB2)) {
                break;
            } else {
                dqVar3 = new dq((x) this.a.pop(), dqVar3);
            }
        }
        this.a.push(dqVar3);
    }
}

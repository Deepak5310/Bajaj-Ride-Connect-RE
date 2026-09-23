package com.google.android.libraries.navigation.internal.tg;

import com.google.android.libraries.navigation.internal.zr.j;
import com.google.android.libraries.navigation.internal.zr.k;
import com.google.android.libraries.navigation.internal.zr.l;
import com.google.android.libraries.navigation.internal.zr.m;
import com.google.android.libraries.navigation.internal.zr.n;
import com.google.android.libraries.navigation.internal.zr.p;
import com.google.android.libraries.navigation.internal.zr.q;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static q a(q qVar) {
        j jVar = (j) q.a.q();
        if ((qVar.b & 1) != 0) {
            int iA = p.a(qVar.c);
            if (iA == 0) {
                iA = p.a;
            }
            if (!jVar.b.H()) {
                jVar.v();
            }
            q qVar2 = (q) jVar.b;
            int i = iA - 1;
            if (iA == 0) {
                throw null;
            }
            qVar2.c = i;
            qVar2.b |= 1;
        }
        if ((qVar.b & 2) != 0) {
            m mVar = (m) n.a.q();
            n nVar = qVar.d;
            if (nVar == null) {
                nVar = n.a;
            }
            if ((nVar.b & 1) != 0) {
                n nVar2 = qVar.d;
                if (nVar2 == null) {
                    nVar2 = n.a;
                }
                String str = nVar2.c;
                if (!mVar.b.H()) {
                    mVar.v();
                }
                n nVar3 = (n) mVar.b;
                str.getClass();
                nVar3.b |= 1;
                nVar3.c = str;
            }
            n nVar4 = qVar.d;
            if (nVar4 == null) {
                nVar4 = n.a;
            }
            if ((nVar4.b & 2) != 0) {
                n nVar5 = qVar.d;
                if (nVar5 == null) {
                    nVar5 = n.a;
                }
                String str2 = nVar5.d;
                if (!mVar.b.H()) {
                    mVar.v();
                }
                n nVar6 = (n) mVar.b;
                str2.getClass();
                nVar6.b |= 2;
                nVar6.d = str2;
            }
            if (!jVar.b.H()) {
                jVar.v();
            }
            q qVar3 = (q) jVar.b;
            n nVar7 = (n) mVar.t();
            nVar7.getClass();
            qVar3.d = nVar7;
            qVar3.b |= 2;
        }
        if ((qVar.b & 4) != 0) {
            k kVar = (k) l.a.q();
            l lVar = qVar.e;
            if (lVar == null) {
                lVar = l.a;
            }
            if ((lVar.b & 1) != 0) {
                l lVar2 = qVar.e;
                if (lVar2 == null) {
                    lVar2 = l.a;
                }
                String str3 = lVar2.c;
                if (!kVar.b.H()) {
                    kVar.v();
                }
                l lVar3 = (l) kVar.b;
                str3.getClass();
                lVar3.b |= 1;
                lVar3.c = str3;
            }
            l lVar4 = qVar.e;
            if (lVar4 == null) {
                lVar4 = l.a;
            }
            if ((lVar4.b & 2) != 0) {
                l lVar5 = qVar.e;
                if (lVar5 == null) {
                    lVar5 = l.a;
                }
                String str4 = lVar5.d;
                if (!kVar.b.H()) {
                    kVar.v();
                }
                l lVar6 = (l) kVar.b;
                str4.getClass();
                lVar6.b |= 2;
                lVar6.d = str4;
            }
            l lVar7 = qVar.e;
            if (lVar7 == null) {
                lVar7 = l.a;
            }
            if ((lVar7.b & 4) != 0) {
                l lVar8 = qVar.e;
                if (lVar8 == null) {
                    lVar8 = l.a;
                }
                String str5 = lVar8.e;
                if (!kVar.b.H()) {
                    kVar.v();
                }
                l lVar9 = (l) kVar.b;
                str5.getClass();
                lVar9.b |= 4;
                lVar9.e = str5;
            }
            if (!jVar.b.H()) {
                jVar.v();
            }
            q qVar4 = (q) jVar.b;
            l lVar10 = (l) kVar.t();
            lVar10.getClass();
            qVar4.e = lVar10;
            qVar4.b |= 4;
        }
        return (q) jVar.t();
    }
}

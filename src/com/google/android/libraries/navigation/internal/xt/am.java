package com.google.android.libraries.navigation.internal.xt;

import com.google.android.libraries.navigation.internal.ael.cs;
import java.util.Collections;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am {
    public static final /* synthetic */ int a = 0;
    private static final com.google.android.libraries.navigation.internal.yk.b b = new com.google.android.libraries.navigation.internal.yk.b(e.a);
    private static final Object c = new Object();
    private static volatile com.google.android.libraries.navigation.internal.yh.p d = null;

    static com.google.android.libraries.navigation.internal.aac.bj a(com.google.android.libraries.navigation.internal.xo.y yVar, final String str, String str2) {
        com.google.android.libraries.navigation.internal.yh.l lVarH = com.google.android.libraries.navigation.internal.yh.m.h();
        Pattern pattern = com.google.android.libraries.navigation.internal.xz.g.a;
        com.google.android.libraries.navigation.internal.xz.f fVar = new com.google.android.libraries.navigation.internal.xz.f(yVar.d);
        fVar.b("phenotype");
        fVar.c("all_accounts.pb");
        lVarH.d(fVar.a());
        lVarH.c(e.a);
        ((com.google.android.libraries.navigation.internal.yh.a) lVarH).a = com.google.android.libraries.navigation.internal.yx.an.j(b);
        lVarH.b();
        com.google.android.libraries.navigation.internal.yh.m mVarA = lVarH.a();
        com.google.android.libraries.navigation.internal.yh.p pVarA = d;
        if (pVarA == null) {
            synchronized (c) {
                pVarA = d;
                if (pVarA == null) {
                    com.google.android.libraries.navigation.internal.yh.q qVar = new com.google.android.libraries.navigation.internal.yh.q();
                    qVar.a = yVar.d();
                    qVar.b = yVar.c();
                    qVar.b(com.google.android.libraries.navigation.internal.yh.ac.a);
                    pVarA = qVar.a();
                    d = pVarA;
                }
            }
        }
        final String str3 = "";
        return pVarA.a(mVarA).b(new com.google.android.libraries.navigation.internal.yx.aa(str, str3) { // from class: com.google.android.libraries.navigation.internal.xt.al
            public final /* synthetic */ String a;
            public final /* synthetic */ String b = "";

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                e eVar = (e) obj;
                int i = am.a;
                b bVar = b.a;
                cs csVar = eVar.b;
                String str4 = this.a;
                if (csVar.containsKey(str4)) {
                    bVar = (b) csVar.get(str4);
                }
                String str5 = this.b;
                com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) bVar.aH(5, null);
                bbVar.x(bVar);
                a aVar = (a) bbVar;
                if (!Collections.unmodifiableList(((b) aVar.b).c).contains(str5)) {
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    b bVar2 = (b) aVar.b;
                    com.google.android.libraries.navigation.internal.ael.bz bzVar = bVar2.c;
                    if (!bzVar.c()) {
                        bVar2.c = com.google.android.libraries.navigation.internal.ael.bi.A(bzVar);
                    }
                    bVar2.c.add(str5);
                }
                com.google.android.libraries.navigation.internal.ael.bb bbVar2 = (com.google.android.libraries.navigation.internal.ael.bb) eVar.aH(5, null);
                bbVar2.x(eVar);
                d dVar = (d) bbVar2;
                if (!aVar.b.H()) {
                    aVar.v();
                }
                b bVar3 = (b) aVar.b;
                bVar3.b |= 1;
                bVar3.d = str5;
                b bVar4 = (b) aVar.t();
                bVar4.getClass();
                if (!dVar.b.H()) {
                    dVar.v();
                }
                e eVar2 = (e) dVar.b;
                cs csVar2 = eVar2.b;
                if (!csVar2.b) {
                    eVar2.b = csVar2.a();
                }
                eVar2.b.put(str4, bVar4);
                return (e) dVar.t();
            }
        }, yVar.d());
    }
}

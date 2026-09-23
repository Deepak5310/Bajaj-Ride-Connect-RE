package com.google.android.libraries.navigation.internal.uy;

import com.google.android.apps.gmm.base.components.gmmrecyclerview.GmmRecyclerView;
import com.google.android.libraries.navigation.internal.ms.ah;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac extends bt<com.google.android.libraries.navigation.internal.va.c> implements com.google.android.libraries.navigation.internal.yt.e {
    public static final /* synthetic */ int a = 0;
    private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("StepListLayout");

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        dd ddVar = new dd() { // from class: com.google.android.libraries.navigation.internal.uy.ab
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.va.c cVar = (com.google.android.libraries.navigation.internal.va.c) csVar;
                int i = ac.a;
                int i2 = ev.d;
                eq eqVar = new eq();
                List<? extends com.google.android.libraries.navigation.internal.va.a> listA = cVar.a();
                if (listA.isEmpty()) {
                    return eqVar.g();
                }
                List<? extends com.google.android.libraries.navigation.internal.va.b> listF = listA.get(0).f();
                for (int i3 = 0; i3 < listF.size(); i3++) {
                    if (i3 == 0) {
                        com.google.android.libraries.navigation.internal.uk.a aVarB = cVar.b();
                        if (aVarB != null) {
                            eqVar.h(ah.a(new z(), aVarB));
                        }
                    } else {
                        com.google.android.libraries.navigation.internal.va.b bVar = listF.get(i3);
                        eqVar.h(ah.a(new m(), bVar));
                        eqVar.h(ah.a(new aa(), bVar));
                    }
                }
                for (int i4 = 1; i4 < listA.size(); i4++) {
                    com.google.android.libraries.navigation.internal.va.a aVar = listA.get(i4);
                    List<? extends com.google.android.libraries.navigation.internal.va.b> listF2 = aVar.f();
                    int i5 = 0;
                    while (i5 < listF2.size()) {
                        com.google.android.libraries.navigation.internal.va.b bVar2 = listF2.get(i5);
                        if (i5 == 0) {
                            if (!aVar.c().booleanValue()) {
                                eqVar.h(ah.a(new l(), aVar));
                            }
                            i5 = 0;
                        }
                        if (aVar.c().booleanValue()) {
                            eqVar.h(ah.a(new m(), bVar2));
                            eqVar.h(ah.a(new aa(), bVar2));
                        }
                        i5++;
                    }
                }
                return eqVar.g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        int i = com.google.android.libraries.navigation.internal.w.d.a;
        return GmmRecyclerView.a(ddVar, ah.p(com.google.android.libraries.navigation.internal.m.b.c(com.google.android.libraries.navigation.internal.w.b.b(), com.google.android.libraries.navigation.internal.ju.b.k, com.google.android.libraries.navigation.internal.m.b.b)), ah.aG(false), ch.e(com.google.android.libraries.navigation.internal.ms.e.DIVIDER, null), ah.T(-2), ah.ag(-1), ch.e(com.google.android.libraries.navigation.internal.mz.b.ITEM_ANIMATOR, null));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return b;
    }
}

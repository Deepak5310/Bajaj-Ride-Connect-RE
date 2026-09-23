package com.google.android.libraries.navigation.internal.yh;

import com.google.android.libraries.navigation.internal.aac.ax;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.google.android.libraries.navigation.internal.aac.t {
    public final List a;
    public final Executor b;

    public j(List list, Executor executor) {
        this.a = list;
        this.b = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.t
    public final /* bridge */ /* synthetic */ bj a(Object obj) throws Exception {
        ar arVar = (ar) obj;
        final int i = ((lv) this.a).c;
        final ArrayList arrayList = new ArrayList(i);
        no it2 = ((ev) this.a).iterator();
        while (it2.hasNext()) {
            arrayList.add(((e) it2.next()).b());
        }
        return com.google.android.libraries.navigation.internal.aac.j.i(arVar.a(com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.h
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj2) {
                final cy cyVar = (cy) obj2;
                final List list = arrayList;
                ax axVar = new ax(false, ev.n(list));
                final j jVar = this.a;
                final int i2 = i;
                return new com.google.android.libraries.navigation.internal.aac.ab(axVar.b, axVar.a, jVar.b, com.google.android.libraries.navigation.internal.yr.am.c(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.yh.g
                    @Override // com.google.android.libraries.navigation.internal.aac.s
                    public final bj a() {
                        bj bjVarH = az.h(cyVar);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if (((Boolean) az.n((Future) list.get(i3))).booleanValue()) {
                                final e eVar = (e) jVar.a.get(i3);
                                bjVarH = com.google.android.libraries.navigation.internal.aac.j.i(bjVarH, com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.f
                                    @Override // com.google.android.libraries.navigation.internal.aac.t
                                    public final bj a(Object obj3) {
                                        return eVar.c();
                                    }
                                }), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                            }
                        }
                        return bjVarH;
                    }
                }));
            }
        }), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE), com.google.android.libraries.navigation.internal.yr.am.d(new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.i
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj2) {
                int i2 = i;
                ArrayList arrayList2 = new ArrayList(i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    if (((Boolean) az.n((Future) arrayList.get(i3))).booleanValue()) {
                        arrayList2.add(((e) this.a.a.get(i3)).a());
                    }
                }
                return az.b(arrayList2).a(new com.google.android.libraries.navigation.internal.aac.u(), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            }
        }), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
    }
}

package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.hg;
import com.google.android.libraries.navigation.internal.adg.ho;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class de extends com.google.android.libraries.navigation.internal.yy.j {
    final /* synthetic */ dg a;

    public de(dg dgVar) {
        this.a = dgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.j
    public final /* bridge */ /* synthetic */ Object a(Object obj) throws Exception {
        df dfVar;
        final hg hgVar = (hg) obj;
        com.google.android.libraries.navigation.internal.adg.df dfVar2 = hgVar.d;
        if (dfVar2 == null) {
            dfVar2 = com.google.android.libraries.navigation.internal.adg.df.a;
        }
        com.google.android.libraries.navigation.internal.adg.dh dhVar = dfVar2.d;
        if (dhVar == null) {
            dhVar = com.google.android.libraries.navigation.internal.adg.dh.a;
        }
        dg dgVar = this.a;
        final com.google.android.libraries.navigation.internal.yx.an anVarA = di.a(dhVar.b, dgVar.c);
        String str = (String) dgVar.a.b(hgVar, new Callable() { // from class: com.google.android.libraries.navigation.internal.px.db
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return di.b(hgVar, anVarA);
            }
        });
        com.google.android.libraries.navigation.internal.adg.df dfVar3 = hgVar.d;
        if (dfVar3 == null) {
            dfVar3 = com.google.android.libraries.navigation.internal.adg.df.a;
        }
        if (dgVar.b.contains(Integer.valueOf(dfVar3.c))) {
            com.google.android.libraries.navigation.internal.adg.df dfVar4 = hgVar.d;
            if (dfVar4 == null) {
                dfVar4 = com.google.android.libraries.navigation.internal.adg.df.a;
            }
            int i = dfVar4.c;
            dfVar = new df();
        } else {
            ho hoVar = hgVar.c;
            if (hoVar == null) {
                hoVar = ho.a;
            }
            dfVar = di.d(hoVar.c, dgVar.c) ? new df() : df.a(anVarA, str);
        }
        return com.google.android.libraries.navigation.internal.yx.an.i(dfVar);
    }
}

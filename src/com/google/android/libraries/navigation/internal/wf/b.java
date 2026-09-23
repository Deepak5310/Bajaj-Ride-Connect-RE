package com.google.android.libraries.navigation.internal.wf;

import com.google.android.libraries.navigation.internal.add.al;
import com.google.android.libraries.navigation.internal.add.am;
import com.google.android.libraries.navigation.internal.add.an;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.rz.x;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class b extends com.google.android.libraries.navigation.internal.yx.v {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.yx.v
    protected final /* bridge */ /* synthetic */ Object b(Object obj) {
        am amVar = (am) an.a.q();
        ev evVarA = ((x) obj).a();
        int i = ((lv) evVarA).c;
        for (int i2 = 0; i2 < i; i2++) {
            al alVar = (al) p.a.c((com.google.android.libraries.navigation.internal.rz.v) evVarA.get(i2));
            if (!amVar.b.H()) {
                amVar.v();
            }
            an anVar = (an) amVar.b;
            alVar.getClass();
            bz bzVar = anVar.b;
            if (!bzVar.c()) {
                anVar.b = bi.A(bzVar);
            }
            anVar.b.add(alVar);
        }
        return (an) amVar.t();
    }
}

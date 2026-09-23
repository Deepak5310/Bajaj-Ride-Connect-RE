package com.google.android.libraries.navigation.internal.wf;

import com.google.android.libraries.navigation.internal.add.ah;
import com.google.android.libraries.navigation.internal.add.ak;
import com.google.android.libraries.navigation.internal.add.al;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.rz.ab;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class a extends com.google.android.libraries.navigation.internal.yx.v {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.yx.v
    protected final /* bridge */ /* synthetic */ Object b(Object obj) {
        ah ahVar = (ah) al.a.q();
        ev evVarA = ((com.google.android.libraries.navigation.internal.rz.v) obj).a();
        int i = ((lv) evVarA).c;
        for (int i2 = 0; i2 < i; i2++) {
            ak akVar = (ak) o.a.c((ab) evVarA.get(i2));
            if (!ahVar.b.H()) {
                ahVar.v();
            }
            al alVar = (al) ahVar.b;
            akVar.getClass();
            bz bzVar = alVar.b;
            if (!bzVar.c()) {
                alVar.b = bi.A(bzVar);
            }
            alVar.b.add(akVar);
        }
        return (al) ahVar.t();
    }
}

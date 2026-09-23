package com.google.android.libraries.navigation.internal.aac;

import com.google.android.libraries.navigation.internal.yz.ek;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends x {
    public v(ek ekVar, boolean z) {
        super(ekVar, z);
        q();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.x
    public final /* bridge */ /* synthetic */ Object t(List list) {
        ArrayList arrayListE = hx.e(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            w wVar = (w) it2.next();
            arrayListE.add(wVar != null ? wVar.a : null);
        }
        return Collections.unmodifiableList(arrayListE);
    }
}

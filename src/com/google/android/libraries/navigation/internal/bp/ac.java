package com.google.android.libraries.navigation.internal.bp;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ac {
    public static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bp.ac");

    public static ac b(List list) {
        ac acVar = (ac) list.get(0);
        int i = 1;
        while (i < list.size()) {
            ac acVar2 = (ac) list.get(i);
            z zVar = null;
            if (acVar != null && acVar2 != null) {
                ArrayList arrayList = new ArrayList();
                aa.a(acVar, arrayList);
                aa.a(acVar2, arrayList);
                zVar = new z((ac[]) arrayList.toArray(new ac[0]));
            }
            i++;
            if (zVar != null) {
                acVar = zVar;
            }
        }
        return acVar;
    }

    public boolean a() {
        return false;
    }
}

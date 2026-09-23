package com.google.android.libraries.navigation.internal.wp;

import com.google.android.libraries.navigation.internal.add.aw;
import com.google.android.libraries.navigation.internal.ade.p;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final String a(aw awVar) {
        String strConcat = "";
        if ((awVar.b & 1) != 0) {
            p pVar = awVar.c;
            if (pVar == null) {
                pVar = p.a;
            }
            strConcat = "".concat(String.valueOf(pVar.b));
        }
        Iterator it2 = awVar.d.iterator();
        while (it2.hasNext()) {
            strConcat = strConcat.concat(String.valueOf(((p) it2.next()).b));
        }
        return Integer.toString(strConcat.hashCode());
    }
}

package com.google.android.libraries.navigation.internal.ye;

import com.google.android.libraries.navigation.internal.yz.gs;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.xy.e {
    public static final InputStream b(com.google.android.libraries.navigation.internal.xy.d dVar) throws IOException {
        InputStream inputStreamD = dVar.a.d(dVar.e);
        ArrayList arrayList = new ArrayList();
        arrayList.add(inputStreamD);
        if (!dVar.c.isEmpty()) {
            List list = dVar.c;
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                com.google.android.libraries.navigation.internal.yf.c cVarA = ((com.google.android.libraries.navigation.internal.yf.e) it2.next()).a();
                if (cVarA != null) {
                    arrayList2.add(cVarA);
                }
            }
            com.google.android.libraries.navigation.internal.xy.a aVar = !arrayList2.isEmpty() ? new com.google.android.libraries.navigation.internal.xy.a(inputStreamD, arrayList2) : null;
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        for (com.google.android.libraries.navigation.internal.yg.a aVar2 : dVar.b) {
            arrayList.add(com.google.android.libraries.navigation.internal.yg.a.c((InputStream) gs.d(arrayList)));
        }
        Collections.reverse(arrayList);
        return (InputStream) arrayList.get(0);
    }

    @Override // com.google.android.libraries.navigation.internal.xy.e
    public final /* bridge */ /* synthetic */ Object a(com.google.android.libraries.navigation.internal.xy.d dVar) throws IOException {
        return b(dVar);
    }
}

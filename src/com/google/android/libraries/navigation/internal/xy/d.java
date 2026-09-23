package com.google.android.libraries.navigation.internal.xy;

import android.net.Uri;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final com.google.android.libraries.navigation.internal.yf.a a;
    public final List b;
    public final List c;
    public final Uri d;
    public final Uri e;

    public d(c cVar) {
        this.a = cVar.b;
        this.b = cVar.c;
        this.c = cVar.d;
        this.d = cVar.e;
        this.e = cVar.f;
    }

    public final List a(OutputStream outputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(outputStream);
        if (!this.c.isEmpty()) {
            List list = this.c;
            int i = b.a;
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                com.google.android.libraries.navigation.internal.yf.d dVarB = ((com.google.android.libraries.navigation.internal.yf.e) it2.next()).b();
                if (dVarB != null) {
                    arrayList2.add(dVarB);
                }
            }
            b bVar = !arrayList2.isEmpty() ? new b(outputStream, arrayList2) : null;
            if (bVar != null) {
                arrayList.add(bVar);
            }
        }
        for (com.google.android.libraries.navigation.internal.yg.a aVar : this.b) {
            arrayList.add(com.google.android.libraries.navigation.internal.yg.a.d((OutputStream) gs.d(arrayList)));
        }
        Collections.reverse(arrayList);
        return arrayList;
    }
}

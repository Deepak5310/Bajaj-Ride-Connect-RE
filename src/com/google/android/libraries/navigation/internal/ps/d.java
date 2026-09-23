package com.google.android.libraries.navigation.internal.ps;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements f {
    final /* synthetic */ boolean a;
    final /* synthetic */ h b;
    private List c = null;

    public d(h hVar, boolean z) {
        this.a = z;
        this.b = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ps.f
    public final void a(cd cdVar, int i, Collection collection) {
        List listO;
        if (i == 0 && collection != null) {
            this.b.a.m(cdVar, collection);
            this.b.a(collection);
        }
        synchronized (this.b) {
            if (this.a && i == 2) {
                listO = this.c;
                if (listO == null) {
                    listO = (List) this.b.e.get(cdVar);
                }
                if (listO != null) {
                    listO = ev.o(listO);
                }
            } else {
                if (this.c == null) {
                    this.c = (List) this.b.e.remove(cdVar);
                }
                listO = this.c;
            }
        }
        if (listO != null) {
            Iterator it2 = listO.iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).a(cdVar, i, collection);
            }
        }
    }
}

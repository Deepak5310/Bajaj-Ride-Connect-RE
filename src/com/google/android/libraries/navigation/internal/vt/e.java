package com.google.android.libraries.navigation.internal.vt;

import android.location.Location;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.db.s;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.ia.k;
import com.google.android.libraries.navigation.internal.km.l;
import com.google.android.libraries.navigation.internal.xe.fw;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends k {
    private final int f;

    public e(int i, Class cls, c cVar, ap apVar) {
        super(cls, cVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        int i = this.f;
        if (i == 0) {
            c cVar = (c) this.c;
            s sVar = (s) aVar;
            synchronized (cVar.c) {
                r rVarD = sVar.d();
                if (rVarD != null) {
                    Iterator it2 = cVar.c.a.iterator();
                    while (it2.hasNext()) {
                        ((fw) it2.next()).b(rVarD);
                    }
                }
            }
            return;
        }
        if (i == 1) {
            c cVar2 = (c) this.c;
            com.google.android.libraries.navigation.internal.dh.a aVar2 = (com.google.android.libraries.navigation.internal.dh.a) aVar;
            synchronized (cVar2.c) {
                int i2 = l.a;
                int i3 = com.google.android.libraries.navigation.internal.fp.a.a;
                Location location = aVar2.a;
                if (location != null) {
                    Iterator it3 = cVar2.c.a.iterator();
                    while (it3.hasNext()) {
                        ((fw) it3.next()).c(location);
                    }
                }
            }
            return;
        }
        c cVar3 = (c) this.c;
        com.google.android.libraries.navigation.internal.cw.d dVar = (com.google.android.libraries.navigation.internal.cw.d) aVar;
        synchronized (cVar3.c) {
            boolean z = dVar.c;
            if (!cVar3.a) {
                if (dVar.c) {
                    cVar3.a = true;
                    cVar3.b = true;
                }
            } else {
                boolean z2 = dVar.c;
                if (z2 != cVar3.b) {
                    cVar3.b = z2;
                    Iterator it4 = cVar3.c.a.iterator();
                    while (it4.hasNext()) {
                        ((fw) it4.next()).a(dVar.c);
                    }
                }
            }
        }
    }
}

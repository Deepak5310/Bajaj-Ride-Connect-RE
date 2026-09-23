package com.google.android.libraries.navigation.internal.in;

import com.google.android.libraries.navigation.internal.ace.kx;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.f;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.nn;
import com.google.android.libraries.navigation.internal.zr.bu;
import com.google.android.libraries.navigation.internal.zr.dr;
import com.google.android.libraries.navigation.internal.zr.ds;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public ds a;
    public final ds b;
    private final com.google.android.libraries.navigation.internal.xu.c c;
    private final com.google.android.libraries.navigation.internal.afo.a d;
    private final com.google.android.libraries.navigation.internal.afo.a e;
    private final AtomicBoolean f = new AtomicBoolean(false);

    public b(com.google.android.libraries.navigation.internal.xu.c cVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2) {
        this.c = cVar;
        this.d = aVar;
        this.e = aVar2;
        ds dsVar = cVar.a() ? (ds) ((f) aVar.a()).f(ab.Q, (dg) ds.a.aH(7, null), null) : null;
        ds dsVar2 = cVar.a() ? (ds) ((f) aVar.a()).f(ab.R, (dg) ds.a.aH(7, null), null) : null;
        if (dsVar == null || dsVar2 == null) {
            this.b = dsVar == null ? dsVar2 : dsVar;
        } else {
            this.b = c(dsVar, dsVar2);
        }
        this.a = dsVar2 == null ? ds.a : dsVar2;
    }

    private static fd b(ds dsVar) {
        return de.d(dsVar.b).g(new aa() { // from class: com.google.android.libraries.navigation.internal.in.a
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return Integer.valueOf(((bu) obj).b);
            }
        });
    }

    private static ds c(ds dsVar, ds dsVar2) {
        fd fdVarB = b(dsVar);
        fd fdVarB2 = b(dsVar2);
        dr drVar = (dr) ds.a.q();
        nn nnVarListIterator = fdVarB.entrySet().listIterator();
        while (nnVarListIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) nnVarListIterator.next();
            if (fdVarB2.containsKey(entry.getKey())) {
                bu buVar = (bu) fdVarB2.get(entry.getKey());
                if (buVar.c >= ((bu) entry.getValue()).c) {
                    drVar.a(buVar);
                } else {
                    drVar.a((bu) entry.getValue());
                }
            } else {
                drVar.a((bu) entry.getValue());
            }
        }
        nn nnVarListIterator2 = fdVarB2.entrySet().listIterator();
        while (nnVarListIterator2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) nnVarListIterator2.next();
            if (!fdVarB.containsKey(entry2.getKey())) {
                drVar.a((bu) entry2.getValue());
            }
        }
        return (ds) drVar.t();
    }

    public final synchronized void a(ds dsVar) {
        this.a = c(this.a, dsVar);
        if (this.c.a() && (!((kx) ((Optional) this.e.a()).orElse(kx.a)).l || this.f.get())) {
            ((f) this.d.a()).s(ab.Q, this.a);
        }
        if (this.c.a()) {
            dr drVar = (dr) ds.a.q();
            for (bu buVar : this.a.b) {
                if (buVar.d) {
                    drVar.a(buVar);
                }
            }
            ((f) this.d.a()).s(ab.R, ((ds) drVar.b).b.size() == 0 ? null : drVar.t());
        }
    }
}

package com.google.android.libraries.navigation.internal.agb;

import com.google.android.libraries.navigation.internal.afx.aq;
import com.google.android.libraries.navigation.internal.afx.ar;
import com.google.android.libraries.navigation.internal.afx.as;
import com.google.android.libraries.navigation.internal.afx.au;
import com.google.android.libraries.navigation.internal.afx.av;
import com.google.android.libraries.navigation.internal.afx.az;
import com.google.android.libraries.navigation.internal.afx.ba;
import com.google.android.libraries.navigation.internal.afx.cl;
import com.google.android.libraries.navigation.internal.afx.r;
import com.google.android.libraries.navigation.internal.afx.z;
import com.google.android.libraries.navigation.internal.aga.dv;
import com.google.android.libraries.navigation.internal.yz.kc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class f extends az {
    public static final Logger f = Logger.getLogger(f.class.getName());
    public final ar h;
    protected boolean i;
    protected r k;
    public List g = new ArrayList(0);
    protected final ba j = new dv();

    protected f(ar arVar) {
        this.h = arVar;
        f.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "<init>", "Created");
    }

    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final cl a(av avVar) {
        b bVar;
        cl clVar;
        try {
            this.i = true;
            f.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "acceptResolvedAddressesInternal", "Received resolution result: {0}", avVar);
            LinkedHashMap linkedHashMapI = kc.i(avVar.a.size());
            for (z zVar : avVar.a) {
                au auVar = new au();
                auVar.a = avVar.a;
                auVar.b = avVar.b;
                auVar.c = avVar.c;
                auVar.a = Collections.singletonList(zVar);
                com.google.android.libraries.navigation.internal.afx.a aVar = new com.google.android.libraries.navigation.internal.afx.a(com.google.android.libraries.navigation.internal.afx.c.a);
                aVar.b(e, true);
                auVar.b = aVar.a();
                auVar.c = null;
                linkedHashMapI.put(new e(zVar), auVar.a());
            }
            if (linkedHashMapI.isEmpty()) {
                cl clVarB = cl.f.b("NameResolver returned no usable address. ".concat(String.valueOf(String.valueOf(avVar))));
                b(clVarB);
                bVar = new b(clVarB, null);
            } else {
                LinkedHashMap linkedHashMapI2 = kc.i(this.g.size());
                for (d dVar : this.g) {
                    linkedHashMapI2.put(dVar.a, dVar);
                }
                ArrayList arrayList = new ArrayList(linkedHashMapI.size());
                for (Map.Entry entry : linkedHashMapI.entrySet()) {
                    d dVarF = (d) linkedHashMapI2.remove(entry.getKey());
                    if (dVarF == null) {
                        dVarF = f(entry.getKey());
                    }
                    arrayList.add(dVarF);
                    if (entry.getValue() != null) {
                        dVarF.b.c((av) entry.getValue());
                    }
                }
                this.g = arrayList;
                bVar = new b(cl.b, new ArrayList(linkedHashMapI2.values()));
            }
            if (bVar.a.c()) {
                g();
                Iterator it2 = bVar.b.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).b();
                }
                clVar = bVar.a;
            } else {
                clVar = bVar.a;
            }
            this.i = false;
            return clVar;
        } catch (Throwable th) {
            this.i = false;
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final void b(cl clVar) {
        if (this.k != r.READY) {
            this.h.f(r.TRANSIENT_FAILURE, new aq(as.b(clVar)));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final void e() {
        f.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "shutdown", "Shutdown");
        Iterator it2 = this.g.iterator();
        while (it2.hasNext()) {
            ((d) it2.next()).b();
        }
        this.g.clear();
    }

    protected d f(Object obj) {
        throw null;
    }

    protected abstract void g();
}

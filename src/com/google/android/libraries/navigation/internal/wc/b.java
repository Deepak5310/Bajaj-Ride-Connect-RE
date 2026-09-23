package com.google.android.libraries.navigation.internal.wc;

import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.nn;
import com.google.android.libraries.navigation.internal.zr.bu;
import com.google.android.libraries.navigation.internal.zr.dr;
import com.google.android.libraries.navigation.internal.zr.ds;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private static b c;
    public ds a;
    public ds b = ds.a;

    private b() {
    }

    public static synchronized b a() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    private static fd c(ds dsVar) {
        return de.d(dsVar.b).g(new aa() { // from class: com.google.android.libraries.navigation.internal.wc.a
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return Integer.valueOf(((bu) obj).b);
            }
        });
    }

    public final synchronized void b(ds dsVar) {
        fd fdVarC = c(this.b);
        fd fdVarC2 = c(dsVar);
        dr drVar = (dr) ds.a.q();
        nn nnVarListIterator = fdVarC.entrySet().listIterator();
        while (nnVarListIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) nnVarListIterator.next();
            if (fdVarC2.containsKey(entry.getKey())) {
                bu buVar = (bu) fdVarC2.get(entry.getKey());
                if (buVar.c > ((bu) entry.getValue()).c) {
                    drVar.a(buVar);
                } else {
                    drVar.a((bu) entry.getValue());
                }
            } else {
                drVar.a((bu) entry.getValue());
            }
        }
        nn nnVarListIterator2 = fdVarC2.entrySet().listIterator();
        while (nnVarListIterator2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) nnVarListIterator2.next();
            if (!fdVarC.containsKey(entry2.getKey())) {
                drVar.a((bu) entry2.getValue());
            }
        }
        this.b = (ds) drVar.t();
    }
}

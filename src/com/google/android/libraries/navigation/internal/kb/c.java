package com.google.android.libraries.navigation.internal.kb;

import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zt.d;
import com.google.android.libraries.navigation.internal.zt.f;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements Serializable {
    public final String a;

    public c(d dVar) {
        ar.q(dVar);
        f fVar = dVar.c;
        String strD = a.d(fVar == null ? f.a : fVar);
        if ((dVar.b & 2) != 0) {
            strD = strD + ":" + dVar.d;
        }
        this.a = strD;
    }

    public static an b(String str) {
        return an.i(a.a(str)).b(new aa() { // from class: com.google.android.libraries.navigation.internal.kb.b
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return new c((d) obj);
            }
        });
    }

    public final c a(long j) {
        com.google.android.libraries.navigation.internal.zt.c cVar = (com.google.android.libraries.navigation.internal.zt.c) d.a.q();
        d dVarA = a.a(this.a);
        ar.q(dVarA);
        f fVar = dVarA.c;
        if (fVar == null) {
            fVar = f.a;
        }
        if (!cVar.b.H()) {
            cVar.v();
        }
        d dVar = (d) cVar.b;
        fVar.getClass();
        dVar.c = fVar;
        dVar.b |= 1;
        if (!cVar.b.H()) {
            cVar.v();
        }
        d dVar2 = (d) cVar.b;
        dVar2.b |= 2;
        dVar2.d = j;
        return new c((d) cVar.t());
    }

    public final d c() {
        return a.a(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((c) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}

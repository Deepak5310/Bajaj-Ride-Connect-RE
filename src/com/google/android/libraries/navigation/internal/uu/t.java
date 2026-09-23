package com.google.android.libraries.navigation.internal.uu;

import android.content.SharedPreferences;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    public final com.google.android.libraries.navigation.internal.iv.f a;
    public boolean b;
    public boolean c;
    public final SharedPreferences.OnSharedPreferenceChangeListener d = new s(this);
    public p e;

    public t(com.google.android.libraries.navigation.internal.iv.f fVar) {
        ar.q(fVar);
        this.a = fVar;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003a  */
    public final void a() {
        boolean z;
        if (this.a.y(ab.aN, true)) {
            com.google.android.libraries.navigation.internal.aby.b bVar = ((com.google.android.libraries.navigation.internal.aby.e) this.a.f(ab.N, (dg) com.google.android.libraries.navigation.internal.aby.e.a.aH(7, null), com.google.android.libraries.navigation.internal.aby.e.a)).b;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.aby.b.a;
            }
            int iA = com.google.android.libraries.navigation.internal.aby.c.a(bVar.b);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.aby.c.c;
            }
            if (iA == 0) {
                throw null;
            }
            z = iA + (-2) != 1;
        }
        this.b = z;
    }

    public final void b() {
        this.c = this.a.y(ab.aP, true);
    }
}

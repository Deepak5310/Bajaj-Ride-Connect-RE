package com.google.android.libraries.navigation.internal.abv;

import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abf.u;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afm.be;
import com.google.android.libraries.navigation.internal.afm.bx;
import com.google.android.libraries.navigation.internal.afm.cl;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends com.google.android.libraries.navigation.internal.abg.h {
    private static final String b = "n";
    private final com.google.android.libraries.navigation.internal.abt.d c;
    private final m d;
    private final boolean e;
    private final u f;
    private final l g;

    public n(com.google.android.libraries.navigation.internal.abt.d dVar, m mVar) {
        u uVar = u.a;
        l lVar = l.b;
        s.k(dVar, "key");
        this.c = dVar;
        this.d = mVar;
        this.e = true;
        this.f = uVar;
        s.k(lVar, "streetViewProtoDefaults");
        this.g = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final void b() {
        super.b();
        p.f(b, 6);
        this.d.c(this.c, true, false, new HashMap());
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final boolean e() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (r.a(this.c, nVar.c)) {
            boolean z = nVar.e;
            if (r.a(true, true)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final int h() {
        return 40;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, true});
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void i(DataOutputStream dataOutputStream) throws IOException {
        l lVar = this.g;
        com.google.android.libraries.navigation.internal.abt.d dVar = this.c;
        be beVarA = lVar.a(dVar.b, dVar.c, dVar.d);
        if (!beVarA.b.H()) {
            beVarA.v();
        }
        com.google.android.libraries.navigation.internal.abt.d dVar2 = this.c;
        bx bxVar = (bx) beVarA.b;
        bx bxVar2 = bx.a;
        bxVar.b |= 1;
        bxVar.c = dVar2.a;
        bx bxVar3 = (bx) beVarA.t();
        if (p.f(b, 4)) {
            com.google.android.libraries.navigation.internal.abw.l.b(bxVar3);
        }
        this.f.b(dataOutputStream, bxVar3);
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void j(DataInputStream dataInputStream) throws IOException {
        cl clVar = (cl) this.f.a((dg) cl.a.aH(7, null), dataInputStream);
        if (p.f(b, 4)) {
            com.google.android.libraries.navigation.internal.abw.l.c(clVar);
        }
        this.d.c(this.c, false, (clVar.b & 128) != 0 && clVar.j, this.g.b(clVar));
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h
    public final String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("key", this.c);
        return ajVarF.e("isImmediateRequest", true).toString();
    }
}

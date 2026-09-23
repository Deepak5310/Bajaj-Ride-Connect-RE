package com.google.android.libraries.navigation.internal.cn;

import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.cl.bd;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends x {
    public final ev a;
    public final ev b;
    public final ev c;
    private final int d;
    private final bd e;
    private final String f;
    private final bm.a g;

    public j(ev evVar, ev evVar2, ev evVar3, int i, bd bdVar, String str, bm.a aVar) {
        this.a = evVar;
        this.b = evVar2;
        this.c = evVar3;
        this.d = i;
        this.e = bdVar;
        this.f = str;
        this.g = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.x
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.x
    public final bd b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.x
    @Deprecated
    public final ev c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.x
    @Deprecated
    public final ev d() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.x
    public final ev e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        bd bdVar;
        String str;
        bm.a aVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (hx.i(this.a, xVar.e()) && hx.i(this.b, xVar.c()) && hx.i(this.c, xVar.d()) && this.d == xVar.a() && ((bdVar = this.e) != null ? bdVar.equals(xVar.b()) : xVar.b() == null) && ((str = this.f) != null ? str.equals(xVar.g()) : xVar.g() == null) && ((aVar = this.g) != null ? aVar.equals(xVar.f()) : xVar.f() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.x
    public final bm.a f() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.x
    public final String g() {
        return this.f;
    }

    public final int hashCode() {
        int iHashCode = ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
        bd bdVar = this.e;
        int iHashCode2 = ((((iHashCode * 1000003) ^ this.d) * 1000003) ^ (bdVar == null ? 0 : bdVar.hashCode())) * 1000003;
        String str = this.f;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        bm.a aVar = this.g;
        return iHashCode3 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public final String toString() {
        bm.a aVar = this.g;
        bd bdVar = this.e;
        ev evVar = this.c;
        ev evVar2 = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(evVar2) + ", " + String.valueOf(evVar) + ", " + this.d + ", " + String.valueOf(bdVar) + ", " + this.f + ", " + String.valueOf(aVar) + "}";
    }
}

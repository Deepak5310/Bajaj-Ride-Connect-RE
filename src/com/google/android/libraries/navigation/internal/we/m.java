package com.google.android.libraries.navigation.internal.we;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends z {
    public final ev a;
    public final com.google.android.libraries.navigation.internal.tj.u b;

    public m(ev evVar, com.google.android.libraries.navigation.internal.tj.u uVar) {
        if (evVar == null) {
            throw new NullPointerException("Null guidanceAlertList");
        }
        this.a = evVar;
        this.b = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.we.z
    public final com.google.android.libraries.navigation.internal.tj.u a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.we.z
    public final ev b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.tj.u uVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (hx.i(this.a, zVar.b()) && ((uVar = this.b) != null ? uVar.equals(zVar.a()) : zVar.a() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 1000003;
        com.google.android.libraries.navigation.internal.tj.u uVar = this.b;
        return (iHashCode * 1000003) ^ (uVar == null ? 0 : uVar.hashCode());
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.tj.u uVar = this.b;
        return "GuidanceAlerts{guidanceAlertList=" + this.a.toString() + ", promptState=" + String.valueOf(uVar) + "}";
    }
}

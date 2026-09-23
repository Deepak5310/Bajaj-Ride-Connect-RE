package com.google.android.libraries.navigation.internal.pt;

import com.google.android.libraries.navigation.internal.adq.h;
import com.google.android.libraries.navigation.internal.oe.i;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements Serializable, Comparable {
    public static final d a = new d(new i(0, 0), 0);
    public final i b;
    public final int c;

    public d(i iVar, int i) {
        this.b = iVar;
        this.c = i;
    }

    public static d a(h hVar) {
        i iVarA;
        if (hVar == null || (hVar.b & 1) == 0 || (iVarA = i.a(hVar.c)) == null) {
            return null;
        }
        return new d(iVarA, (hVar.b & 2) != 0 ? (int) (((double) hVar.d) * 1000.0d) : Integer.MIN_VALUE);
    }

    public static d b(com.google.android.libraries.navigation.internal.acw.h hVar) {
        if (hVar == null) {
            return null;
        }
        i iVarA = i.a(hVar.c);
        int i = (hVar.b & 2) != 0 ? hVar.d : Integer.MIN_VALUE;
        if (iVarA != null) {
            return new d(iVarA, i);
        }
        return null;
    }

    public final com.google.android.libraries.navigation.internal.aci.b c() {
        com.google.android.libraries.navigation.internal.aci.a aVar = (com.google.android.libraries.navigation.internal.aci.a) com.google.android.libraries.navigation.internal.aci.b.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        i iVar = this.b;
        com.google.android.libraries.navigation.internal.aci.b bVar = (com.google.android.libraries.navigation.internal.aci.b) aVar.b;
        bVar.b |= 1;
        bVar.c = iVar.c;
        return (com.google.android.libraries.navigation.internal.aci.b) aVar.t();
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.b.compareTo(((d) obj).b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            return this.b.equals(((d) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        i iVar = this.b;
        return "{" + getClass().getSimpleName() + ":id=" + String.valueOf(iVar) + ", levelNumberE3=" + this.c + "}";
    }
}

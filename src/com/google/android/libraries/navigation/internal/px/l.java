package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.jb;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l extends aq {
    private final jb b;
    private final com.google.android.libraries.navigation.internal.qc.i c;
    private final am d;

    public l(jb jbVar, com.google.android.libraries.navigation.internal.qc.i iVar, am amVar) {
        Objects.requireNonNull(jbVar);
        this.b = jbVar;
        Objects.requireNonNull(iVar);
        this.c = iVar;
        Objects.requireNonNull(amVar);
        this.d = amVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.aq
    public final am a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.px.aq
    public final com.google.android.libraries.navigation.internal.qc.i b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.px.aq
    public final jb c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aq) {
            aq aqVar = (aq) obj;
            if (this.b.equals(aqVar.c()) && this.c.equals(aqVar.b()) && this.d.equals(aqVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iN;
        jb jbVar = this.b;
        if (jbVar.H()) {
            iN = jbVar.n();
        } else {
            int iN2 = jbVar.ak;
            if (iN2 == 0) {
                iN2 = jbVar.n();
                jbVar.ak = iN2;
            }
            iN = iN2;
        }
        return ((((iN ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public final String toString() {
        am amVar = this.d;
        com.google.android.libraries.navigation.internal.qc.i iVar = this.c;
        return "{" + String.valueOf(this.b) + ", " + String.valueOf(iVar) + ", " + String.valueOf(amVar) + "}";
    }
}

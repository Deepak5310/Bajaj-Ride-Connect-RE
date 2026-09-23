package com.google.android.libraries.navigation.internal.xo;

import android.content.Context;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends ag {
    public final Context a;
    public final br b;

    public a(Context context, br brVar) {
        this.a = context;
        this.b = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xo.ag
    public final Context a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.xo.ag
    public final br b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        br brVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof ag) {
            ag agVar = (ag) obj;
            if (this.a.equals(agVar.a()) && ((brVar = this.b) != null ? brVar.equals(agVar.b()) : agVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 1000003;
        br brVar = this.b;
        return (iHashCode * 1000003) ^ (brVar == null ? 0 : brVar.hashCode());
    }

    public final String toString() {
        br brVar = this.b;
        return "FlagsContext{context=" + this.a.toString() + ", hermeticFileOverrides=" + String.valueOf(brVar) + "}";
    }
}

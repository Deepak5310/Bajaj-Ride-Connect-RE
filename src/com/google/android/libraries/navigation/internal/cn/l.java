package com.google.android.libraries.navigation.internal.cn;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends z {
    private final long a;
    private final boolean b;
    private final ev c;
    private final q d;

    public l(long j, boolean z, ev evVar, q qVar) {
        this.a = j;
        this.b = z;
        this.c = evVar;
        this.d = qVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.z
    public final long a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.z
    public final q b() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.z
    public final ev c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.z
    public final boolean d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        q qVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (this.a == zVar.a() && this.b == zVar.d() && hx.i(this.c, zVar.c()) && ((qVar = this.d) != null ? qVar.equals(zVar.b()) : zVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = true != this.b ? 1237 : 1231;
        long j = this.a;
        int iHashCode = ((i ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003)) * 1000003) ^ this.c.hashCode();
        q qVar = this.d;
        return (iHashCode * 1000003) ^ (qVar == null ? 0 : qVar.hashCode());
    }

    public final String toString() {
        q qVar = this.d;
        return "{" + this.a + ", " + this.b + ", " + String.valueOf(this.c) + ", " + String.valueOf(qVar) + "}";
    }
}

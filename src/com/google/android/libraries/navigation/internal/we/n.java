package com.google.android.libraries.navigation.internal.we;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends az {
    public final com.google.android.libraries.navigation.internal.add.t a;
    public final boolean b;

    public n(com.google.android.libraries.navigation.internal.add.t tVar, boolean z) {
        if (tVar == null) {
            throw new NullPointerException("Null guidanceAlert");
        }
        this.a = tVar;
        this.b = z;
    }

    @Override // com.google.android.libraries.navigation.internal.we.az
    public final com.google.android.libraries.navigation.internal.add.t a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.we.az
    public final boolean b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof az) {
            az azVar = (az) obj;
            if (this.a.equals(azVar.a()) && this.b == azVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "TrafficReportAlert{guidanceAlert=" + this.a.toString() + ", isSuppressed=" + this.b + "}";
    }

    public final int hashCode() {
        int iN;
        com.google.android.libraries.navigation.internal.add.t tVar = this.a;
        if (tVar.H()) {
            iN = tVar.n();
        } else {
            int iN2 = tVar.ak;
            if (iN2 == 0) {
                iN2 = tVar.n();
                tVar.ak = iN2;
            }
            iN = iN2;
        }
        return ((iN ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231);
    }
}

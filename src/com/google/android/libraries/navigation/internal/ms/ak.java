package com.google.android.libraries.navigation.internal.ms;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak extends bz {
    private final int a;
    private final cc b;

    public ak(int i, cc ccVar) {
        this.a = i;
        this.b = ccVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bz
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bz
    public final cc b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        cc ccVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof bz) {
            bz bzVar = (bz) obj;
            if (this.a == bzVar.a() && ((ccVar = this.b) != null ? ccVar.equals(bzVar.b()) : bzVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        cc ccVar = this.b;
        return (ccVar == null ? 0 : ccVar.hashCode()) ^ ((this.a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "Rule{verb=" + this.a + ", token=" + String.valueOf(this.b) + "}";
    }
}

package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dy extends com.google.android.libraries.navigation.internal.ael.bd implements ei {
    public dy() {
        super(ef.a);
    }

    @Override // com.google.android.libraries.navigation.internal.adg.ei
    public final dt c() {
        dt dtVar = ((ef) this.b).c;
        return dtVar == null ? dt.a : dtVar;
    }

    @Override // com.google.android.libraries.navigation.internal.adg.ei
    public final dt d() {
        dt dtVar = ((ef) this.b).d;
        return dtVar == null ? dt.a : dtVar;
    }

    @Override // com.google.android.libraries.navigation.internal.adg.ei
    public final boolean e() {
        return (((ef) this.b).b & 2) != 0;
    }
}

package com.google.android.libraries.navigation.internal.xt;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public final com.google.android.libraries.navigation.internal.ma.l a;
    public final String b;

    public i(com.google.android.libraries.navigation.internal.ma.l experimentToken, String configPackageName) {
        Intrinsics.checkNotNullParameter(experimentToken, "experimentToken");
        Intrinsics.checkNotNullParameter(configPackageName, "configPackageName");
        this.a = experimentToken;
        this.b = configPackageName;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.areEqual(this.a, iVar.a) && Intrinsics.areEqual(this.b, iVar.b);
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ExperimentTokenData(experimentToken=" + this.a + ", configPackageName=" + this.b + ")";
    }
}

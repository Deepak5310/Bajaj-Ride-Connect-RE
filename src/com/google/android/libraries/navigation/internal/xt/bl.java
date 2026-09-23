package com.google.android.libraries.navigation.internal.xt;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bl {
    public final com.google.android.libraries.navigation.internal.ael.x a;
    public final String b;
    public final String c;
    public final List d;
    public final List e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    private final boolean i;
    private final List j;

    public bl(boolean z, List enabledBackings, com.google.android.libraries.navigation.internal.ael.x secret, String dirPath, String gmsCoreDirPath, List includeStaticConfigPackages, List excludeStaticConfigPackages, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(enabledBackings, "enabledBackings");
        Intrinsics.checkNotNullParameter(secret, "secret");
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        Intrinsics.checkNotNullParameter(gmsCoreDirPath, "gmsCoreDirPath");
        Intrinsics.checkNotNullParameter(includeStaticConfigPackages, "includeStaticConfigPackages");
        Intrinsics.checkNotNullParameter(excludeStaticConfigPackages, "excludeStaticConfigPackages");
        this.i = z;
        this.j = enabledBackings;
        this.a = secret;
        this.b = dirPath;
        this.c = gmsCoreDirPath;
        this.d = includeStaticConfigPackages;
        this.e = excludeStaticConfigPackages;
        this.f = z2;
        this.g = z3;
        this.h = z4;
    }

    public final boolean a(com.google.android.libraries.navigation.internal.aae.b androidBacking) {
        Intrinsics.checkNotNullParameter(androidBacking, "androidBacking");
        return this.i && this.j.contains(androidBacking);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bl)) {
            return false;
        }
        bl blVar = (bl) obj;
        return this.i == blVar.i && Intrinsics.areEqual(this.j, blVar.j) && Intrinsics.areEqual(this.a, blVar.a) && Intrinsics.areEqual(this.b, blVar.b) && Intrinsics.areEqual(this.c, blVar.c) && Intrinsics.areEqual(this.d, blVar.d) && Intrinsics.areEqual(this.e, blVar.e) && this.f == blVar.f && this.g == blVar.g && this.h == blVar.h;
    }

    public final int hashCode() {
        int iA = (((((((((((bk.a(this.i) * 31) + this.j.hashCode()) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        boolean z = this.h;
        return (((((iA * 31) + bk.a(this.f)) * 31) + bk.a(this.g)) * 31) + bk.a(z);
    }

    public final String toString() {
        return "SharedStorageInfo(shouldUseSharedStorage=" + this.i + ", enabledBackings=" + this.j + ", secret=" + this.a + ", dirPath=" + this.b + ", gmsCoreDirPath=" + this.c + ", includeStaticConfigPackages=" + this.d + ", excludeStaticConfigPackages=" + this.e + ", hasStorageInfoFromGms=" + this.f + ", allowEmptySnapshotToken=" + this.g + ", enableCommitV2Api=" + this.h + ")";
    }
}

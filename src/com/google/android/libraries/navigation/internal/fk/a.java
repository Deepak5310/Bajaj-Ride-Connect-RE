package com.google.android.libraries.navigation.internal.fk;

import com.google.android.libraries.navigation.internal.kp.c;
import com.google.android.libraries.navigation.internal.kp.f;
import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends c {
    private final String a = "cache-trimmed";
    private final String b;

    public a(String str, String str2) {
        if (str2 != null && str2.length() > 80) {
            str2 = String.valueOf(str2.substring(0, 80)).concat("...");
        }
        this.b = str2;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.e, com.google.android.libraries.navigation.internal.ic.a
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final f c() {
        f fVar = new f("tombstone");
        fVar.m("deletedEvent", this.a);
        return fVar.k("extra", this.b);
    }

    public final String toString() {
        String strConcat = this.b != null ? "" : " : ".concat(BuildConfig.TRAVIS);
        return "Tombstone[" + this.a + strConcat + "]";
    }
}

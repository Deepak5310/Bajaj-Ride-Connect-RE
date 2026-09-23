package com.google.android.libraries.navigation.internal.dh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    private final boolean a;

    public y() {
        this.a = false;
    }

    public y(boolean z) {
        this.a = z;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        return new com.google.android.libraries.navigation.internal.kp.f("location-timeout").h("knownBackground", this.a);
    }
}

package com.google.android.libraries.navigation.internal.lh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bf extends Exception {
    public final com.google.android.libraries.navigation.internal.lc.a a;

    public bf(com.google.android.libraries.navigation.internal.lc.a aVar) {
        be.b(aVar.b(), "ResolvableConnectionException can only be created with a connection result containing a resolution.");
        this.a = aVar;
    }
}

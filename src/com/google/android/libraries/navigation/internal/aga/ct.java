package com.google.android.libraries.navigation.internal.aga;

import java.net.SocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ct extends com.google.android.libraries.navigation.internal.afx.bz {
    final SocketAddress a;
    final String b;
    final Collection c;

    public ct(SocketAddress socketAddress, String str) {
        this.a = socketAddress;
        this.b = str;
        this.c = Collections.singleton(socketAddress.getClass());
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bt
    public final com.google.android.libraries.navigation.internal.afx.by a(URI uri, com.google.android.libraries.navigation.internal.afx.br brVar) {
        return new cs(this);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bt
    public final String b() {
        return "directaddress";
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bz
    public final Collection c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bz
    protected final void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bz
    protected final void e() {
    }
}
